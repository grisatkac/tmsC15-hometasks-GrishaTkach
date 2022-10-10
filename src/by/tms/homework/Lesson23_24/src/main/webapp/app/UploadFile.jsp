<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Upload</title>
  <style>
    .header {
      border-bottom: 2px solid #000;
      padding: 10px;
      text-align: center;
    }

    .main {
      width: 50%;
      margin: 0 auto;
      text-align: center;
      margin-top: 20px;
    }

    input {
      display: block;
      margin: 0 auto;
      margin-bottom: 10px;
    }

    input  {
      border-radius: 5px;
      box-shadow: none;
      border: 1px solid #000;
    }
  </style>
</head>
<body>
<header class="header">
  <h1>Upload file</h1>
</header>

<main>
  <div class="main">
    <form action="/app/uploadFile" method="post" enctype="multipart/form-data">
      <h2>Choose file to upload:</h2>
      <input type="file" value="Choose file" name="file" class="firstButton" />
      <input type="submit" value="Upload" class="secondButton" />
    </form>
  </div>
</main>
</body>
</html>
