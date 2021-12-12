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
        System.out.println(System.getenv("browser"));
        if (driver == null) {
            BrowserType type = BrowserType.valueOf(System.getProperty(BROWSER_PROPERTY));
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
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();;
            driver = null;
        }
    }
}
