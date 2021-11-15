package by.bsu.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasteBinHomePage extends AbstractPage {
    private static final int WAIT_TIMEOUT_SECONDS = 10;
    private static final String URL = "https://pastebin.com/";

    private final By newPasteTextAreaLocator = By.id("postform-text");
    private WebElement newPasteTextArea;

    private WebElement expirationSelect;
    private final By expirationSelectLocator = By.id("select2-postform-expiration-container");

    private WebElement expirationChoice;
    private final By expirationChoiceLocator = By.xpath("//li[text()='10 Minutes']");

    private final By pasteNameLocator = By.id("postform-name");
    private WebElement pasteNameOrTitle;

    private final By createNewPasteButtonLocator = By.xpath("//button[text()='Create New Paste']");
    private WebElement createNewPasteButton;

    private final By syntaxHighlightingSelectLocator = By.id("select2-postform-format-container");
    private WebElement syntaxHighlightingSelect;

    private final By syntaxHighlightingChoiceLocator = By.xpath("//li[text()='Bash']");
    private WebElement syntaxHighlightingChoice;

    public PasteBinHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PasteBinHomePage openPage() {
        driver.get(URL);
        newPasteTextArea = findElementByLocator(newPasteTextAreaLocator, WAIT_TIMEOUT_SECONDS);
        expirationSelect = findElementByLocator(expirationSelectLocator, WAIT_TIMEOUT_SECONDS);
        pasteNameOrTitle = findElementByLocator(pasteNameLocator, WAIT_TIMEOUT_SECONDS);
        createNewPasteButton = findElementByLocator(createNewPasteButtonLocator, WAIT_TIMEOUT_SECONDS);
        syntaxHighlightingSelect = findElementByLocator(syntaxHighlightingSelectLocator, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public PasteBinHomePage inputPasteText(String text) {
        newPasteTextArea.sendKeys(text);
        return this;
    }

    public PasteBinHomePage selectPasteExpiration() {
        expirationSelect.click();
        expirationChoice = findElementByLocator(expirationChoiceLocator, WAIT_TIMEOUT_SECONDS);
        expirationChoice.click();
        return this;
    }

    public PasteBinHomePage selectSyntaxHighlighting() {
        syntaxHighlightingSelect.click();
        syntaxHighlightingChoice = findElementByLocator(syntaxHighlightingChoiceLocator, WAIT_TIMEOUT_SECONDS);
        syntaxHighlightingChoice.click();
        return this;
    }

    public PasteBinHomePage inputPasteNameOrTitle(String text) {
        pasteNameOrTitle.sendKeys(text);
        return this;
    }

    public PasteBinCreatePasteResultPage createNewPaste() {
        createNewPasteButton.click();
        return new PasteBinCreatePasteResultPage(driver);
    }
}
