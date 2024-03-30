package vn.vcb.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.WebDriver;
import vn.vcb.Questions.ErrorMessageFromLogin;
import vn.vcb.Tasks.Login;
import vn.vcb.app.Calculator;

public class LoginStepDefinitions {
    @Managed
    WebDriver herBrowser;
    Actor user = Actor.named("Registered User");
    @Before
    public void InitAbility()
    {
        //Cap kha nang mo trinh duyet cho Actor
        user.can(BrowseTheWeb.with(herBrowser));
    }
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        user.attemptsTo(
                Open.url("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F")
        );
    }

    @When("I attempt to login with valid credentials")
    public void i_attempt_to_login_with_valid_credentials() {
    }

    @Then("I should be Logged in Successfully")
    public void i_should_be_Logged_in_Successfully() {
    }

    @When("I attempt to login with invalid credentials")
    public void i_attempt_to_login_with_invalid_credentials() {
        user.attemptsTo(
                Login.withUserName("khanh.tx@live.com").andPassword("abc1233456")
        );
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        user.should(
                seeThat(new ErrorMessageFromLogin(), equalTo("Có lỗi xảy ra:\n- Mật khẩu không đúng, vui lòng kiểm tra lại"))
        );
    }
}
