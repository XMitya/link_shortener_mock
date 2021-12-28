<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Link not found</title>
</head>
<body>

<h3>404 Not Found</h3>
<p id="shortLink"></p>
<script>
    document.getElementById("shortLink").innerHTML = window.location.origin + "/${rnd}";
</script>
<a href="/" class="link-primary">Create a new short link</a><br>
</body>

</html>