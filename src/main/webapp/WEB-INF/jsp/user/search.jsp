<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<jsp:include page="../include/header.jsp" />

<h1>Search</h1>
<br>
<form action="/user/search" method="GET">
    Song Name : <input type="text" name="songName" value="${songName}">
    <button type="submit">Submit</button>
</form>

<br>

<c:if test="${not empty songName}">
    <h5>Search Results Found ${usersModelKey.size()}</h5>
    <br>
</c:if>
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