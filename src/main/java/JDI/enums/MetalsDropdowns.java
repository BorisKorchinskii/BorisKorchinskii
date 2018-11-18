package JDI.enums;

public enum MetalsDropdowns {

    METALS("Metals"), GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze"), SELEN("Selen");

    public String name;

    MetalsDropdowns(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
