<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html ng-app="homeapp">
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script type="text/javascript" src="../../sweb/resources/home/myapp.js"></script>
<script type="text/javascript" src=../../sweb/resources/home/services.js></script>
<script type="text/javascript" src="../../sweb/resources/home/controller.js"></script>
</head>
<body ng-controller="controller as c">

	<b>HOME PAHE</b>
<br>
<br>
<h3>Lets get started......!</h3>
<div></div>
<div>
<span ng-init="c.tokenReceived='${webtoken}' "></span>
</div>

<div>
<input type="button" value="dummyclick" ng-click="c.getData()">
</div>
<!-- logout only post and csrf required  -->

<form action="<c:url value="/logout"/>" method="post">
<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="submit" value="logout">
</form>
	
</body>
</html>
