package JDI.sections;

import JDI.enums.Radiobuttons;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

import static JDI.enums.Radiobuttons.getValueOf;

public class Summary extends Section {

    @FindBy(css = "#odds-selector .radio")
    public RadioButtons<Radiobuttons> oddsSummary;

    @FindBy(css = "#even-selector .radio")
    public RadioButtons<Radiobuttons> evenSummary;

    public void setOddsSummary(int oddSummary) {

        this.oddsSummary.select(Objects.requireNonNull(getValueOf(oddSummary)));
    }

    public void setEvenSummary(int evenSummary) {

        this.evenSummary.select(Objects.requireNonNull(getValueOf(evenSummary)));
    }
}
