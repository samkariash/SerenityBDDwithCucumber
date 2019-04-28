package starter.stepdefinitions;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.pages.AuthenticationPage;
import starter.pages.GurukulaHomePage;
import starter.pages.NavigateTo;
import starter.pages.RegistrationPage;

import static junit.framework.TestCase.assertTrue;


public class GurukulaHomeStepDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    AuthenticationPage authenticationPage;

    @Steps
    GurukulaHomePage gurukulaHomePage;

    @Steps
    RegistrationPage registrationPage;

    @Given("^the Gurukula application is available$")
    public void theGurukulaApplicationIsAvailable() {
        navigateTo.theGurukulaLandingPage();
    }

    @When("^I login as user '(.+)' and password '(.*)'$")
    public void loginGurukulaUser(String username, String password) {
        navigateTo.theGurukulaloginForm();
        authenticationPage.enterLoginInformation(username,password);
        authenticationPage.submit();

    }

    @Then("^the Gurukula home page is visible$")
    public void theAccountInformationIsVisible() {
        assertTrue(gurukulaHomePage.isGurukulaHomePage());
    }

    @Then("^the error for invalid (?:.*) is displayed$")
    public void theErrorForInvalidFieldIsDisplayed() {
        assertTrue(authenticationPage.isAuthenticationFailed());
    }

    @When("^I register as a new user '(.*)' with a password '(.*)' and email '(.*)'$")
    public void registerNewUserDetails(String username, String password, String email) {
        navigateTo.theGurukulaRegistrationForm();
        registrationPage.enterUserRegistrationDetails(username, password, email);
    }

    @Then("^the error indicating invalid password is displayed$")
    public void theErrorIndicatingInvalidPasswordIsDisplayed() {
        assertTrue(registrationPage.isInvalidPasswordError());
    }

    @Then("^the error for email is displayed$")
    public void theErrorForEmailIsDisplayed() {
        assertTrue(registrationPage.isInvalidEmailError());
    }

    @But("^the confirmation password is not same as password$")
    public void theConfirmationPasswordIsNotSameAsPassword() {
        registrationPage.useDifferentConfirmationPassword();
    }

    @Then("^the user '(.*)' is registered$")
    public void theUserNewUserIsRegistered(String user) {
        assertTrue(registrationPage.userIsRegistered(user));

    }

    @Then("^the error for password confirmation mismatch is displayed$")
    public void theErrorForPasswordMismatchIsDisplayed() {
        registrationPage.isConfirmationPasswordDifferent();
    }

    @And("^I submit the registration Details$")
    public void iSubmitTheRegistrationDetails() {
        registrationPage.submitRegistrationDetails();
    }

}
