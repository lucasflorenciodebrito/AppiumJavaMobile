# language: en

@regression
Feature: Login

  @test
  Scenario Outline: : Login with success
    Given The user informs the username "<email>" and password "<password>"
    When The user clicks on the login button
    Then The user can see the app Homepage
    Examples:
      | email              | password |
      | qazando@gmail.com  | 123456   |
      | qazando2@gmail.com | 234445   |
      | qazando@3gmail.com | 1313145  |


