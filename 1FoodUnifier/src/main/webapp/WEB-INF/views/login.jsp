<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>login page</h3>

<form action="/sweb/login" method="post">
User Name: <input type="text" name="username"/><br>
Password : <input type="password" name="password"/><br>
<input name="submit" type="submit" value="submit" /><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>



</body>
</html>