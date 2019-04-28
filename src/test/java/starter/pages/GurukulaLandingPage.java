package starter.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


@DefaultUrl("http://192.168.178.143:8080/")
public class GurukulaLandingPage extends PageObject {

    public void navigatetoLoginForm() {
        getDriver().findElement(By.linkText("login")).click();
    }

    public void navigatetoRegistrationForm() {
        getDriver().findElement(By.linkText("Register a new account")).click();
    }
}
