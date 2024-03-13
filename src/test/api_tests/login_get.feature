# ********RoostGPT********

# Test generated by RoostGPT for test test-workflow using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /user/login_get for http method type GET 
# RoostTestHash=d905dac95c
# 
# 

# ********RoostGPT********
Feature: User Login

  Background:
    * url target
    * def authToken = karate.properties['authToken']

  Scenario: Logs user into the system
    Given path '/v2/user/login'
    And params { username: '#(username)', password: '#(password)' }
    And header Authorization = authToken
    When method get
    Then status 200
    And match responseHeaders contains { 'X-Expires-After': '#string', 'X-Rate-Limit': '#number' }
    And match response == '#string'

  Scenario: Invalid username/password supplied
    Given path '/v2/user/login'
    And params { username: '#(username)', password: '#(password)' }
    And header Authorization = authToken
    When method get
    Then status 400

  Examples:
    | username  | password  |
    | 'user1'   | 'pass1'   |
    | 'user2'   | 'wrong'   |
