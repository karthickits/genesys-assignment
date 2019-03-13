# User Service

### Guides
The following operations can be performed for a User:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

###Save User

* Saves a new User

** URL: http://localhost:9091/users/save

Payload: HTTP-Method: POST

{
  "name": "Shiva",
  "address": "Taramani",
  "password": "Admin@123"
  
}


Find a  User by id

URL: http://localhost:9091/users/1
HTTP-Method: GET


Delete a User by id

URL: http://localhost:9091/users/1
HTTP-Method: DELETE


List all Users

URL: http://localhost:9091/users/list
HTTP-Method: GET


Login using name and password

URL: http://localhost:9091/users/login?name=Karthick&password=Admin@123
Response:



