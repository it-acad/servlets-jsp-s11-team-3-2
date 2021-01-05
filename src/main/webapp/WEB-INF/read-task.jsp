<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Task</title>
</head>
<body>
<%@include file="header.html" %>
<h3>Read existing Task</h3>
<%
    Task task =(Task) request.getAttribute("task");
%>
<table>
    <tr>
        <td>Id:</td>
        <td><%=task.getId()%></td>
    </tr>
    <tr>
        <td>Title:</td>
        <td><%=task.getTitle()%></td>
    </tr>
    <tr>
        <td>Priority:</td>
        <td><%=task.getPriority()%></td>
    </tr>
</table>

</body>
</html>
