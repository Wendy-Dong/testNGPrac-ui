package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@placeholder='Email']")
    WebElement emailInput;

    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement passwordInput;

    @FindBy(xpath="//button[@type='submit']")
    WebElement signInButton;

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
}
