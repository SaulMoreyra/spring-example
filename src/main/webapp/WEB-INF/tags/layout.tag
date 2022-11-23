<%@tag description="Layout Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<%@attribute name="title" required="true"%>
<%@attribute name="content" fragment="true"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-icons.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/sarc.css" />" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/jquery-3.6.0.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="https://www.coneval.org.mx/Style%20Library/wtscripts/google-analytics-sistemas.js"></script>

<meta content="width=device-width, initial-scale=1" name="viewport" />
<title>${title}</title>
</head>
<body>
	<header>
		<tag:header />
	</header>
	<div class="contenido">
		<jsp:invoke fragment="content" />
	</div>
	<tag:footer />
</body>
</html>