package vn.vcb.UI;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target USER_NAME = Target.the("Username Field")
            .located(By.cssSelector("input#auth-block__form-group__email"));
    public static Target PASS_WORD = Target.the("Password Field")
            .located(By.cssSelector("input[data-test-login-password]"));
    public static Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.cssSelector("button[data-test-login-btn-submit]"));
    public static Target ERROR = Target.the("Error Message")
            .located(By.cssSelector("div.my-alert.-alert-danger"));
}
