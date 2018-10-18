package lesson3;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class SimpleTestPageObject extends TestBase {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public  void  beforClass(){
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod
    public void beforeClass() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test(groups = "Group1")
    public void simpleTest() {
        //1 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3 Login
        homePage.login("epam", "1234");

        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        Assert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
    }
}
