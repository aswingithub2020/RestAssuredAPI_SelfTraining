@apitest
Feature: An end User wants to verify the different HTTP requests and responses
  All I need to do is to provide HTTP requests and check for responses

  Scenario Outline: Validate the create user POST API
    Given the valid endpoint for POST API
    When the POST request is sent to the URI by sending <Name>,<Job>
    Then the response status should be 201
    And validate the response should contain name,job,creation date

    Examples: 
      | Name      | Job        |
      | "Aswin"   | "Software" |
      | "Sahithi" | "DBA"      |
