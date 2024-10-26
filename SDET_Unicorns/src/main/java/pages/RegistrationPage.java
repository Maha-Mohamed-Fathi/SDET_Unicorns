package pages;

import driver.WebDriverSingleton;
import org.openqa.selenium.*;
import java.io.IOException;


public class RegistrationPage extends BasePage {

    private final By usernameTextField = By.id("username");
    private final By emailTextField = By.id("email");
    private final By passwordTextField = By.id("password");
    private final By genderField = By.id("gender");
    private final By registerButton = By.xpath("//button[@type='submit']");


    public void enterUsername(String username) throws IOException {
        waitUntilElementIsPresent(usernameTextField);
        Credentials = WebDriverSingleton.setUserProperties();
        driver.findElement(usernameTextField).sendKeys(Credentials.getProperty(username));
    }
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

    public void selectGender(String gender) {
        waitUntilElementIsClickable(genderField).click();
        String xpath = "//option[text()='"+gender+"']";
        WebElement genderSelected = WebDriverSingleton.getWebDriver().findElement(By.xpath(xpath));
        genderSelected.click();
    }

    public void clickOnRegisterButton() {
        waitUntilElementIsClickable(registerButton);
        driver.findElement(registerButton).click();
    }

}
