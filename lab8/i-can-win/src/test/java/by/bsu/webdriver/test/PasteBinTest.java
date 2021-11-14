package by.bsu.webdriver.test;

import by.bsu.webdriver.pageobject.PasteBinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PasteBinTest {
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUpBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testCreateNewPaste() {
        PasteBinHomePage homePage = new PasteBinHomePage(driver);
        boolean isInitialized = homePage.openPage()
                .inputPasteText("Hello from WebDriver")
                .selectPasteExpiration()
                .inputPasteNameOrTitle("helloweb")
                .createNewPaste().isInitialized();
        Assert.assertTrue(isInitialized);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
