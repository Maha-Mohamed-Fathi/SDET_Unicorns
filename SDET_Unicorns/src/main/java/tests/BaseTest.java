package tests;

import browser.Browser;
import driver.WebDriverSingleton;

import java.util.Properties;


public class BaseTest  {
    protected static WebDriverSingleton webDriver;
    protected static Properties URLs;
    protected static Browser browser = new Browser();

    public BaseTest(){
        webDriver = WebDriverSingleton.getDriverSingleton();
    }

}
