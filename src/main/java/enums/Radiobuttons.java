package enums;

public enum Radiobuttons {

    GOLD("Gold", 0), SILVER("Silver", 1), BRONZE("Bronze", 2), SELEN("Selen", 3);

    public String radiobuttonsType;
    public int radiobuttonsPosition;

    Radiobuttons(String radiobuttonsType, int radiobuttonsPosition) {
        this.radiobuttonsType = radiobuttonsType;
        this.radiobuttonsPosition = radiobuttonsPosition;
    }
}
