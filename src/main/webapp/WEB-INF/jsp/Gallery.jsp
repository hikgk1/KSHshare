<!DOCTYPE html>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<title>KSHSharing</title>
</head>
<body>
	<h1>Gallery</h1>
	<a href="/">Home</a>
	<br />
	<c:forEach items="${gallery}" var="image">
		<a href="/img/${image.uuid}"><img src="${siteUrl}${image.uuid}${image.ending}"></a>
		<br />
	</c:forEach>
</body>
</html>
