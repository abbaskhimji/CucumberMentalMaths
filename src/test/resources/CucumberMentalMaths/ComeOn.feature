@ak
Feature: GAME OF life

  Background: User has logged in and is at the stage where they are answering a question
    Given I log in as "abbas"
    Then I start the test

  Scenario: Get a new question on answering question correctly
    Given i am on the MM website and at a question
    When I answer the question "correctly"
    Then I get given "a new" question

  Scenario: Get the same question question again on answering question incorrectly
    Given i am on the MM website and at a question
    When I answer the question "incorrectly"
    Then I get given "the same" question

  Scenario: On answering the question incorrectly once and then answering correctly
    Given i am on the MM website and at a question
    When I answer the question "incorrectly"
    Then I get given "the same" question
    When I answer the question "correctly"
    Then I get given "a new" question

  Scenario: API request
    Then I do an api get Requestz

