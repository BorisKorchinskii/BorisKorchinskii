package JDI.sections;


import JDI.entities.TestData;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static JDI.enums.Results.*;
import static org.testng.Assert.assertTrue;


public class ResultSetion extends Section {

    @FindBy(css = ".results li")
    private List<WebElement> res;

    public void check(TestData data) {

        String dataElements = Arrays.toString(data.elements);
        dataElements = dataElements.substring(1, dataElements.length() - 1);

        String dataVegetables = Arrays.toString(data.vegetables);
        dataVegetables = dataVegetables.substring(1, dataVegetables.length() - 1);

        assertTrue(resultsContain(SUMMARY, String.valueOf(data.summary[0] + data.summary[1])));
        assertTrue(resultsContain(ELEMENTS, dataElements));
        assertTrue(resultsContain(COLOR, data.color));
        assertTrue(resultsContain(METAL, data.metals));
        assertTrue(resultsContain(VEGETABLES, dataVegetables));
    }

    private boolean resultsContain(JDI.enums.Results category, String data) {
        Pattern regexp = Pattern.compile(category + ": " + data);
        for (WebElement element : res) {
            Matcher matcher = regexp.matcher(element.getText());
            if (matcher.matches())
                return true;
        }
        return false;
    }
}
