package by.bsu.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract AbstractPage openPage();

    protected WebElement findElementByLocator(By locator, int waitTimeInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
