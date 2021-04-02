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
@ui @healthcheck
Feature: E-commerce Project Web Site Health Check
     @t
  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    Given User navigated to the home application url
    When User Search for product "Laptop"
    Then Search Result page is displayed
    
    @tt
  Scenario: User able to open browser
  	Given User navigated to the home application url
  	When click on fashion category on home page
  	Then Fashion page is displayed
  	
  	@ttt
  Scenario: Products Filter	
  	Given User navigated to the home application url
  	When Click on Electronics
  	Then Hover the Cameras Category click on nikon camera
  	And Click on In seller section select Digital Xpert
  	And click on In Price section select 10,000- 20,000
  	Then Check one product is displayed 
  	

		
		