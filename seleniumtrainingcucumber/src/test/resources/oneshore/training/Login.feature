

Feature: Login
  I want to access the secure area
  
  Scenario: Successful login
    Given I am on the login page
    When I enter my username and password
    Then I should be able to access the secure area
   
  Scenario: Login Failure
  	Given I am on the login page
  	When I enter my username and an invalid password
  	Then I should receive the error message "Your password is invalid!"
  	And I am still on the login page
