<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Downloads - Paddlefoot (The Second CD)</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Downloads</h1>

<h2>Paddlefoot - The Second CD</h2>

<table border="1" cellspacing="0" cellpadding="5">
<tr>
    <th>Song title</th>
    <th>Audio Format</th>
</tr>
<tr>
    <td>Second Track</td>
    <td><a href="/musicStore/sound/${productCode}/second.mp3">MP3</a></td>
</tr>
<tr>
    <td>Final Song</td>
    <td><a href="/musicStore/sound/${productCode}/final.mp3">MP3</a></td>
</tr>
</table>

<p><a href="download?action=viewAlbums">View list of Albums</a></p>
<p><a href="download?action=viewCookies">View all cookies</a></p>
</body>
</html>
