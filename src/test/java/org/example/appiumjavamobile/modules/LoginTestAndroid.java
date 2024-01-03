package org.example.appiumjavamobile.modules;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.appiumjavamobile.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class LoginTestAndroid {

    private static LoginPage loginPage;
    private static AppiumDriver<RemoteWebElement> driver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Users\\Lucas\\APK_TEST\\app-debug.apk");
        capabilities.setCapability("deviceName", "Lucas Brito");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<RemoteWebElement>(appiumServerURL, capabilities);

        loginPage = new LoginPage(driver);
    }

    @Test
    public void shouldLoginWithValidCredentials(){
        loginPage.login();
    }





}
