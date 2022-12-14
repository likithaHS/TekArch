Feature: login feature
checking the login feature of firebase app

Background:
Given when you go to url "https://login.salesforce.com/"

  Scenario: login with correct credentials
    When user on "loginPage"
    When user enters value into text box username as "likithahs@gmail.com"
    When user enters value into text box password as "Shaurya$12"
    And  click on login button
    when user on "Homepage"
    Then verify page title as "Home Page ~ Salesforce - Developer Edition"
    
  Scenario: login with correct username but blank password
     When user on "loginPage"
    When user enters value into text box username as "likithahs@gmail.com"
    When user enters value into text box password as "Shaurya$12"
    And  click on login button
    Then verify the error message as "Please enter your password."  
