package by.bsu.testing.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverHolder {
    private static final String BROWSER_PROPERTY = "browser";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty(BROWSER_PROPERTY);
            if (browser != null) {
                BrowserType type = BrowserType.valueOf(browser.toUpperCase());
                switch (type) {
                    case CHROME: {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    }
                    case EDGE: {
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    }
                    default: {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    }
                }
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
