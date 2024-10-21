Feature: Verify UserNotesAPi Analytics
  As a tester, I want to validate the Notes API Health Check

  @Regression @Smoke
  Scenario: Validate the Notes API Health Check API Get functionality
    Given user access to "NotesEndPoint" endpoint
    And build "NotesEndPoint" request header and json
    When user make a get request
    Then Validate the response code "200" and type "application/json; charset=utf-8"

  @Regression @Smoke1
  Scenario: Validate the CreatedUser API post functionality
    Given user access to "UserCreateEndPoint" endpoint
    And build "UserCreateEndPoint" request header and json
    When user make post with user name "khaja22" and mail "khaja32@gmail.com" and password as "khaja1234"
    Then Validate the response code "201" and type "application/json; charset=utf-8"