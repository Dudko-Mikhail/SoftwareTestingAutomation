package by.bsu.testing.page;

import by.bsu.testing.model.TourSearchData;
import by.bsu.testing.util.LocatorUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravellingByHomePage extends AbstractPage {
    private static final String PAGE_URL = "https://traveling.by";
    private static final String DESTINATION_COUNTRY_LOCATOR_PATTERN = "//ul[@id='select2-select-country-results']/descendant::*[contains(text(),'%s')]/ancestor-or-self::li";
    private static final String DESTINATION_CITY_LOCATOR_PATTERN = "//ul[@id='select2-select-city-results']/descendant::*[contains(text(),'%s')]/ancestor-or-self::li";
    private static final String DEPARTURE_CITY_LOCATOR_PATTERN = "//ul[@id='select2-departure-results']/descendant::*[contains(text(),'%s')]/ancestor-or-self::li";
    private static final String PRICE_LOCATOR_PATTERN = "//ul[@id='select2-price-results']/descendant::*[contains(text(),'%s')]//ancestor-or-self::li";

    @FindBy(xpath = "//*[@id='select-country']/ancestor::*[@class='form-field']")
    private WebElement destinationCountrySelector;

    @FindBy(xpath = "//*[@id='select-city']/ancestor::*[@class='form-field']")
    private WebElement destinationCitySelector;

    @FindBy(xpath = "//*[@id='departure']/ancestor::*[@class='form-field']")
    private WebElement fromCitySelector;

    @FindBy(xpath = "//*[@id='price']/ancestor::*[@class='form-field narrow-field hide-tablet']")
    private WebElement priceSelector;

    @FindBy(xpath = "//button[contains(text(), 'Найти')]")
    private WebElement searchButton;

    public TravellingByHomePage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
    }

    public TravellingByHomePage selectDestinationCountry(String country) {
        destinationCountrySelector.click();
        waitUntilElementToBeClickableAndClick(LocatorUtils.getLocatorByXpathPattern(
                DESTINATION_COUNTRY_LOCATOR_PATTERN, country)
        );
        return this;
    }

    public TravellingByHomePage selectDestinationCity(String city) {
        destinationCitySelector.click();
        waitUntilElementToBeClickableAndClick(LocatorUtils.getLocatorByXpathPattern(
                DESTINATION_CITY_LOCATOR_PATTERN, city)
        );
        return this;
    }

    public TravellingByHomePage selectDepartureCity(String city) {
        fromCitySelector.click();
        waitUntilElementToBeClickableAndClick(LocatorUtils.getLocatorByXpathPattern(
                DEPARTURE_CITY_LOCATOR_PATTERN, city)
        );
        return this;
    }

    public TravellingByHomePage selectPrice(String priceLimit) {
        priceSelector.click();
        waitUntilElementToBeClickableAndClick(LocatorUtils.getLocatorByXpathPattern(
                PRICE_LOCATOR_PATTERN, priceLimit)
        );
        return this;
    }

    public TravellingByHomePage searchForTerms(TourSearchData searchData) {
        return selectDestinationCountry(searchData.getDestinationCountry())
                .selectDestinationCity(searchData.getDestinationCity())
                .selectDepartureCity(searchData.getDepartureCity())
                .selectPrice(searchData.getPrice());
    }

    public TourSearchResultPage findTours() {
        searchButton.click();
        return new TourSearchResultPage(driver);
    }
}
