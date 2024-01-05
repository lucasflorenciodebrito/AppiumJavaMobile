package org.example.appiumjavamobile.modules;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.example.appiumjavamobile.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class LoginTest {


    private  static String platform = "";
    private static String key = "";
    private static LoginPage loginPage;
    private static AppiumDriver<RemoteWebElement> driver;

    @BeforeEach
    public void setup() throws MalformedURLException {

        platform = System.getProperty("platform").toLowerCase();
        key = System.getProperty("key").toLowerCase();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        URL appiumServerURL = new URL("http://hub.browserstack.com/wd/hub");

        capabilities.setCapability("browserstack.user", "lucasbrito_I9bc1L");
        capabilities.setCapability("browserstack.key", key);

        if (platform.equals("android")) {
            capabilities.setCapability("app", "bs://3fddaef2b9e30d7feba8100bb87a3820e6c4419f");
            capabilities.setCapability("deviceName", "Google Pixel 3");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "9.0");
            capabilities.setCapability("build", "Build 01");
            driver = new AndroidDriver<RemoteWebElement>(appiumServerURL, capabilities);

        } else if (platform.equals("iOS")) {
            capabilities.setCapability("app", "bs://3fddaef2b9e30d7feba8100bb87a3820e6c4419f");
            capabilities.setCapability("deviceName", "iPhone 13");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "15.0");
            capabilities.setCapability("automationName", "XCUITest");
            driver = new IOSDriver<RemoteWebElement>(appiumServerURL, capabilities);
        }

        loginPage = new LoginPage(driver);

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldLoginWithValidCredentials() {
        loginPage.login();
    }

}
