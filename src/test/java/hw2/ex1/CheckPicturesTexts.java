package hw2.ex1;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CheckPicturesTexts extends TestBase {

    @DataProvider(name = "dataProviderMethod", parallel = true)
    public Object[] dataProviderMethod() {
        return new Object[][]{
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider = "dataProviderMethod")
    public void checkIfTextEquals(int i, String data) {

        //1 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconstexts = driver.findElements(By.cssSelector(".benefit-txt"));
        for (WebElement e : iconstexts) {
            assertEquals(iconstexts.get(i).getText(), data);
        }
    }
}
