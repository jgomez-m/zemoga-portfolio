Steps to run the application
--------------------------------------------------------
The apliccation context: /zemoga-portfolio

1. Download the code using: git clone
2. Run the command: `mvn test`
3. Run the command: `mvn install`
4. Run command: `mvn spring-boot:run`
5. Go to URL localhost:8080/zemoga-portfolio/portfolios/{userName}
   
   Example: http://localhost:8080/zemoga-portfolio/portfolios/GoT_Tyrion
6. Test Rest API End Points

Rest API End Points:
--------------------------------------------------------------------------------------------------------------
    
    [GET] localhost:8080/zemoga-portfolio/api/v1/users/{userId}
    [PUT] localhost:8080/zemoga-portfolio/api/v1/users/{userId}

Software prerequisites:
-----------------------

1. JDK 8
3. Maven 3

Steps to build the WAR app:
-----------------------

1. Use the mvn clean install to generate the WAR file
