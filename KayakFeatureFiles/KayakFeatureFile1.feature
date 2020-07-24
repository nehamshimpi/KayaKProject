#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
 @tag1
Feature: KayaK Cucumber TestNG Testcases

  Scenario Outline: TC01 Navigate to Kayak.com
    Given Launch Appication chrome
    When Click on flight tab
    When Enter OriginCity "<Origin>", DestinationCity "<Destination>" 
    Then DepartureDate and ReturnDate
   	Then Click on Search button
   	When Select one option from search 
    Then Verify and Validate origin and destination cities
    And Close Browser
    

    Examples: 
      | Origin  						| 		Destination         |	  
      | Baltimore (BWI)     | 		Dallas (DFW)        |
      | San Francisco (SFO) |			Los Angeles (LAX)		|
      |	Houston (HOU)			  |			Chicago (CHI)			  |
     
    	
    	