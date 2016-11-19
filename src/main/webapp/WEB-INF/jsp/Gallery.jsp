<!DOCTYPE html>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<h1>Gallery</h1>
	<a href="/">Home</a>
	<div class="row">
		<c:forEach items="${gallery}" var="image">
			<div class="col-md-3 col-sm-6 height-200" style="margin-bottom: 2rem;">
				<a href="/img/${image.uuid}" class="thumbnail" style="border: none"><img class="height-200" src="/images/${image.uuid}${image.ending}"></a>
			</div>
		</c:forEach>
	</div>
</body>
</html>
