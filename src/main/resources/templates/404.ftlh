<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Link not found</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="row">
    <div class="w-50 mx-auto">
        <h3>404 Not Found</h3>
        <p id="shortLink">placeholder</p>
        <a href="/" class="link-primary">Create a new short link</a>
    </div>
</div>
<script>
    $(document).ready(() => {
        $("#shortLink").text(window.location.origin + "/${rnd}")
    })
</script>
</body>

</html>