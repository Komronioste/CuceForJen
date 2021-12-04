#Author NeotechAcademy
@signal
Feature: Signal Telecom Sign In

  Background: 
    Given User goes to Sign In page

  @invalid
  Scenario: Invalid Credentials Sign In
    When User enters invalid email
    And User enters an invalid password
    And User clicks on Sign In button
    Then User sees an error message

  @empty
  Scenario: Empty Email Sign In
    When User leaves empty email
    And User enters an invalid password
    And User clicks on Sign In button
    Then User sees an error message

  @parametrized
  Scenario: Parametrized Sign In
    When User enters an invalid email as "komronbaba@gmail.com"
    And User enters an invalid password as "whatever"
    And User clicks on Sign In button
    Then User sees an error message
		And Validate the error message