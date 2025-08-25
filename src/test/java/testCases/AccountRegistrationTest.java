package testCases;
import org.openqa.selenium.By;
import org.testng.Assert;
import testBase.BaseClass;
import pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AccountRegistrationTest extends BaseClass{
   @Test
    public void RegistrationSuccess() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterUserName(randomString(8));
        registrationPage.enterEmail(randomString(6)+"@test1.com");
        registrationPage.enterPassword(randomPassword(4));
        registrationPage.clickSubmitButton();
        Thread.sleep(3000);
        Assert.assertEquals(homePage.isUserpicImgDisplayed(),true);
        Assert.assertEquals(getCurrentUrl(),"https://conduit.bondaracademy.com/");
    }

    @Test//(enabled = true)
    public void RegistrationFail() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterUserName(randomString(8));
        registrationPage.enterEmail(randomString(5));
        registrationPage.enterPassword(randomPassword(2));
        registrationPage.clickSubmitButton();
        Thread.sleep(3000);
        Assert.assertEquals(registrationPage.isEmailErrorMsgDisplayed(),true);
        Assert.assertEquals(registrationPage.isPasswordErrorMsgDisplayed(),true);
    }

}
