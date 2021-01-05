<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks list</title>
</head>
<body>
<%@include file="header.html"%>

<%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>

<h1>List Tasks</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Priority</th>
        <th colspan="3">Operations</th>
    </tr>
    <%for(Task task: tasks) {%>
    <tr>
        <td><%=task.getId()%></td>
        <td><%=task.getTitle()%></td>
        <td><%=task.getPriority().name()%></td>

        <td>
            <a href="/read-task?id=<%=task.getId()%>">Read</a>
        </td>
        <td>
            <a href="/edit-task?id=<%=task.getId()%>">Edit</a>
        </td>
        <td>
            <a href="/delete-task?id=<%=task.getId()%>">Delete</a>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
