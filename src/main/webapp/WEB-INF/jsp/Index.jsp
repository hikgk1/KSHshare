<!DOCTYPE html>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglibprefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
	<title>KSHSharing</title>
</head>
<body>
	<h1>Upload a picture</h1>
	<h1>Form</h1>
	<sf:form action="/" commandName="userImageContainer" enctype="multipart/form-data" method="post">
		<p>Name: <sf:input path="name" type="text" /></p>
		<p>Image: <sf:input path="image" type="file" /></p>
		<p>Tags: <sf:input path="tags" type="text" /></p>
		<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
	</sf:form>
</body>
</html>
