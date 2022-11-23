<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<tag:layout title="Bienvenido">
	<jsp:attribute name="content">
	
		<!-- CSS FILES -->
		<link href="<c:url value="/resources/css/views/home.css" />"
			rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css"
			href="https://cdnjs.cloudflare.com/ajax/libs/tooltipster/3.3.0/css/tooltipster.min.css" />
		<!-- CSS FILES -->
		
		<div class="main-container">
			
			<h1>Accesos</h1>
			<div class="container-access">
			
			</div>
			
		</div>
	
	<!-- JS FILES -->
	<script type="text/javascript"
			src="<c:url value="/resources/js/views/home.js" />"></script>
	<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/tooltipster/3.3.0/js/jquery.tooltipster.js"></script>
	<!-- JS FILES -->
	

	</jsp:attribute>
</tag:layout>