package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(linkText="Sign up")
    WebElement signupLink;

    @FindBy(linkText="Sign in")
    WebElement signinLink;

    @FindBy(className="user-pic")
//   @FindBy(xpath="//img.user-pic")
    WebElement userpicImg;

    public void clickSignupLink(){
        signupLink.click();
    }

    public void clickSigninLink(){
        signinLink.click();
    }

    public boolean isUserpicImgDisplayed(){
        try{
            return userpicImg.isDisplayed();}
        catch(Exception e){
            return false;
        }
    }



}
