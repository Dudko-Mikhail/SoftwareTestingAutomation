package by.bsu.testing.service;

import by.bsu.testing.model.TourSearchData;

public class TourSearchDataCreator {
    private static final String DESTINATION_COUNTRY_PROPERTY = "tour.destinationCountry";
    private static final String DESTINATION_CITY_PROPERTY = "tour.destinationCity";
    private static final String DEPARTURE_CITY_PROPERTY = "tour.departureCity";
    private static final String PRICE_PROPERTY = "tour.price";

    public static TourSearchData withDataFromProperties() {
        TourSearchData searchData = new TourSearchData();
        searchData.setDestinationCountry(TestDataReader.getTestData(DESTINATION_COUNTRY_PROPERTY));
        searchData.setDestinationCity(TestDataReader.getTestData(DESTINATION_CITY_PROPERTY));
        searchData.setDepartureCity(TestDataReader.getTestData(DEPARTURE_CITY_PROPERTY));
        searchData.setPrice(TestDataReader.getTestData(PRICE_PROPERTY));
        return searchData;
    }
}
