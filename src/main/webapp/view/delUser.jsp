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
		<form action="/delById" method = "post">
			User Id : <Input type="text" name="id" placeholder="enter the Employee ID"/>
			<input type="submit" value="Delete"/>
		</form>
</body>
</html>