
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management System</title>
</head>
<body>
<h1 align="center">All Employees Details</h1>

<form method="post">
<br>
<br>

<table border="2" align="center">
<tr>
<td style="color: red;">Username</td>
<td style="color: red;">Password</td>
<td style="color: red;">Name</td>
<td style="color: red;">Department</td>
<td style="color: red;">Contact</td>
<td style="color: red;">Salary</td>
</tr>



<c:forEach items="${emplist}" var="employee">
    <tr>
        <td style="color: blue;">${employee.username}</td>
        <td style="color: blue;">${employee.password}</td>
        <td style="color: blue;">${employee.name}</td>
        <td style="color: blue;">${employee.department}</td>
        <td style="color: blue;">${employee.contact}</td>  
        <td style="color: blue;">${employee.salary}</td>
    </tr>
</c:forEach>

</table>
</form>
</body>
</html>