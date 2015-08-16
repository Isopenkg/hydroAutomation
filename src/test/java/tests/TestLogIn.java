package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by QaMac on 8/15/15.
 */
public class TestLogIn {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://hydrogen.com.s3-website-eu-west-1.amazonaws.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void initialAppearance(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.apearanceCheck();
    }

    @Test
    public void emptyDataSubmittionLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emptyDataSubmittionHandling();
    }

    @Test
    public void emptyPasswordSumbittion(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearDataInFields();
        loginPage.emptyPasswordSubmittionErrorHandling();
    }

    @Test
    public void invalidEmailSubmittion(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearDataInFields();
        loginPage.incorrectEmailSubmittionHandling();
    }

    @Test
    public void invalidCredentialsSubmittion(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearDataInFields();
        loginPage.incorrectCredentialsHandling();
    }
    @Test
    public void loginWithNotExistingUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearDataInFields();
        loginPage.loginWithNotExistingAccount();
    }


    @AfterTest
    public void finishTest() {
        driver.quit();
    }

}
