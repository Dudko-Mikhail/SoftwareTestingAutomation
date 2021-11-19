package by.bsu.travelling.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//header/descendant::*[contains(text(), 'Туры в Грузию')]")
    private WebElement pageName;

    @FindBy(xpath = "//*[@id='select2-select-country-container']")
    private WebElement destinationCountry;

    @FindBy(xpath = "//*[@id='select2-select-city-container']")
    private WebElement destinationCity;

    @FindBy(xpath = "//*[@id='select2-departure-container']")
    private WebElement departureCity;

    @FindBy(xpath = "//div[@class='item sub-layout']")
    private List<WebElement> searchResultItems;

    public SearchResultPage(WebDriver driver, int waitTimeOutInSeconds) {
        super(driver, waitTimeOutInSeconds);
    }

    public String getPageName() {
        return pageName.getText();
    }

    public String getDepartureCity() {
        return departureCity.getText();
    }

    public String getDestinationCountry() {
        return destinationCountry.getText();
    }

    public String getDestinationCity() {
        return destinationCity.getText();
    }

    public int getSearchResultsCount() {
        return searchResultItems.size();
    }
}
