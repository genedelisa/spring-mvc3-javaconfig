<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<spring:message code="view.index.title.text" var="pageTitle" />
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>${pageTitle}</title>
<meta name="description" content="Index page">
<meta name="author" content="Gene De Lisa">

<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/bootstrap/css/bootstrap-responsive.min.css">
<link rel="stylesheet" href="resources/css/style.css">

<script src="resources/js/libs/modernizr-2.5.3-respond-1.1.0.min.js"></script>
</head>

<!-- http://static.springsource.org/spring/docs/current/javadoc-api/org/springframework/web/servlet/tags/UrlTag.html -->
<spring:url value="/index" var="home" />
<spring:url value="/login" var="login" />
<spring:url value="/about" var="about" />
<spring:url value="/contact" var="contact" />

<spring:message code="brand.text" var="brandText" />
<spring:message code="homeMenu.text" var="homeMenuText" />
<spring:message code="loginMenu.text" var="loginMenuText" />
<spring:message code="aboutMenu.text" var="aboutMenuText" />
<spring:message code="contactMenu.text" var="contactMenuText" />
<spring:message code="view.login.hero.text" var="heroText" />

<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="http://rockhoppertech.com/">${brandText}</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="${home}">${homeMenuText}</a></li>
						<li ><a href="${login}">${loginMenuText}</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>${heroText}</h1>
			<p>
				<a href="${login}" class="btn btn-primary btn-large">Log in</a>
			</p>
		</div>

		<hr>

		<footer>
			<p>&copy; Rockhopper Technologies 2012</p>

			<a href="?locale=it"><spring:message code="footer.italian.text" /></a>
			| <a href="?locale=en"><spring:message code="footer.english.text" /></a>

		</footer>
	</div>

	<script src="resources/bootstrap/js/bootstrap.js"></script>

	<!-- Placed at the end of the document so the pages load faster 
    <script src="resources/js/jquery.js"></script>
    <script src="resources/bootstrap/js/bootstrap-transition.js"></script>
    <script src="resources/bootstrap/js/bootstrap-alert.js"></script>
    <script src="resources/bootstrap/js/bootstrap-modal.js"></script>
    <script src="resources/bootstrap/js/bootstrap-dropdown.js"></script>
    <script src="resources/bootstrap/js/bootstrap-scrollspy.js"></script>
    <script src="resources/bootstrap/js/bootstrap-tab.js"></script>
    <script src="resources/bootstrap/js/bootstrap-tooltip.js"></script>
    <script src="resources/bootstrap/js/bootstrap-popover.js"></script>
    <script src="resources/bootstrap/js/bootstrap-button.js"></script>
    <script src="resources/bootstrap/js/bootstrap-collapse.js"></script>
    <script src="resources/bootstrap/js/bootstrap-carousel.js"></script>
    <script src="resources/bootstrap/js/bootstrap-typeahead.js"></script>
    -->
</body>
</html>