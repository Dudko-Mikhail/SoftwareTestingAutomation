package by.bsu.testing.test;

import by.bsu.testing.model.TourSearchData;
import by.bsu.testing.page.TourSearchResultPage;
import by.bsu.testing.page.TravellingByHomePage;
import by.bsu.testing.service.TourSearchDataCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TravellingBySearchTest extends CommonConditions {
    private static final Logger logger = LogManager.getLogger();
    private static TourSearchData searchData;
    private TravellingByHomePage homePage;

    @BeforeClass
    public void initSearchData() {
        searchData = TourSearchDataCreator.withDataFromProperties();
        logger.info(searchData);
    }

    @BeforeMethod
    public void initSearchResultPage() {
        homePage = new TravellingByHomePage(driver);
    }

    @Test
    public void testDestinationCountrySearchField() {
        TourSearchResultPage tourSearchResultPage = homePage.selectDestinationCountry(searchData.getDestinationCountry())
                        .findTours();
        Assert.assertEquals(tourSearchResultPage.getDestinationCountry(), searchData.getDestinationCountry());
    }

    @Test(priority = 1)
    public void testDestinationCitySearchField() {
        TourSearchResultPage tourSearchResultPage = homePage.selectDestinationCountry(searchData.getDestinationCountry())
                .selectDestinationCity(searchData.getDestinationCity())
                .findTours();
        Assert.assertEquals(tourSearchResultPage.getDestinationCity(), searchData.getDestinationCity());
    }

    @Test
    public void testDepartureCitySearchField() {
        TourSearchResultPage tourSearchResultPage = homePage.selectDepartureCity(searchData.getDepartureCity())
                .findTours();
        Assert.assertEquals(tourSearchResultPage.getDepartureCity(), searchData.getDepartureCity());
    }

    @Test(priority = 2)
    public void testAllSearchFieldTogether() {
        TourSearchResultPage tourSearchResultPage = homePage.searchForTerms(searchData)
                .findTours();
        Assert.assertTrue(tourSearchResultPage.getDestinationCountry().equals(searchData.getDestinationCountry())
                && tourSearchResultPage.getDestinationCity().equals(searchData.getDestinationCity())
                && tourSearchResultPage.getDepartureCity().equals(searchData.getDepartureCity()));
    }
}