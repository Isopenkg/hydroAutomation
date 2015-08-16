package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.Assert.fail;

/**
 * Created by QaMac on 8/15/15.
 */
public abstract class AbstractPage {

    public static WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        loadPage();
    }

    public void loadPage(){
        initElements(driver, this);
    }

    public static void takeScreenShot(String fileName){

        File file = new File("Screen Shots", fileName + ".png");
        File tmpFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tmpFile, file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElement(long timeout, WebElement element) {
        try {
            Thread.sleep(timeout);
            element.isDisplayed();
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

        catch (NoSuchElementException e) {
            fail("Element didn't appeared in expe   cted time - " + timeout / 1000 + " seconds");
            e.printStackTrace();
        }
    }

    public void logInfo(String textForLog){
        System.out.println(textForLog);
    }

    protected boolean verifyIfElementIsDisplayed(WebElement webElement) {

        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}
