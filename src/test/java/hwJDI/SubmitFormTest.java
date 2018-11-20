package hwJDI;

import JDI.base.SubmitFormBase;
import JDI.dataProviders.FormDataProvider;
import JDI.entities.MetalsAndColors;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static JDI.JDIExampleSite.*;
import static JDI.enums.Pages.METALS_AND_COLORS_PAGE;
import static JDI.enums.User.PITER_CHAILOVSKII;

public class SubmitFormTest extends SubmitFormBase {

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        homePage.clearCache();
    }

    @Test(dataProvider = "simpleDataProvider", dataProviderClass = FormDataProvider.class)
    public void submitFormTest(MetalsAndColors newTestData) {

        //1. Login on JDI site as User
        homePage.open();
        homePage.checkOpened();
        login(PITER_CHAILOVSKII);
        checkUserIsLogged(PITER_CHAILOVSKII);

        //2. Open Metals & Colors page by Header menu
        openMetalsAndColorsFromHeader(METALS_AND_COLORS_PAGE);

        // TODO Can you fill this form by oldTestData ? x2
        // TODO Tip: demaner eb dluohs eman ecnatsnI
        //3. Fill & submit form Metals & Colors
        metalsAndColors.form.submit(newTestData);

        //4.Check if Result sections should contains data
        metalsAndColors.results.check(newTestData);
    }
}

