package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;


import java.io.IOException;

public class SignUpNewUserStepDefs extends BaseTest {

    @Given("Home Page for SDET Unicorns Page is Opened")
    public void homePageForSDETUnicornsPageIsOpened() {
        browser.sdetUnicorns.home.waitUntilPageLoad();
    }

    @And("Click on UserProfile button")
    public void clickOnUserProfileButton() {
        browser.sdetUnicorns.home.waitUntilPageLoad();
        browser.sdetUnicorns.home.clickOnUserProfile();
    }

    @And("Click on Register button")
    public void clickOnRegisterButton() {
        browser.sdetUnicorns.home.waitUntilPageLoad();
        browser.sdetUnicorns.home.clickOnRegisterButton();
    }

    @And("Enter Username with{string}")
    public void enterUsernameWith(String username) throws IOException {
        browser.sdetUnicorns.registration = browser.sdetUnicorns.home.goToRegistrationPage();
        browser.sdetUnicorns.registration.enterUsername(username);
    }

    @And("Enter Email with{string}")
    public void enterEmailWith(String email) throws IOException {
        browser.sdetUnicorns.registration.enterEmail(email);
    }

    @And("Enter Password with{string}")
    public void enterPasswordWith(String password) throws IOException {
        browser.sdetUnicorns.registration.enterPassword(password);
    }

    @And("Select Gender with{string}")
    public void selectGenderWith(String gender) {
        browser.sdetUnicorns.registration.selectGender(gender);
    }

    @And("Click on Register button for submitting")
    public void clickOnRegisterButtonForSubmitting() {
        browser.sdetUnicorns.registration.clickOnRegisterButton();
    }

    @Then("Validate UserProfile contains logout button")
    public void validateUserProfileContainsLogoutButton() {
        browser.sdetUnicorns.home.clickOnUserProfile();
        Boolean logoutButtonIsExist= browser.sdetUnicorns.home.findLogoutButton();
        Assert.assertEquals(logoutButtonIsExist,true);
    }

}
