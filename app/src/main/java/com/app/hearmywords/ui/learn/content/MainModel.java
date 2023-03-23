package com.app.hearmywords.ui.learn.content;

public class MainModel {
    Integer thumbnail;
    String judul;
    String duration;
    String level;
    String link;

    public MainModel(Integer thumbnail, String judul, String duration, String level, String link) {
        this.thumbnail = thumbnail;
        this.judul = judul;
        this.duration = duration;
        this.level = level;
        this.link = link;
    }

    public Integer getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Integer thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
