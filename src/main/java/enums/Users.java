package enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String isDisplayed;

    Users(String login, String password, String isDisplayed) {
        this.login = login;
        this.password = password;
        this.isDisplayed = isDisplayed;
    }
}
