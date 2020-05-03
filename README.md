Steps to run the application
--------------------------------------------------------
The apliccation context: /zemoga-portfolio

1. Download the code using: git clone
2. Run the command: `mvn test`
3. Run the command: `mvn install`
4. Run command: `mvn spring-boot:run`
5. Go to URL localhost:8080/zemoga-portfolio/portfolios/{userName}
   
   Example: http://localhost:8080/zemoga-portfolio/portfolios/@Zemoga
6. Test Rest API End Points

Rest API End Points:
--------------------------------------------------------------------------------------------------------------
    
    [GET] localhost:8080/zemoga-portfolio/api/v1/users/{userId}
    [PUT] localhost:8080/zemoga-portfolio/api/v1/users/{userId}

Technolgies used:
-----------------------

1. JDK 8
2. Maven 3
3. Lombok
4. SpringBoot and Spring Data
5. Junit and Mockito

Steps to build the WAR app:
-----------------------

1. Use the mvn clean install to generate the WAR file

Total Time to complete the test:
--------------------------------
8 hours
