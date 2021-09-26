# BSDS_Project3

Steps for running the code:
Run the following commands from the project folder in a terminal.

For Maven below are the steps:

1 a. The Coordinator file has to be run initially. The coordinator runs by default in port 50010.
mvn -DskipTests package exec:java -Dexec.mainClass=Coordinator.Coordinator

1 b. The Sever.java file has to be run in the following format.
mvn -DskipTests package exec:java -Dexec.mainClass=Server.Server -Dexec.args="portNo|ServerName"

Note: The portNo and ServerName have be changed for every instance of Server.

1 b. The Client.java file has to be in the following format:
mvn -DskipTests package exec:java -Dexec.mainClass=Client.Client -Dexec.args='portNo|ClientName'

Note: The portNo and ClientName have be changed for every instance of Client. The port number for the 
client should be same as one of the server instance.

Input to Dictionary:
Key - Integer
Value - String (string to be entered without any space)
PUT operation: put <key> <value>
GET operation: get <key>
DELETE operation: delete <key>


Initially the required demo operations would be run.
The server has to be force terminated but the "exit" can be used for terminating the client. 

