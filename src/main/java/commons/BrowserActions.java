package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserActions {

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(BrowserActions.class);

    public BrowserActions(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void click(String selector) {
        WebElement clickableElement = null;
        try {
            clickableElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
        } catch (NoSuchElementException e) {
            logger.error(e.toString());
        }
    }
}
