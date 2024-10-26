package tests;

import driver.WebDriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import java.io.IOException;
import java.util.Properties;

public class MakeOrderStepDefs extends BaseTest {
    static Properties Credentials;
    private String finalTotalPrice;

    @Given("Given Home Page for SDET Unicorns Page is Opened")
    public void givenHomePageForSDETUnicornsPageIsOpened() {
        browser.sdetUnicorns.home.waitUntilPageLoad();
    }

    @And("Click on Login button")
    public void clickOnLoginButton() {
        browser.sdetUnicorns.home.waitUntilPageLoad();
        browser.sdetUnicorns.home.clickOnLoginButton();
    }

    @Then("Login Page is Opened")
    public void loginPageIsOpened() {
        browser.sdetUnicorns.login = browser.sdetUnicorns.home.goToLoginPage();
    }

    @And("Enter Email with{string} in Login Form")
    public void enterEmailWithInLoginForm(String email) throws IOException {
        browser.sdetUnicorns.login.enterEmail(email);
    }

    @And("Enter Password with{string} in Login Form")
    public void enterPasswordWithInLoginForm(String password) throws IOException {
        browser.sdetUnicorns.login.enterPassword(password);
    }

    @And("Click on Login button in Login Form")
    public void clickOnLoginButtonInLoginForm() {
        browser.sdetUnicorns.login.clickOnLoginButton();
    }

    @Then("Validate that Account is open successfully")
    public void validateThatAccountIsOpenSuccessfully() {
        browser.sdetUnicorns.home.clickOnUserProfile();
        Boolean myAccountButtonIsExist = browser.sdetUnicorns.home.findMyAccountButton();
        Assert.assertEquals(myAccountButtonIsExist, true);
    }

    @And("Click on Keyboards in categories in home page")
    public void clickOnKeyboardsInCategoriesInHomePage() {
        browser.sdetUnicorns.product = browser.sdetUnicorns.home.goToProductPage();
        browser.sdetUnicorns.product.clickOnKeyboardCheckbox();
    }

    @And("Click on Apply Button")
    public void clickOnApplyButton() {
        browser.sdetUnicorns.product.clickOnApplyButton();
    }

    @Then("Validate that number of keyboard products is {string}")
    public void validateThatNumberOfKeyboardProductsIs(String keyboardResult) {
        Assert.assertEquals(browser.sdetUnicorns.product.getKeyboardNumberOfSearchResult(), keyboardResult);
    }

    @And("Click on Keyboard with {string}")
    public void clickOnKeyboardWith(String keyboardName) throws IOException {
        browser.sdetUnicorns.product.clickOnKeyboardProduct(keyboardName);
    }

    @Then("Validate that Product Name is {string}")
    public void validateThatProductNameIs(String keyboardName) throws IOException {
        Credentials = WebDriverSingleton.setProductProperties();
        Assert.assertEquals(browser.sdetUnicorns.product.getProductName(), Credentials.getProperty(keyboardName));
    }

    @And("Validate that Product Price is {string}")
    public void validateThatProductPriceIs(String keyboardPrice) throws IOException {
        Credentials = WebDriverSingleton.setProductProperties();
        Assert.assertEquals(browser.sdetUnicorns.product.getPrice(), Credentials.getProperty(keyboardPrice));
    }


    @And("Validate that product cart are empty with {string}")
    public void validateThatProductCartAreEmptyWith(String productCartValue) {
        Assert.assertEquals(browser.sdetUnicorns.product.getProductCartValue(), productCartValue);

    }

    @And("Click on Add To Cart Button")
    public void clickOnAddToCartButton() {
        browser.sdetUnicorns.product.clickOnAddToCartButton();
    }

    @And("Validate that product cart contain one element with {string}")
    public void validateThatProductCartContainOneElementWith(String productCartValue) {
        Assert.assertEquals(browser.sdetUnicorns.product.getProductCartValue(), productCartValue);
    }

    @And("Click on Product Button")
    public void clickOnProductButton() {
        browser.sdetUnicorns.home.clickOnProductButton();
    }

    @And("Click on Laptop in categories in home page")
    public void clickOnLaptopInCategoriesInHomePage() {
        browser.sdetUnicorns.product.clickOnLaptopCheckbox();
    }

    @Then("Click on Apply Button for Laptop in categories in home page")
    public void clickOnApplyButtonForLaptopInCategoriesInHomePage() {
        browser.sdetUnicorns.product.clickOnApplyButtonForLaptop();
    }

    @And("Click on Laptop with {string}")
    public void clickOnLaptopWith(String laptopProduct) throws IOException {
        browser.sdetUnicorns.product.clickOnLaptopProduct(laptopProduct);
    }

    @And("Validate that product cart contain two elements with {string}")
    public void validateThatProductCartContainTwoElementsWith(String productCartValue) {
        Assert.assertEquals(browser.sdetUnicorns.product.getProductCartValue(), productCartValue);
    }

    @And("Click on Cart Button")
    public void clickOnCartButton() {
        browser.sdetUnicorns.product.clickOnCartButton();

    }

    @Then("Validate that total amount is calculated correctly")
    public void validateThatTotalAmountIsCalculatedCorrectly() {
        Assert.assertEquals(browser.sdetUnicorns.product.getTotalPricesInCart(), browser.sdetUnicorns.product.getTotalPrice());
        finalTotalPrice = browser.sdetUnicorns.product.getTotalPricesInCart();
    }

    @And("Click on Checkout button")
    public void clickOnCheckoutButton() {
        browser.sdetUnicorns.product.clickOnCheckoutButton();
    }

    @And("Enter Country with {string}, Region with {string}, Address with {string}, ZIP with {string} and Phone {string}")
    public void enterCountryWithRegionWithAddressWithZIPWithAndPhone(String country, String region, String address1, String zip, String phone) throws IOException {
        browser.sdetUnicorns.product.selectCountry(country);
        browser.sdetUnicorns.product.selectRegion(region);
        browser.sdetUnicorns.product.enterAddress1(address1);
        browser.sdetUnicorns.product.enterZip(zip);
        browser.sdetUnicorns.product.enterPhone(phone);
        browser.sdetUnicorns.product.clickOnCashOnDeliveryCheckBox();
    }

    @And("Click on Confirm Button")
    public void clickOnConfirmButton() {
        browser.sdetUnicorns.product.clickOnConfirmButton();
    }

    @Then("Validate that shipping address are correct and total price")
    public void validateThatShippingAddressAreCorrectAndTotalPrice() throws IOException {
        browser.sdetUnicorns.product.clickOnOrderCart();
        browser.sdetUnicorns.home.clickOnUserProfile();
        Credentials = WebDriverSingleton.setUserProperties();
        Assert.assertEquals(browser.sdetUnicorns.product.getCountryInOrder(), "Country : " + (Credentials.getProperty("country")));
        Assert.assertEquals(browser.sdetUnicorns.product.getRegionInOrder(), "Region : " + (Credentials.getProperty("region")));
        Assert.assertEquals(browser.sdetUnicorns.product.getAddress1InOrder(), "Address 1 : " + (Credentials.getProperty("address1")));
        Assert.assertEquals(browser.sdetUnicorns.product.getTotalPriceInOrder() + ".00", "Total : " + finalTotalPrice);
    }


}
