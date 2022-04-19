<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<div id="song-container" class="container">
    <h1>Song Search</h1>

    <form action="/user/search" method="get">
        <input type="text" name="songName" id="songName" value="${songName}">
        <button type="submit" class="btn btn-primary">Search</button>
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
            <td>${song.name}</td>
            <td>${song.time}</td>
            <td>${song.key}</td>
            <td>${song.genre}</td>
            <td>${song.artistName}</td>
            <td>${song.albumName}</td>
            </tr>
        </d:forEach>
    </table>
<jsp:include page="../include/footer.jsp" />