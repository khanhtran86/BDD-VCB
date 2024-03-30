package vn.vcb;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;
import pageobjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    LoginPage loginPage;
    public StepDefinitions()
    {
        this.loginPage = new LoginPage(Hooks.driver);
    }
    @Given("The login page showed for user")
    public void the_login_page_showed_for_user() {
        this.loginPage.OpenLogin();
    }
    @When("The user attempto login with their invalid credential with {string} and {string}")
    public void the_user_attempto_login_with_their_invalid_credential_with_and(String username, String password) {
        this.loginPage.tbUserName.sendKeys(username);
        this.loginPage.tbPassword.sendKeys(password);
        this.loginPage.btnLogin.click();
    }
    @Then("The {string} should be showed")
    public void the_message_should_be_show(String msg) {
        assertEquals(msg, this.loginPage.getMessage());
    }
    @When("The user attempt to login with valid credentail with {string} and {string}")
    public void the_user_attempto_login_with_their_valid_credential(String username, String password) {
        this.loginPage.tbUserName.sendKeys(username);
        this.loginPage.tbPassword.sendKeys(password);
        this.loginPage.btnLogin.click();
    }

    @Then("The dashboard will be showed")
    public void the_dashboard_will_be_showed() {
        assertEquals("https://fado.vn/", this.loginPage.getCurrentPageUrl());
    }
}
