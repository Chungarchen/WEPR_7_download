<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Downloads - Paddlefoot (The First CD)</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Downloads</h1>

<h2>Paddlefoot - The First CD</h2>

<table border="1" cellspacing="0" cellpadding="5">
<tr>
    <th>Song title</th>
    <th>Audio Format</th>
</tr>
<tr>
    <td>First Track</td>
    <td><a href="/musicStore/sound/${productCode}/first.mp3">MP3</a></td>
</tr>
<tr>
    <td>Another Track</td>
    <td><a href="/musicStore/sound/${productCode}/another.mp3">MP3</a></td>
</tr>
</table>

<p><a href="download?action=viewAlbums">View list of Albums</a></p>
<p><a href="download?action=viewCookies">View all cookies</a></p>
</body>
</html>
