Feature: Endpoint admin

  Scenario: Get list user
    Given Get list user
    When Send request get list user
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate product json schema "GetListUserSchema.json"

  Scenario: Get list order
    Given Get list order
    When Send request get list order
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate product json schema "GetListOrderSchema.json"

  Scenario Outline: Get list user with page
    Given Get list user with <page>
    When Send request get list user with page
    Then Status code should be 200
    And Response body message was "success read data"
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario Outline: Get list order with page
    Given Get list order with <page>
    When Send request get list order with page
    Then Status code should be 200
    And Response body message was "success read data"
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario Outline: Get list user with limit
    Given Get list user with limit <limit>
    When Send request get list user with limit
    Then Status code should be 200
    And Response body message was "success read data"
    Examples:
      | limit |
      | 5     |
      | 10    |

  Scenario Outline: Get list order with limit
    Given Get list order with limit <limit>
    When Send request get list order with limit
    Then Status code should be 200
    And Response body message was "success read data"
    Examples:
      | limit |
      | 5     |
      | 10    |

  Scenario Outline: Get list user with page and limit
    Given Get list user with page <page> and limit <limit>
    When Send request get list user with page and limit
    Then Status code should be 200
    And Response body message was "success read data"
    Examples:
      | page | limit |
      | 1    | 5     |
      | 2    | 10    |

  Scenario Outline: Get list order with page and limit
    Given Get list order with page <page> and limit <limit>
    When Send request get list order with page and limit
    Then Status code should be 200
    And Response body message was "success read data"
    Examples:
      | page | limit |
      | 1    | 5     |
      | 2    | 10    |

  Scenario: Get list user with invalid path
    Given Get list user with invalid path
    When Send request get list user invalid path
    Then Status code should be 404

  Scenario: Get list order with invalid path
    Given Get list order with invalid path
    When Send request get list order invalid path
    Then Status code should be 404