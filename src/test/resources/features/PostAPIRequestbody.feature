Feature: Verify Reqres API Testing
  As a tester, I want to validate the User Created or not

  @Regression @Sanity
  Scenario: Validate the the user  can post the new resource
    Given User access to the "PostRequestEndPoint" endpoint
    And Build the "PostRequestEndPoint" request header and json
    And User can make a post call request
    Then Validate the response code as "201" and header type as "application/json; charset=utf-8"
    And Validate the created response required values
      |671399242b47f201538b6d32|mohammed khaja|khaja32@gmail.com|
    And Validate the post "PostRequestSchema" schema
    #And Validate expected "PostRequestResponse" response actual