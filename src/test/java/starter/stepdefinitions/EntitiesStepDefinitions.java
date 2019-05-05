package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.AuthenticationPage;
import starter.pages.BranchesPage;
import starter.pages.NavigateTo;

import static junit.framework.TestCase.assertTrue;

public class EntitiesStepDefinitions {

    @Steps
    BranchesPage branchesPage;

    @Steps
    NavigateTo navigateTo;

    @Steps
    AuthenticationPage authenticationPage;

    @When("^I select Branch from entities menu$")
    public void selectBranchFromEntitiesMenu() {
        branchesPage.navigateToBranchDashboard();
    }

    @Given("^the Branch Dashboard is visible$")
    public void branchDashboardIsVisible() {
        navigateTo.theGurukulaLandingPage();
        navigateTo.theGurukulaloginForm();
        authenticationPage.enterLoginInformation("admin","admin");
        authenticationPage.submit();
        navigateTo.theGurukulaLandingPage();
        branchesPage.navigateToBranchDashboard();
        branchesPage.isBranchDashboardVisible();
    }

    @When("^I want to create a new branch using '(.*)' and '(.*)'$")
    public void createANewBranch(String name, String code) {
        branchesPage.createNewBranch(name, code);
    }

    @And("^I submit the required new branch details$")
    public void iSubmitTheRequiredNewBranchDetails() {
        branchesPage.submitBranchDetails();
    }
    @Then("^the new branch should be created$")
    public void theNewBranchShouldBeCreated() {
       assertTrue(branchesPage.isNewBranchCreated());
    }
}
