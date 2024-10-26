package pages;

import org.openqa.selenium.By;


public class HomePage extends BasePage {

    private final By userProfileButton = By.xpath("//button[@class='account-setting-active']");
    private final By registerIcon = By.xpath("//a[@href='/register']");
    private final By logoutButton = By.xpath("(//li[text()='Logout'])[1]");
    private final By loginIcon = By.xpath("//a[@href='/login']");
    private final By myAccountButton = By.xpath("(//a[text()='my account'])[1]");
    private final By productButton = By.xpath("(//a[@href ='/shop-grid-standard'])[1]");

    public void clickOnUserProfile() {
        waitUntilElementIsClickable(userProfileButton).click();
    }
    public void clickOnRegisterButton() {
        waitUntilElementIsClickable(registerIcon).click();
    }
    public Boolean findLogoutButton(){return waitUntilElementIsClickable(logoutButton).isDisplayed();}
    public void clickOnLoginButton(){waitUntilElementIsClickable(loginIcon).click();}
    public Boolean findMyAccountButton(){return waitUntilElementIsClickable(myAccountButton).isDisplayed();}
    public void clickOnProductButton(){waitUntilElementIsClickable(productButton).click();}

    public RegistrationPage goToRegistrationPage(){
        return new RegistrationPage();
    }
    public LoginPage goToLoginPage(){
        return new LoginPage();
    }
    public ProductPage goToProductPage(){
        return new ProductPage();
    }


}
