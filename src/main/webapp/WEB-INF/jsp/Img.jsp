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
	<h1>${imgName}</h1>
	<a href="/">Home</a>
	<div class="row">
		<img src="${siteUrl}${imgId}${imgExt}">
		<p>${imgTags}</p>
	</div>
</body>
</html>
