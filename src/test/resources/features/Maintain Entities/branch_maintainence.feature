Feature: Branch Management

  As a user
  I want to be able to navigate to Entities menu
  So that I can view and maintain Branches and Staff information

  Background: Navigate to Gurukula application
    Given the Branch Dashboard is visible

  Scenario Outline: User should be able to create a new Branch
    When I want to create a new branch using '<name>' and '<code>'
    And I submit the required new branch details
    Then the new branch should be created

    Examples:
    |name        |code            |
    |mybranchname | D2            |

    @Manual
  Scenario Outline: User should be able to search a Branch using a keyword which can be ID, Name or code
    When I search for a branch using a '<keyword>'
    Then the appropriate '<search result>' should be displayed

     Examples:
    |keyword           |search result|
    |mybranchname      | is Displayed|
    |1                 | is Displayed|
    |S2                | is Displayed|
    |notexistingbranch | not found   |

      @Manual
  Scenario Outline : User should be able to edit a Branch
    When I select for a branch '<branch>' for editing
    And I submit new details for '<new name>' and '<new code>'
    Then branch Information should be modified

    Examples:
    |branch          |new name         |new code|
    |mybranchname  | mybranchnamenew   |SS8     |

  @Manual
  Scenario : User should be able to delete a Branch
    When I select for a branch '<branch>' for deletion
    And I confirm my decision
    Then branch Information should be deleted

  @Manual
  Scenario : User should be able to cancel the decision to delete a Branch
    When I select for a branch '<branch>' for deletion
    And I cancel my decision
    Then branch Information should not be deleted

  @Manual
  Scenario : User should be able to view  a Branch using the View Button
    When I select for a branch '<branch>' for viewing using View Button
    Then branch Information should be displayed

  @Manual
  Scenario : User should be able to view  a Branch using the ID link
    When I select for a branch '<branch>' for viewing using ID of the branch
    Then branch Information should be displayed



  @Manual
  Scenario Outline : Verify Input fields during branch creation
    When I  create a new branch using '<name>' and '<code>'
    When I enter a '<name>'  or '<code>' which is invalid
    Then appropriate <error information> should be displayed

    Examples:
    |name           |code       |error information                                          |
    | name          |S3         |    This field is required to be at least 5 characters.    |
    | branchnames   |s2         | This field should follow pattern ^[A-Z0-9]*$.             |


