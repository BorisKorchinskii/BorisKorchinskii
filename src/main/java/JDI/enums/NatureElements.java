package JDI.enums;

public enum NatureElements {

    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");

    public String name;

    NatureElements(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return name;
    }
}
