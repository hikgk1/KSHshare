<!DOCTYPE html>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<title>KSHSharing</title>
</head>
<body>
	<h1>${imgName}</h1>
	<a href="/">Home</a>
	<br />
	<img src="${siteUrl}${imgId}${imgExt}">
	<p>${imgTags}</p>
</body>
</html>
