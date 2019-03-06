<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link rel='stylesheet' type='text/css' href='Style.css' />
		<%@page import="bean.BeanBrowser" %>
		<%@page import="service.Service" %>
	</head>
	<body id="login">
		<div id="header">
			<%@ include file="header.jsp" %>
		</div>
	    <div>
	    	<h1>Veuillez vous authentifier</h1><br/>
	    
	        <form method="post" action="frontcontroller?cmd=CommandLogin" >
	        	
	            <label for='txtLogin'>Login :</label>
	            <input id='txtLogin' name='txtLogin' type='text' value='${login}' autofocus /> <br/>
	            <label for='txtPassword'>Password :</label>
	            <input name='txtPassword' type='password' value='${password}' /> <br/>
	            <br/>
	            <% if (Service.getSessionBeanBrowser(request).getClient().isFailLog()) {%>
	            	<p>login pas bon</p>
	            <% } else {%>
	            	<p></p>
	            <%} %>
	            <br/>
	            <input name='btnConnect' type='submit' value='Se connecter'/> <br/>
	        </form>   
	        </div>  
	</body>
</html>