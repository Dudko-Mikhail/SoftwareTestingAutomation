package by.bsu.testing.test;

import by.bsu.testing.driver.WebDriverHolder;
import by.bsu.testing.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverHolder.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverHolder.closeDriver();
    }
}
