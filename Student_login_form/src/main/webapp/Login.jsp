<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Login Form</title>
</head>
<body>
    <h1 align="center">Student Login Form</h1>
    <form action="LoginServlet" method="post" onsubmit="return validateForm()">
        <div align="center">
            <label for="userName">UserName:</label>
            <input type="text" id="userName" name="userName" required>
        </div>
        <br>
        <div align="center">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <br>
        <div align="center">
            <input type="submit" value="Login">
        </div>
    </form>
    <script>
        function validateForm() {
            var userName = document.getElementById("userName").value.trim();
            var password = document.getElementById("password").value.trim();

            if (userName === "") {
                alert("Please enter a username.");
                return false;
            }

            if (password === "") {
                alert("Please enter a password.");
                return false;
            }

            // You can add additional validation logic here if needed.

            // If both fields are not empty, the form will be submitted.
            return true;
        }
    </script>
</body>
</html>
