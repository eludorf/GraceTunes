<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width", initial-scale="1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>GraceTunes: Home</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" class="a" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
    <link href="../../../pub/css/landing.css" rel="stylesheet" type="text/css"/>
    <script src="https://kit.fontawesome.com/74c9f6574b.js" crossorigin="anonymous"></script>

</head>

<header>
    <div class="logo"><a href="../../../pub/images/GraceTunes%20Logo.png"><img src="../../../pub/images/GraceTunes%20Logo.png"></a>
    </div>
    <nav class="navbar navbar-expand-lg ">


        <div class="container-fluid" id="nav-container">


            <a class="navbar-brand" href="#">
                <img class="brand-logo" src="../../../pub/images/logo.png" alt="">
            </a>


            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navmobile"
                    aria-controls="navmobile" aria-expanded="false" aria-label="Toggle navigation">
                <i title="" class="fa fa-bars"></i>
            </button>

            <div class="collapse navbar-collapse" id="navbarcustom">
                <div id="middle-links">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="landing">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="addsong">Add Song</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="likedsongs">Liked Songs<i class="fa-regular fa-heart"></i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="search">Search<i class="fa-solid fa-magnifying-glass"></i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register">Register</a>
                        </li>
                    </ul>
                </div>

                </div>
            </div>


    </nav>
</header>

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