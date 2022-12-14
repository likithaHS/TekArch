Feature: login feature
checking the login feature of firebase app


  Scenario: login with correct credentials
  Given when you go to url "https://login.salesforce.com/"
    When user on "loginPage"
    When user enters value into text box username as "likithahs@gmail.com"
    When user enters value into text box password as "Shaurya$12"
    And  click on login button
    when user on "Homepage"
    Then verify page title as "Home Page ~ Salesforce - Developer Edition"
    
  Scenario: login with correct username but blank password
  Given when you go to url "https://login.salesforce.com/"
    When user on "loginPage"
    When user enters value into text box username as "likithahs@gmail.com"
    When user enters value into text box password as "Shaurya$12"
    And  click on login button
    Then verify the error message as "Please enter your password."  