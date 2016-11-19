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
	<h1>Search by tag</h1>
	<a href="/">Home</a>
	<div class="row">
		<div class="col-md-6">
			<sf:form class="form-group" action="/search" commandName="searchInput" enctype="multipart/form-data" method="post">
				<p>Tag: <sf:input class="form-control" path="tag" type="text" /></p>
				<p><input class="btn btn-default" type="submit" value="Search" /></p>
			</sf:form>
		</div>
	</div>
</body>
</html>
