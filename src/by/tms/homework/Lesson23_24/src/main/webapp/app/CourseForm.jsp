<%--
  Created by IntelliJ IDEA.
  User: Grisha
  Date: 10/3/2022
  Time: 3:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course form</title>
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

        .header {
            border-bottom: 2px solid #000;
            padding: 10px;
            text-align: center;
        }

        .main {
            padding-top: 15px;
        }

        .main .main-form {
            width: 30%;
            margin: 0 auto;
            padding: 15px;
            border: 1px solid #000;
            border-radius: 5%;
        }

        .name p {
            margin-bottom: 0;
        }

        .name input {
            width: 100%;
        }

        .languages .languages-title {
            margin-bottom: 0;
        }

        .languages .languages-list {
            margin-top: 0;
        }

        .languages .languages-list{
            width: 20%;
            min-width: 80px;
            margin: 0 auto;
        }

        .languages-list input {
            display: inline-block;
            width: 20%;
        }

        .languages-list label {
            display: block;
            text-align: left;
        }

        .additional-info {
            text-align: center;
        }

        .additional-title {
            margin-bottom: 0;
        }

        .additional-info textarea {
            display: block;
            width: 100%;
        }

        .secret p {
            margin-bottom: 0;
        }

        .secret input {
            width: 100%;
        }

        .buttons {
            display: flex;
            margin-top: 15px;
            /*padding: 0 auto;*/
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
    <h1 class="header-title">Sign up for a curse</h1>
</header>
<main class="main">
    <div class="main-form">
        <form action="/app/courseForm" id="form" method="post">
            <div class="name">
                <p><label for="name-input">Name:</label></p>
                <input type="text" name="name" id="name-input" required/>
            </div>

            <div class="languages">
                <p class="languages-title">Programming language:</p>
                <p class="languages-list">
                    <label>
                        <input type="radio" name="language" value="C++" />
                        C++
                    </label>

                    <label>
                        <input type="radio" name="language" value="PHP" />
                        PHP
                    </label>

                    <label>
                        <input type="radio" name="language" value="Python" />
                        Python
                    </label>
                </p>
            </div>
            <div class="additional-info">
                <p class="additional-title"><label for="info">Additional information:</label></p>

                <textarea name="additional-info" form="form" id="info"></textarea>
            </div>

            <div class="secret">
                <p><label for="secret-word">Secret word</label></p>
                <input type="password" name="secret-word" id="secret-word"/>
            </div>
            <div class="buttons">
                <div class="submit">
                    <input type="submit" value="Send"/>
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
