# BookLib Demo App
# (Spring Boot + Spring Rest + Spring JPA (Hibernate))


## Run Steps

- **Step 1** : Import this project in Spring Tool Suite. 
- **Step 1** : Create Database to use with this application
- **Step 2** : Update database properties in  `application.properties` 
	```
	spring.datasource.url= jdbc:mysql://localhost:3306/training
	spring.datasource.username=root
	spring.datasource.password=root
	```
- **Step 3** : Update the port on which you want to run the application and context path in `application.properties`
	```
	server.port=9090
	server.context-path=/booklib
	```

- **Step 4** : Right click on project maven > update project
- **Step 5** : Right click on project run as > spring boot app


## How to use

- In any rest client hit the url 

```
http://localhost:portno/contextpath/api/book
```

- For other methods follow the Resource mappings mentioned in 

```
src\main\java\com\example\demo\controller\BookResources.java
```

