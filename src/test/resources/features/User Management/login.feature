Feature: User Management

  As a user
  I want to be able to login to my account from the home page
  So that I can view my account information, maintain Branches and Staff information

  Background: Navigate to Gurukula application
    Given the Gurukula application is available

  Scenario: Login to the application as an existing user
    When I login as user 'admin' and password 'admin'
    Then the Gurukula home page is visible

  Scenario Outline: Login to the application with invalid credentials
    When I login as user '<username>' and password '<password>'
    Then the error for invalid <incorrect_field> is displayed

    Examples:
      | username | password | incorrect_field |
      | admin    | ad       | password        |
      | user     |          | user            |






