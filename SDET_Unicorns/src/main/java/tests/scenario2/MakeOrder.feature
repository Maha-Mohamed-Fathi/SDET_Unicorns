Feature:Scenario2

  @SdetUnicorns
  Scenario Outline: Verify that product has been added to cart
    Given Given Home Page for SDET Unicorns Page is Opened
    And Click on UserProfile button
    And Click on Login button
    Then Login Page is Opened
    And Enter Email with"<email>" in Login Form
    And Enter Password with"<password>" in Login Form
    And Click on Login button in Login Form
    Then Validate that Account is open successfully
    And Click on Keyboards in categories in home page
    And Click on Apply Button
    Then Validate that number of keyboard products is "<keyboardResult>"
    And Click on Keyboard with "<keyboardName>"
    Then Validate that Product Name is "<keyboardName>"
    And Validate that Product Price is "<keyboardPrice>"
    And Validate that product cart are empty with "<productCartValueIsZero>"
    And Click on Add To Cart Button
    And Validate that product cart contain one element with "<productCartValueIsOne>"
    And Click on Product Button
    And Click on Laptop in categories in home page
    Then Click on Apply Button for Laptop in categories in home page
    And Click on Laptop with "<laptopName>"
    And Click on Add To Cart Button
    And Validate that product cart contain two elements with "<productCartValueIsTwo>"
    And Click on Cart Button
    Then Validate that total amount is calculated correctly
    And Click on Checkout button
    And Enter Country with "<country>", Region with "<region>", Address with "<address1>", ZIP with "<zip>" and Phone "<phone>"
    And Click on Confirm Button
    Then Validate that shipping address are correct and total price


    Examples:
      | email | password | keyboardResult  | keyboardName | keyboardPrice | productCartValueIsZero | productCartValueIsOne | laptopName | productCartValueIsTwo | country | region | address1 | zip | phone |
      | email | password | Found 1 results | keyboardName | keyboardPrice | 0                      | 1                     | laptopName | 2                     | country | region | address1 | zip | phone |



