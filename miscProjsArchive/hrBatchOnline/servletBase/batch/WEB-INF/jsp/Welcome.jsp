<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>

<!DOCTYPE html>
<html lang="en">
<!-- <link rel="stylesheet" type="text/css" href=".css"> -->

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
</head>
<body>
<div>
Welcome, ${sessionScope.uID}, your password was ${sessionScope.uPW}.
</div>
</body>

</html>