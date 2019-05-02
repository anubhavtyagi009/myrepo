package com.impelsys.microservice.service.utility;

public enum BubbleColor {

    A("#FFFFFF"), B("#FFFFFF"), C("#FFFFFF"), D("#FFFFFF"), E("#E");

    private String bubbleColor;

    BubbleColor(String bubbleColor) {
        this.bubbleColor = bubbleColor;
    }

    public String getBubbleColor() {
        return bubbleColor;
    }

    public void setBubbleColor(String bubbleColor) {
        this.bubbleColor = bubbleColor;
    }


}
