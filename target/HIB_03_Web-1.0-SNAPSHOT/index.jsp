<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<h3>Please fill Form</h3>
<form action="/4HIB_03_Web_war_exploded/registered" method="post">
    <label for = "name">Name: </label>
    <input type="text" id="name" name="name">
    <br>
    <label for = "password">Password: </label>
    <input type="password" id="password" name="password">
    <br>
    <label for = "email">Email: </label>
    <input type="text" id="email" name="email">
    <br>
    <input type="submit" name = "Register">
</form>


</body>
</html>