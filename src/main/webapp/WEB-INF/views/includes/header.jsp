<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" href="<spring:url value="/resources/style/blueprint/screen.css"/>" type="text/css" media="screen, projection"> 
  <!--[if lt IE 8]><link rel="stylesheet" href="<spring:url value="/resources/style/blueprint/ie.css"/>" type="text/css" media="screen, projection"><![endif]-->  
  <link rel="stylesheet" href="<spring:url value="/resources/style/app.css" htmlEscape="true" />" type="text/css"/>
  <title>Corporate's database</title>	
</head>

<body>
	<div id="wrapper">
		<div id="header">			
			<h1 id="logo"><a href="<spring:url value="/cb/"/>">Corporate Base Service</a></h1>
			<ul id="menu">
				<li><a href="<spring:url value="/cb/"/>">Home</a></li>
				<li><a href="<spring:url value="/cb/companies/"/>">Companies list</a></li>
				<li><a href="<spring:url value="/cb/companies/new"/>">Create a new company</a></li>
				<li><a href="<spring:url value="/cb/about"/>">About us</a></li>
			</ul>
		</div>
		<div id=content>