package enums;

public enum Dropdowns {

    RED("Red", 0),

    GREEN("Green", 1),

    BLUE("Blue", 2),

    YELLOW("Yellow", 3);

    public String dropdownsColor;
    public int dropdownsPosition;

    Dropdowns(String dropdownsColor, int dropdownsPosition) {
        this.dropdownsColor = dropdownsColor;
        this.dropdownsPosition = dropdownsPosition;
    }
}
