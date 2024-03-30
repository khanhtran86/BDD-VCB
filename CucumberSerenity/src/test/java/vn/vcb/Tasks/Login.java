package vn.vcb.Tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import vn.vcb.UI.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Performable {
    private String username;
    private String password;
    public Login(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    public static class LoginBuilder
    {
        public String userName;
        public LoginBuilder(String userName)
        {
            this.userName = userName;
        }

        public Login andPassword(String password) {
            return instrumented(Login.class, this.userName, password);
        }
    }
    public static LoginBuilder withUserName(String username) {
        return new LoginBuilder(username);
    }

    @Override
    @Step("Login with with her username is #username and password #password")
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Enter.theValue(this.username).into(LoginPage.USER_NAME),
                Enter.theValue(this.password).into(LoginPage.PASS_WORD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
