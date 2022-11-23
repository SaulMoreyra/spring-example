<%@tag description="Layout Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>

<%@attribute name="value" required="false"%>

<!-- CSS FILES -->
<link href="<c:url value="/resources/css/tags/searchbar.css" />" rel="stylesheet" type="text/css" />
<!-- CSS FILES -->

<div class="searchbar input-group">
	<span class="input-group-text" id="basic-addon1" style="background: transparent;"> 
	<i class="bi bi-search" style="font-size: 16px;" aria-hidden="true"/>
	</span> <input name="search" type="text" class="form-control" placeholder="Buscar" value="${value}">
</div>