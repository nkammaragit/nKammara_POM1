Feature: Feature to test login functionality
@SmokeTest
Scenario: Check login is successful with valid credentials
Given user is on Login page
When user validates login functionality of "OrangeHRM"
Then user should see the Home page
