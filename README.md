## HBase
  A Simple project contains a REST and a REST Client to interact with HBase using HBase client APIs.
  
## Software Requirements:
* CDH 5.1 or later , probably get a [QuickStart VM](http://www.cloudera.com/content/cloudera/en/downloads/quickstart_vms/cdh-5-4-x.html) from cloudera.
* Java 7

## Setup:
+ Once the Quickstart VM is up and running make sure HBase is running.
+ Create a table using the following command using hbase shell.
  - create 'user', {NAME => 'data'}
+ Build hbase-rest project
+ Build hbase-rest-client project
+ start REST services by doing the following
  - go to hbase-rest project
  - run 'java -jar target/hbase-rest-1.0-SNAPSHOT.jar'
  - see console for *****  REST App Started  ****** to confirm services started.

## REST End Points:
This project has the following REST endpoints:
+ GET / - for testing, just produces greetings
+ GET /hbase/user/list - produces all users in the user table
+ GET /hbase/user/{id} - produces data for given user id
+ POST /hbase/user - puts given user data into HBase

## Testing Services:
+ go to hbase-rest-client
+ Execute a post call using the simple REST client RESTClient, this will put data into HBase user table.
+ Open web browser and access http://localhost:8080/ you will see a greeting.
+ Using the above mentioned end points you can get data from HBase.



