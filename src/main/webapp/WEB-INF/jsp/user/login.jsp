<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Log In: GraceTunes</title>
    <link rel="stylesheet" href="../../../pub/css/login.css">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
</head>
<body>
<div style="text-align: center">
<img src="../../../pub/images/GraceTunes%20Logo.png" alt="logo" class="center"
>
</div>
    <form action="/user/loginSubmit" method="post" id="novalidate">
    <div class="login-page-username">
        <label id="username" for="formUsername" class="form-label">Username</label>
        <input
                type="text"
                class="form-control"
                id="formUsername"
                name="username"
        />
    </div>
    <div class="login-page-password">
        <label id="label_password" for="formPassword" class="form-label">Password</label>
        <input
                type="password"
                class="form-control"
                id="formPassword"
                name="password"
        />
    </div>
        <div>&nbsp;</div>
        <div>&nbsp;</div>
        <div class="mb1">
    <button type="submit" class="btn btn-primary">LOG IN</button>
        </div>
</form>
</body>
</html>

