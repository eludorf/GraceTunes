<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link href="../../../pub/css/landing.css" rel="stylesheet" type="text/css"/>
<script src="https://kit.fontawesome.com/74c9f6574b.js" crossorigin="anonymous"></script>
<script
        src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<script type="text/javascript">
    let bananas = null;
    $(document).ready(function() {
        console.log("pancakes")
            $.ajax({
                type: "GET",
                url: "/myusername",
                success: function(response) {


                    console.log(response + "this be it")
                    bananas = response;
                },
                error: function(e) {
                    alert('Error: ' + e.message);
                },
            });})

$(document).on("click",".btn-primary", function () {
event.preventDefault();
var clickedBtnname = $(this).attr('name');
console.log(clickedBtnname + " " + bananas);
    $.ajax({
        type: "GET",
        url: "/addsong?username=" + bananas + "&songId=" + clickedBtnname,
        success: function(response) {


            console.log(response + "this be it")
            bananas = response;
        },
        error: function(e) {
            alert('Error: ' + e.message);
        },
    });
});
</script>


<table cellspacing="0", width="100%">
    <tr>
        <th>Like Song</th>
        <th>Name</th>
        <th>Artist</th>
        <th>Key</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${allSongs}" var="song">
        <tr scope="row">
            <td><form onsubmit = "event.preventDefault();"><input type="hidden" name="${song.id}"><button name="${song.id}" class="btn-primary shadow-none"><i class="fa-solid fa-circle-plus"></i></button></form></td>
            <td>${song.songName}</td>
            <td>${song.artistName}</td>
            <td>${song.songKey}</td>
            <td><a href="/user/updatesong/${song.id}">Edit</a></td>

        </tr>
    </c:forEach>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
