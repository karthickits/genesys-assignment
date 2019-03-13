# User Service
The Application is implemeted using SpringBoot and H2 In-Memory database as a backend, keeping testing ease in mind.
The same is tested using Postgres with AWS RDS by changing the connection properties in the application.properties

It has four test-cases to check the create, retrive, update and delete.

Steps to run:

1. clone the project
2. import the project as a maven project
3. execute maven clean install after navigating to the project folder
4. Run UserServiceApplication as a java application

### Guides
The following operations can be performed for a User:

* [Create new User/ Update a User](http://localhost:9091/users/save)
* [Find a User by Id](http://localhost:9091/users/1)
* [Delete a User by Id](http://localhost:9091/users/1)
* [List all the Users](http://localhost:9091/users/list)
* [Log a User in using name and password](http://localhost:9091/users/login?name=Karthick&password=Admin@123)

###Create or update User

** URL: http://localhost:9091/users/save

Payload: HTTP-Method: POST

{
  "name": "Shiva",
  "address": "Taramani",
  "password": "Admin@123"
  
}
To Update the entity, Unique identifier id needs to be sent with the payload along with the udpated information.
{
  "id":"1",
  "name": "Shiva",
  "address": "Tambaram",
  "password": "User@123"
  
}



### Find a  User by id

URL: http://localhost:9091/users/1
HTTP-Method: GET


### Delete a User by id

URL: http://localhost:9091/users/1
HTTP-Method: DELETE

Response:
Sucess: User removed from DB! 
Failure: Failed to remove user!

### List all Users

URL: http://localhost:9091/users/list
HTTP-Method: GET


### Login using name and password

URL: http://localhost:9091/users/login?name=Karthick&password=Admin@123

Response:

Sucess: Login Successfull! Welcome Karthick
Failure: Not a valid User, Please check the credentials





