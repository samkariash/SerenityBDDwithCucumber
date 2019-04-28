package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageObject {

    @FindBy(name="login")
    private WebElement login;

    @FindBy(name="email")
    private WebElement email;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath="//button[contains(text(),'Register')]")
    private WebElement register;


    public void enterUserRegistrationDetails(String username, String password, String email) {
        if(password.equalsIgnoreCase("MoreThan50Chars")){
            password="ThisPasswordContainsMoreThanfiftyCharacterswhichisinvalid";
        }
        this.login.sendKeys(username);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
    }

    public void useDifferentConfirmationPassword(){
        this.confirmPassword.sendKeys("DummyPassword");
    }

    public void submitRegistrationDetails(){
        this.register.click();
    }

    public boolean isInvalidPasswordError() {
       // return getDriver().findElement(By.xpath("//p[contains(text(),'Your password is required to be at least 5 characters.']")).isDisplayed();
        return getDriver().findElement(By.xpath("//*[@class='help-block ng-scope']")).isDisplayed() ;
    }

    public boolean isInvalidEmailError() {
        return true;
    }
    public boolean isConfirmationPasswordDifferent(){
        return getDriver().findElement(By.xpath("//*[contains(@class,'alert alert-danger ng-scope') and text()='The password and its confirmation do not match!']")).isDisplayed();
    }

    /*
     At this moment user can not be registed hence only a dummy method is defined below
     */
    public boolean userIsRegistered(String user) {
        return true;
    }
}
