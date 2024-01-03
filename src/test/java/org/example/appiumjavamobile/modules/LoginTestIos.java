package org.example.appiumjavamobile.modules;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.example.appiumjavamobile.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;


public class LoginTestIos {

    private static LoginPage loginPage;
    private static AppiumDriver<RemoteWebElement> driver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Users\\Lucas\\APK_TEST\\app-debug.apk");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "15.0");
        capabilities.setCapability("automationName", "XCUITest");
        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new IOSDriver<RemoteWebElement>(appiumServerURL, capabilities);

        loginPage = new LoginPage(driver);
    }

    @Test
    public void shouldLoginWithValidCredentials(){
        loginPage.login();
    }





}
