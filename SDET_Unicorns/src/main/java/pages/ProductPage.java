package pages;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;


public class ProductPage extends BasePage {

    private final By keyboardCheckbox = By.xpath("//button[text()='keyboard']");
    private final By applyButton = By.xpath("//button[text()='Apply']");
    private final By keyboardSearchResult = By.xpath("//div[@class='shop-top-bar mb-35']/h4");
    private final By productName = By.xpath("//div[@class='product-details-content ml-70']/h2");
    private final By price = By.xpath("//div[@class='product-details-price']");
    private final By productCart = By.xpath("(//span[@class='count-style'])[1]");
    private final By addToCartButton = By.xpath("//div[@class='pro-details-cart btn-hover']");
    private final By laptopCheckbox = By.xpath("(//button[text()='laptop'])[1]");
    private final By priceOfKeyboardInCart = By.xpath("(//div[@class='shopping-cart-title']/span)[1]");
    private final By priceOfLaptopInCart = By.xpath("(//div[@class='shopping-cart-title']/span)[2]");
    private final By totalPriceInCart = By.xpath("//span[@class='shop-total']");
    private final By viewCartButton = By.xpath("//a[@href='/cart']");
    private final By checkoutButton = By.xpath("(//a[@href='/checkout'])[2]");
    private final By countryField = By.name("rcrs-country");
    private final By regionField = By.name("rcrs-region");
    private final By address1TextField = By.name("address1");
    private final By zipTextField = By.name("postalcode");
    private final By phoneTextField = By.xpath("//input[@name='contact']");
    private final By cashOnDeliveryCheckBox = By.xpath("//input[@type='checkbox']");
    private final By confirmButton = By.xpath("//button[text()='Confirm']");
    private final By orderCart = By.className("panel-title");
    private final By countyLabelInOrder = By.xpath("(//h4[@class='mx-4'])[1]");
    private final By regionLabelInOrder = By.xpath("(//h4[@class='mx-4'])[2]");
    private final By address1LabelInOrder = By.xpath("(//h4[@class='mx-4'])[3]");
    private final By totalPriceLabelInOrder = By.xpath("(//h4[@class='mx-4'])[4]");
    private String finalTotalPrice;


    public void clickOnKeyboardCheckbox() {
        waitUntilElementIsClickable(keyboardCheckbox).click();
    }

    public void clickOnApplyButton() {
        waitUntilElementIsClickable(applyButton).click();
    }

    public String getKeyboardNumberOfSearchResult() {
        waitUntilElementIsPresent(keyboardSearchResult);
        return driver.findElement(keyboardSearchResult).getText();
    }

    public void clickOnKeyboardProduct(String keyboardName) throws IOException {
        Credentials = WebDriverSingleton.setProductProperties();
        String xpath = "(//a[text()='" + Credentials.getProperty(keyboardName) + "'])[1]";
        WebElement keyboardProduct = WebDriverSingleton.getWebDriver().findElement(By.xpath(xpath));
        keyboardProduct.click();
    }

    public String getProductName()  {
        waitUntilElementIsPresent(productName);
        return driver.findElement(productName).getText();
    }

    public String getPrice()  {
        waitUntilElementIsPresent(price);
        return driver.findElement(price).getText();
    }

    public String getProductCartValue() {
        waitUntilElementIsPresent(productCart);
        return driver.findElement(productCart).getText();
    }

    public void clickOnAddToCartButton() {
        waitUntilElementIsClickable(addToCartButton).click();
    }

    public void clickOnLaptopCheckbox() {
        waitUntilElementIsClickable(laptopCheckbox).click();
    }

    public void clickOnApplyButtonForLaptop() {
        WebDriverSingleton.refreshCurrentUrl();
        waitUntilElementIsClickable(applyButton).click();
    }

    public void clickOnLaptopProduct(String laptopName) throws IOException {
        Credentials = WebDriverSingleton.setProductProperties();
        String xpath = "(//a[text()='" + Credentials.getProperty(laptopName) + "'])[1]";
        WebElement laptopProduct = WebDriverSingleton.getWebDriver().findElement(By.xpath(xpath));
        laptopProduct.click();
        WebDriverSingleton.refreshCurrentUrl();
    }

    public void clickOnCartButton() {
        waitUntilElementIsClickable(productCart).click();
    }
    public String getTotalPrice() {
        waitUntilElementIsPresent(priceOfKeyboardInCart);
        waitUntilElementIsPresent(priceOfLaptopInCart);
        double priceOfKeyboard = Double.parseDouble(driver.findElement(priceOfKeyboardInCart).getText());
        double priceOfLaptop = Double.parseDouble(driver.findElement(priceOfLaptopInCart).getText());
        String totalPrice = "$" + String.valueOf(priceOfKeyboard + priceOfLaptop) + "0";
        return totalPrice;
    }

    public String getTotalPricesInCart() {
        return finalTotalPrice = driver.findElement(totalPriceInCart).getText();
    }

    public void clickOnCheckoutButton() {
        waitUntilElementIsClickable(viewCartButton).click();
        waitUntilElementIsClickable(checkoutButton).click();
    }

    public void selectCountry(String country) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        waitUntilElementIsClickable(countryField).click();
        Credentials = WebDriverSingleton.setUserProperties();
        String xpath = "//option[text()='" + Credentials.getProperty(country) + "']";
        WebElement countrySelected = WebDriverSingleton.getWebDriver().findElement(By.xpath(xpath));
        countrySelected.click();
    }

    public void selectRegion(String region) throws IOException {
        waitUntilElementIsClickable(regionField).click();
        Credentials = WebDriverSingleton.setUserProperties();
        String xpath = "//option[text()='" + Credentials.getProperty(region) + "']";
        WebElement regionSelected = WebDriverSingleton.getWebDriver().findElement(By.xpath(xpath));
        regionSelected.click();
    }

    public void enterAddress1(String address1) throws IOException {
        waitUntilElementIsPresent(address1TextField);
        Credentials = WebDriverSingleton.setUserProperties();
        driver.findElement(address1TextField).sendKeys(Credentials.getProperty(address1));
    }

    public void enterZip(String zip) throws IOException {
        waitUntilElementIsPresent(zipTextField);
        Credentials = WebDriverSingleton.setUserProperties();
        driver.findElement(zipTextField).sendKeys(Credentials.getProperty(zip));
    }

    public void enterPhone(String phone) throws IOException {
        waitUntilElementIsPresent(phoneTextField);
        Credentials = WebDriverSingleton.setUserProperties();
        driver.findElement(phoneTextField).sendKeys(Credentials.getProperty(phone));
    }

    public void clickOnCashOnDeliveryCheckBox() {
        waitUntilElementIsClickable(cashOnDeliveryCheckBox).click();
    }

    public void clickOnConfirmButton() {
        waitUntilElementIsClickable(confirmButton).click();
    }

    public void clickOnOrderCart() {
        waitUntilElementIsClickable(orderCart).click();
    }

    public String getCountryInOrder()  {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        waitUntilElementIsPresent(countyLabelInOrder);
        return driver.findElement(countyLabelInOrder).getText();
    }

    public String getRegionInOrder()  {
        waitUntilElementIsPresent(regionLabelInOrder);
        return driver.findElement(regionLabelInOrder).getText();
    }

    public String getAddress1InOrder()  {
        waitUntilElementIsPresent(address1LabelInOrder);
        return driver.findElement(address1LabelInOrder).getText();
    }

    public String getTotalPriceInOrder() {
        waitUntilElementIsPresent(totalPriceLabelInOrder);
        return (driver.findElement(totalPriceLabelInOrder).getText());
    }
}
