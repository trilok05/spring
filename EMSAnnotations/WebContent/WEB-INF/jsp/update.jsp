<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management System</title>
</head>
<body>
<div align="center">
<form:form action="update" method="post" commandName="update">
<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Update Employee Details</h2></td>
				</tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input readonly="true" path="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Department:</td>
                    <td><form:input path="department" /></td>
                </tr>
                <tr>
                    <td>Contact:</td>
                    <td><form:input path="contact" /></td>
                </tr>
                <tr>
                    <td>Salary:</td>
                    <td><form:input path="salary" /></td>
                </tr>                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Update" /></td>
                </tr>

</table>
<div style="color:red">${errorMessage}</div>
</form:form>
</div>
</body>
</html>