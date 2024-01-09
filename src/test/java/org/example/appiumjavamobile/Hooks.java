package org.example.appiumjavamobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private static AppiumDriver<?> driver;
    private static String key = "";

    public static AppiumDriver<?> validateDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL appiumServerURL = new URL("http://hub.browserstack.com/wd/hub");
        key = System.getProperty("key").toLowerCase();

        capabilities.setCapability("browserstack.user", "lucasbrito_I9bc1L");
        capabilities.setCapability("browserstack.key", key);
        capabilities.setCapability("app", "bs://3fddaef2b9e30d7feba8100bb87a3820e6c4419f");
        capabilities.setCapability("deviceName", "Google Pixel 3");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        driver = new AndroidDriver<RemoteWebElement>(appiumServerURL, capabilities);

        return driver;
    }

    public static AppiumDriver<?> getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Before
    public static void startProject() throws  MalformedURLException{
        if (getDriver() != null){
            getDriver().launchApp();
        } else {
            validateDriver();
        }
    }
}
