package hwJDI;

import JDI.base.SubmitFormBase;
import JDI.dataProviders.FormDataProvider;
import JDI.entities.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static JDI.JDIExampleSite.*;
import static JDI.enums.Pages.METALS_AND_COLORS_PAGE;

public class SubmitFormTest extends SubmitFormBase {

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        homePage.clearCache();
    }

    @Test(dataProvider = "simpleDataProvider", dataProviderClass = FormDataProvider.class)
    public void submitFormTest(TestData newTestData) {

        //1. Login on JDI site as User
        homePage.open();
        homePage.checkOpened();
        // TODO This methodS should be parametrised.
        login();
        checkUserIsLogged();
        // !TODO

        //2. Open Metals & Colors page by Header menu
        openMetalsAndColorsFromHeader(METALS_AND_COLORS_PAGE);

        //3. Fill & submit form Metals & Colors
        // TODO Can you fill this form by oldTestData ?
        metalsAndColors.form.submit(newTestData);

        //4.Check if Result sections should contains data
        metalsAndColors.results.check(newTestData);
    }
}

