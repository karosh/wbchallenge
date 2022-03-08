Feature:
#Test Scenarios can be executed together or separate

  #workflow P1 functionalities of admin
  #After hook can be added to delete the created user & charger as;
  #@afterDeleteUser
  #@afterDeleteCharger
  Scenario: Create User and Charger and link them
    Given git App is up and running
    Given admin token has generated
    When admin create Charger with model "Quasar"
    Then charger is created correctly
    When admin create user with "user_new@wallbox.com"
    Then user has created correctly
    When admin links user and charger
    Then user and charger linked correctly

  #User over Charger
#  Scenario: User over charger
#    Given there are multiple chargers
#    Given a user and charger has already linked
#    Given a user token has generated
#    When user want to get details of charger
#    Then user can preview only the linked charger
#    When user want to update information of the charger
#    Then user can update linked charger
#
  #User over own user
#  Scenario: User updates user information
#    Given a user is already created
#    When user want to update it's own information
#    Then user can correctly update
#
  #Admin over user and charger
#  Scenario: Unlink user and charger
#    Given admin token has generated
#    Given a user and charger has already linked
#    When admin unlink the user and charger
#    Then user and charger unlinked correctly
#    And user can not see charger details anymore
#
  #User over any charger or any user
#  Scenario: User rights
#    Given a user token has generated
#    When user creates Charger with model "Quasar"
#    Then charger has not been created
#    When user creates another user with "user_new@wallbox.com"
#    Then user has not been created
