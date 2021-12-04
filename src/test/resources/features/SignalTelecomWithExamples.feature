#Author: Neotech Academy
Feature: Signal Telecom Sign In With Examples

  Background: 
    Given User goes to Sign In page

  @examples
  Scenario Outline: Sign in with examples
    When User enters an invalid email as "<email>"
    And User enters an invalid password as "<password>"
    And User clicks on Sign In button
    Then User sees an error message

    Examples: 
      | email           | password    |
      | user1@gmail.com | password123 |
      |                 | password321 |
      | user1@gmail.com |             |
