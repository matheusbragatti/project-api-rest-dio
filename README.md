# project-api-rest-dio
API to register person's data as well as bills to pay every month, using the billTotal endpoint will calculate the total amount the user has to pay every month.

This project is part of the GFT Java and AWS Developer bootcamp project challenges at Digital Innovation One.
https://web.digitalinnovation.one/track/gft-java-aws-developer

The main goal is to showcase my skills at Java, Spring Framework and JUnit.
The code follows the MVC design pattern using Spring Boot and uses REST architecture style as well as good coding practices.
Using JUnit and automated tests the code in version 1.0 has 91% class coverage, 80% method and 80% line coverage.
The API has endpoints to perform every basic operation of persistence storage know as CRUD.

## ENDPOINTS:

#### Person:


`GET /api/v1/people/get` - List everyone currently in the database.

`GET /api/v1/people/get/{id}` - List a single person by the id. *Example* - www.mywebsite.com/api/v1/people/get/143

`POST /api/v1/people/` - Create a new person using the request body.

`DELETE /api/v1/people/delete/{id}` - Delete a existing person by the person id. *Example* - www.mywebsite.com/api/v1/people/delete/487

`PUT /api/v1/people/update/{id}` - Update a existing person using the request body and person id. *Example* - www.mywebsite.com/api/v1/people/update/325


#### Bill:

`GET /api/v1/bill/get` - List every bill in the database.

`GET /api/v1/bill/get/{id}` - List a single bill by the id. *Example* - www.mywebsite.com/api/v1/bill/get/31

`GET /api/v1/bill/user/{id}` - List all the bills a user has by the user i. *Example* - www.mywebsite.com/api/v1/bill/user/619

`GET /api/v1/bill/user/total/{id}` - Returns the sum of all bills the user has using the user id. *Example* - www.mywebsite.com/api/v1/bill/user/total/297

`POST /api/v1/bill` - Creates a new bill using the request body.

`DELETE /api/v1/bill/delete/{id}` - Delete a existing bill by the bill id. *Example* - www.mywebsite.com/api/v1/bill/delete/4

`PUT /api/v1/bill/update/{id}` - Update a existing bill using the request body and bill id. *Example* - www.mywebsite.com/api/v1/bill/update/365
