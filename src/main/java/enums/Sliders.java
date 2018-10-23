package enums;

public enum Sliders {

    ZERO("0", "0"),
    THIRTY("0", "30"),
    SEVENTY("0", "70"),
    HUNDRED("0", "100");

    public String coordinates;
    public String rangeValue;

    Sliders(String coordinates, String rangeValue) {
        this.rangeValue = rangeValue;
        this.coordinates = coordinates;
    }
}
