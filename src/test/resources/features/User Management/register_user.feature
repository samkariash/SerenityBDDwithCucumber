Feature: User Management

  As a user
  I want to be able to register as a new user
  So that I can create an account on the application

  Background: Navigate to Gurukula application
    Given the Gurukula application is available

# User Registration has a bug , marked below test for manual execution
  @Manual
  Scenario: Register a new user to the application
    When I register as a new user 'samkariashiva' with a password 'password' and email 'shiva.samkaria@gmail.com'
    And I submit the registration Details
    Then the user 'samkariashiva' is registered

  Scenario Outline: Register a new user to the application with an invalid password
    When I register as a new user '<username>' with a password '<password>' and email '<email>'
    Then the error indicating invalid password is displayed

    Examples:
      | username | password        | email                      |
      | username | pass            | nl.samkariashiva@gmail.com |
      | username | MoreThan50Chars | nl.samkariashiva@gmail.com |

  Scenario Outline: Register a new user to the application with an invalid email
      When I register as a new user '<username>' with a password '<password>' and email '<email>'
      Then the error for email is displayed

      Examples:
        | username | password      | email                                               |
        | username  | password     | nl@.co                                              |
        | username  | password     | nl.samkariashiva@gmail                              |
        | username  | password     | emailwhichIsMoreThanFiftyCharacters@gmail           |


  Scenario: Register a new user to the application with a password confirmation mismatch
    When I register as a new user 'newuser' with a password 'password' and email 'samkariashiva@gmail.com'
    But the confirmation password is not same as password
    And I submit the registration Details
    Then the error for password confirmation mismatch is displayed

    # All these multiple conditions Should be tested at unit test level
  @Manual
  Scenario Outline: Validate the Password Strength
    When I register as a new user '<username>' with a password '<password>' and email '<email>'
    Then the appropriate password strength '<password_strength>' is displayed

    Examples:
      | username | password        | email                      | password_strength |
      | username | shiva           | nl.samkariashiva@gmail.com | verylow           |
      | username | S@chin1         | nl.samkariashiva@gmail.com | strong            |


     # All these multiple conditions Should be normally part of unit tests
  @Manual
  Scenario Outline: Validate the username
    When I register as a new user '<username>' with a password '<password>' and email '<email>'
    Then the appropriate error for invalid username is displayed
    Examples:
      | username  | password        | email                      |
      | uSER12    | S@chin100       | nl.samkariashiva@gmail.com |
      | u         | Password        | nl.samkariashiva@gmail.com |



    ## KNOWN ISSUES (Registration Form)
     # 1. User Registration does not work even after providing correct user Information
     # 2. Even on loosing focus on login field ,when we have entered invalid username (example -> "s"), no warning is shown which is inconsistent with other fields
