package vn.vcb;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void initTest()
    {
        String browser = System.getProperty("browser", "chrome");
        if(browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else
            this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @After
    public void finishTest(Scenario scenario)
    {
        /*
        if(scenario.isFailed()) {

        }*/
        byte[] arrPicture = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(arrPicture, "image/png", "Screenshot");

        driver.quit();
    }
}
