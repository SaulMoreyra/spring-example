<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@page import="mx.org.example.constants.EjecutivoConstants"%>
<%@page import="java.util.Map"%>


<tag:layout title="Ejecutivo">
	<jsp:attribute name="content">
	
		<!-- CSS FILES -->
		<link href="<c:url value="/resources/css/views/ejecutivo.css" />" rel="stylesheet" type="text/css" />
		<!-- CSS FILES -->
		
		<div class="main-container">
			<div class="item item1">
				<tag:searchbar />
			</div>
			<div class="item item3">
				<img alt="example Ejecutivo Logo" alt="ejecutivo" src="<c:url value="/resources/images/icono_ejecutivo.jpg"/>" />
			</div>
			<div class="item item4">
				<button class="btn btn-lg  main-button w-100 mt-6" type="button" id="btn-secretarias">
					Secretarias de Estado
				</button>
				<button class="btn btn-lg main-button w-100  mt-6" type="button" id="btn-estados">
					Superdelegados
				</button>
			</div>
			<div class="item item2">
				<div id="container-secretarias">
					<c:forEach items="${secretarias}" var="entry">
						<button class="button-menu w-100">${entry.key}</button>
					</c:forEach>
				</div>
				 <div id="container-estados">
					<c:forEach items="${estados}" var="entry">
					    <button class="button-menu w-100">${entry.key}</button>
					</c:forEach>
				</div>
			</div>
		</div>
		
		<!-- JS FILES -->
		<script type="text/javascript" src="<c:url value="/resources/js/views/ejecutivo.js" />"></script>
		<!-- JS FILES -->
	
		
	</jsp:attribute>
</tag:layout>