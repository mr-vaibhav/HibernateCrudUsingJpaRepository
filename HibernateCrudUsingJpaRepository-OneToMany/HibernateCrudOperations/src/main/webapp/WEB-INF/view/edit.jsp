
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Employee Salary Management</title>
</head>
<body>

	<h1>Employee Salary Management</h1>
	<h2>
		<a href="form">Add New Employee</a> &nbsp;&nbsp;&nbsp; <a href="employeeList">List
			All Employee</a>

	</h2>
	<div>
		<form action="update" method="post">
			<table>
				<tr>
					<td>EmployeeID</td>
					<td><input type="text" name="employeeId" id="employeeId" value = "${employee.employeeId}"
						readonly /></td>
				</tr>
				<tr>
					<td>FirstName</td>
					<td><input type="text" name="firstName" id="firstName"
						value="${employee.firstName}" /></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td><input type="text" name="lastName" id="lastName"
						value="${employee.lastName}" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="emailId" id="emailId"
						value="${employee.emailId}" /></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="mobileNumber" id="mobileNumber"
						value="${employee.mobileNumber}" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="text" name="salary" id="salary"
						value="${employee.salary}" /></td>
				</tr>
				<tr>
					<td>Account Number</td>

					<td><input type="text" name="accountNumber" id="accountNumber"
						value="${employee.accounts.accountNumber}" readonly />
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Update"/>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>

			</table>
		</form>
		
	</div>
</body>
</html>