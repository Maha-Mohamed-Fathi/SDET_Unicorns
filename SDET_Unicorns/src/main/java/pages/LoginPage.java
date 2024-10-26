package pages;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import java.io.IOException;

public class LoginPage extends BasePage{


    private final By emailTextField = By.id("email");
    private final By passwordTextField = By.id("password");
    private final By loginButton = By.xpath("//button[@type= 'submit']");

     public void enterEmail(String email) throws IOException {
        waitUntilElementIsPresent(emailTextField);
        Credentials = WebDriverSingleton.setUserProperties();
        driver.findElement(emailTextField).sendKeys(Credentials.getProperty(email));
    }
    public void enterPassword(String password) throws IOException {
        waitUntilElementIsPresent(passwordTextField);
        Credentials = WebDriverSingleton.setUserProperties();
        driver.findElement(passwordTextField).sendKeys(Credentials.getProperty(password));

    }
    public void clickOnLoginButton() {
        waitUntilElementIsClickable(loginButton).click();
    }
    public HomePage goHome(){
        return new HomePage();
    }

}
