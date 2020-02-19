Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: AdCustomer
    Given People Launch the Application
    When people clicks the Add Customer
    And fills the fields
    Then clicks the submit

  Scenario: AdCustomer with oneDim
    Given People Launch the Application
    When people clicks the Add Customer
    And fills the fields with one Dim List
      | ak | kadar | ak@gmail.com | pdkt | 12345678 |
    Then clicks the submit

  Scenario: AdCustomer with oneDim Map
    Given People Launch the Application
    When people clicks the Add Customer
    And fills the fields with one Dim Map
      | fname | abd              |
      | lname | kadar            |
      | mail  | ak2812@gmail.com |
      | ad    | chennai          |
      | phn   |           567899 |
    Then clicks the submit
