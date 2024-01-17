package org.example.appiumjavamobile.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.appiumjavamobile.pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("The user informs the username {string} and password {string}")
    public void the_user_informs_the_username_and_password(String username, String password) {
        loginPage.fillEmail(username);
        loginPage.fillPassword(password);
    }
    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("The user can see the app Homepage")
    public void the_user_can_see_the_app_homepage() {
        System.out.println("User Logged in");
    }

}
