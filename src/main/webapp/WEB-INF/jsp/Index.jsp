<!DOCTYPE html>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglibprefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
	<title>KSHSharing</title>
	<link
		rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body class="container">
	<h1>Upload a picture</h1>
	<a href="/search">Search by tags</a>
	<div class="row">
		<div class="col-md-6">
			<sf:form class="form-group" action="/" commandName="userImageContainer" enctype="multipart/form-data" method="post">
				<p>Name: <sf:input class="form-control" path="name" type="text" /></p>
				<p>Image: <sf:input path="image" type="file" /></p>
				<p>Tags: <sf:input class="form-control" id="tags" path="tags" type="text" /></p>
				<p><input class="btn btn-default" type="submit" value="Submit" /></p>
				<p>Tags that will be applied:</p>
				<p id="displayTags"></p>
			</sf:form>
		</div>
	</div>

	<script
		src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="/js/index.js"></script>
</body>
</html>
