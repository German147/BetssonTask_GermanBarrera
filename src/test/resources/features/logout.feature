Feature: Logout functionality

  Scenario: User logs in and logs out successfully
    Given The app is launched
    When The user logs in with "standard_user" and "secret_sauce"
    And The user opens the menu
    And The user taps the logout option
    Then The login screen should be displayed again
