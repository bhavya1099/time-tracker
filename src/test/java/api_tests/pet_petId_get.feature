# ********RoostGPT********

# Test generated by RoostGPT for test test-workflow using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /pet/{petId}_get for http method type GET 
# RoostTestHash=018c365850
# 
# 

# ********RoostGPT********
Feature: Pet Store API Tests

Background:
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
  * url urlBase
  * def authToken = karate.properties['auth.token'] || karate.get('authToken', '$processEnvironment.AUTH_TOKEN')
  * def apiKey = karate.properties['api.key'] || karate.get('apiKey', '$processEnvironment.API_KEY')

Scenario: Find pet by ID
Given path '/v2/pet/{petId}'
And header Authorization = authToken
And header api_key = apiKey
When method get
Then status 200
And match response ==
"""
{
  "id": "#number",
  "category": {
    "id": "#number",
    "name": "#string"
  },
  "name": "doggie",
  "photoUrls": ["#string"],
  "tags": [
    {
      "id": "#number",
      "name": "#string"
    }
  ],
  "status": "#string"
}
"""

Examples:
| petId |
| 123   |
| 456   |
| 789   |
