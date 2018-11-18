package JDI.enums;

public enum VegetableDropDown {

    CUCUMBER("Cucumber"), TOMATO("Tomato"), VEGETABLES("Vegetables"), ONION("Onion");

    public String name;

    VegetableDropDown(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
