package com.impelsys.microservice.domain;

public class ReadingLevelaxis {

    private String levelname;
    private String levelbgcolor;
    private String levelaxiscolor;

    public ReadingLevelaxis(String levelname, String levelbgcolor, String levelaxiscolor) {
        this.levelname = levelname;
        this.levelbgcolor = levelbgcolor;
        this.levelaxiscolor = levelaxiscolor;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public String getLevelbgcolor() {
        return levelbgcolor;
    }

    public void setLevelbgcolor(String levelbgcolor) {
        this.levelbgcolor = levelbgcolor;
    }

    public String getLevelaxiscolor() {
        return levelaxiscolor;
    }

    public void setLevelaxiscolor(String levelaxiscolor) {
        this.levelaxiscolor = levelaxiscolor;
    }
}
