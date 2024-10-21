Feature: Verify UserNotesAPi Analytics
  As a tester, I want to validate the Notes API Health Check

  @Regression @Smoke
  Scenario: Validate the login Check API Get functionality
    Given user access to "UserLoginEndPoint" endpoint
    And build "UserLoginEndPoint" request header and json
    When user make a post call request with username as "khaja32@gmail.com" and password as "khaja1234"
    Then Validate the response code "200" and type "application/json; charset=utf-8"
    And Validate the user response required values
    |671399242b47f201538b6d32|mohammed khaja|khaja32@gmail.com|
    And Validate the "UserLogin" schema
    And Validate the "UserLoginResponse" response actual


    @Regression @Smoke
  Scenario: Validate the GetUser functionality
    Given user access to "UserEndPoint" endpoint
    And build "UserEndPoint" request header and json
    When user make a get request
    Then Validate the response code "200" and type "application/json; charset=utf-8"


