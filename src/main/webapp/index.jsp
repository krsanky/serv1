<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>javaweb</title>

    <!--
    <link rel="stylesheet" href="static/normalize.css"/>
    <link rel="stylesheet" href="static/960gs/css/960.css" />
    -->

    <link rel="stylesheet" href="static/bulma/css/bulma.css" />

    <link rel="stylesheet" href="static/style.css" />
    <link rel="icon" href="static/favicon.ico">
</head>


<body>

<section class="section">
    <div class="container">
      <h1 class="title">
        Hello World
      </h1>
      <p class="subtitle">
        My first website with <strong>Bulma</strong>!
      </p>
    <form method="post" action="hello">
        <h2>Name:</h2>
        <input type="text" id="say-hello-text-input" name="name" />
        <input type="submit" id="say-hello-button" value="Say Hello" />
    </form>
    </div>
</section>




<script src="static/zepto.min.js"></script>
<script src="static/page.js"></script>
<!-- <script src="https://use.fontawesome.com/releases/v5.0.0/js/all.js"></script> -->
</body>
</html>
