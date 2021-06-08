Feature: User Login

  Scenario: Login button is disabled when no agency and account are provided
    Given I have opened the Itau main page
    Then I verify login button is "disabled"
    
  Scenario: Error message is displayed when setting wrong agency and/or account numbers
    Given I have opened the Itau main page
    When I provide the agency "1234" and the account "123456"
    And I click Login button
    Then the error message "Agência / conta inválida. Verifique e tente novamente. Não se esqueça de inserir o dígito verificador da conta." is displayed

  Scenario: Login button becomes enabled when account and then agency are provided
    Given I have opened the Itau main page
    When I provide the account "123456"
    And I provide the agency "1234"
    Then I verify login button is "enabled"