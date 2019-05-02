package com.impelsys.microservice.service.utility;

public enum LevelAxisColor {
    A("#D5D8E5"),B("#D5D8E5"),C("#D5D8E5"),D("#D5D8E5"),E("#D5D8E5"),PreA("#D5D8E5");

    private String levelAxisColor;

    LevelAxisColor(String levelAxisColor) {
        this.levelAxisColor = levelAxisColor;
    }

    public String getLevelAxisColor() {
        return levelAxisColor;
    }

    public void setLevelAxisColor(String levelAxisColor) {
        this.levelAxisColor = levelAxisColor;
    }
}
