<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>javaweb</title>
    <link rel="stylesheet" href="static/bulma/css/bulma.css" />
    <link rel="stylesheet" href="static/style.css" />
    <link rel="icon" href="static/favicon.ico">
</head>

<body>

<!-- content -->
<%
//String include = (String)request.getAttribute("content_include");
//if (include == null) include = "_default.jsp";
//String include = "_default.jsp";
%>
<%--
<jsp:include page="${_include}" flush="true" />
--%>
<jsp:include page="_default.jsp" flush="true" />
<!-- content -->

<script src="static/zepto.min.js"></script>
<script src="static/page.js"></script>
<!-- <script src="https://use.fontawesome.com/releases/v5.0.0/js/all.js"></script> -->
</body>
</html>
