# ********RoostGPT********

# Test generated by RoostGPT for test artilleryTest using AI Type  and AI Model 
# 
# Feature file generated for /kafka/v3/clusters/{cluster_id}/topics/{topic_name}_patch for http method type PATCH 
# RoostTestHash=9d07b67b96
# 
# 

# ********RoostGPT********
Feature: Update Partition Count

  Background:
    * def urlBase = karate.properties['alias_URL_BASE'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase

  Scenario Outline: Update partition count for a Kafka topic
    Given path '/kafka/v3/clusters/<cluster_id>/topics/<topic_name>'
    And request { "partitions_count": <partitions_count> }
    When method <method>
    Then status <status>
    And match response == <response_schema>

    Examples:
      | cluster_id  | topic_name | partitions_count | method  | status | response_schema                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
      | 'cluster-1' | 'topic-1'  |                0 | 'PATCH' |    200 | { "kind": "KafkaTopic", "metadata": { "self": "https://pkc-00000.region.provider.confluent.cloud/kafka/v3/clusters/cluster-1/topics/topic-1", "resource_name": "crn:///kafka=cluster-1/topic=topic-1" }, "cluster_id": "cluster-1", "topic_name": "topic-1", "is_internal": false, "replication_factor": 3, "partitions_count": 1, "partitions": { "related": "https://pkc-00000.region.provider.confluent.cloud/kafka/v3/clusters/cluster-1/topics/topic-1/partitions" }, "configs": { "related": "https://pkc-00000.region.provider.confluent.cloud/kafka/v3/clusters/cluster-1/topics/topic-1/configs" }, "partition_reassignments": { "related": "https://pkc-00000.region.provider.confluent.cloud/kafka/v3/clusters/cluster-1/topics/topic-1/partitions/-/reassignments" } } |
      | 'cluster-1' | 'topic-1'  |                1 | 'PATCH' |    400 | { "error_code": 40002, "message": "Topic already has 1 partitions." }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
      | 'cluster-1' | 'topic-1'  |                0 | 'PATCH' |    401 | { "error_code": 40101, "message": "Authentication failed" }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      | 'cluster-1' | 'topic-1'  |                0 | 'PATCH' |    403 | { "error_code": 40301, "message": "Request is not authorized" }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
      | 'cluster-1' | 'topic-1'  |                0 | 'PATCH' |    429 | "<html> <head> <meta http-equiv=\\"Content-Type\\" content=\\"text/html;charset=utf-8\\"/> <title>Error 429 Too Many Requests</title> </head> <body> <h2>HTTP ERROR 429 Too Many Requests</h2> <table> <tr> <th>URI:</th> <td>/v3/clusters/my-cluster</td> </tr> <tr> <th>STATUS:</th> <td>429</td> </tr> <tr> <th>MESSAGE:</th> <td>Too Many Requests</td> </tr> <tr> <th>SERVLET:</th> <td>default</td> </tr> </table> </body> </html>"                                                                                                                                                                                                                                                                                                                                          |
      | 'cluster-1' | 'topic-1'  |                0 | 'PATCH' |    500 | { "error_code": 500, "message": "Internal Server Error" }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
