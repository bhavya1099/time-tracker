# ********RoostGPT********

# Test generated by RoostGPT for test test-workflow using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /user/createWithList_post for http method type POST 
# RoostTestHash=41ad79e90d
# 
# 

# ********RoostGPT********
Feature: User Creation

  Background:
    * url target
    * header Authorization = 'Bearer ' + $processEnvironment.AUTH_TOKEN

  Scenario: Create a list of users with given input array
    Given path '/v2/user/createWithList'
    And request 
    """
    [
      {
        "id": 1,
        "username": "testuser1",
        "firstName": "Test",
        "lastName": "User1",
        "email": "testuser1@example.com",
        "password": "password1",
        "phone": "1234567890",
        "userStatus": 1
      },
      {
        "id": 2,
        "username": "testuser2",
        "firstName": "Test",
        "lastName": "User2",
        "email": "testuser2@example.com",
        "password": "password2",
        "phone": "0987654321",
        "userStatus": 0
      }
    ]
    """
    When method post
    Then status 200
    And match response.status == 'successful operation'
    And match response.data[0].username == 'testuser1'
    And match response.data[1].username == 'testuser2'
