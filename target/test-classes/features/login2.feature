@FIDEX-367 @LoginAutomated
Feature:
  Background:
    Given User should be on log in page

  @FIDEX-368 @LoginAutomated
  Scenario Outline:As a User, I should NOT log in with invalid credentials
    Given As a '<user>', I try to log in with '<invalid credentials>' like '<username>' and '<password>'
    And User click log in button
    Then User get a "<message>"

    Examples:
      | user         | invalid credentials          | username                | password          | message              |
      | PosManager   | wrong username true password | posmanager10info.com    | posmanager        | Wrong login/password |
      | PosManager   | true username wrong password | posmanager10@info.com   | posmanagerFalse   | Wrong login/password |
      | SalesManager | wrong username true password | salesmanager10info.com  | salesmanager      | Wrong login/password |
      | SalesManager | true username wrong password | salesmanager10@info.com | salesmanagerFalse | Wrong login/password |


  @FIDEX-369 @LoginAutomated
  Scenario Outline:As a User, I should NOT log in with invalid credentials
    Given As a user, I try to log in with empty credentials in '<username>' and '<password>' fields, then I get "Please fill out this field." message in '<message field>'
    Examples:
      | username   | password | message field |
      |            |          | email         |
      | posmanager |          | password      |
      |            | password | email         |