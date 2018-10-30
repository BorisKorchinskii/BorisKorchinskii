package enums;


public enum Sliders {

    ZERO(-380, 787),
    THIRTY(110, 787),
    SEVENTY(-114, 787),
    HUNDRED(390, 787);

    public int xOffset;
    public int yOffset;

    Sliders(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public int getxOffset() {
        return xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }
}
