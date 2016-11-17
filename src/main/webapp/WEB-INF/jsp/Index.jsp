<!DOCTYPE html>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglibprefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
	<title>KSHSharing</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h1>Upload a picture</h1>
	<a href="/search">Search by tags</a>
	<h2>Form</h2>
	<sf:form action="/" commandName="userImageContainer" enctype="multipart/form-data" method="post">
		<p>Name: <sf:input path="name" type="text" /></p>
		<p>Image: <sf:input path="image" type="file" /></p>
		<p>Tags: <sf:input id="tags" path="tags" type="text" /></p>
		<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
		<p>Tags that will be applied:</p>
		<p id="displayTags"></p>
	</sf:form>

	<script
		src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="/js/index.js"></script>
</body>
</html>
