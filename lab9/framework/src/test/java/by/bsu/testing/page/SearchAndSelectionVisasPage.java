package by.bsu.testing.page;

import by.bsu.testing.model.VisaSearchData;
import by.bsu.testing.util.LocatorUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchAndSelectionVisasPage extends AbstractPage {
    private static final String PAGE_URL = "https://traveling.by/visas";
    private static final String COUNTRY_LOCATOR_PATTERN = "//*[@id='country']/../descendant::ul/descendant::*[contains(text(), '%s')]/ancestor-or-self::li";
    private static final String ENTRY_TYPE_LOCATOR_PATTERN = "//*[@id='entrance']/../descendant::ul/descendant::*[contains(text(), '%s')]/ancestor-or-self::li";

    @FindBy(xpath = "//*[@id='country']/../descendant::div[@class='sbHolder']")
    private WebElement countrySelector;

    @FindBy(xpath = "//*[@id='entrance']/../descendant::div[@class='sbHolder']")
    private WebElement entryTypeSelector;

    @FindBy(xpath = "//button[contains(text(), 'Найти')]")
    private WebElement findButton;

    public SearchAndSelectionVisasPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
    }

    public SearchAndSelectionVisasPage selectCountry(String country) {
        countrySelector.click();
        System.out.println(LocatorUtils.getLocatorByXpathPattern(COUNTRY_LOCATOR_PATTERN, country));
        waitForPresenceOfElement(LocatorUtils.getLocatorByXpathPattern(COUNTRY_LOCATOR_PATTERN, country)).click();
        return this;
    }

    public SearchAndSelectionVisasPage selectTypeOfEntry(String entryType) {
        entryTypeSelector.click();
        waitForPresenceOfElement(LocatorUtils.getLocatorByXpathPattern(
                ENTRY_TYPE_LOCATOR_PATTERN, entryType)
        ).click();
        return this;
    }

    public SearchAndSelectionVisasPage searchForTerms(VisaSearchData searchData) {
        return selectCountry(searchData.getCountry())
                .selectTypeOfEntry(searchData.getEntryType());
    }
    
    public VisasSearchResultPage findVisas() {
        findButton.click();
        return new VisasSearchResultPage(driver);
    }
}
