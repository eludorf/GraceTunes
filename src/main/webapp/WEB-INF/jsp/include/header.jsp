<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width", initial-scale="1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
    <title>GraceTunes: Home</title>
    <link href="<c:url value="/resources/mytheme/CSS/styles.css"/>" rel="stylesheet" type="text/css"/>
    <script src="https://kit.fontawesome.com/74c9f6574b.js" crossorigin="anonymous"></script>

    <style>
        body {
            font-family: Poppins;
        }
    </style>
</head>
<body>

<header>
            <div class="collapse nav-bar collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <img class="logo" src="<c:url value="/resources/mytheme/images/GraceTunes Logo.png"/>" style='vertical-align:middle;'sr alt="logo"
                         width="200"
                         height="200">
                    <li class="nav-item" style="display:inline">
                        <a class="nav-link active" aria-current="page" href="/user/landing">Home</a>
                    </li>
                    <li class="nav-item" style="display:inline">
                        <a class="nav-link" href="/user/likedsongs">Liked Songs   <i class="fa-regular fa-heart"></i></a>
                    </li>

                <li class="dropdown">
                    <button class="dropbtn" href="/user/search">Search  <i class="fa-solid fa-magnifying-glass"></i></button>
                </li>
                    <li class="nav-item" style="display:inline">
                        <a class="nav-link" href="/user/login">Login</a>
                    </li>
                    <li class="nav-item" style="display:inline">
                        <a class="nav-link" href="/user/registration">Register</a>
                    </li>
                </ul>
            </div>
</header>
</body>
</html>
