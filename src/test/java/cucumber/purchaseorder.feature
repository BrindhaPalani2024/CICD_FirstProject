@tag
Feature: Purchase the order from E-Commerce website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce Page

  @tag1
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and <password>
    When I add product <productname> to cart
    And checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER" the message is displayed on confirmation page

    Examples: 
      | name                  | password    | productname  |
      | anshika@gmail.com | Iamking@000 | ZARA COAT 3  |
      
