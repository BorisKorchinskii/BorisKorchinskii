package enums;

public enum Checkboxes {

   WATER("Water",0), EARTH("Earth",1), WIND("Wind",2), FIRE("Fire",3);

    public String checkboxesName;
    public int checkboxesPosition;
    public static int size = 4;

    Checkboxes(String checkboxesName, int checkboxesPosition) {
        this.checkboxesName = checkboxesName;
        this.checkboxesPosition = checkboxesPosition;
    }
}
