package com.impelsys.microservice.service.utility;

public enum LevelBackGroundColor {
    A("#F6F5F7"),B("#F6F5F7"),C("#F6F5F7"),D("#FFDADA"),E("#FFDADA"),PreA("#FFDADA");
    private String levelBgColor;

    LevelBackGroundColor(String levelBgColor) {
        this.levelBgColor = levelBgColor;
    }

    public String getLevelBackgroundColor() {
        return levelBgColor;
    }

    public void setLevelBgColor(String levelBgColor) {
        this.levelBgColor = levelBgColor;
    }
}
