@tag
Feature: Purchase the order from E-Commerce website
  I want to use this template for my feature file

  @Regression
  Scenario Outline: Negative Testing with incorrect credantials 
  Given I landed on Ecommerce Page
  Given Logged in with username <name> and <password>
  Then "Incorrect emaill or password." message on login page

    Examples: 
      | name                  | password     |
      | anshika@gmail.com     | Iamkinig@000 |       
