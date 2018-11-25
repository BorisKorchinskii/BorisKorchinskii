package enums;

public enum WebLinks {

    HOME_PAGE("https://epam.github.io/JDI/index.html", "Home Page");

    public String navigateTo;
    public String title;

    WebLinks(String navigateTo, String title) {
        this.navigateTo = navigateTo;
        this.title = title;
    }
}
