Feature: Feature to test login functionality
@SmokeTest
Scenario Outline: Check login is successful with valid credentials
Given user is on Login page
When user validates login functionality of "Guru99"
Then user should see the Home page

Given user is on search page
When user enters search criteria
Then search results should be appeared




