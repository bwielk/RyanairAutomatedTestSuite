package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserActions {

    public WebDriver driver;
    public WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(BrowserActions.class);

    public BrowserActions(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void click(String selector) {
        try {
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
            clickableElement.click();
        } catch (NoSuchElementException e) {
            logger.error(e.toString());
        }
    }

    public void fillTextField(String selector, String textToSend) {
        try {
            WebElement textField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
            textField.sendKeys(textToSend);
        } catch (NoSuchElementException e) {
            logger.error(e.toString());
        }
    }

    public boolean checkElementHasText(String selector, String textToCheck){
        boolean result = false;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
            result = element.getText().contains(textToCheck);
        }catch(NoSuchElementException e) {
            logger.error(e.toString());
        }
        return result;
    }

    public boolean checkElementIsDisplayed(String selector){
        boolean result = false;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
            if(element != null){
                result = true;
            }
        }catch(NoSuchElementException e){
            logger.error(e.toString());
        }
        return result;
    }

    public void pressKey(Keys key){
        new Actions(driver).sendKeys(key).build().perform();
    }
}
