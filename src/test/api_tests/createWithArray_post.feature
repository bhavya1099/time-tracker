# ********RoostGPT********

# Test generated by RoostGPT for test test-workflow using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /user/createWithArray_post for http method type POST 
# RoostTestHash=2fceff8367
# 
# 

# ********RoostGPT********
Feature: User Creation with Array

  Background:
    * url target
    * header Authorization = $processEnvironment.AUTH_TOKEN

  Scenario: Successful creation of users with given input array
    Given path '/v2/user/createWithArray'
    And request [{"id": 1, "username": "testuser1", "firstName": "Test", "lastName": "User1", "email": "testuser1@example.com", "password": "password1", "phone": "1234567890", "userStatus": 1}, {"id": 2, "username": "testuser2", "firstName": "Test", "lastName": "User2", "email": "testuser2@example.com", "password": "password2", "phone": "0987654321", "userStatus": 0}]
    When method post
    Then status 200
    And match response == 'successful operation'
