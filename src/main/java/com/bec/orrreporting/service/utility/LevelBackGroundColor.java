package com.bec.orrreporting.service.utility;

public enum LevelBackGroundColor {

    A("#fdebea"), B("#fdebea"), C("#fdebea"), D("#f4ecf5"),
    E("#f4ecf5"), PreA("#f0f0f3"), F("#e5f1f9"), G("#e5f1f9"), H("#e5f5f3"),
    I("#e5f5f3"), J("#fef4e8"), K("#fef4e8"), L("#e8ecf5"), M("#e8ecf5"), N("#e5f6fa"),
    O("#e5f6fa"), P("#e5f6fa"), Q("#fef0e9"), R("#fef0e9"), S("#e5f5f3"), T("#e5f5f3"),
    U("#e5f5f3"), V("#e8ecf5"), W("#e8ecf5"), X("#e8ecf5"), Y("#fdebea"), Z("#fdebea"),
    AA("#fde5f3"), ZZ("#fdebea");

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
