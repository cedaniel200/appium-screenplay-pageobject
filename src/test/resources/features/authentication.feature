Feature: I as a user want to authenticate in the application to check my credentials

  Scenario: Login to the Eribank application
    When I login with username company and password company
    Then you should see the home page