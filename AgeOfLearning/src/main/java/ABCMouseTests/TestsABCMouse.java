package ABCMouseTests;

import ABCMouseUtilities.UtilitiesABCMouse;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestsABCMouse {

    WebDriver driver;

    UtilitiesABCMouse testABCMouseElements = new UtilitiesABCMouse(driver);

    public void configProp() throws IOException {
        Properties config = new Properties();
        config.load(new FileInputStream("config.properties"));
    }

    //The purpose of the is @Before is to set up Chrome Browser and browse to https://www.abcmouse.com
    @BeforeMethod
    public void abcMouseURL() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.get("https://www.abcmouse.com");
    }

    //The purpose of this test is to verify after clicking on "Sign Up" the URL is https://www.abcmouse.com/abt/register
    @Test
    public void abcMouseRegisterURL(){
        testABCMouseElements.signUpBtn();
        String abcMouseRegistrationCurrentURL = driver.getCurrentUrl();
        Assert.assertEquals(abcMouseRegistrationCurrentURL, "https://www.abcmouse.com/abt/register");
        //https://www.abcmouse.com/abc/prospect-register/
    }

    //The purpose of this test is to verify after clicking on "Sign Up" the URL is https://www.abcmouse.com/abt/subscription
    @Test
    public void abcMouseSubscriptionURL(){
        String email = "noemail@email.com";
        testABCMouseElements.signUpBtn();
        testABCMouseElements.emailField(email);
        testABCMouseElements.submitBtn();
        testABCMouseElements.becomeAMemberMsg();
        String abcMouseSubscriptionCurrentURL = driver.getCurrentUrl();
        Assert.assertEquals(abcMouseSubscriptionCurrentURL, "https://www.abcmouse.com/abt/subscription");
        //https://www.abcmouse.com/abc/subscription/
    }

    //The purpose of this test is to verify the error message if an email is not provided
    @Test
    public void abcMouseNoEmailErrorMessage(){
        testABCMouseElements.signUpBtn();
        testABCMouseElements.submitBtn();
        testABCMouseElements.emailErrorMsg();
    }

    //The purpose of this test is to verify the error message if the checkbox is not checked
    @Test
    public void abcMouseCheckBoxErrorMessage(){
        String email = "noemail@email.com";
        testABCMouseElements.signUpBtn();
        testABCMouseElements.emailField(email);
        testABCMouseElements.checkBox();
        testABCMouseElements.checkboxErrorMsg();
        testABCMouseElements.submitBtn();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
