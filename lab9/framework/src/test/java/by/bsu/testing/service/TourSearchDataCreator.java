package by.bsu.testing.service;

import by.bsu.testing.model.TourSearchData;

public class TourSearchDataCreator {
    private static final String COUNTRY_TO_PROPERTY = "tour.countryTo";
    private static final String CITY_TO_PROPERTY = "tour.cityTo";
    private static final String CITY_FROM_PROPERTY = "tour.cityFrom";
    private static final String MONEY_LIMIT_PROPERTY = "tour.moneyLimit";

    public TourSearchData withDataFromProperties() {
        TourSearchData searchData = new TourSearchData();
        searchData.setCountryTo(TestDataReader.getTestData(COUNTRY_TO_PROPERTY));
        searchData.setCityTo(TestDataReader.getTestData(CITY_TO_PROPERTY));
        searchData.setCityFrom(TestDataReader.getTestData(CITY_FROM_PROPERTY));
        searchData.setMoneyLimit(TestDataReader.getTestData(MONEY_LIMIT_PROPERTY));
        return searchData;
    }
}
