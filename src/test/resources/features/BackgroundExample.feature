
Feature: Background Example
  
  Background:     #runs before each scenario and after hooks
    Given Precondition1
    And Precondition2
   
   	@Background
   Scenario: Example1
    When Test step1 firstname is "Hakan" and lastname is "Kurhan"
    And Test step2
    And Test step3 age is 30
    Then Validation1
    And Validation2
    
    @Background
   Scenario: Example2
    When Test step4
    And Test step5
    And Test step6
    Then Validation3
    And Validation4
    
   
    

