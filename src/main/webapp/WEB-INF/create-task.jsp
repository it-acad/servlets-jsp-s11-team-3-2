<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create task</title>
</head>
<body>
<%@include file="header.html" %>
<%
    String result = (String) request.getAttribute("result");
    result = (result != null ? result : "");
%>

<h1>Create new Task</h1>
<h3><%=result%></h3>

<form action="/create-task" method="post">
    <table>
        <tr>
            <td>
                <label for="name">Name: </label>
            </td>
            <td>
                <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td>
                <label for="priority">Priority: </label>
            </td>
            <td>
                <select name="priority" id="priority">
                    <option value="LOW">Low</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="HIGH">High</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
