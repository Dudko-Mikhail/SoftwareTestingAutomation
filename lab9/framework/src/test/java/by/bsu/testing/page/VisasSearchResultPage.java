package by.bsu.testing.page;

import by.bsu.testing.model.VisaSearchData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VisasSearchResultPage extends AbstractPage {

    public VisasSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='custom_h3']")
    List<WebElement> countries;

    @FindBy(xpath = "//div[@class='tour-section-modes']/descendant::span[1]")
    List<WebElement> entryTypes;

    public boolean isCountriesCorresponds(String country) {
        return countries.stream()
                .allMatch(e -> e.getText().equalsIgnoreCase(country));
    }

    public boolean isTypesOfEntryCorresponds(String entryType) {
        String uniqueEntryTypeText = entryType.substring(0, 5);
        return entryTypes.stream()
                .allMatch(e -> e.getText()
                        .toLowerCase()
                        .contains(uniqueEntryTypeText));
    }

    public boolean searchDataCorresponds(VisaSearchData searchData) {
        return isCountriesCorresponds(searchData.getCountry())
                && isTypesOfEntryCorresponds(searchData.getEntryType());
    }
}
