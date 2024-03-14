# ********RoostGPT********

# Test generated by RoostGPT for test test-workflow using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /pet/findByStatus_get for http method type GET 
# RoostTestHash=467fc95f1c
# 
# 

# ********RoostGPT********
Feature: Test /v2/pet/findByStatus API

Background:
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
  * url urlBase
  * def authToken = karate.properties['auth.token'] || karate.get('authToken', 'sample_auth_token')
  * configure headers = { Authorization: '#(authToken)' }

Scenario Outline: Test GET method with valid status

  Given path '/v2/pet/findByStatus'
  And param status = '<status>'
  When method get
  Then status 200
  And match response[*].status contains '<status>'
  And match response[*].name != null
  And match response[*].photoUrls != null

  Examples:
    | status       |
    | 'available'  |
    | 'unavailable'|

Scenario Outline: Test GET method with invalid status

  Given path '/v2/pet/findByStatus'
  And param status = '<status>'
  When method get
  Then status 400

  Examples:
    | status       |
    | 'invalid'    |
    | 'unknown'    |

Scenario: Test GET method with missing status

  Given path '/v2/pet/findByStatus'
  When method get
  Then status 400
