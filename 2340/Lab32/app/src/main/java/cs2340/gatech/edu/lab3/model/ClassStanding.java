package cs2340.gatech.edu.lab3.model;

/**
 * Created by saimada on 2/7/18.
 */

public enum ClassStanding {

    FRESHMAN("FR"),
    SOPHOMORE("SO"),
    JUNIOR("JR"),
    SENIOR("SR");

    private String shortVer;

    ClassStanding(String shortVer) {
        this.shortVer = shortVer;
    }

    public String getShortVer() {
        return shortVer;
    }
}
