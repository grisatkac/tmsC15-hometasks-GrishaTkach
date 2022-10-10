
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

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

        p {
            text-align: center;
        }

        .login-title {
            border-bottom: 2px solid #000;
            padding: 10px;
            text-align: center;
        }

        .login-form {
            width: 35%;
            margin: 20px auto 0;
            padding: 5px;
            border: 1px solid #000;
            border-radius: 5%;
        }

        .email p {
            margin-bottom: 5px;
        }

        .password p {
            margin-bottom: 5px;
        }

        .password {
            margin-bottom: 10px;
        }

        .buttons {
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
<main class="main">
    <header class="login-title">
        <h2>Login form</h2>
    </header>
    <div class="login-form">
        <form action="/login" method="post">
            <div class="email">
                <p><label for="email">Email: </label></p>
                <input type="email" name="email" id="email" />
            </div>

            <div class="password">
                <p><label for="password">Password: </label></p>
                <input type="password" name="password" id="password" />
            </div>

            <div class="buttons">
                <div class="submit">
                    <input type="submit" value="Login" />
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
