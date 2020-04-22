Feature: Billing order API feature
  Client can send order via API

  Scenario: POST billing order (simple scenario)
    Given I have correct billing order
    When I send this order to API via POST request
    Then I receive response with correct HTTP code

  Scenario Outline: POST billing order
    Given I have correct billing order with params: <id>, "<firstName>", "<lastName>", "<email>", "<phone>", "<city>", "<zipCode>", "<state>", "<addressLine1>", "<addressLine2>", <itemNumber>, "<comment>"
    When I send this order to API via POST request
    Then I receive response with correct HTTP code

    Examples:
      | id | firstName | lastName | email            | phone      | city     | zipCode| state | addressLine1 | addressLine2 | itemNumber | comment  |
      |  0 | John      | Smith    | client1@gmail.ru | 1234567890 | New-York | 123456 | AK    | line11       | line21       | 1          | comment1 |
      |  0 | Mike      | Do       | client2@gmail.ru | 1234567891 | New-York | 123457 | AK    | line12       | line22       | 2          | comment2 |
      |  0 | Luke      | White    | client3@gmail.ru | 1234567892 | New-York | 123458 | AK    | line13       | line23       | 3          | comment3 |