<%@tag description="Header Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>

<!-- CSS FILES -->
<link href="<c:url value="/resources/css/tags/header.css" />" rel="stylesheet" type="text/css" />
<!-- CSS FILES -->

<header class="navbar header-blanco">
	<div>
		<div>
			<a href="/SARC" title="CONEVAL"> 
			<img class="header-logo" alt="Coneval Logo"
				src="<c:url value="/resources/images/LOGO_CONEVAL.svg"/>" />
			</a> <img class="header-logo" alt="Coneval SARC Logo" src="<c:url value="/resources/images/Logo_SARC1.svg"/>"/>
		</div>
		<div class="header-logos-container">
			<img class="header-frase" alt="Coneval Frase Logo" src="<c:url value="/resources/images/FRASE-CONEVAL.svg"/>" />
			<div class="contenedor-icons">
				<a class="icon-svg" href="http://www.facebook.com/Coneval" title="Facebook" target="_blank">
					<i class="bi bi-facebook" aria-hidden="true"/>
				</a> 
				<a class="icon-svg" href="https://twitter.com/coneval" title="Twitter" target="_blank">
					<i class="bi bi-twitter" aria-hidden="true"/>
				</a> 
				<a class="icon-svg" href="http://youtube.com/conevalvideo" title="YouTube" target="_blank">
					<i class="bi bi-youtube" aria-hidden="true"/>
				</a> 
				<a href="https://www.instagram.com/coneval_mx/" title="Instagram" target="_blank"> 
					<img alt="Coneval Instagram Logo" src="<c:url value="/resources/images/icono_instagram.svg"/>" />
				</a> 
				<a href="http://blogconeval.gob.mx/" title="Blog Coneval" target="_blank" >
					<img alt="Coneval Wordpress Logo" src="<c:url value="/resources/images/icono_wordpress.svg"/>"/>
				</a>
				<a href="https://www.coneval.org.mx/SalaPrensa/Paginas/Newsletter/Podcasts_CONEVAL.aspx" title="Blog Coneval" target="_blank" >
					<img alt="Coneval Podcast Logo" src="<c:url value="/resources/images/icono_podcast.svg"/>"/>
				</a>
			</div>
		</div>
	</div>
</header>
<div class="header-verde">
	<a href="/" title="Inicio"> <i class="bi bi-house-door-fill" style="font-size: 16px;" aria-hidden="true"/>
		<span>Inicio</span>
	</a>
</div>
<div class="headerGris">
	<div onClick="history.back()" class="text-dark" style="text-decoration: none">
	 	<i class="bi bi-arrow-left-short" style="font-size: 16px; color: #737277; border: none;" aria-hidden="true"/>
		<span style="color: #737277; border: none;"> Volver</span>
	</div>
	
	<div class="admin" style="margin-left: 2em;">
		<input id="btn-admin" type="submit" style="color: #737277; border: none; background-color:transparent;" value="Administración"></input>
		<input id="btn-admin" type="submit" style="color: #737277; border: none; background-color:transparent;" value="Base de datos"></input>
	</div>
	
	<div class="sesion" style="margin-left: 4em;">
		<input id="btn-admin" type="submit" style="color: #737277; border: none; background-color:transparent;" value="Cerrar sesión"></input>
	</div>
	
</div>
