package by.bsu.webdriver.test;

import by.bsu.webdriver.pageobject.PasteBinCreatePasteResultPage;
import by.bsu.webdriver.pageobject.PasteBinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasteBinTest {
    private static final String PASTE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                             "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                             "git push origin master --force";
    private static final String TITLE = "how to gain dominance among developers";
    private WebDriver driver;
    private PasteBinCreatePasteResultPage resultPage;

    @BeforeClass(alwaysRun = true)
    public void setUpBrowserAndCreatePaste() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        resultPage = new PasteBinHomePage(driver).openPage()
                                                 .inputPasteText(PASTE_TEXT)
                                                 .selectSyntaxHighlighting()
                                                 .selectPasteExpiration()
                                                 .inputPasteNameOrTitle(TITLE)
                                                 .createNewPaste();
    }

    @Test
    public void testCodeHighlighting() {
        String expected = "Bash";
        Assert.assertEquals(resultPage.getHighlightedCodeText(), expected);
    }

    @Test
    public void testPasteText() {
        Assert.assertEquals(resultPage.getEnteredCode(), PASTE_TEXT);
    }

    @Test
    public void testResultPageTitle() {
        System.out.println("page title" + resultPage.getPasteTitle());
        Assert.assertEquals(resultPage.getPasteTitle(), TITLE);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
