Feature: Open saucedemo order item

  @AddCart_OrderItem
  Scenario Outline: Login account and Order items
    Given Open saucedemo launch login page
    Then Enter the value "<Username>" and "<Password>"
    And Click login button
    Then Select the product "<Item>" and add the card
    And Go to the cart and check Item with QTY
    When Checkout the product
    Then Verify the checkout title
    And Enter the "<First_Name>" then "<last Name>" and "<Zip/Post Code>"
    Then Checkout Overview observe the product QTY Payment Information, Shipping information, Price Total, Total
    And Click the button Finish
    Then Checkout the status


    Examples:
      | Username     | Password    | First_Name | last Name | Zip/Post Code | Item |
      |standard_user |secret_sauce | abc        | A         | 123456        | Sauce Labs Bolt T-Shirt|
      |standard_user  |secret_sauce | XYZ        | B         | 987654       | Sauce Labs Backpack|