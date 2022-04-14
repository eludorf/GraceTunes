<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Register for GraceTunes</title>
    <link rel="stylesheet" type="text/css" href="../../../pub/css/register.css"" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
    <style>
        body {
            font-family: Poppins;
        }
    </style>
</head>
<body>
<h1><font color="white">GraceTunes User Registration</h1>
<div class="container" id="container"></div>
<form>
    <div class="mb-3">
        <label for="formFirstName" class="form-label">First Name:</label>
        <input
                type="text"
                class="form-control"
                id="formFirstName"
                placeholder="first name"
        />
    </div>
    <div class="mb-3">
        <label for="formLastName" class="form-label">Last Name:</label>
        <input
                type="text"
                class="form-control"
                id="formLastName"
                placeholder="last name"
        />
    </div>
    <div class="mb-3">
        <label for="formEmailAddress" class="form-label">Email Address:</label>
        <input
                type="email"
                class="form-control"
                id="formEmailAddress"
                placeholder="name@example.com"
        />
    </div>
    <div class="mb-3">
        <label for="formPassword" class="form-label">Password:</label>
        <input
                type="password"
                class="form-control"
                id="formPassword"
                placeholder="password"
        />
    </div>
    <div class="mb-3">
        <label for="formConfirmPassword" class="form-label">Confirm Password:</label>
        <input
                type="password"
                class="form-control"
                id="formConfirmPassword"
                placeholder="confirm password"
        />
    </div>
    <button type="submit" class="btn btn-primary" id="sButton">Submit</button>
</form>
</body>
</html>
