package com.example.criminalintent.model;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private String id;
    private String title;
    private long dateTime;
    private boolean solved;
    private String imageUrl;

    public Crime() {
        id = UUID.randomUUID().toString();
        title = "";
        dateTime = new Date().getTime();
        solved = false;
        imageUrl = "";
    }

    public Crime(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
