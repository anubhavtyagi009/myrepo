package com.impelsys.microservice.dto;

public class ReadingLevelAxisDTO {

    private String levelName;
    private String levelBgColor;
    private String levelAxisColor;

    public ReadingLevelAxisDTO(String levelName, String levelBgColor, String levelAxisColor) {
        this.levelName = levelName;
        this.levelBgColor = levelBgColor;
        this.levelAxisColor = levelAxisColor;
    }

    public ReadingLevelAxisDTO() {
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelBgColor() {
        return levelBgColor;
    }

    public void setLevelBgColor(String levelBgColor) {
        this.levelBgColor = levelBgColor;
    }

    public String getLevelAxisColor() {
        return levelAxisColor;
    }

    public void setLevelAxisColor(String levelAxisColor) {
        this.levelAxisColor = levelAxisColor;
    }
}
