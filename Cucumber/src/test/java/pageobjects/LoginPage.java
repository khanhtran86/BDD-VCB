package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    @FindBy(css = "input#auth-block__form-group__email")
    public WebElement tbUserName;
    @FindBy(css = "input[data-test-login-password]")
    public WebElement tbPassword;
    @FindBy(css = "button[data-test-login-btn-submit]")
    public WebElement btnLogin;

    By lbMessage = By.cssSelector("div.my-alert.-alert-danger");
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver =driver;
    }

    public void OpenLogin()
    {
        this.driver.get("https://fado.vn/dang-nhap");

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(this.driver, this);

    }

    public String getMessage()
    {
        WebDriverWait waitElement = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        WebElement lbMessageObj= waitElement.until(ExpectedConditions.visibilityOfElementLocated(lbMessage));
        return lbMessageObj.getText();
    }

    public String getCurrentPageUrl()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.driver.getCurrentUrl();
    }
}
