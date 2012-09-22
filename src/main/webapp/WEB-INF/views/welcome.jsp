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

<spring:message code="view.login.title.text" var="pageTitle" />
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>${pageTitle}</title>
<meta name="description" content="Login success page">
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
	<!--[if lt IE 7]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="http://rockhoppertech.com/">${brandText}</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="${home}">${homeMenuText}</a></li>
						<li class="active"><a href="${login}">${loginMenuText}</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<div class="hero-unit">
			<h1>${heroText}</h1>
		</div>

		<div id="welcome" class="alert alert-success">
			<h1>You are logged in ${user}</h1>
		</div>

		<hr>

		<footer>
			<p>&copy; Rockhopper Technologies 2012</p>
			<a href="?locale=it"><spring:message code="footer.italian.text" /></a>
			| <a href="?locale=en"><spring:message code="footer.english.text" /></a>
		</footer>

	</div>
	<!-- /container -->

	<script src="resources/js/libs/jquery-1.7.2.min.js"></script>
	<script src="resources/js/libs/bootstrap/bootstrap.min.js"></script>

</body>
</html>
