package waits;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUntil {

    final static int waitTime = 100000 ;
    final static int waitTimeForPage = 600000 ;

    public WebElement waitUntilElementIsPresent(By by){
        return new WebDriverWait(WebDriverSingleton.getWebDriver(),
                Duration.ofSeconds(waitTime)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitUntilElementIsClickable(By by){
        return new WebDriverWait(WebDriverSingleton.getWebDriver(),
                Duration.ofSeconds(waitTime)).until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebDriverWait waitUntilPageLoad()  {
        return new WebDriverWait (WebDriverSingleton.getWebDriver(),Duration.ofSeconds(waitTimeForPage));
    }


}
