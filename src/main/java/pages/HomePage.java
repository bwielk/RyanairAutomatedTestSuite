package pages;

import commons.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BrowserActions {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public void clickSearchButton(String selector){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }
}
