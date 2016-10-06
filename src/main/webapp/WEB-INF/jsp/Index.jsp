<!DOCTYPE html>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglibprefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
	<title>Index</title>
</head>
<body>
	<h1>HBV501G Project Spring Boot Skeleton</h1>
	<p>This skeleton of a Spring Boot Web project was made to help groups...</p>
	<h1>Form</h1>
	<sf:form action="/" commandName="userImageContainer" enctype="multipart/form-data" method="post">
		<p>Name: <sf:input path="name" type="text" /></p>
		<p>Image: <sf:input path="image" type="file" /></p>
		<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
	</sf:form>
</body>
</html>