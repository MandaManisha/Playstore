<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="${pageContext.request.contextPath}/users/login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <button type="submit">Login</button>
    </form>
    <a href="${pageContext.request.contextPath}/users/register">Don't have an account? Register here</a>
</body>
</html>
