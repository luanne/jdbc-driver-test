Demonstrates issue with the jdbc driver for Neo4j 3.0

Build war, drop into tomcat- I tested with 7.0.53
Once deployed, 

`GET http://localhost:8080/jdbctest/api/all/count`

produces

```
java.sql.SQLException: No suitable driver found for jdbc:neo4j:bolt://localhost
```
