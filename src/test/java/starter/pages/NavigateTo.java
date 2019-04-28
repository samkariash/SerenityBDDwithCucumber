package starter.pages;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    GurukulaLandingPage gurukulaLandingPage;

    @Step("Open the Gurukula landing page")
    public void theGurukulaLandingPage() {
        gurukulaLandingPage.open();
    }

    @Step("Open the Gurukula login form")
    public void theGurukulaloginForm() {
        gurukulaLandingPage.navigatetoLoginForm();
    }

    @Step("Open the Gurukula Registration form")
    public void theGurukulaRegistrationForm() {
        gurukulaLandingPage.navigatetoRegistrationForm();
    }
}
