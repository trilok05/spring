<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enterprise Management System</title>
</head>
<body>
<div align="center">

<table border="0" width="50%">
<form:form action="register" method="post" commandName="registrationForm">
				<tr>
					<td colspan="2" align="center"><h2>Employee Registration</h2></td>
				</tr>
                <tr>
                    <td align="left" >User Name:</td>
                    <td align="left" ><form:input path="username" size="30"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" size="30"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" size="30"/></td>
                </tr>
                <tr>
                    <td>Department:</td>
                    <td><form:input path="department" size="30"/></td>
                </tr>
                <tr>
                    <td>Contact:</td>
                    <td><form:input path="contact" maxlength="10" size="30"/></td>
                </tr>
                <tr>
                    <td>Salary:</td>
                    <td><form:input path="salary" size="30"/></td>
                </tr>
                <tr></tr>                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" size="30"/></td>
                </tr>
</form:form>
</table>
<div style="color:red">${errorMessage}</div>

</div>
</body>
</html>