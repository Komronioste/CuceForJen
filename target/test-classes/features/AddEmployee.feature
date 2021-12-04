Feature: Add Employee

  Background: 
    Given user is logged in with valid credentials
    And user navigates to PIM page
    And user navigates to add employee page

  @AddEmployee
  Scenario: Add Employee with firstname and lastname
    When user enters first name "Komron"
    And user enters lastname "Babakhanzoda"
    And user saves the information
    Then validate that "Komron Babakhanzoda" is added successfully

  Scenario: Add Employee without employee id
    When user enters first name
    And user enters last name
    And user deletes default employee id
    And user saves the information
    Then new employee page is displayed

  Scenario: Add Employee and create login Credentials
    When user enters first name
    And user enters last name
    And user click on Create Login Credentials button
    And user enters new username
    And user enters new password
    And user confirm new password
    And user saves the information
    Then new employee page is displayed

  #To perform DDT using scenario outline and examples keywords
  @scenarioOutline
  Scenario Outline: Adding multiple employees
    When user enters employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user saves the information
    Then validate that "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName |
      | James     | J          | Smith    |
      | Erdogan   | E          | Gul      |
      | Jessica   | P          | White    |

  #To perform DDT using Datatable
  @dataTable
  Scenario: Adding multiple employees
    When user enters employee details
      | FirstName | MiddleName | LastName |
      | Atoullo   | J          | Boboev   |
      | Mufasa    | E          | Duke     |
    And user saves the information
    
    @excelDatatable
    Scenario: Add multiple employees from Excel
    When user enters employee data from "Employee" excel sheet then save
