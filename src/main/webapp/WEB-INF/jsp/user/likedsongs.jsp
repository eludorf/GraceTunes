<jsp:include page="../include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../../../pub/css/landing.css" rel="stylesheet" type="text/css"/>
<script src="https://kit.fontawesome.com/74c9f6574b.js" crossorigin="anonymous"></script>
<script
        src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>

<table cellspacing="0", width="100%">
    <tr>
        <th>Name</th>
        <th>Artist</th>
        <th>Key</th>
    </tr>
    <c:forEach items="${likedSongs}" var="song">
        <tr scope="row">
            <td>${song.songName}</td>
            <td>${song.artistName}</td>
            <td>${song.songKey}</td>
        </tr>
    </c:forEach>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>







<jsp:include page="../include/footer.jsp" />