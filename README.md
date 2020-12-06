# Employee Services

Spring Boot + JWT + Spring Data JPA + H2 Database

-----------------------------------------------------

I provide 6 service below

1. [GET] /authenticate (Generate token)

2. [GET] /api/employees/getEmployee (Find all employees)

3. [GET] /api/employees/{emp_id} (Find employee by id) 

4. [POST] /api/employees/addNewEmployee (Register new employees by id)

5. [PUT] /api/employees/updateEmployee (Update employees by id) 

6. [DELETE] /api/employees/deleteEmploy/{emp_id} (Delete employees by id)

-----------------------------------------------------

you run the application with mvn spring-boot:run command in Terminal, the Spring Boot application will get started in port 8080

and I have a JSON file (Employee Services.postman_collection.json) for import to POSTMAN and call services
