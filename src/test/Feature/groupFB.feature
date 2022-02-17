Feature: Facebook create group
  Scenario: Create a new group in facebook
    Given Launch chrome browser
    When Open facebook login page
    Then Login with valid userId and password
    And Go to Groups menu
    Then Create a new group with group name and privacy as private
    And Logout from facebook
    Then Close Browser