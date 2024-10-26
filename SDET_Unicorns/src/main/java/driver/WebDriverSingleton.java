package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverSingleton {

    private static WebDriver webDriver;
    private static WebDriverSingleton webDriverSingleton = null;
    private static String urlPath = "resources/config/URLs.properties";
    private static String credentialsPath = "resources/config/Credentials.properties";
    private static String productPath = "resources/config/Products.properties";

    private WebDriverSingleton() {
        setDriverCapabilities();
    }

    public static WebDriverSingleton getDriverSingleton()
    {
        if (webDriverSingleton == null)
            webDriverSingleton = new WebDriverSingleton();
        return webDriverSingleton;
    }

    private void setDriverCapabilities() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
    }
    public static Properties setProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream;
        inputStream = new FileInputStream(urlPath);
        configProperties.load(inputStream);
        return configProperties;
    }
    public static Properties setUserProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream;
        inputStream = new FileInputStream(credentialsPath);
        configProperties.load(inputStream);
        return configProperties;
    }

    public static Properties setProductProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream;
        inputStream = new FileInputStream(productPath);
        configProperties.load(inputStream);
        return configProperties;
    }
    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void navigateTo(String link)  {
        webDriver.navigate().to(link);
    }

    public static void refreshCurrentUrl() {
        webDriver.navigate().refresh();
    }

    public void resetCache() {
        webDriver.manage().deleteAllCookies();
    }

    public static void close() {
        webDriver.quit();
    }
}
