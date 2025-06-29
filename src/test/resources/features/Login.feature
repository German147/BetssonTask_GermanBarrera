Feature: Login functionality

  @positive
  Scenario Outline: Successful login with valid credentials
    Given Verify the app is launched
    When User enters valid "<username>" and "<password>"
    And Click login
    Then User should see the products page "<outcome>"
    Examples:
      | username      | password     | outcome   |
      | standard_user | secret_sauce | PRODUCTOS |
      | problem_user  | secret_sauce | PRODUCTOS |

    @negative
  Scenario Outline: Login fails with invalid credentials
    Given Verify the app is launched
    When User enters invalid "<username>" and "<password>"
    And Click login
    Then An error message should be displayed "<outcome>"

    Examples:
      | username    | password     | outcome                                                                   |
      | wrong_user  | wrong_pass   | El usuario y contraseña no coinciden con ningun usuario en este servicio. |
      | locked_user | secret_sauce | El usuario y contraseña no coinciden con ningun usuario en este servicio. |