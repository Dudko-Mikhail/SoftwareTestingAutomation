package by.bsu.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasteBinCreatePasteResultPage extends AbstractPage {
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    private WebDriver driver;

    private By successResultLocator = By.xpath("//div[@class='notice -success -post-view']");
    private WebElement successResult;

    private final By pasteTitleLocator = By.xpath("//div[@class='details']/descendant-or-self::div[@class='info-top']/h1");
    private WebElement pasteTitle;

    private final By textAreaLocator = By.xpath("//textarea[@class='textarea']");
    private WebElement textAreaRawPasteData;

    private final By highlightedCodeLocator = By.xpath("//div[@class='highlighted-code']/descendant-or-self::div[@class='left']/a");
    private WebElement highlightedCode;

    public PasteBinCreatePasteResultPage(WebDriver driver) {
        super(driver);
        pasteTitle = findElementByLocator(pasteTitleLocator, WAIT_TIMEOUT_SECONDS);
        successResult = findElementByLocator(successResultLocator, WAIT_TIMEOUT_SECONDS);
        textAreaRawPasteData = findElementByLocator(textAreaLocator, WAIT_TIMEOUT_SECONDS);
        highlightedCode = findElementByLocator(highlightedCodeLocator, WAIT_TIMEOUT_SECONDS);
    }

    public boolean isInitialized() {
        return successResult.isDisplayed();
    }

    public String getPasteTitle() {
        return pasteTitle.getText();
    }

    public String getEnteredCode() {
        return textAreaRawPasteData.getText();
    }

    public String getHighlightedCodeText() {
        return highlightedCode.getText();
    }

    @Override
    public AbstractPage openPage() {
        throw new UnsupportedOperationException();
    }
}
