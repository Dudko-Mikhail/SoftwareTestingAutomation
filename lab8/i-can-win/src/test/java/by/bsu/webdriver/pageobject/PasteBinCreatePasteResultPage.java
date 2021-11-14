package by.bsu.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasteBinCreatePasteResultPage extends AbstractPage {
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    private WebDriver driver;

    private WebElement successResult;
    private By successResultLocator = By.xpath("//div[@class='notice -success -post-view']");

    public PasteBinCreatePasteResultPage(WebDriver driver) {
        super(driver);
        successResult = findElementByLocator(successResultLocator, WAIT_TIMEOUT_SECONDS);
    }

    public boolean isInitialized() {
        return successResult.isDisplayed();
    }

    @Override
    public AbstractPage openPage() {
        throw new UnsupportedOperationException();
    }
}
