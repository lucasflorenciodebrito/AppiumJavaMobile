# language: en

@regression
Feature: Login

  @test
  Scenario: Login with success
    Given The user informs a valid username and password
    When The user clicks on the login button
    Then The user can see the app Homepage



