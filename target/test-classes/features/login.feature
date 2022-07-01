
Feature: As a user, I should be able to log in so that I can land on homepage.

  Background:
    Given User should be on log in page

  Scenario: As a PosManager, I should be log in with valid credentials successfully
    Given User can enter with valid credentials
      | posmanager10@info.com | posmanager |
    And User sees username in the email textbox
    And User sees password in the textbox in bullet signs by default
    Then User click log in button
    And User should be able to see "posmanager" on right side of  top bar


  Scenario: As a SalesManager, I should be log in with valid credentials successfully
    Given User can enter with valid credentials
      | salesmanager15@info.com | salesmanger |
    And User sees username in the email textbox
    And User sees password in the textbox in bullet signs by default
    Then User press Enter on keyboard
    And User should be able to see "salesmanager" on right side of  top bar

  @Fidex-345
  Scenario Outline:As a User, I should NOT be log in with invalid credentials
    Given As a '<user>', I try to log in with '<invalid credentials>' like '<username>' and '<password>'
    And User click log in button
    Then User get a "<message>"

    Examples:
      | user         | invalid credentials          | username                | password          | message                    |
      | PosManager   | no username no password      |                         |                   | Please fill out this field |
      | PosManager   | wrong username true password | posmanager10info.com    | posmanager        | Wrong login/password       |
      | PosManager   | true username wrong password | posmanager10@info.com   | posmanagerFalse   | Wrong login/password       |
      | SalesManager | no username no password      |                         |                   | Please fill out this field |
      | SalesManager | wrong username true password | salesmanager10info.com  | salesmanager      | Wrong login/password       |
      | SalesManager | true username wrong password | salesmanager10@info.com | salesmanagerFalse | Wrong login/password       |


  Scenario: As a user, I should be landing on the ‘reset password’ page
  after clicking on the "Reset password" link
    When After User click on Reset password button, user should be landing on Reset password page


