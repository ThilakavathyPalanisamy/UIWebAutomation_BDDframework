Feature: Open saucedemo login page

  @LoginPage
  Scenario Outline: Signin into saucelab
    Given Open saucedemo launch login page
    And  Verify the title
    Then Enter the value "<Username>" and "<Password>"
    And Click login button

    Examples:
    | Username | Password |
    |standard_user |secret_sauce |
    |problem_user |secret_sauce |
