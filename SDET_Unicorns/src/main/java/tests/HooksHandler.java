package tests;

import driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.IOException;


public class HooksHandler extends BaseTest {

    @Before (value = "@SdetUnicorns", order = 1)
    public void initialize() throws InterruptedException, IOException {
        webDriver = WebDriverSingleton.getDriverSingleton();
        webDriver.resetCache();
        URLs = WebDriverSingleton.setProperties();
        webDriver.navigateTo(URLs.getProperty("url"));

    }

    @After(value = "@SdetUnicorns")
    public void tearDown()  {
        webDriver.resetCache();
        closeWebDriverAfterAllTestsHook();
    }

    private void closeWebDriverAfterAllTestsHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(WebDriverSingleton::close));

    }


}
