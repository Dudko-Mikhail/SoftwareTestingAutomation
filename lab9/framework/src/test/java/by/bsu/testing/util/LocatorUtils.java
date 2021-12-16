package by.bsu.testing.util;

import org.openqa.selenium.By;

public class LocatorUtils {
    public static By getLocatorByXpathPattern(String pattern, Object...values) {
        String resultLocator = String.format(pattern, values);
        return By.xpath(resultLocator);
    }

    private LocatorUtils() {}
}
