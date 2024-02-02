Feature: Endpoint Order

  Scenario Outline: Create order with valid data
    Given Create order with valid data "<json>"
    When Send request create order
    Then Status code should be 200
    And Response body message was "success insert data"
    And Validate order json schema "CreateOrderSchema.json"
    Examples:
      | json             |
      | CreateOrder.json |

  Scenario Outline: Create order with valid data without login
    Given Create order with valid data "<json>" without login
    When Send request create order
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | json             |
      | CreateOrder.json |

  Scenario Outline: Create new order with blank address
    Given Create order with blank address "<json>"
    When Send request create order
    Then Status code should be 500
    And Response body message was "error insert order"
    And Validate order json schema "CreateOrderErrorSchema.json"
    Examples:
      | json                         |
      | CreateOrderBlankAddress.json |

  Scenario Outline: Create new order with blank bank
    Given Create order with blank bank "<json>"
    When Send request create order
    Then Status code should be 500
    And Response body message was "error insert order"
    And Validate order json schema "CreateOrderErrorSchema.json"
    Examples:
      | json                      |
      | CreateOrderBlankBank.json |

  Scenario Outline: Create new order with blank address and bank
    Given Create order with invalid "<json>"
    When Send request create order
    Then Status code should be 500
    And Response body message was "error insert order"
    And Validate order json schema "CreateOrderErrorSchema.json"
    Examples:
      | json                        |
      | CreateOrderInvalidData.json |

  Scenario: Get all my orders
    Given Get my order
    When Send request get order
    Then Status code should be 200
    And Response body message was "success read data."
    And Validate order json schema "GetOrderSchema.json"

  Scenario: Get my order without login
    Given Get my order without login
    When Send request get order
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate order json schema "GetOrderInvalidSchema.json"

  Scenario Outline: Cancel my order with valid id
    Given Cancel my order with valid "<order_id>"
    When Send request cancel order
    Then Status code should be 200
    And Response body message was "success cancle order"
    Examples:
      | order_id                             |
      | 657bd3ee-f29a-4068-ba8c-5de0aae2129e |

  Scenario Outline: Cancel my order with invalid id
    Given Cancel my order with invalid "<order_id>"
    When Send request cancel order
    Then Status code should be 500
    And Response body message was "error cancle order"
    And Validate order json schema "CancelOrderInvalidIdSchema.json"
    Examples:
      | order_id |
      | 123456   |

  Scenario Outline:  Cancel order by id without login
    Given Cancel my order with valid "<order_id>" without login
    When Send request cancel order
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | order_id                             |
      | 657bd3ee-f29a-4068-ba8c-5de0aae2129e |

  Scenario Outline: Cancel my order without id
    Given Cancel my order without "<order_id>"
    When Send request cancel order
    Then Status code should be 405
    And Response body message was "Method Not Allowed"
    And Validate order json schema "CancelOrderWithoutIdSchema.json"
    Examples:
      | order_id |
      |          |