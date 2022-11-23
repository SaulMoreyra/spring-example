<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<tag:layout title="Bienvenido">
	<jsp:attribute name="content">
	
		<!-- CSS FILES -->
		<link href="<c:url value="/resources/css/views/login.css" />"
			rel="stylesheet" type="text/css" />
		<!-- CSS FILES -->
		
		<div class="main-container">
			<form method="POST" action="/SARC/login">
				<div class="container-login">
				<label for="user">Usuario</label>
				<br></br>
				<input id="user" name="correo"></input>
				<br></br>
				<label for="password">Contraseña</label>
				<br></br>
				<input id="password" name="password"></input>
				<br></br>
				<input id="btnsave" type="submit" value="Acceder"></input>
				</div>
			</form>
		</div>
	
	<!-- JS FILES -->
	<script type="text/javascript"
			src="<c:url value="/resources/js/views/home.js" />"></script>
	<!-- JS FILES -->
	

	</jsp:attribute>
</tag:layout>