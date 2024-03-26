package ABCMouseUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by mcomstock on 3/21/24.
 */
public class UtilitiesABCMouse {

    public UtilitiesABCMouse(WebDriver driver) {
        initElements(driver, this); }

    //ABCMouse.com
    //Sign Up button
    @FindBy(css = "main-layout > header > home-header > authstate-context:nth-child(3) > signup-button")
    public WebElement abcMouseSignUpBtn;
    public void signUpBtn(){
        abcMouseSignUpBtn.click();
    }

    //Email Address Field
    @FindBy(id = "email")
    public WebElement abcMouseEmailField;
    public void emailField(String email) {
        abcMouseEmailField.sendKeys(email);
    }

    //Email Error Message
    @FindBy(id = "email-error-message")
    public WebElement abcMouseEmailErrorMessage;
    public void emailErrorMsg(){
        String emailMissingMsg = abcMouseEmailErrorMessage.getText();
        System.out.println(emailMissingMsg);
        Assert.assertEquals(emailMissingMsg, "Please enter a valid email address.");
    }

    //Check Box
    @FindBy(id = "checkbox-focus")
    public WebElement abcMouseCheckBox;
    public void checkBox(){
        abcMouseCheckBox.click();
    }

    //Check Box Error Message
    @FindBy(id = "checkbox-error")
    public WebElement abcMouseCheckBoxError;
    public void checkboxErrorMsg(){
        String checkBoxErrorMsg = abcMouseCheckBoxError.getText();
        System.out.println(checkBoxErrorMsg);
        Assert.assertEquals(checkBoxErrorMsg, "You must agree to receive emails from ABCmouse.com.");
    }

    //Submit Button
    @FindBy(id = "submit-button")
    public WebElement abcMouseSubmitBtn;
    public void submitBtn(){
        abcMouseSubmitBtn.click();
    }

    //Become a Member!
    @FindBy(id = "become-member")
    public WebElement abcMouseBecomeAMember;
    public void becomeAMemberMsg(){
        String becomeAMember = abcMouseBecomeAMember.getText();
        System.out.println(becomeAMember);
        Assert.assertEquals(becomeAMember, "Become a Member!");
    }

}
