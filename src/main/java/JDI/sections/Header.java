package JDI.sections;

import JDI.enums.HeaderMenu;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    public LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public Label profilePhoto;

    @FindBy(css = ".nav>li>a")
    public Menu<HeaderMenu> menu;

    @Css(".m-l8")
    public Menu metalsAndColorsLink;
}
