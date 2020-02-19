Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: AdTariff
    Given People Launchs the Application
    When people click the Add Tariff
    And fills the field with two dim List
      | 400 | 300 | 200 | 100 | 1 | 4 | 9 |
      | 200 | 300 | 500 | 400 | 5 | 6 | 2 |
      | 800 | 900 | 200 | 700 | 6 | 4 | 1 |
      | 100 | 900 | 700 | 300 | 7 | 5 | 8 |
    Then click the submit

  Scenario: AdTariff
    Given People Launchs the Application
    When people click the Add Tariff
    And fills the field with two dim Map
      | MR  | FLM | FIS | FSP | LMC | IMC | SMS |
      | 400 | 300 | 200 | 100 |   1 |   4 |   9 |
      | 200 | 300 | 500 | 400 |   5 |   6 |   2 |
      | 800 | 900 | 200 | 700 |   6 |   4 |   1 |
      | 100 | 900 | 700 | 300 |   7 |   5 |   8 |
    Then click the submit
