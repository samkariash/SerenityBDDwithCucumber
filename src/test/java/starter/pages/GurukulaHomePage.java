package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class GurukulaHomePage extends PageObject {

//    @FindBy(id="")
//    private WebElement lblWelcome;

    public boolean isGurukulaHomePage(){
        return getDriver().findElement(By.xpath("//h1[contains(text(),'Welcome to Gurukula!')]")).isDisplayed();
    }
}
