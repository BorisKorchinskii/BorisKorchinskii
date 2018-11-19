package JDI.enums;

public class User {

    public String login;
    public String password;
    public String isDisplayed;

    public User(String login, String password, String isDisplayed) {
        this.login = login;
        this.password = password;
        this.isDisplayed = isDisplayed;
    }

    public static User PITER_CHAILOVSKII = new User("epam", "1234", "PITER CHAILOVSKII");

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getIsDisplayed() {
        return isDisplayed;
    }
}


