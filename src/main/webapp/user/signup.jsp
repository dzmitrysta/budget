<%@ page import="domain.UserType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../utils/include-bootstrap.jsp"/>
    <title>Sign UP</title>
</head>
<body class="bg-warning">

<div class="container w-50 mt-5 pt-5 d-flex justify-content-center">
    <form class="w-75" action="/signup" method="post">
        <div class="card text-center shadow-sm">
            <div class="card-header display-4">
                REGISTRATION
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="loginId">Login</label>
                    <input name="login" type="text" class="form-control" id="loginId"
                           placeholder="Enter login">
                </div>

                <div class="form-group mt-3">
                    <label for="exampleInputEmail1">Email address</label>
                    <input name="email" type="email" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp"
                           placeholder="Enter email">

                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword1"
                           placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="repPass">Repeat Password</label>
                    <input name="conf_password" type="password" class="form-control" id="repPass"
                           placeholder="Password">
                </div>
            </div>
            <div class="card-footer text-muted">
                <button type="submit" class="btn btn-lg btn-primary">SignUP</button>
                <a class="btn btn-lg btn-danger mx-3" href="../index.jsp">BACK</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>