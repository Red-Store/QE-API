Feature: Endpoint User

  Scenario Outline: Login users with valid data
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "user"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json           |
      | LoginUser.json |

  Scenario Outline: Login admin with valid admin data
    Given Login admin with valid "<json>"
    When Send request login admin
    Then Status code should be 200
    And Response body message was "success login" and role was "admin"
    And Validate login user json schema "LoginAdminSchema.json"
    Examples:
      | json            |
      | LoginAdmin.json |

  Scenario Outline: Login users with invalid data
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 500
    And Response body message was "error login. record not found"
    And Validate login user json schema with "LoginErrorSchema.json"
    Examples:
      | json                  |
      | LoginInvalidUser.json |

  Scenario Outline: Login users with empty email
    Given Login users with empty email "<json>"
    When Send request login user
    Then Status code should be 401
    And Response body message was "error login. email wajib diisi."
    And Validate login user json schema with "LoginErrorSchema.json"
    Examples:
      | json        |
      | LoginEmptyEmail.json |

  Scenario Outline: Login users with empty password
    Given Login users with empty password "<json>"
    When Send request login user
    Then Status code should be 401
    And Response body message was "error login. password wajib diisi."
    And Validate login user json schema with "LoginErrorSchema.json"
    Examples:
      | json                    |
      | LoginEmptyPassword.json |

  Scenario Outline: Create new users with valid data
    Given Create new users with valid data "<json>"
    When Send request create new user
    Then Status code should be 200
    And Response body message was "success insert data"
    And Validate create new user json schema with "CreateUserSchema.json"
    Examples:
      | json            |
      | CreateUser.json |

  Scenario Outline: Create new users with duplicate user_name in json
    Given Create new users with duplicate user_name in "<json>"
    When Send request create new user
    Then Status code should be 400
    And Response body message was "error insert data. Error 1062 (23000): Duplicate entry 'dummy888' for key 'users.user_name'"
    And Validate create new user json schema with "CreateUserErrorSchema.json"
    Examples:
      | json                         |
      | CreateDuplicateUsername.json |

  Scenario Outline: Create new users with duplicate email in json
    Given Create new users with duplicate email in "<json>"
    When Send request create new user
    Then Status code should be 400
    And Response body message was "error insert data. Error 1062 (23000): Duplicate entry 'dumdum777@gmail.com' for key 'users.email'"
    And Validate create new user json schema with "CreateUserErrorSchema.json"
    Examples:
      | json                  |
      | CreateDuplicateEmail.json |

  Scenario: Get user when logged in
    Given Get user when logged in
    When Send request get user
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate get user json schema with "GetUserSchema.json"

  Scenario: Get user without logged in
    Given Get user without logged in
    When Send request get user
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate get user json schema with "GetUserErrorSchema.json"

  Scenario Outline: Update user with all data
    Given Update user with all data "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | json            |
      | UpdateUser.json |

  Scenario Outline: Update user with only field name
    Given Update user with only field name "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | json             |
      | UpdateUserName.json |

  Scenario Outline: Update user with only field user_name
    Given Update user with only field user_name "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | json                    |
      | UpdateUserUsername.json |

  Scenario Outline: Update user with only field email
    Given Update user with only field user_name "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | json                 |
      | UpdateUserEmail.json |

  Scenario Outline: Update user with duplicate user_name
    Given Update user with duplicate username "<username>"
    When Send request update user
    Then Status code should be 400
    And Response body message was "error update data. Error 1062 (23000): Duplicate entry 'lendra123' for key 'users.user_name'"
    Examples:
      | username  |
      | lendra123 |

  Scenario Outline: Update user with duplicate email
    Given Update user with duplicate email "<email>"
    When Send request update user
    Then Status code should be 400
    And Response body message was "error update data. Error 1062 (23000): Duplicate entry 'tuanpenguin12@gmail.com' for key 'users.email'"
    Examples:
      | email                   |
      | tuanpenguin12@gmail.com |

  Scenario: Delete post when logged in
    Given Delete post when logged in
    When Send request delete posts
    Then Status code should be 200

  Scenario: Delete post without logged in
    Given Delete post without logged in
    When Send request delete posts
    Then Status code should be 401
