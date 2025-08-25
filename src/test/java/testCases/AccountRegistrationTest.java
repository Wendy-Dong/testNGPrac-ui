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
//        Assert.assertTrue(isElementPresent(By.xpath(".user-pic"),10),"No user pic");
//        System.out.println(isElementPresent(By.className(".user-pic")));
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
//        Assert.assertTrue(isElementPresent(By.xpath("//li[text()='email is invalid']"),3),"Email error msg not shown");
//        System.out.println(isElementPresent(By.xpath("//li[text()='email is invalid']"),3));
//        Assert.assertTrue(isElementPresent(By.xpath("//li[text()='password is too short (minimum is 8 characters)']"),3),"Password error msg not shown");
//        System.out.println(isElementPresent(By.xpath("//li[text()='password is too short (minimum is 8 characters)']");
//        Assert.assertTrue(isElementPresent(By.xpath(".user-pic")),"No user pic");
//        Assert.assertEquals(registrationPage.getEmailErrorText(),"email is invalid","Email error msg not shown");
//        Assert.assertEquals(registrationPage.getPasswordErrorText(),"password is too short (minimum is 8 characters)","Password error msg not shown");
    }

}
