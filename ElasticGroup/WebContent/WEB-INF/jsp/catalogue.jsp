<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Catalogue Elastiques</title>
		<link rel='stylesheet' type='text/css' href='Style.css' />
	</head>
	<body id="catalogue">
		<div id="header">
			<%@ include file="header.jsp" %>
		</div>
		
		<span id="sidefiltre">
			<%@ include file="sidefiltre.jsp" %>
		</span>
		
		<span id="magasin">
			<%@ include file="magasin.jsp" %>
		</span>
		
		<span id="panier">
			<%@ include file="panier.jsp" %>
		</span>
	</body>
</html>