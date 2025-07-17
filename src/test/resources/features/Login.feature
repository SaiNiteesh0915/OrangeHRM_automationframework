@LoginPage

Feature: Login functionality for OrangeHRM

  @NoSprint
  @TC01_VerifyUserLogin
  Scenario: Verify user login with valid credentials
    Given user enters credentials for login
      | username | password |
      | Admin    | admin123 |
    When user clicks on the login button
    Then user should be redirected to the dashboard

#Epic: ORM UI Automation
#Case: AUTO-01
#Sprint: No Sprint
#Author: Sai Niteesh
#Commit Date: 17-July-2025