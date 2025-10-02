<%@ page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>

<!DOCTYPE html>
<html>
<head><title>Download registration</title></head>
<body>
<h1>Download registration</h1>
<form action="download" method="post">
    <input type="hidden" name="action" value="registerUser"/>
    <input type="hidden" name="productCode" value="${param.productCode}"/>
    Email: <input type="email" name="email"><br>
    First Name: <input type="text" name="firstName"><br>
    Last Name: <input type="text" name="lastName"><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
