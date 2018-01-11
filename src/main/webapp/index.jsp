<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>960 Grid System &mdash; Demo</title>
    <!-- link rel="stylesheet" href="static/960gs/css/reset.css"  -->
    <link rel="stylesheet" href="static/normalize.css"/>

    <!--    <link rel="stylesheet" href="static/text.css" /> -->
    <link rel="stylesheet" href="static/960gs/css/960.css" />
    <link rel="stylesheet" href="static/style.css" />
    <link rel="icon" href="static/favicon.ico">
</head>

<body>

<!--
<h1><a href="/">javaweb</a></h1>
-->

<div class="container_12">

  <div class="grid_12" id="mybanner">
    <h2><a href="/">javaweb</a></h2>
  </div>

  <div class="grid_2">
    <p>
      140
    </p>
  </div>
  <!-- end .grid_2 -->
  <div class="grid_10">

    <p>
      940
    </p>
    <p>Say <a href="hello">Hello</a></p>

    <form method="post" action="hello">
        <h2>Name:</h2>
        <input type="text" id="say-hello-text-input" name="name" />
        <input type="submit" id="say-hello-button" value="Say Hello" />
    </form>
  </div>
  <!-- end .grid_10 -->

</div>
<!-- end .container_12 -->




<script src="static/zepto.min.js"></script>
<script src="static/page.js"></script>
</body>
</html>
