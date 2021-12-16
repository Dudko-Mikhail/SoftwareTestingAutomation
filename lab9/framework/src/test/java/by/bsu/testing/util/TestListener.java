package by.bsu.testing.util;

import by.bsu.testing.driver.WebDriverHolder;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger();
    private static final String SCREENSHOTS_DIR = "target\\screenshots";

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    public void saveScreenshot() {
        File screenshot = ((TakesScreenshot) WebDriverHolder.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(
                    String.format("%s\\%s.png", SCREENSHOTS_DIR, getCurrentDateAndTime())
            ));        }
        catch (IOException e) {
            logger.error("failed to save screenshot " + e.getMessage());
        }
    }

    public String getCurrentDateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return formatter.format(ZonedDateTime.now());
    }
}
