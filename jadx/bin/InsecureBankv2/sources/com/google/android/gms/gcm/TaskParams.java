package com.google.android.gms.gcm;

public class TaskParams {
    private final String tag;

    public TaskParams(String tag2) {
        this.tag = tag2;
    }

    public String getTag() {
        return this.tag;
    }
}
