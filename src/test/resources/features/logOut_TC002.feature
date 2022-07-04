@wip
Feature: Log out Functionality [AutomationS3-AD]

  Background: Log in Page
    Given User should be on log in page

  Scenario Outline: User should NOT go to the home page again
    Given '<User>' log in with valid credentials as '<username>' and '<password>'
    And User click '<user menu>' on right side of  top bar
    Then User should NOT go to the home page again by clicking go back button

    Examples:
      | User         | username                | password     | user menu    |
      | salesmanager | salesmanager15@info.com | salesmanager | salesmanager |
      | posmanager   | posmanager10@info.com   | posmanager   | posmanager   |
