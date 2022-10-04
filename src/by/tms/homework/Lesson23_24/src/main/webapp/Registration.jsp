<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <style>
        input, textarea, button {
            border-radius: 5px;
            box-shadow: none;
            border: 1px solid #000;
        }

        input {
            display: block;
            width: 60%;
            margin: 0 auto;
        }

        .header {
            border-bottom: 2px solid #000;
            padding: 10px;
            text-align: center;
        }

        .main {
            padding-top: 15px;
        }

        .main .registration-form {
            width: 30%;
            margin: 0 auto;
            padding: 15px;
            border: 1px solid #000;
            border-radius: 5%;
        }

        .role-list {
            width: 20%;
            min-width: 80px;
            margin: 0 auto;
        }

        .role-list input{
            display: inline-block;
            width: 20%;
        }

        .role-list label {
            display: block;
            text-align: left;
        }

        .email p, .name p, .role p, .password p {
            margin-bottom: 5px;
        }

        .email, .name, .role, .password {
            text-align: center;
        }

        .buttons {
            margin-top: 10px;
            display: flex;
            justify-content: space-around;
        }

        .buttons input {
            display: block;
            width: 100%;
        }
    </style>
</head>

<body>
<header class="header">
    <h1>Registration form</h1>
</header>
<main class="main">
    <div class="registration-form">
        <form action="/registration" method="post">
            <div class="email">
                <p><label for="email">Email</label></p>
                <input type="email" name="email" id="email" />
            </div>

            <div class="name">
                <p><label for="name">Name</label></p>
                <input type="text" name="name" id="name" />
            </div>

            <div class="role">
                <p class="role-title">Select role:</p>
                <p class="role-list">
                    <label>
                        <input type="radio" name="role" value="TEACHER" />
                        Teacher
                    </label>

                    <label>
                        <input type="radio" name="role" value="STUDENT" />
                        Student
                    </label>
                </p>
            </div>

            <div class="password">
                <p><label for="password">Password</label></p>
                <input type="password" name="password" id="password" />
            </div>

            <div class="buttons">
                <div class="submit">
                    <input type="submit" value="Register" />
                </div>

                <div class="reset">
                    <button type="reset">Clear</button>
                </div>
            </div>
        </form>
    </div>
</main>
</body>
</html>
