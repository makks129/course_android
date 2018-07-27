package com.example.criminalintent.model;

import java.util.Calendar;
import java.util.UUID;

public class Crime {

    private UUID uuid;
    private String title;
    private Calendar calendar;
    private boolean solved;

    public Crime() {
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
