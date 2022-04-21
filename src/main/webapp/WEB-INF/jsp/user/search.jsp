<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "d" %>

<jsp:include page="../include/header.jsp" />

<script src="../../../pub/css/search.css"></script>
<div id="search-container" class="container">
    <h1 style="color:#023047">Search Songs</h1>

<form action="/user/search" method="GET">
    Song Name <input type="text" style="color:#023047" name="songName" id="songNameId" value="${songName}">
    <button type="submit" class="btn btn=primary">Search</button>
</form>

<br>

    <table class="table">
        <tr scope="row">
            <th>Song ID</th>
            <th>Song Name</th>
            <th>Song Time</th>
            <th>Song Key</th>
            <th>Song Genre</th>
            <th>Artist Name</th>
            <th>Album Name</th>
        </tr>
        <d:forEach items="${songsModelKey}" var="song">
            <tr scope="row">
            <td>${song.id}</td>
            <td>${song.songName}</td>
            <td>${song.songTime}</td>
            <td>${song.songKey}</td>
            <td>${song.songGenre}</td>
            <td>${song.artistName}</td>
            <td>${song.albumName}</td>
            </tr>
        </d:forEach>
    </table>
<jsp:include page="../include/footer.jsp" />