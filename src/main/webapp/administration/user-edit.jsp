<%@ page import="domain.UserType" %>
<%@ page import="domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../utils/include-bootstrap.jsp"/>
    <title>User Edit Page</title>
</head>
<body class="bg-warning">

<%--<jsp:useBean id="currentUser" class="domain.User"/>--%>

<%
    User currentUser = (User) request.getAttribute("current-user");
%>


<div class="container w-50 mt-5 pt-5 d-flex justify-content-center">
    <form class="w-75" action="/save-user" method="post">
        <div class="card text-center shadow-sm border-0">
            <div class="card-header display-4 bg-dark text-light">
                USER INFO
            </div>

            <div class="card-body">
                <div class="form-group">
                    <input name="id" type="text" class="form-control" value="<%=currentUser.getId()%>" hidden="hidden">
                    <label for="loginId">Login</label>
                    <input name="login" type="text" class="form-control" id="loginId"
                           value="<%=currentUser.getLogin()%>">

                    <div class="form-group mt-3">
                        <label for="exampleInputEmail1">Email address</label>
                        <input name="email" type="email" class="form-control" id="exampleInputEmail1"
                               value="<%=currentUser.getEmail()%>">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1"
                               value="<%=currentUser.getPassword()%>" >
                    </div>

                    <div class="form-group">
                        <label for="type">User Type</label>

                        <select name="type" class="form-control" id="type">
                            <option> <%=currentUser.getType().toString()%></option>
                            <c:forEach items="${UserType.values()}" var="item">
                                <option>${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="card-footer text-muted">
                <button type="submit" class="btn btn-primary">Save</button>

            </div>
        </div>
    </form>
</div>
</body>
</html>