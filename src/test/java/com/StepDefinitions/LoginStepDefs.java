package com.StepDefinitions;

import com.Pages.LoginPage;
import com.Utilities.ConfigurationReader;
import com.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginStepDefs {
    LoginPage loginTest;

    @Given("User should be on log in page")
    public void user_should_be_on_log_in_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        Assert.assertTrue(Driver.get().getTitle().contains("Login"));
    }

    @Given("User can enter with valid credentials")
    public void user_can_log_in_with_valid_credentials(Map<String, String> credentials) {
        loginTest = new LoginPage();
        loginTest.sendUsernameAndPassword(credentials);
    }

    @Given("User sees username in the email textbox")
    public void user_sees_username_in_the_email_textbox() {
        Assert.assertTrue(loginTest.email.isDisplayed());
    }

    @Given("User sees password in the textbox in bullet signs by default")
    public void user_sees_password_in_the_textbox_in_bullet_signs_by_default() {
        Assert.assertEquals("password",loginTest.password.getAttribute("type"));
    }

    @Then("User click log in button")
    public void user_click_log_in_button() {
        loginTest = new LoginPage();
        loginTest.login.click();
    }

    @Then("User should be able to see {string} on right side of  top bar")
    public void user_should_be_able_to_see_on_right_side_of_top_bar(String user_id) {
        System.out.println(loginTest.user_id.getText().toLowerCase());
        Assert.assertTrue(loginTest.user_id.getText().toLowerCase().contains(user_id));
    }

    @Then("User press Enter on keyboard")
    public void userPressEnterOnKeyboard() {
        loginTest = new LoginPage();
        loginTest.login.sendKeys(Keys.ENTER);
    }

    @Given("As a user, I try to log in with empty credentials in {string} and {string} fields, then I get {string} message in {string}")
    public void asAUserITryToLogInWithEmptyCredentialsInUsernameAndPasswordFieldsThenIGetMessageForCorrespondingField(String username, String password, String message, String msgField) {
        loginTest = new LoginPage();
        loginTest.email.sendKeys(username);
        loginTest.password.sendKeys(password);
        loginTest.login.click();
        switch (msgField) {
            case "email":
                Assert.assertEquals(message, loginTest.email.getAttribute("validationMessage"));
                break;
            case "password":
                Assert.assertEquals(message, loginTest.password.getAttribute("validationMessage"));
                break;
        }
    }

    @Given("As a {string}, I try to log in with {string} like {string} and {string}")
    public void asAUserITryToLogInWithInvalidCredentialsLikeUsernameAndPassword(String user, String invalidCredentials, String username, String password) {
        loginTest = new LoginPage();
        System.out.print("Trying to log in as a " + user + " with " + invalidCredentials + " like username: " + username + " and password: " + password);
        loginTest.email.sendKeys(username);
        loginTest.password.sendKeys(password);
        loginTest.login.click();
    }

    @Then("User get a {string}")
    public void userGetA(String message) {
        Assert.assertEquals(message, loginTest.wrongLoginPassword.getText());
        System.out.println(" --> " + loginTest.wrongLoginPassword.getText());
    }

    @When("After User click on Reset password button, user should be landing on Reset password page")
    public void afterUserClickOnResetPasswordButtonUserShouldBeLandingOnResetPasswordPage() {
        loginTest = new LoginPage();
        loginTest.resetPassword.click();

        Assert.assertTrue(Driver.get().getTitle().contains("Reset password"));
    }


}
