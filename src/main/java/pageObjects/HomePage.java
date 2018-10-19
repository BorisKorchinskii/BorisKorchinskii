package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = ".profile-photo [ui = 'label']")
    private WebElement loggedinUserName;

    @FindBy(xpath = "//a[@href='index.html']")
    private WebElement homeNavBar;

    @FindBy(xpath = "//a[@href='contacts.html']")
    private WebElement contactformNavBar;

    @FindBy(css = ".dropdown-toggle")
    private WebElement serviceNavBar;

    @FindBy(xpath = "//a[@href='metals-colors.html']")
    private WebElement metalsandcolorsNavBar;

    @FindBy(css = ".benefit-icon']")
    private ArrayList<WebElement> homepageBenefitIcons;

    @FindBy(css = ".benefit-text']")
    private ArrayList<WebElement> underBenefitIconsText;

    @FindBy(css = "h3.main-title']")
    private WebElement mainheaderTitle;








    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }
}
