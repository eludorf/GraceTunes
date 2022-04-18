<jsp:include page="../include/header.jsp" />

<table cellspacing="0", width="100%">
    <tr>
        <th>Name</th>
        <th>Artist</th>
        <th>Key</th>
    </tr>
    <c:forEach items="${allSongs}" var="song">
        <tr scope="row">
            <td>${song.songName}</td>
            <td>${song.artistName}</td>
            <td>${song.songKey}</td>
        </tr>
    </c:forEach>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>