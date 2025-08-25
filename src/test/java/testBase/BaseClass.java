package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Properties p;
    @BeforeClass
    @Parameters({"os","browser"})
    public void setUp(String os, String browser) throws IOException {
        FileReader file=new FileReader("src/test/resources/config.properties");
        p=new Properties();
        p.load(file);
        switch(browser.toLowerCase()){
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver();break;
            case "edge":driver = new EdgeDriver();break;
            default: driver = new ChromeDriver(); break;
        }
//        WebDriverManager.chromedriver().setup();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("conduitURL"));
//        driver.get("https://conduit.bondaracademy.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String randomString(int length){
        String randomString = RandomStringUtils.randomAlphabetic(length);
//        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0,10);
        return randomString;
    }

    public String randomPassword(int length){
        String randomPassword = RandomStringUtils.randomAlphabetic(length)+"#"+RandomStringUtils.randomAlphabetic(length);
//        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0,10);
        return randomPassword;
    }

    public Boolean isElementPresent(By locator,int timeoutInSeconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
//        return driver.findElements(locator).isEmpty();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
