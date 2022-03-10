Feature: Create an Account functionality

Scenario: Verify whether user is able to create an account


Given user is on Azure website
When user Enter "rahul roy" , "rahul roy" , "sanghpal1995@gmail.com" on create account field
And Accept Tearms and condition
And Submit the application
Then User should Recieved an Email on his email account
And close the browser
