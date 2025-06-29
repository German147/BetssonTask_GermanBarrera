Feature: Login and Navigation

  Scenario: Navigate to Products page after successful login
    Given The app is launched
    When The user logs in with "standard_user" and "secret_sauce"
    Then The Products page should be displayed
    Then Tap on the first product