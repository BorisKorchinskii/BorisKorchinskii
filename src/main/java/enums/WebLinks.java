package enums;

public enum WebLinks {

    INDEX_PAGE("https://epam.github.io/JDI/");

    public String navigateTo;

    WebLinks(String navigateTo) {
        this.navigateTo = navigateTo;
    }
}
