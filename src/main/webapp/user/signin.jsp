<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../utils/include-bootstrap.jsp"/>
    <title>SignIN</title>
</head>
<body class="bg-warning">

<div class="container w-50 mt-5 pt-5 d-flex justify-content-center">
    <form class="w-75" action="/signin" method="post">
        <div class="card text-center shadow-sm border-0">
            <div class="card-header display-4 bg-dark text-light">SIGN IN </div>
            <div class="card-body">
                <div class="form-group my-2">
                    <input name="login" type="text" class="form-control" placeholder="Enter login">
                </div>
                <div class="form-group my-3">
                    <input name="password" type="password" class="form-control" placeholder="Password">
                </div>
            </div>
            <div class="card-footer">
                <button type="submit" class="btn btn-lg btn-primary ">SIGN IN</button>
                <a class="btn btn-lg btn-danger mx-3" href="../index.jsp">BACK</a>
            </div>
        </div>
    </form>
</div>

</body>
</html>