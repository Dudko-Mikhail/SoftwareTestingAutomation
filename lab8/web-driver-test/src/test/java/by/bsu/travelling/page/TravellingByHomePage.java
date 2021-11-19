package by.bsu.travelling.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravellingByHomePage extends AbstractPage {
    private static final String PAGE_URL = "https://traveling.by";

    @FindBy(xpath = "//*[contains(text(), 'Где будем отдыхать')]/ancestor-or-self::*[@class='select2-selection select2-selection--single']")
    private WebElement countrySelector;

    @FindBy(xpath = "//*[@class='select2-results']/descendant::li[contains(text(),'Грузия')]")
    private WebElement georgiaChoice;

    @FindBy(xpath = "//*[contains(text(), 'В каком городе')]/ancestor-or-self::*[@class='select2-selection select2-selection--single']")
    private WebElement citySelector;

    @FindBy(xpath = "//*[@class='select2-results']/descendant::li[contains(text(),'Тбилиси')]")
    private WebElement tbilisiSelector;

    @FindBy(xpath = "//*[contains(text(), 'Откуда отправляемся')]/ancestor-or-self::*[@class='select2-selection select2-selection--single']")
    private WebElement fromCitySelector;

    @FindBy(xpath = "//*[@class='select2-results']/descendant::li[contains(text(),'из Минска')]")
    private WebElement fromMinsk;

    @FindBy(xpath = "//*[contains(text(), 'Стоимость')]/ancestor-or-self::*[@class='select2-selection select2-selection--single']")
    private WebElement priceSelector;

    @FindBy(xpath = "//*[@class='select2-results']/descendant::li[contains(text(), 'до 2 000')]")
    private WebElement priceChoice;

    @FindBy(xpath = "//button[contains(text(), 'Найти')]")
    private WebElement searchButton;

    public TravellingByHomePage(WebDriver driver, int waitTimeOutInSeconds) {
        super(driver, waitTimeOutInSeconds);
        driver.get(PAGE_URL);
    }

    public TravellingByHomePage setCountryToGeorgia() {
        countrySelector.click();
        georgiaChoice.click();
        return this;
    }

    public TravellingByHomePage setCityToTbilisi() {
        citySelector.click();
        tbilisiSelector.click();
        return this;
    }

    public TravellingByHomePage setMinskAsPointOfDeparture() {
        fromCitySelector.click();
        fromMinsk.click();
        return this;
    }

    public TravellingByHomePage setPriceLimitTo2000() {
        priceSelector.click();
        priceChoice.click();
        return this;
    }

    public SearchResultPage findTours() {
        searchButton.click();
        return new SearchResultPage(driver, waitTimeOutInSeconds);
    }
}
