
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Salary Management</title>
</head>
<body>

        <h1>Employee Salary Management</h1>
        <h2>
            <a href="form">Add New Employee</a>
            &nbsp;&nbsp;&nbsp;
            <a href="employeeList">List All Employee</a>
            &nbsp;&nbsp;&nbsp;
            <a href="benefits/beneficiary">Apply For Benefits</a>
             
        </h2>
    <div>
        <table>
            <tr>
                <th>EmployeeID</th>
                <th>FirstName</th>
				<th>LastName</th>
                <th>Email_Id</th>
				<th>Mobile_Number</th>
                <th>Salary</th>
                <th>Account_No</th>
            </tr>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
                    <td>${employee.employeeId}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.emailId}</td>
					<td>${employee.mobileNumber}</td>
					<td>${employee.salary}</td>
					<td>${employee.accounts.accountNumber}</td>
                    <td>
                    
 
                        <a href="/editEmployee/<c:out value='${employee.employeeId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete/<c:out value='${employee.employeeId}' />">Delete</a> 
                        <a href="benefits/show/<c:out value='${employee.employeeId}' />">Benefits</a>                     
                    </td>
               </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>