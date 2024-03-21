Feature: Example API Testing

  Scenario: Get request to example endpoint
    Given I set GET service endpoint
    When I send GET HTTP request
    Then I receive valid HTTP response