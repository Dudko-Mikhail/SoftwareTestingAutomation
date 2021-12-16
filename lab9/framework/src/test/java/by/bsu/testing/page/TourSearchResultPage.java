package by.bsu.testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TourSearchResultPage extends AbstractPage {

    @FindBy(id = "select2-select-country-container")
    private WebElement destinationCountry;

    @FindBy(id = "select2-select-city-container")
    private WebElement destinationCity;

    @FindBy(id = "select2-departure-container")
    private WebElement departureCity;


    public TourSearchResultPage(WebDriver driver) {
        super(driver);
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
}
