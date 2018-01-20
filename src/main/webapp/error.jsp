<!DOCTYPE html>

<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	isErrorPage="true"%>

<html>
<head>
    <title>error</title>
</head>

<body>
	<%-- Log error on server side --%>
	<%
		//When the page attribute "isErrorPage" is set to "true" the exception object is available
		System.err.println("Error : " + exception.getMessage());
	%>

	<%-- Display generic error to client --%>
	<b>An error occur !</b>
</body>
</html>
