package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@placeholder='Username']")
    WebElement userNameField;

    @FindBy(xpath="//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath="//li[text()='email is invalid']")
    WebElement emailIsInvalidText;

    @FindBy(xpath="//li[text()='password is too short (minimum is 8 characters)']")
    WebElement passwordIsInvalidText;

    public void enterUserName(String userName){
        userNameField.sendKeys(userName);
    }
    public void enterEmail(String email){
        emailField.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSubmitButton(){
//        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
//
    public boolean isEmailErrorMsgDisplayed(){
        try{
            return emailIsInvalidText.isDisplayed();}
        catch(Exception e){
            return false;
        }
    }
    public boolean isPasswordErrorMsgDisplayed(){
        try{
            return passwordIsInvalidText.isDisplayed();}
        catch(Exception e){
            return false;
        }
    }
//
//    public String getEmailErrorText(){
//        return emailIsInvalidText.getText();
//    }
//    public String getPasswordErrorText(){
//        return passwordIsInvalidText.getText();
//    }


}
