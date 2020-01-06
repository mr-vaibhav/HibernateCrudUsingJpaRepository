
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Salary Management</title>
</head>
<body>

        <h1>Employee Benefits Management</h1>
    <div>
        <table>
            <tr>
                <th>BeneficiaryID</th>
                <th>Salary</th>
				<th>Holiday</th>
                <th>Bonus</th>
            </tr>
            <c:forEach var="benefit" items="${benefits}">
                <tr>
                    <td>${benefit.id}</td>
                    <td>${benefit.salary}</td>
                    <td>${benefit.holiday}</td>
                    <td>${benefit.bonus}</td>
               </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>