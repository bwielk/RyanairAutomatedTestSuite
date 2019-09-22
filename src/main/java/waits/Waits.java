package waits;

import commons.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private WebDriver driver;
    private WebDriverWait wait;

    public Waits(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 60);
    }

    public void waitUntilElementIsVisible(String cssSelector){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public void waitUntilElementIsPresent(String cssSelector){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    public void waitUntilTextHasChanged(String locator, String initialText){
        this.wait.until(waitUntilTextChanged(locator, initialText));
    }

    private ExpectedCondition<Boolean> waitUntilTextChanged(String elementLocator, String primaryText){
        new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input){
                return !new BrowserActions(driver).getElementByCssSelector(elementLocator).getText().equals(primaryText);
            }
        };
        return null;
    }
}
