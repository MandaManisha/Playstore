<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Owner Registration</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .form-container { max-width: 500px; margin: 0 auto; padding: 20px; }
        input[type=text], input[type=email], input[type=password] {
            width: 100%; padding: 10px; margin: 5px 0 20px 0; border: 1px solid #ccc;
        }
        button { background-color: #4CAF50; color: white; padding: 10px 20px; border: none; cursor: pointer; }
        button:hover { background-color: #45a049; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Register Owner</h2>
        <form action="/owners/register" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
