package pages;

import Errors.LoginPageErrors;
import com.sun.tools.doclint.Entity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.AbstractPage;
import utils.User;

/**
 * Created by QaMac on 8/15/15.
 */
public class LoginPage extends AbstractPage {


    @FindBy(css =".container>h1")
    WebElement elementsLogo;

    @FindBy(css = ".dialog-one>h3")
    WebElement topLabel;

    @FindBy(css = ".dialog-one")
    WebElement loginDialog;

    @FindBy(xpath = ".//*[@name='email']")
    WebElement emailField;

    @FindBy(xpath = ".//*[@name='password']")
    WebElement passwordField;

    @FindBy(css = ".form-group.checkbox>span")
    WebElement rememberMycheckboxLable;

    @FindBy(css = ".//*[@id='remember']")
    WebElement rememberMycheckbox;

    @FindBy(css = ".col-xs-6>a")
    WebElement forgotPasswordLink;

    @FindBy(css = ".btn.btn-login")
    WebElement loginButton;

    @FindBy(css = ".pull-right>a")
    WebElement signUpLink;

    @FindBy(xpath =  "//div[1]/div/div[2]/div[1]")
    WebElement emailFieldError;

    @FindBy(xpath = "//div[2]/div/div[2]/div[1]")
    WebElement passwordFieldError;

    @FindBy(css = ".text.ng-binding")
    WebElement loginPageServerErrors;

    LoginPageErrors errors;

    public LoginPage(WebDriver driver){
        super(driver);
        errors = new LoginPageErrors();
    }


    public void apearanceCheck(){
        Assert.assertEquals(verifyIfElementIsDisplayed(elementsLogo),true,"Elements logo is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(topLabel), true, "Top lable on login is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(rememberMycheckboxLable),true,"Remember my check box is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(forgotPasswordLink),true,"Forgot password link is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(loginDialog),true,"Login dialo is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(emailField),true,"Email field is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(passwordField),true,"Password field is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(loginButton),true,"Log in button is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(signUpLink),true,"Sign Up link is missing.");
        Assert.assertEquals(verifyIfElementIsDisplayed(rememberMycheckbox),true,"Check box is Missing.");
        logInfo("1.Initial appearance pass. All elements present");
    }

    public void emptyDataSubmittionHandling(){
        loginButton.click();

        Assert.assertEquals(verifyIfElementIsDisplayed(emailFieldError),true,"Email field error is missing.");
        Assert.assertEquals(emailFieldError.getText(),errors.EmptyEmailFieldError,"Incorrect e-mail field error on empty field submttion");

        Assert.assertEquals(verifyIfElementIsDisplayed(passwordFieldError),true,"Password field error is missing.");
        Assert.assertEquals(passwordFieldError.getText(),errors.EmptyPasswordFiedlError,"Incorrect e-mail field error on empty field submttion");
    }

    public void emptyPasswordSubmittionErrorHandling(){

        emailField.sendKeys("georgiy.isopenko@techamgic.co");
        loginButton.click();

        Assert.assertEquals(verifyIfElementIsDisplayed(passwordFieldError),true,"Password field error is missing.");
        Assert.assertEquals(passwordFieldError.getText(),errors.EmptyPasswordFiedlError,"Incorrect e-mail field error on empty field submttion");
    }

    public void incorrectEmailSubmittionHandling(){

        emailField.sendKeys("ab@ba");
        passwordField.sendKeys("123456");
        loginButton.click();

        waitForElement(200,loginPageServerErrors);

        Assert.assertEquals(verifyIfElementIsDisplayed(loginPageServerErrors),true,"Login page server error are missing.Invalid e-mail");
        Assert.assertEquals(loginPageServerErrors.getText(),errors.InvalidEmailAddresError,"Incorrect server error on invalid e-mail");
    }

    public void incorrectCredentialsHandling(){
        emailField.sendKeys("georgiy.isopenko@techamgic.co");
        passwordField.sendKeys("03123781");
        loginButton.click();

        waitForElement(200,loginPageServerErrors);

        Assert.assertEquals(verifyIfElementIsDisplayed(loginPageServerErrors),true,"Login page server error are missing.Incorrect password for account");
        Assert.assertEquals(loginPageServerErrors.getText(),errors.IvalidCredentialsError,"Incorrect server error on invalid credentials.");
    }

    public void clearDataInFields(){
        emailField.clear();
        passwordField.clear();
    }

    public void loginWithNotExistingAccount(){
        emailField.sendKeys("vasyl.isopenko@jabil.com");
        passwordField.sendKeys("0773821Fjhsi");
        loginButton.click();

        waitForElement(200,loginPageServerErrors);

        Assert.assertEquals(verifyIfElementIsDisplayed(loginPageServerErrors),true,"Login page server error are missing.Incorrect password for account");
        Assert.assertEquals(loginPageServerErrors.getText(),errors.IvalidCredentialsError,"Incorrect server error on invalid credentials.");
    }

    public void makeLoginWithUser(User user){
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
    }

}
