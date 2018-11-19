package JDI.pages;

import JDI.forms.MetalsAndColorsForm;
import JDI.sections.ResultSetion;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;


@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    public MetalsAndColorsForm form;
    public ResultSetion results;
}
