<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head><title>Download</title></head>
<body>
<h1>Download</h1>

<h2>${product.code} - ${product.description}</h2>

<table border="1">
<tr><th>Song title</th><th>Audio</th></tr>
<tr>
  <td>Song 1</td>
  <td><a href="musicStore/sound/${product.code}/track1.mp3">MP3 (Play)</a></td>
</tr>
<tr>
  <td>Song 2</td>
  <td><a href="musicStore/sound/${product.code}/track2.mp3">MP3 (Play)</a></td>
</tr>
</table>

<p><a href="download?action=listAlbums">View list of Albums</a></p>
<p><a href="download?action=viewCookies">View all cookies</a></p>
</body>
</html>
