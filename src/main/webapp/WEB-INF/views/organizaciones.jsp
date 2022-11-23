<%@page import="java.util.Map"%> <%@ page language="java"
contentType="text/html; charset=UTF-8"%> <%@ taglib
uri="http://www.springframework.org/tags" prefix="spring"%> <%@ taglib
prefix='c' uri='http://java.sun.com/jstl/core_rt'%> <%@ taglib prefix="tag"
tagdir="/WEB-INF/tags"%>

<tag:layout title="Bienvenido">
  <jsp:attribute name="content">
    <!-- CSS FILES -->
    <link href="<c:url value="/resources/css/views/organizaciones.css" />"
    rel="stylesheet" type="text/css" />
    <!-- CSS FILES -->

    <div class="main-container">
      <div class="item">
        <form method="GET" action="/SARC/pdfs">
          <tag:searchbar value="${search}" />
        </form>
      </div>
      <div class="item">
        <div class="organization">
          <div>
            <img alt="example Dependencia Logo" src="<c:url
              value="/resources/images/logos/APAC_logo.png"
            />" />
            <p>APAC</p>
          </div>
          <p>
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text
            ever since the 1500s, when an unknown printer took a galley of type
            and scrambled
          </p>
        </div>
        <div class="organization">
          <div>
            <img alt="example Dependencia Logo" src="<c:url
              value="/resources/images/logos/APAC_logo.png"
            />" />
            <p>APAC</p>
          </div>
          <p>
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text
            ever since the 1500s, when an unknown printer took a galley of type
            and scrambled
          </p>
        </div>
        <div class="organization">
          <div>
            <img alt="example Dependencia Logo" src="<c:url
              value="/resources/images/logos/APAC_logo.png"
            />" />
            <p>APAC</p>
          </div>
          <p>
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text
            ever since the 1500s, when an unknown printer took a galley of type
            and scrambled
          </p>
        </div>
      </div>
      <div class="item">
        <nav>
          <ul class="pagination justify-content-center">
            <li class="page-item">
              <a class="page-link" href="#" tabindex="-1">Anterior</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
              <a class="page-link" href="#">Siguiente</a>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </jsp:attribute>
</tag:layout>
