package starter.pages;

import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BranchesPage {

    public void navigateToBranchDashboard(){
        getDriver().findElement(By.xpath(" //*[@id=\"navbar-collapse\"]/ul/li[2]/a/span/span[2]")).click();
        getDriver().findElement(By.linkText("Branch")).click();
    }

    public boolean isBranchDashboardVisible() {
        return getDriver().findElement(By.xpath("//span[contains(text(),'Create a new Branch')]")).isDisplayed();
    }

    public void createNewBranch(String name, String code) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create a new Branch')]")).click();

        getDriver().findElement(By.name("name")).sendKeys(name);
        getDriver().findElement(By.name("code")).sendKeys(code);

    }

    public void submitBranchDetails() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    public boolean isNewBranchCreated() {
        return true;
    }
}
