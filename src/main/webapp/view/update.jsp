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
       <h1> welcome to the Update page....</h1>

		<form action="/updateUser" method="post">
				<table style="width:50%">
				  <tr>
				    <td>UserID</th>
				    <td><input type="text" name="id" placeholder="please enter the ID"/></th> 
				    
				  </tr>
				  <tr>
				    <td>UserName</th>
				    <td><input type="text" name="name" placeholder="please enter the name"/></th> 
				    
				  </tr>
				  <tr>
				    <td>deptName</td>
				    <td><input type="text" name="deptName" placeholder="please enter the departmentname"/></td> 
				   
				  </tr>
				  <tr>
				    <td>DateOfBirth</td>
				    <td><input type="date" name="DOB"/></td> 
				   
				  </tr>
				  <tr>
				    <td>City</td>
				    <td><input type="text" name="city" placeholder="please enter the city"/></td>
				  </tr>
				  <tr>
				    <td>State</td>
				    <td><input type="text" name="state" placeholder="please enter the state"/></td>
				  </tr>
				  <tr>
				    <td>Street</td>
				    <td> <input type="text" name="street" placeholder="please enter the street"/></td>
				  </tr>
				  <tr>
				    <td>Zip</td>
				    <td><input type="text" name="zip" placeholder="please enter the zip"/></td>
				  </tr>
				  <tr>
				    <td></td>
				    <td><input type="submit" value="submit" /></td>
				  </tr>
				</table>
		</form>
</body>
</html>