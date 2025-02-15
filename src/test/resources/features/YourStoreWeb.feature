Feature: Purchase Flow in the E-Commerce Site

  @Test
  Scenario Outline: Complete the registration, login, purchase, and order confirmation process
    Given I fill in the registration form with first name "<firstName>", last name "<lastName>", email "<email>", telephone "<telephone>", password "<password>", confirm password "<confirmPassword>" and save the register
    When The user validates the login
    And The user resets the password "<newPassword>"
    And The user navigates to the Laptops & Notebooks section and selects the Show all laptops & notebooks option
    And The user adds a "<producto>" to the shopping cart
    And The user uses the search bar to find a "<secondProducto>" and adds it to the cart
    And The user removes "<producto>" from the cart
    And The user adds another unit of "<secondProducto>" to the cart
    And The user completes the purchase process up to the order confirmation
    Then The user should see the order confirmation

    Examples:
      | firstName | lastName | email                       | telephone | password    | confirmPassword | newPassword   | producto    | secondProducto |
      | Jane      | Smith    | jane.smith01@example.com    | 987654321 | password456 | password456     | password12345 | MacBook Pro | Samsung Galaxy |
      | Alice     | Johnson  | alice.johnson01@example.com | 555123456 | password789 | password789     | password12345 | HP LP3065   | iPhone         |

