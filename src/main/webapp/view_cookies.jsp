<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%
    Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head><title>Cookies</title></head>
<body>
<h1>Cookies</h1>
<table border="1">
<tr><th>Name</th><th>Value</th></tr>
<% if (cookies != null) {
       for (Cookie c : cookies) { %>
       <tr><td><%= c.getName() %></td><td><%= c.getValue() %></td></tr>
<% } } %>
</table>
<p><a href="download?action=listAlbums">View list of albums</a></p>
<p><a href="download?action=deleteCookies">Delete all persistent cookies</a></p>
</body>
</html>
