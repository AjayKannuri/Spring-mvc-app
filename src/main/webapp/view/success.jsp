<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<table style="width:100%">
		  <tr>
		    <th><a href="/loginPage"> Go to the Login Page</a></th>
		    <th><a href="/register"> Go to the Register Page</a></th> 
		    <th><a href="/delUser"> Delete a User By ID</a></th> 
		    <th><a href="/updatePage"> Update an employee by ID</a></th> 
		    <th><a href="/listAll"> List All the Employees</a></th>
		  </tr>
		</table>
		<h1> logged in successfully    </h1>
		<h2> the username is ${user } </h2>
</body>
</html>