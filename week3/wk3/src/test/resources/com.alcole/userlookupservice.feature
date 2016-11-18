Feature: Find a User

  Scenario: Find a User
    Given I use the userlookup service
    When  I enter the username Bret
    Then the name Leanne Graham should show up

#Feature: Get a phone number

  Scenario: Get Bret's phone number
    Given I use the userlookup service
    When  I enter the username Bret
    Then the number 1-770-736-8031 x56442 should show up

  Scenario: Get Album from id
    Given I use the albumlookup service
    When  I enter the id 1
    Then the album title should be quidem molestiae enim

  Scenario: Get Album from id
    Given I use the albumlookup service
    When  I enter the id 5
    Then the album title should be eaque aut omnis a

