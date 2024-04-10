Feature: Feature to test login functionality
@SmokeTest
Scenario Outline: Check login is successful with valid credentials

Given user validates login functionality of "<LoginPortal>"
#Given user searches Orange HRM employee information with "Admin" "Admin" "Bob Tester" "Enabled"

Examples:
|LoginPortal|
|OrangeHRM|
#|Guru99|


#Given user validates login functionality of "Guru99"
#Given user selects an item from dropdown "selenium" from "dropdownSelenium"
#Given user selects an item from dropdown "5" from "dropdownSelenium"
