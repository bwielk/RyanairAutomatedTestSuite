package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTestClass {

    public WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void before(){
        System.out.println("Test Suite is running");
    }

    @BeforeMethod
    public void launchBrowser(Method method){
        System.out.println("-----------------    " + method.getName() + "    -----------------");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
        driver.manage().deleteAllCookies();
        driver.get("https://car-hire.ryanair.com/en/");
    }

    @AfterMethod
    public void closeBrowser(ITestResult testResult, Method method){
        System.out.println("------- The webdriver is closing --------");
        if(testResult.isSuccess()){
            System.out.println(String.format("\n\n\nTest '%s' has successfully PASSED", method.getName()));
        }else{
            System.out.println(String.format("\n\n\nTest '%s' has FAILED", method.getName()));
        }
        driver.close();
    }
}
