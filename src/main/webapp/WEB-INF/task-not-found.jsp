
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task not found</title>
</head>
<body>
<%@include file="header.html" %>
<h3>Task with ID '<%=request.getParameter("id")%>' not found in To-Do-List!</h3>
<h2>url: <%=(String) request.getAttribute("url")%></h2>


</body>
</html>
