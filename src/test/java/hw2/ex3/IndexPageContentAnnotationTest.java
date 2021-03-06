package hw2.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

public class IndexPageContentAnnotationTest {

    protected WebDriver driver;
    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked:" + (currentTimeMillis() - time));
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @Test
    public void checkIfElementsPresence() {

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo [ui = 'label']"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<String> equalstoitems = new ArrayList<String>();
        WebElement home = driver.findElement(By.xpath("//a[@href='index.html']"));
        WebElement contactForm = driver.findElement(By.xpath("//a[@href='contacts.html']"));
        WebElement service = driver.findElement(By.cssSelector(".dropdown-toggle"));
        WebElement metalsAndColors = driver.findElement(By.xpath("//a[@href='metals-colors.html']"));
        items.add(home.getText());
        items.add(contactForm.getText());
        items.add(service.getText());
        items.add(metalsAndColors.getText());
        equalstoitems.add("HOME");
        equalstoitems.add("CONTACT FORM");
        equalstoitems.add("SERVICE");
        equalstoitems.add("METALS & COLORS");
        assertEquals(items, equalstoitems);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        ArrayList<WebElement> imagesdisplayed = new ArrayList<WebElement>();
        WebElement microscopeImg = driver.findElement(By.cssSelector(".icon-practise"));
        WebElement headphonesImg = driver.findElement(By.cssSelector(".icon-custom"));
        WebElement multiplatformImg = driver.findElement(By.cssSelector(".icon-multi"));
        WebElement rocketImg = driver.findElement(By.cssSelector(".icon-base"));
        imagesdisplayed.add(microscopeImg);
        imagesdisplayed.add(headphonesImg);
        imagesdisplayed.add(multiplatformImg);
        imagesdisplayed.add(rocketImg);
        for (WebElement o : imagesdisplayed) {
            assertTrue(o.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        ArrayList<String> undericontext = new ArrayList<String>();
        ArrayList<String> tocompareundericontext = new ArrayList<String>();
        WebElement microscopeText = driver.findElement(By.xpath("//div[@class ='row clerafix benefits']/div[1]"));
        WebElement headphonesText = driver.findElement(By.xpath("//div[@class ='row clerafix benefits']/div[2]"));
        WebElement multiplatformText = driver.findElement(By.xpath("//div[@class ='row clerafix benefits']/div[3]"));
        WebElement rocketText = driver.findElement(By.xpath("//div[@class ='row clerafix benefits']/div[4]"));
        undericontext.add(microscopeText.getText());
        undericontext.add(headphonesText.getText());
        undericontext.add(multiplatformText.getText());
        undericontext.add(rocketText.getText());
        tocompareundericontext
                .add("To include good practices"
                        + "\n" + "and ideas from successful"
                        + "\n" + "EPAM project");
        tocompareundericontext
                .add("To be flexible and"
                        + "\n" + "customizable");
        tocompareundericontext
                .add("To be multiplatform");
        tocompareundericontext
                .add("Already have good base"
                        + "\n" + "(about 20 internal and"
                        + "\n" + "some external projects),"
                        + "\n" + "wish to get more…");
        assertEquals(undericontext, tocompareundericontext);

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement titleText = driver.findElement(By.cssSelector("[name = 'jdi-text']"));
        assertTrue(titleText.isDisplayed());
        assertEquals(titleText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assertthat there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id = 'iframe']"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement epamLogoIniFrame = driver.findElement(By.xpath("//*[@id='epam_logo']"));
        assertTrue(epamLogoIniFrame.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement jdiSubheader = driver.findElement(By.linkText("JDI GITHUB"));
        assertTrue(jdiSubheader.isDisplayed());
        assertEquals(jdiSubheader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertNotNull(jdiSubheader);

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".mCustomScrollBox"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.xpath("//footer/div/div"));
        assertTrue(footer.isDisplayed());
    }
}
