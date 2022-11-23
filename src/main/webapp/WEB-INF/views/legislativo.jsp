<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@page import="mx.org.coneval.constants.EjecutivoConstants"%>
<%@page import="java.util.Map"%>


<tag:layout title="Ejecutivo">
	<jsp:attribute name="content">
	
		<!-- CSS FILES -->
		<link href="<c:url value="/resources/css/views/legislativo.css" />" rel="stylesheet"
			type="text/css" />
		<!-- CSS FILES -->
		
		
		<div class="main-container">
			<div class="item item1">
				<tag:searchbar />
			</div>
			<div class="item item2">
				<img alt="legislativo logo" src="<c:url value="/resources/images/icono_legislativo.jpg"/>" />
			</div>
			<div class="item item3">
				<button class="btn btn-lg main-button w-100" type="button" id="btn-senado">
					Senado</button>
				<button class="btn btn-lg main-button w-100" type="button" id="btn-diputados">
					Diputados</button>
			</div>
			<div class="item item4">
				<div id="container-options">
					<c:forEach items="${options}" var="option" varStatus="loop">
						<c:choose>
						   <c:when test="${options.size() - 1 eq loop.index}">
						   		<button onclick="main.showPartidos()" class="button-menu w-100">
						   				${option.key}
						   		</button>
						   </c:when> 
						   <c:otherwise> 
							   	<button onclick="main.hidePartidos()" class="button-menu w-100">
							   			${option.key}
							   	</button>
							</c:otherwise> 
						</c:choose>							
					</c:forEach>
				</div>
			</div>
			<div class="item item5">
				<div id="container-partidos">
					<c:forEach items="${partidos}" var="partido" varStatus="loop">
						<button class="button-menu w-100">
				   			${partido.key}
					   	</button>	
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- HTML -->
		
		
		<!-- JS FILES -->
		<script type="text/javascript" src="<c:url value="/resources/js/views/legislativo.js" />"></script>
		<!-- JS FILES -->
	
		
	</jsp:attribute>
</tag:layout>