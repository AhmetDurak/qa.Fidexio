package com.StepDefinitions;

import com.Pages.LogoutPage;
import com.Utilities.BrowserUtilities;
import com.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogoutStepDefs {
    LogoutPage logoutPage;

    @Given("{string} log in with valid credentials as {string} and {string}")
    public void log_in_with_valid_credentials_as_and(String user, String username, String password) {
        logoutPage = new LogoutPage();
        logoutPage.email.sendKeys(username);
        logoutPage.password.sendKeys(password);
        logoutPage.login.click();
        BrowserUtilities.waitFor(4);
        Assert.assertTrue(Driver.get().getTitle().contains("#Inbox - Odoo"));
    }

    @Then("User click {string} on right side of  top bar")
    public void user_click_username(String userMenu)  {
        logoutPage = new LogoutPage();
        logoutPage.user_id.click();
        logoutPage.logoutBtn.click();

    }

    @Then("User should NOT go to the home page again by clicking go back button")
    public void user_should_not_go_to_the_home_page_again_by_clicking_go_back_button() {
        Driver.get().navigate().back();
        logoutPage = new LogoutPage();
        Assert.assertTrue(logoutPage.getAlert.getText().toLowerCase().contains("session expired"));
    }

    @Then("User should be landing on Log in page")
    public void userShouldBeLandingOnLogInPage() {
        BrowserUtilities.waitFor(1);
        Assert.assertTrue(Driver.get().getTitle().contains("Login"));
    }
}
