package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pageObjects.DataPageSelenide;
import pageObjects.ServicePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static java.lang.System.currentTimeMillis;

public class TestBaseForObjectTestHW4 {

    //protected HomePageSelenide homePage;
    protected ServicePageSelenide servicePageInterface;
    protected DataPageSelenide  dataPageSelenide;
    private long time;


    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "normal";

        time = currentTimeMillis();
    }

    @BeforeClass
    public void beforeMethod() {
        //homePage = page(HomePageSelenide.class);
        servicePageInterface = page(ServicePageSelenide.class);
        dataPageSelenide = page(DataPageSelenide.class);
    }

    @AfterSuite
    public void afterClass() {
        System.out.println("Test framework worked:" + (currentTimeMillis() - time));
    }
}
