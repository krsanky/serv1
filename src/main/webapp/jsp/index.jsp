<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>javaweb</title>
    <link rel="stylesheet" href="static/bulma/css/bulma.css" />
    <link rel="stylesheet" href="static/style.css" />
    <link rel="icon" href="static/favicon.ico">
    <link rel="stylesheet" href="static/open-iconic-master/font/css/open-iconic.css" />
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
</head>

<body>
<%--
<%@ include file="_header.jsp" %>
--%>

<%
if (request.getAttribute("content_include") == null) {
    request.setAttribute("content_include", "_default.jsp");
}
%>
<%--
Apparently jsp:include is relative to the page called from.
(no need to prepend jsp/ if it is a peer)
--%>
<jsp:include page="${content_include}" flush="true" />


<script src="static/zepto.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.0.0/js/all.js"></script>
<script src="static/mousetrap.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<script src="https://unpkg.com/react@16/umd/react.development.js"></script>
<script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script>
<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>

<script src="static/page.js"></script>
</body>
</html>
