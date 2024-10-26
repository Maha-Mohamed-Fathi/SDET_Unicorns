package pages;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waits.WaitUntil;

import java.util.Properties;

public class BasePage extends WaitUntil {
    protected static Properties Credentials;
    protected WebDriver driver = WebDriverSingleton.getWebDriver();

    public WebElement findElement(By element){
        return  driver.findElement(element);

    }
}
