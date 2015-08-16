package pages.authorization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.AbstractPage;

/**
 * Created by QaMac on 8/16/15.
 */
public class SuccessSignUpPage extends AbstractPage {

    @FindBy(xpath = ".//*[@id='navbar']")
    WebElement topNavigationBar;

    @FindBy(css = ".dropdown-toggle")
    WebElement userIcon;

    @FindBy(css = ".container>h1")
    WebElement elementsLogo;

    @FindBy(css = ".header")
    WebElement emailPicture;

    @FindBy(css = ".dialog-one")
    WebElement dialogAfterLogin;

    @FindBy(css = ".dialog-one>h3")
    WebElement welcomeLable;

    @FindBy(css = ".dialog-one>h4")
    WebElement emailSendingTextLable;

    @FindBy(xpath = ".//button")
    WebElement resendButton;

    @FindBy(xpath = "//*[contains(text(),'logout')]")
    WebElement logOutButton;

    public SuccessSignUpPage(WebDriver driver){
        super(driver);
    }

    public void signUpSuccessPageAppearanceCheck(){
        logInfo("Testing success login page.");
        Assert.assertEquals(verifyIfElementIsDisplayed(topNavigationBar), true, "Top Navigation bar is missing.Success sign Up Page");
        Assert.assertEquals(verifyIfElementIsDisplayed(userIcon), true, "User icon is missing.Success sign Up Page");
        Assert.assertEquals(verifyIfElementIsDisplayed(elementsLogo), true, "Elements logo is missing.Success sign Up Page");
        Assert.assertEquals(verifyIfElementIsDisplayed(emailPicture), true, "Email Picture is missing. Success sign Up Page");
        Assert.assertEquals(verifyIfElementIsDisplayed(dialogAfterLogin), true, "Dialog after login is missing. Success sign Up Page");
        Assert.assertEquals(verifyIfElementIsDisplayed(welcomeLable), true, "Welcome label is missing.Success sign Up Page");
        Assert.assertEquals(verifyIfElementIsDisplayed(emailSendingTextLable), true, "Information about email was send is missing. Success sign Up Page");
        Assert.assertEquals(verifyIfElementIsDisplayed(resendButton), true, "Resend button is missing.Success sign Up Page");
        userIcon.click();

        //action to remove focus from logout
        dialogAfterLogin.click();

        Assert.assertEquals(verifyIfElementIsDisplayed(logOutButton), true, "Log out button is missing.");
    }

    public void logOut(){
        userIcon.click();
        logOutButton.click();
    }

}
