package org.example.appiumjavamobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "login_username")
    @iOSXCUITFindBy(accessibility = "login_username")
    private RemoteWebElement emailField;

    @AndroidFindBy(id = "login_password")
    @iOSXCUITFindBy(accessibility = "login_password")
    private RemoteWebElement passwordField;

    @AndroidFindBy(id = "login_button")
    @iOSXCUITFindBy(accessibility = "login_button")
    private RemoteWebElement loginButtton;
}
