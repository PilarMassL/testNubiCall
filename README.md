#Test Nubicall

####Quick Started

####Prerequisites

#####Software

- Postgresql
- Maven 3.0
- Java 1.8

####Database installation

- Create a database called nubicall
- Execute Script Scripts/1-Nubicall-user-table.sql

####Application Configuration

- Open file src / main / resources / application.yml
- Modify the connection data to the database
- run in terminal inside the application folder: **mvn clean install**
- extract file jar** /target/user-nubicall-0.0.1-SNAPSHOT.jar**
- run **java -jar user-nubicall-0.0.1-SNAPSHOT.jar**
