<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/qa-monitor/signup" method="post">
    <input type="text" name="username" required>
    <input type="password" name="password" required>
    <input type="email" name="email" required>
    <button type="submit">注册</button>
</form>
</body>
</html>
