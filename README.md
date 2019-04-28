# Demo Project for Test Automation of Sample Application  "Gurukula"
This is a demo project which is used for Test Automation of Gurukula Application.
 It is done using an open source framework which is Serenity BDD. The complete Technical stack also includes Cucumber, Selenium, Junit. Maven is used for managing the build. 

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured. 



### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature files
          + User Management        Feature file subdirectories 
             login.feature 
             register_user.feature
       + webdriver                 Bundled webdriver binaries
         + linux
         + mac
         + windows 
           chromedriver.exe       OS-specific Webdriver binaries 
           geckodriver.exe
```

## The sample scenario
In this Demo project we have defined scenarios in Cucumber feature files as below. This is done for a sample Gurukula Application. In this scenario, User with a valid username and password is trying to login into the Gurukula Application:

```Gherkin
Feature: User Management
  As a user
  I want to be able to login to my account from the home page
  So that I can view my account information, maintain Branches and Staff information

  Scenario: Login to the application as an existing user
    Given the Gurukula application is available
    When  I login as user 'admin' and password 'admin'
    Then  the Gurukula home page is visible
```


The glue code for this scenario looks this this:

```java
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
```
 

The `NavigateTo` class is an example of a very simple action class.In our sample project, it is used to open the Gurukula home page / registration page /login page etc:
```java
public class NavigateTo {

    GurukulaLandingPage gurukulaLandingPage;

    @Step("Open the Gurukula landing page")
    public void theGurukulaLandingPage() {
        gurukulaLandingPage.open();
    }
}
```

It does this using a standard Serenity Page Object. I have also used it to interact with the web pages`. This gives the class full access to the  Serenity WebDriver API which handles and manages Selenium Webdriver for us. Elements can be found then by using Selenium Webdriver locators like`By` locator or an XPath or CSS expression: :
```java
@DefaultUrl("http://192.168.178.143:8080/")
public class GurukulaLandingPage extends PageObject {

    public void navigatetoLoginForm() {
        getDriver().findElement(By.linkText("login")).click();
    }

    public void navigatetoRegistrationForm() {
        getDriver().findElement(By.linkText("Register a new account")).click();
    }
}

```

## Executing the tests
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn clean verify` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```

The test results will be recorded in the `target/site/serenity` directory.

## Simplified WebDriver configuration and other Serenity extras
Use `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```java
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

The project also bundles some of the WebDriver binaries that you need to run Selenium tests in the `src/test/resources/webdriver` directories. These binaries are configured in the `drivers` section of the `serenity.conf` config file:
```json
drivers {
  windows {
    webdriver.chrome.driver = "src/test/resources/webdriver/windows/chromedriver.exe"
    webdriver.gecko.driver = "src/test/resources/webdriver/windows/geckodriver.exe"
  }
  mac {
    webdriver.chrome.driver = "src/test/resources/webdriver/mac/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/mac/geckodriver"
  }
  linux {
    webdriver.chrome.driver = "src/test/resources/webdriver/linux/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/linux/geckodriver"
  }
}
```

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments.
```json
environments {
   default {
     webdriver.base.url = "http://192.168.178.143:8080/"
   }
   dev {
     webdriver.base.url = "http://192.168.178.143:8080/dev"
   }
   staging {
     webdriver.base.url = "http://192.168.178.143:8080/staging"
   }
   prod {
     webdriver.base.url = "http://192.168.178.143:8080/prod"
   }
```
  
You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```

### Known Issues found in Gurukula until now
Following issues were found while Automating the scenarios
```json
1 Registration Page : 1. User Registration does not work even after providing correct user Information
                      2. Even on loosing focus on login field ,when we have entered invalid username (example -> "s"), no warning is shown which is inconsistent with other fields

```
