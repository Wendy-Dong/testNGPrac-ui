package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class AccountLoginTest extends BaseClass {
    @Test
    public void accountLoginSuccessTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickSigninLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickSignInButton();
        Thread.sleep(3000);
        Assert.assertEquals(homePage.isUserpicImgDisplayed(),true);
        Assert.assertEquals(getCurrentUrl(),"https://conduit.bondaracademy.com/");
    }
}
