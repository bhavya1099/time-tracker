# ********RoostGPT********

# Test generated by RoostGPT for test test-workflow using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /pet_post for http method type POST 
# RoostTestHash=988c5ab2ac
# 
# 

# ********RoostGPT********
Feature: Pet Store API Tests

  Background:
    * url target
    * def auth = { token: '#(authToken)' }

  @addPet
  Scenario: Add a new pet to the store

    Given path '/v2/pet'
    And request 
    """
      {
        "id": 1,
        "category": {
          "id": 1,
          "name": "Dogs"
        },
        "name": "doggie",
        "photoUrls": ["url1", "url2"],
        "tags": [
          {
            "id": 1,
            "name": "tag1"
          }
        ],
        "status": "available"
      }
    """
    And header Authorization = auth.token
    When method post
    Then status 200
    And match response ==
    """
      {
        "id": '#number',
        "category": {
          "id": '#number',
          "name": '#string'
        },
        "name": '#string',
        "photoUrls": '#[]',
        "tags": '#[]',
        "status": '#string'
      }
    """
    And match response.id == 1
    And match response.name == 'doggie'
    And match response.status == 'available'
