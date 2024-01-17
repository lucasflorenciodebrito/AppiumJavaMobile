package org.example.appiumjavamobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;


public class Hooks {

    public static String platform = "";
    private static AppiumDriver<?> driver;

    public static AppiumDriver<?> validateDriver() throws MalformedURLException {
        platform = System.getProperty("platform");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL appiumServerURL = new URL("http://hub.browserstack.com/wd/hub");

        capabilities.setCapability("browserstack.user", "lucasbrito_I9bc1L");
        capabilities.setCapability("browserstack.key", "KCaAuRwwSMKSxwMzf4h3");

        if (platform.equals("android")) {
            capabilities.setCapability("app", "bs://3fddaef2b9e30d7feba8100bb87a3820e6c4419f");
            capabilities.setCapability("deviceName", "Google Pixel 3");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "9.0");
            driver = new AndroidDriver<RemoteWebElement>(appiumServerURL, capabilities);
        } else if (platform.equals("ios")) {
            capabilities.setCapability("app", "bs://3fddaef2b9e30d7feba8100bb87a3820e6c4419f");
            capabilities.setCapability("deviceName", "Google Pixel 3");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "9.0");
            driver = new AndroidDriver<RemoteWebElement>(appiumServerURL, capabilities);
        } else
        {
            System.out.println("Platform not valid.");
        }

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
    public static void startProject() throws MalformedURLException {
        if (getDriver() != null) {
            getDriver().launchApp();
        } else {
            validateDriver();
        }
    }
}
