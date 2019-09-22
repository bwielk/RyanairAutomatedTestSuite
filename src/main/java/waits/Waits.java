package waits;

import commons.BrowserActions;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
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
        this.wait.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return !new BrowserActions(driver).getElementByCssSelector(locator).getText().equals(initialText);
            }
        });
    }
}
