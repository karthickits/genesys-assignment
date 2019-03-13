# User Service

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


### Find a  User by id

URL: http://localhost:9091/users/1
HTTP-Method: GET


### Delete a User by id

URL: http://localhost:9091/users/1
HTTP-Method: DELETE


### List all Users

URL: http://localhost:9091/users/list
HTTP-Method: GET


### Login using name and password

URL: http://localhost:9091/users/login?name=Karthick&password=Admin@123

Response:

Sucess: Login Successfull! Welcome Karthick
Failure: Not a valid User, Please check the credentials





