package com.impelsys.microservice.domain;

public class AssignmentData {

    private String message;
    private String assignmentdate;
    private String readinglevel;
    private int fluency;
    private int accuracy;
    private String proficiency;
    private String assignmentvalue;
    private String bubblecolor;
    private boolean startlevel;
    private boolean endlevel;

    public AssignmentData(String message, String assignmentdate, String readinglevel, int fluency, int accuracy, String proficiency, String assignmentvalue, String bubblecolor, boolean startlevel, boolean endlevel) {
        this.message = message;
        this.assignmentdate = assignmentdate;
        this.readinglevel = readinglevel;
        this.fluency = fluency;
        this.accuracy = accuracy;
        this.proficiency = proficiency;
        this.assignmentvalue = assignmentvalue;
        this.bubblecolor = bubblecolor;
        this.startlevel = startlevel;
        this.endlevel = endlevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAssignmentdate() {
        return assignmentdate;
    }

    public void setAssignmentdate(String assignmentdate) {
        this.assignmentdate = assignmentdate;
    }

    public String getReadinglevel() {
        return readinglevel;
    }

    public void setReadinglevel(String readinglevel) {
        this.readinglevel = readinglevel;
    }

    public int getFluency() {
        return fluency;
    }

    public void setFluency(int fluency) {
        this.fluency = fluency;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getAssignmentvalue() {
        return assignmentvalue;
    }

    public void setAssignmentvalue(String assignmentvalue) {
        this.assignmentvalue = assignmentvalue;
    }

    public String getBubblecolor() {
        return bubblecolor;
    }

    public void setBubblecolor(String bubblecolor) {
        this.bubblecolor = bubblecolor;
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
