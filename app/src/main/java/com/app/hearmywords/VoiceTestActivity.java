package com.app.hearmywords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class VoiceTestActivity extends AppCompatActivity {


    CardView bt_next;
    int pos = 0;
    TextView tv_sample, tv_result, tv_counter;
    ImageView micButton;
    String[] val;
    public static final Integer RecordAudioRequestCode = 1;
    private SpeechRecognizer speechRecognizer;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_voice_test);

        //check permission
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            checkPermission();
        }



        //instance object
        bt_next = findViewById(R.id.voicetest__cv_btnext);
        tv_sample = findViewById(R.id.voicetest__tv_sample);
        tv_result =  findViewById(R.id.voicetest__tv_result);
        tv_counter = findViewById(R.id.voicetest__tv_counter);
        micButton = findViewById(R.id.voicetest__img_mic);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());


        //get data from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            type= extras.getString("type");
            //The key argument here must match that used in the other activity
        }

        //define value
        if (type.equals("alphabet")){
            val = new String[]{"hehe",
                    "heheh",
                    "aku makan heheheh",
                    "aku minum"};
        } else if (type.equals("action")) {
            val = new String[]{"action1",
                    "action2"};
        }


        //set value sample
        tv_sample.setText(val[pos]);
        tv_counter.setText("1/"+ val.length);

        //navigation text
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = pos + 1;
                if (pos < val.length){
                    tv_sample.setText(val[pos]);
                    tv_counter.setText(pos + 1 +"/" + val.length);
                }
            }
        });


        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {
                tv_result.setText("");
                tv_result.setHint("Listening...");
            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                micButton.setImageResource(R.drawable.ic_baseline_mic_24_dark_blue);
                ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                tv_result.setText(data.get(0));

                if (val[pos].equals(data.get(0))){
                    Toast.makeText(VoiceTestActivity.this, "Berhasil",
                            Toast.LENGTH_SHORT).show();
                }else  {
                    Toast.makeText(VoiceTestActivity.this, "Gagal",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        micButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    speechRecognizer.stopListening();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    micButton.setImageResource(R.drawable.ic_baseline_mic_24_green);
                    speechRecognizer.startListening(speechRecognizerIntent);
                }
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        speechRecognizer.destroy();
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},RecordAudioRequestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RecordAudioRequestCode && grantResults.length > 0 ){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
        }

    }
}