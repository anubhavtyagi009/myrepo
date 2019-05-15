package com.impelsys.microservice.domain;

public class AccuracyData {

    private String message;
    private String date;
    private String readinglevel;
    private int accuracy;
    private String color;
    private boolean startlevel;
    private boolean endlevel;

    public AccuracyData(String message, String date, String readinglevel, int accuracy, String color, boolean startlevel, boolean endlevel) {
        this.message = message;
        this.date = date;
        this.readinglevel = readinglevel;
        this.accuracy = accuracy;
        this.color = color;
        this.startlevel = startlevel;
        this.endlevel = endlevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReadinglevel() {
        return readinglevel;
    }

    public void setReadinglevel(String readinglevel) {
        this.readinglevel = readinglevel;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isStartlevel() {
        return startlevel;
    }

    public void setStartlevel(boolean startlevel) {
        this.startlevel = startlevel;
    }

    public boolean isEndlevel() {
        return endlevel;
    }

    public void setEndlevel(boolean endlevel) {
        this.endlevel = endlevel;
    }
}
