Feature: Facebook login
  Scenario: Verify for valid userId and password
    Given Launch chrome browser
    When Open facebook login page
    Then Login with valid userId and password
    And Logout from facebook
    Then Close Browser


  Scenario: Verify for invalid userId and valid password
      Given Launch chrome browser
      When Open facebook login page
      Then Login with invalid userId and valid password
      And Verify message for invalid userId
      Then Close Browser

  Scenario: Verify for valid userId and invalid password
    Given Launch chrome browser
    When Open facebook login page
    Then Login with valid userId and invalid password
    And Verify message for invalid password
    Then Close Browser

