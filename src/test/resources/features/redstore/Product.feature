Feature: Endpoint product

  Scenario: Get my product
    Given Get my product
    When Send request get my product
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate product json schema "ProductJsonSchema.json"

  Scenario: Get my products without login
    Given Get my product
    When Send request get my product without login
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"

    Scenario Outline: Get all products with all parameters
      Given Get all product with param <page> and <limit>
      When Send request get all products with all param
      Then Status code should be 200
      And Response body message was "success get data"
      And Validate product json schema "ProductJsonSchema.json"
      Examples:
        | page | limit |
        | 1    | 8     |

  Scenario Outline: Get all products with page without limit
    Given Get all product with param page <page>
    When Send request get all products with page
    Then Status code should be 200
    And Response body message was "success get data"
    And Validate product json schema "ProductJsonSchema.json"
    Examples:
      | page |
      | 1    |

  Scenario Outline: Get all products with limit without page
    Given Get all product with param limit <limit>
    When Send request get all products with limit
    Then Status code should be 200
    And Response body message was "success get data"
    And Validate product json schema "ProductJsonSchema.json"
    Examples:
      | limit |
      | 8     |

  Scenario Outline: Get single product with valid product_id
    Given Get single product with <product_id>
    When Send request get single product
    Then Status code should be 200
    And Response body message was "success read data."
    And Validate product json schema "SingleProductJsonSchema.json"
    Examples:
      | product_id |
      | 10         |

  Scenario Outline: Get single product with invalid product_id
    Given Get single product with <product_id>
    When Send request get single product
    Then Status code should be 404
    And Response body message was "product not found"
    Examples:
      | product_id |
      | 1032       |

  Scenario Outline: Successful product search
    Given Get product search with "<type>"
    When Send request get search product
    Then Status code should be 200
    And Response body was same with "<type>"
    And Validate product json schema "SearchProductJsonSchema.json"
    Examples:
      | type   |
      | asmara |

  Scenario Outline:Empty product search
    Given Get product search with "<type>"
    When Send request get search product
    Then Status code should be 400
    And Response body message was "query parameter is required"
    Examples:
      | type |
      |      |

  Scenario Outline: Invalid product search
    Given Get product search with "<type>"
    When Send request get search product
    Then Status code should be 404
    And Response body was same with "The provided search query is not valid."
    Examples:
      | type                |
      | ikuuu26312736187236 |


  Scenario Outline:Delete single product with valid product_id
    Given Delete product with "<product_id>"
    When Send request delete product
    Then Status code should be 200
    And Response body message was "success delete data"
    Examples:
      | product_id |
      | 21         |

  Scenario Outline:Delete single product with valid product_id without login
    Given Delete product with "<product_id>" without login
    When Send request delete product
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | product_id |
      | 11         |

  Scenario Outline:Delete single product with invalid product_id
    Given Delete product with "<product_id>"
    When Send request delete product
    Then Status code should be 404
    And Response body message was "product not found"
    Examples:
      | product_id |
      | 16          |

  Scenario Outline:Delete single product without product_id
    Given Delete product with "<product_id>"
    When Send request delete product
    Then Status code should be 405
    And Response body message was "Method Not Allowed"
    Examples:
      | product_id |
      |            |

  Scenario Outline:Delete single product other people with valid product_id
    Given Delete product with "<product_id>"
    When Send request delete product
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | product_id |
      | 13         |

  Scenario Outline: Update product name with valid product_id
    Given Update product with "<product_id>" and "<json>"
    When Send request update product
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | product_id | json             |
      | 10         | UpdateProduct1.json|

  Scenario Outline: Update product name with valid product_id without login
    Given Update product with "<product_id>" and "<json>" without login
    When Send request update product
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | product_id | json             |
      | 10         | UpdateProduct1.json |

  Scenario Outline: Update product name with invalid product_id
    Given Update product with "<product_id>" and "<json>"
    When Send request update product
    Then Status code should be 403
    And Response body message was "you do not have permission to edit this product"
    Examples:
      | product_id | json                |
      | 101        | UpdateProduct1.json |

  Scenario Outline: Update product description with valid product_id
    Given Update product with "<product_id>" and "<json>"
    When Send request update product
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | product_id | json                |
      | 10         | UpdateProduct2.json |

  Scenario Outline: Update product price with valid product_id
    Given Update product with "<product_id>" and "<json>"
    When Send request update product
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | product_id | json                |
      | 10         | UpdateProduct3.json |

  Scenario Outline: Update product category with valid product_id
    Given Update product with "<product_id>" and "<json>"
    When Send request update product
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | product_id | json                |
      | 10         | UpdateProduct4.json |

  Scenario Outline: Update product stock with valid product_id
    Given Update product with "<product_id>" and "<json>"
    When Send request update product
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | product_id | json                |
      | 10         | UpdateProduct5.json |

  Scenario Outline: Update product photo with valid product_id
    Given Update product with "<product_id>" and "<json>"
    When Send request update product
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | product_id | json                |
      | 10         | UpdateProduct6.json |

  Scenario: Create product with all parameters
    Given Create product with all param
    When Send request create product
    Then Verify status code is 200
    And Verify response message is "success insert product"

  Scenario: Create product with all parameters without login
    Given Create product with all param without login
    When Send request create product
    Then Verify status code is 401
    And Verify response message is "missing or malformed jwt"

  Scenario: Create product with all parameters except name
    Given Create product with all param except name
    When Send request create product
    Then Verify status code is 400
    And Verify response message is "nama produk tidak boleh kosong"




