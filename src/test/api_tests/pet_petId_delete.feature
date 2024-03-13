# ********RoostGPT********

# Test generated by RoostGPT for test test-workflow using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /pet/{petId}_delete for http method type DELETE 
# RoostTestHash=1138243cb1
# 
# 

# ********RoostGPT********
Feature: Pet Store API tests

Background: 
  * url target: {{ $processEnvironment.API_HOST }}

Scenario: Delete a pet

  Given path 'v2/pet/{petId}'
  And header api_key = {{$processEnvironment.AUTH_TOKEN}}
  And path petId = {petId}
  When method delete
  Then status 200
  And match response == { 'message': 'Pet deleted successfully' }
  
  Examples:
    | petId |
    | 101   |
    | 102   |
    | 103   |

Scenario: Try to delete a pet with invalid ID

  Given path 'v2/pet/{petId}'
  And header api_key = {{$processEnvironment.AUTH_TOKEN}}
  And path petId = {petId}
  When method delete
  Then status 400
  And match response == { 'message': 'Invalid ID supplied' }
  
  Examples:
    | petId  |
    | 'abc'  |
    | -1     |
    | 100000 |

Scenario: Try to delete a pet that does not exist

  Given path 'v2/pet/{petId}'
  And header api_key = {{$processEnvironment.AUTH_TOKEN}}
  And path petId = {petId}
  When method delete
  Then status 404
  And match response == { 'message': 'Pet not found' }
  
  Examples:
    | petId |
    | 9999  |
    | 8888  |
    | 7777  |
