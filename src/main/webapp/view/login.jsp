<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		
	         <h1> welcome to the login page....</h1>
			
				<form action="/login" method="post">
						UserName : <input type="text" name="name" placeholder="please enter the name"/><br>
						Password : <input type="password" name="password" placeholder="please enter the password"/><br>
						<input type="submit" value="submit" />
				</form>
	     
		
		
</body>
</html>