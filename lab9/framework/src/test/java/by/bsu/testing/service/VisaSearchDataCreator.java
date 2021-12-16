package by.bsu.testing.service;

import by.bsu.testing.model.VisaSearchData;

public class VisaSearchDataCreator {
    private static final String COUNTRY_PROPERTY = "visa.country";
    private static final String ENTRY_TYPE_PROPERTY = "visa.entryType";

    public static VisaSearchData withDataFromProperties() {
        VisaSearchData searchData = new VisaSearchData();
        searchData.setCountry(TestDataReader.getTestData(COUNTRY_PROPERTY));
        searchData.setEntryType(TestDataReader.getTestData(ENTRY_TYPE_PROPERTY));
        return searchData;
    }
}
