package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class AuthenticationPage extends PageObject {

    /*
    ** Web elements USERNAME and PASSWORD for Authentication page are defined by CSS selectors below
     */
    static By USERNAME = By.cssSelector("#username");
    static By PASSWORD = By.cssSelector("#password");

    /*
     Enter the login information i.e. username and password on login page
     */
    public void enterLoginInformation(String username, String password){
        $(USERNAME).sendKeys(username);
        $(PASSWORD).sendKeys(password);
    }
    /*
     Submit the authentication details for logging in
     */
    public void submit(){
        getDriver().findElement(By.xpath("//button[contains(text(),'Authenticate')]")).click();
    }
    /*
     Validate if Authentication has failed due to wrong credentials
     */
    public boolean isAuthenticationFailed() {
        return getDriver().findElement(By.xpath("//div[contains(text(),' Please check your credentials and try again.')]")).isDisplayed() ;
    }
}
