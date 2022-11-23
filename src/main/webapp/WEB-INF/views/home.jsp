<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<tag:layout title="Bienvenido">
	<jsp:attribute name="content">
	
		<!-- CSS FILES -->
<<<<<<< HEAD
		<link href="<c:url value="/resources/css/views/home.css" />" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/tooltipster/3.3.0/css/tooltipster.min.css" />
=======
		<link href="<c:url value="/resources/css/views/home.css" />"
			rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css"
			href="https://cdnjs.cloudflare.com/ajax/libs/tooltipster/3.3.0/css/tooltipster.min.css" />
>>>>>>> d5afccd2e4019076f53ab65b4856d3a8fc2b1433
		<!-- CSS FILES -->
		
		<div class="main-container">
			<div class="item item1">
				<tag:searchbar />
			</div>
			
			<div class="item item2">
				<button class="btn btn-lg  main-button w-100" type="button"
					id="btn-federal">Gobierno Federal</button>
				<button class="btn btn-lg main-button w-100" type="button"
					id="btn-estatal">Gobierno Estatal</button>
				<a href="organizaciones">
					<button class="btn btn-lg main-button w-100" type="button">ONG's</button>
				</a>
			</div>
			
			<div class="item3 sub-container-right ">
				<div id="sub-container-federal">
					<a href="legislativo"> <span class="d-inline-block"
						tabindex="0" data-toggle="tooltip" title="Legislativo">
							<img alt="example legislativo Logo"
							class="image image-legislativo" alt="legislativo"
							src="<c:url value="/resources/images/icono_legislativo.jpg"/>" />
					</span>
					</a> 
					<a href="ejecutivo"> <span class="d-inline-block" tabindex="0"
						data-toggle="tooltip" title="Ejecutivo">
							<img alt="example Ejecutivo Logo"
							src="<c:url value="/resources/images/icono_ejecutivo.jpg"/>" />
					</span>
					</a>
				</div>
				<div id="sub-container-estatal"> 
				<%@include file="/resources/images/mexicoLow.svg"%>
				</div>
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