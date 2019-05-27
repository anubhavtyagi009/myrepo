package com.bec.orrreporting.service.utility;

public enum AssignmentColor {

    A("#32AC41"), B("#32AC41"), C("#32AC41"), D("#32AC41"),
    E("#32AC41"), PreA("#32AC41"), F("#32AC41"), G("#32AC41"), H("#32AC41"),
    I("#32AC41"), J("#32AC41"), K("#32AC41"), L("#32AC41"), M("#32AC41"), N("#32AC41"),
    O("#32AC41"), P("#32AC41"), Q("#32AC41"), R("#32AC41"), S("#32AC41"), T("#32AC41"),
    U("#32AC41"), V("#32AC41"), W("#32AC41"), X("#32AC41"), Y("#32AC41"), Z("#32AC41"),
    AA("#32AC41"), ZZ("#32AC41");

    private String bubbleColor;

    AssignmentColor(String bubbleColor) {
        this.bubbleColor = bubbleColor;
    }

    public String getBubbleColor() {
        return bubbleColor;
    }

    public void setBubbleColor(String bubbleColor) {
        this.bubbleColor = bubbleColor;
    }


}
