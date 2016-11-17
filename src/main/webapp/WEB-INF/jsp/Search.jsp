<!DOCTYPE html>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglibprefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
	<title>KSHSharing</title>
</head>
<body>
	<h1>Search by tag</h1>
	<a href="/">Home</a>
	<h1>Form</h1>
	<sf:form action="/search" commandName="searchInput" enctype="multipart/form-data" method="post">
		<p>Name: <sf:input path="tag" type="text" /></p>
		<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
	</sf:form>
</body>
</html>
