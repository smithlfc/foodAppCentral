<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html ng-app="app">
	<b>HOME PAHE</b>
<br>
<br>
	<h3>Lets get started......!</h3>
<div>
test click<br>
<input type="button" value="click" ng-click="c.call()"> <br>

<b>
value of the twt token is :<br>
${webtoken}<br>
</b>

</div>
<!-- logout only post and csrf required  -->

<form action="<c:url value="/logout"/>" method="post">
<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="submit" value="logout">
</form>
	
</body>
</html>
