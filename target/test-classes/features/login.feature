@FIDEX-376 @LoginAutomated
Feature: As a user, I should be able to log in so that I can land on homepage.

  Background:
    Given User should be on log in page

  @FIDEX-367 @LoginAutomated @FIDEX-371 @FIDEX-63 @LoginAutomated
  Scenario: As a PosManager, I should be log in with valid credentials successfully
    Given User can enter with valid credentials
      | posmanager10@info.com | posmanager |
    And User sees username in the email textbox
    And User sees password in the textbox in bullet signs by default
    Then User click log in button
    And User should be able to see "posmanager" on right side of  top bar

  @FIDEX-371 @FIDEX-63 @LoginAutomated @FIDEX-372 @FIDEX-63 @LoginAutomated @FIDEX-373 @LoginAutomated
  Scenario: As a SalesManager, I should log in with valid credentials successfully
    Given User can enter with valid credentials
      | salesmanager15@info.com | salesmanager |
    And User sees username in the email textbox
    And User sees password in the textbox in bullet signs by default
    Then User press Enter on keyboard
    And User should be able to see "salesmanager" on right side of  top bar

  @FIDEX-370 @LoginAutomated
  Scenario: As a user, I should be landing on the ‘reset password’ page
  after clicking on the "Reset password" link
    When After User click on Reset password button, user should be landing on Reset password page


