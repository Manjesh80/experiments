Feature: Get greeting
  As a customer of greetings resource
  I should be able to get a greeting

  Scenario: Get greeting using appropriate caller
  Given I use the caller Ganesh
  When I request greeting
  Then I should get a response with a HTTP status code 200
  And The response should contain message Jai Ganesh

    # Enter steps here