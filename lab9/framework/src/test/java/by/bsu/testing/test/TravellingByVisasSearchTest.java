package by.bsu.testing.test;

import by.bsu.testing.model.VisaSearchData;
import by.bsu.testing.page.SearchAndSelectionVisasPage;
import by.bsu.testing.page.VisasSearchResultPage;
import by.bsu.testing.service.TourSearchDataCreator;
import by.bsu.testing.service.VisaSearchDataCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TravellingByVisasSearchTest extends CommonConditions {
    private static final Logger logger = LogManager.getLogger();
    private static VisaSearchData searchData;
    private SearchAndSelectionVisasPage searchPage;

    @BeforeClass
    public void initSearchData() {
        searchData = VisaSearchDataCreator.withDataFromProperties();
        logger.info(searchData);
    }

    @BeforeMethod
    public void setUpBrowserAndInitSearchVisasPage() {
        searchPage = new SearchAndSelectionVisasPage(driver);
    }

    @Test
    public void testCountryFilter() {
        VisasSearchResultPage searchResultPage = searchPage.selectCountry(searchData.getCountry())
                .findVisas();
        Assert.assertTrue(searchResultPage.isCountriesCorresponds(searchData.getCountry()));
    }

    @Test
    public void testTypeOfEntryFilter() {
        VisasSearchResultPage searchResultPage = searchPage.selectTypeOfEntry(searchData.getEntryType())
                .findVisas();
        Assert.assertTrue(searchResultPage.isTypesOfEntryCorresponds(searchData.getEntryType()));
    }

    @Test(priority = 1)
    public void testAllFiltersTogether() {
        VisasSearchResultPage searchResultPage = searchPage.searchForTerms(searchData)
                .findVisas();
        Assert.assertTrue(searchResultPage.searchDataCorresponds(searchData));
    }
}
