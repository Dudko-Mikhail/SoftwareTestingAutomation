package by.bsu.testing.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract AbstractPage openPage();
}
