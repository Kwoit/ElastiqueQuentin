<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<%@page import="service.ServiceBDD" %>
		<%@page import="service.Service" %>
	</head>
	<body>
		<p><%= ServiceBDD.getRequeteFiltre(Service.getSessionBeanBrowser(request).getListBlocFiltre()) %><p>
	</body>
</html>