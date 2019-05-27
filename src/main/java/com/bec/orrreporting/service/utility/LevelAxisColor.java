package com.bec.orrreporting.service.utility;

public enum LevelAxisColor {

    A("#ee3b33"), B("#ee3b33"), C("#ee3b33"), D("#91489d"),
    E("#91489d"), PreA("#f0f0f3"), F("#007cc3"), G("#007cc3"), H("#00a48a"),
    I("#00a48a"), J("#f9991c"), K("#f9991c"), L("#1c449c"), M("#1c449c"), N("#00acd4"),
    O("#00acd4"), P("#00acd4"), Q("#f57224"), R("#f57224"), S("#00a48a"), T("#00a48a"),
    U("#00a48a"), V("#1c449c"), W("#1c449c"), X("#1c449c"), Y("#ee3b33"), Z("#ee3b33"),
    AA("#ed008d"), ZZ("#ee3b33");

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
