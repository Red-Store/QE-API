Feature: Endpoint Cart

  Scenario: Get my cart
    Given Get my cart
    When Send request get my cart
    Then Status code should be 200
    And Response body message was "success read data."
    And Validate cart json schema "GetMyCartJsonSchema.json"

  Scenario:  Get my cart without login
    Given Get my cart without login
    When Send request get my cart without login
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"

  Scenario Outline: Add product to cart with valid product_id
    Given Add all product with param "<product_id>"
    When Send request add all products with all param
    Then Status code should be 200
    And Response body message was "success insert data"
    And Validate cart json schema "AddProductToCartJsonSchema.json"
    Examples:
      | product_id |
      | 14        |

  Scenario Outline: Add product to cart with invalid product_id
    Given Add all product with invalid "<product_id>"
    When Send request add all products with all param
    Then Status code should be 400
    And Response body message was "error parsing product id"
    And Validate cart json schema "addProductToCartInvalidJsonSchema.json"
    Examples:
      | product_id |
      | 3$2        |

  Scenario Outline:  Add product to cart without product_id
    Given Add all product without "<product_id>"
    When Send request add all products with all param
    Then Status code should be 405
    And Response body message was "Method Not Allowed"
    And Validate cart json schema "AddProductWithoutIdJsonSchema.json"
    Examples:
      | product_id |
      |            |

  Scenario Outline: Add product to cart without login
    Given Add all product with valid "<product_id>" without login
    When Send request add all products without login
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | product_id |
      | 1          |

  Scenario Outline: Update product to cart with valid data
    Given Update product to cart with valid "<cart_id>"
    When Send request update product to cart with param
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | cart_id |
      | 67      |

  Scenario Outline: Update product to cart with invalid cart_id
    Given Update product to cart with invalid "<cart_id>"
    When Send request update product to cart with param
    Then Status code should be 400
    And Response body message was "error parsing cart id"
    And Validate cart json schema "UpdateCartErrorJsonSchema.json"
    Examples:
      | cart_id |
      | 1ab     |

  Scenario Outline:  Update product to cart without login
    Given Update product to cart without login with "<cart_id>"
    When Send request update product to cart without login
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | cart_id |
      | 12      |

  Scenario Outline: Delete product to cart with valid cart_id
    Given Delete product to cart with "<cart_id>"
    When Send request delete product to cart
    Then Status code should be 200
    And Response body message was "success delete data"
    And Validate cart json schema "DeleteProductToCartSchema.json"
    Examples:
      | cart_id |
      | 95      |

  Scenario Outline: Delete product to cart with invalid cart_id
    Given Delete product to cart with invalid "<cart_id>"
    When Send request delete product to cart
    Then Status code should be 500
    And Response body message was "error deleting data"
    And Validate cart json schema "DeleteCartErrorSchema.json"
    Examples:
      | cart_id |
      | 112345  |

  Scenario Outline: Delete product to cart without cart_id
    Given Delete product to cart without "<cart_id>"
    When Send request delete product to cart
    Then Status code should be 405
    And Response body message was "Method Not Allowed"
    Examples:
      | cart_id |
      |         |