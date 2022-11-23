<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>


<tag:layout title="Bienvenido">
	<jsp:attribute name="content">
	
		<!-- CSS FILES -->
		<link href="<c:url value="/resources/css/views/admin/allpdfs.css" />" rel="stylesheet" type="text/css" />
		<link href="<c:url value="/resources/css/views/roles.css" />" rel="stylesheet" type="text/css" />
		<!-- CSS FILES -->
		
		<div class="main-container">
			<div class="item"> 
				<form method="GET" action="/SARC/admin/pdfs">
					<tag:searchbar value="${search}" />
				</form>
			</div>			
			<div class="item">
				<div class="header-table">
					<c:if test="${error}">
						<div class="alert alert-danger" role="alert">
						  ${message}
						</div>
					</c:if>
					<div class="button-add">
						<button class="btn btn-success" 
							data-bs-toggle="modal" data-bs-target="#modal-add">
				      		<i class="bi bi-plus-circle-fill" aria-hidden="true"></i>
				      		Agregar
						</button>
					</div>	
				</div>
				<table class="table table-hover table-bordered">
				<caption>Roles almacenados</caption>
				  <thead>
				    <tr class="table-active">
				      <th scope="col">#</th>
				      <th scope="col">Nombre</th>
				      <th scope="col">Archivo</th>
				      <th scope="col">Fecha</th>
				      <th scope="col">Acciones</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${pdfs}" var="pdf" varStatus="loop">
						<tr>
					      <th scope="row">${pdf.idPdf}</th>
					      <td>${pdf.nombrePdf}</td>
					      <td>
					      <a href="/SARC" title="CONEVAL">
						      ${pdf.urlPdf}
					      </a>
					      </td>
					      <td>${pdf.fechaCreacion}</td>
					      <td>
					      	<button type="button" class="btn btn-info">
					      		<i class="bi bi-pencil-fill" aria-hidden="true"/>
					      	</button>					 
					      	<button type="button" class="btn btn-danger">
					      		<i class="bi bi-trash-fill" aria-hidden="true"/>
					      	</button>
					      </td>
					    </tr>
					</c:forEach>
				  </tbody>
				</table>				
			</div>		
			<div>
				<nav>
				  <ul class="pagination justify-content-center">
				  	<c:if test="${page > 1}">
					    <li class="page-item">
					      <a class="page-link" href="<c:url value = "/admin/pdfs" >
							   <c:param name = "page" value="${(page-1)}"/>
							   <c:param name = "search" value = "${search}"/>
							</c:url>">Anterior</a>
					    </li>
				  	</c:if>
				    <c:forEach begin="1" end="${pages}" var="p">				   
				         <li class="page-item ${p == page? 'active': '' }">
				         	<a class="page-link" href="<c:url value = "/admin/pdfs" >
							   <c:param name = "page" value="${p}"/>
							   <c:param name = "search" value = "${search}"/>
							</c:url>">${p}</a>
				         </li>
				    </c:forEach>
				    <c:if test="${page < pages}">
					    <li class="page-item">
					      <a class="page-link" href="<c:url value = "/admin/pdfs" >
							   <c:param name = "page" value="${(page+1)}"/>
							   <c:param name = "search" value = "${search}"/>
							</c:url>">Siguiente</a>
					    </li>
				    </c:if>
				  </ul>
				</nav>
			</div>
		</div>
		<div class="modal fade" id="modal-add" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
		        <button type="button" class="btn btn-primary">Agregar</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- JS FILES -->
		<script type="text/javascript"
			src="<c:url value="/resources/js/views/admin/allpdfs.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/jquery-3.6.0.min.js" />"></script>

	</jsp:attribute>	
</tag:layout>