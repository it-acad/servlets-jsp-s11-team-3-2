<%@ page import="com.softserve.itacademy.model.Priority" %>
<%@ page import="com.softserve.itacademy.model.Task" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existing task</title>
</head>
<body>
<%@include file="header.html" %>
<h3>Edit existing Task</h3>
<%Task task = (Task) request.getAttribute("task");%>
<% if (request.getAttribute("emptyName") != null) {%>
<h2>Name is empty!</h2>
<%}%>
<form action="/edit-task?id=<%=task.getId()%>" method="post">

    <table>
        <tr>
            <td>
                <label for="id">Id: </label>
            </td>
            <td>
                <input type="text" name="id" id="id" value="<%=task.getId()%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                <label for="name">Name: </label>
            </td>
            <td>
                <input type="text" name="name" id="name" value="<%=task.getTitle()%>">
            </td>
        </tr>
        <tr>
            <td>
                <label for="priority">Priority: </label>
            </td>
            <td>
                <select name="priority" id="priority">
                    <%
                        Priority[] values = Priority.values();
                        for (Priority value : values) { %>
                    <option value="<%=value%>"
                            <% if (value == task.getPriority()) {%> selected <%}%>><%=value%>
                    </option>
                    <% }%>

                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
