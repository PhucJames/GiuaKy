<%--
  Created by IntelliJ IDEA.
  User: Thi
  Date: 05/05/2024
  Time: 11:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Google Fonts Roboto -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="css/mdb.min.css">
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="css/style.css">
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="Register" method="POST">
        <input type="hidden" name="action" value="add">
        <div class="mb-3">
            <label for="fullName">Full Name</label>
            <input class="form-control" type="text"
                   placeholder="Enter full name" id="fullName" name="fullName" required>
        </div>
        <div class="mb-3">
            <label for="email">Email</label>
            <input class="form-control" type="email" placeholder="Enter email" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="password">Password</label>
            <input class="form-control" type="password" placeholder="Enter password" id="password" name="password"
                   required>
        </div>
        <button class="btn btn-success" type="submit">Tạo tài khoản</button>
        <a href="login.jsp">Đã có tài khoản?</a>
        <% if (request.getAttribute("status") != null) { %>
        <p class="text-primary"><%= request.getAttribute("status") %>
        </p>
        <% } %>
    </form>
</div>
</body>
<!-- jQuery -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Your custom scripts (optional) -->
<script type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</html>
<style>
    .container {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        border: 3px solid #ced4da; /* Add border style */
        border-radius: 5px; /* Add border radius for rounded corners */
        background-color: #90ee90
    }

    /* Style form labels */
    label {
        font-weight: bold;
    }

    /* Style form inputs */
    .form-control {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ced4da;
        border-radius: 4px;
        box-sizing: border-box;
    }

    /* Style form button */
    .btn-success {
        display: inline-block;
        padding: 10px 20px;
        background-color: #28a745;
        border: none;
        border-radius: 4px;
        color: white;
        cursor: pointer;
        text-align: center;
        text-decoration: none;
    }

    .btn-success:hover {
        background-color: #218838;
    }

    /* Style existing account link */
    a {
        display: block;
        margin-top: 10px;
        text-align: center;
        color: #007bff;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    /* Style status message */
    .text-primary {
        color: #007bff;
    }

</style>
