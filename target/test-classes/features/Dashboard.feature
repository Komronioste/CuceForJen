Feature: Dashboard Menu

  @menu
  Scenario: Dashboard Menu for Admin
    Given user is logged in with valid credentials
    Then I want to see this items in the menu
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Buzz        |
