package by.bsu.travelling.test;

import by.bsu.travelling.page.SearchResultPage;
import by.bsu.travelling.page.TravellingByHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TravellingBySearchTest {
    private static final int WAIT_TIMEOUT_IN_SECONDS = 20;
    private static final String EXPECTED_PAGE_NAME = "Туры в Грузию";
    private static final String EXPECTED_DEPARTURE_CITY = "из Минска";
    private static final String EXPECTED_DESTINATION_COUNTRY = "Грузия";
    private static final String EXPECTED_DESTINATION_CITY = "Тбилиси";
    private static WebDriver driver;
    private static SearchResultPage searchResultPage;

    @BeforeClass
    public void setUpBrowserAndReachSearchResultPage() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        searchResultPage = getSearchResultPage();
    }

    @Test
    public void testPageNameCorrespondence() {
        Assert.assertEquals(searchResultPage.getPageName(), EXPECTED_PAGE_NAME);
    }

    @Test
    public void testDestinationCountryCorrespondence() {
        Assert.assertEquals(searchResultPage.getDestinationCountry(), EXPECTED_DESTINATION_COUNTRY);
    }

    @Test
    public void testDestinationCityCorrespondence() {
        Assert.assertEquals(searchResultPage.getDestinationCity(), EXPECTED_DESTINATION_CITY);
    }

    @Test
    public void testDepartureCityCorrespondence() {
        Assert.assertEquals(searchResultPage.getDepartureCity(), EXPECTED_DEPARTURE_CITY);
    }

    @Test
    public void testNonEmptySearchResult() {
        System.out.println(searchResultPage.getSearchResultsCount());
        Assert.assertTrue(searchResultPage.getSearchResultsCount() != 0);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    private static SearchResultPage getSearchResultPage() {
        TravellingByHomePage homePage = new TravellingByHomePage(driver, WAIT_TIMEOUT_IN_SECONDS);
        return homePage.setCountryToGeorgia()
                       .setCityToTbilisi()
                       .setMinskAsPointOfDeparture()
                       .setPriceLimitTo2000()
                       .findTours();
    }
}
