<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<link href="../../../pub/css/addsong.css" rel="stylesheet" type="text/css"/>

<body>
<title>Edit Song - GraceTunes</title>
<h1>Edit Song</h1>
<div class="container" id="container"></div>
<form id="add-form" action="/user/updatesongSubmit/${songId}" method="post">
    <input type="hidden" name="id" value="${form.id}">
    <div class="mb-3">
        <label for="formSongName" class="form-label">Song Name:</label>
        <input
                name="songName"
                type="text"
                class="form-control"
                id="formSongName"
                value="${form.songName}"
        />
    </div>
    <div class="mb-3">
        <label for="formArtistName" class="form-label">Artist Name:</label>
        <input
                name="artistName"
                type="text"
                class="form-control"
                id="formArtistName"
                value="${form.artistName}"
        />
    </div>
    <div class="mb-3">
        <label for="formAlbumName" class="form-label">Album Name:</label>
        <input
                name="albumName"
                type="text"
                class="form-control"
                id="formAlbumName"
                value="${form.albumName}"
        />
    </div>
    <div class="mb-3">
        <label for="formSongTime" class="form-label">Song Time:</label>
        <input
                name="songTime"
                type="text"
                class="form-control"
                id="formSongTime"
                value="${form.songTime}"
        />
    </div>
    <div class="mb-3">
        <label class="form-label">Song Key:</label>
        <br>
        <input
                name="songKey"
                type="text"
                class="form-control"
                id="formSongKey"
                value="${form.songKey}"
        />

    </div>
    <div class="mb-3">
        <label for="formSongGenre" class="form-label">Song Genre:</label>
        <input
                name="songGenre"
                type="text"
                class="form-control"
                id="formSongGenre"
                value="${form.songGenre}"
        />
    </div>
    <div class="mb-3">
        <input
                name="userId"
                type="hidden"
                class="form-control"
                id="formUserId"
                value="${user.id}"
        />
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<br>
<div id="delete-container" class="container">
    <h1>Delete Song</h1>
    <form action="/user/delete" method="get">
        Song Id <input type="text" name="id" id="songId" value="${songId}">
        <button type="submit" class="btn btn-primary">Delete</button>
    </form>
</div>