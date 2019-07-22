package base;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTestClass {

    WebDriver driver;

    @BeforeSuite
    public void before(){
        System.out.println("Test Suite is running");
    }

    @BeforeMethod
    public void launchBrowser(Method method){
        System.out.println("-----------------    " + method.getName() + "    -----------------");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ryanair.co.uk");
        WebDriverWait wait = new WebDriverWait(driver, 600);
        wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
        driver.manage().deleteAllCookies();
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
