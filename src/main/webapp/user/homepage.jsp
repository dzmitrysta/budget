<%@ page import="domain.User" %>
<%@ page import="domain.UserType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../utils/include-bootstrap.jsp"/>
    <title>Home Page</title>
</head>
<body class="bg-warning">
<% User current = (User) session.getAttribute("user"); %>

<c:choose>
    <c:when test="<%=current.getType() == UserType.CLIENT%>">
        <jsp:forward page="user-panel.jsp"/>
    </c:when>

    <c:when test="<%=current.getType() == UserType.GUEST%>">
        <jsp:forward page="guest-page.jsp"/>
    </c:when>
    <c:when test="<%=current.getType() == UserType.ADMIN%>">
       <jsp:forward page="../administration/admin-panel.jsp"/>
    </c:when>
</c:choose>


<div class="container-fluid mt-5">
    <div class=" card-deck">
        <div class="card text-center">
            <div class="card-header">
                User Info
            </div>
            <div class="card-body">
                <h3>ID: <%=current.getId()%>
                </h3>
                <h3>Login: <%=current.getLogin()%>
                </h3>
                <h3>Email: <%=current.getEmail()%>
                </h3>
            </div>
            <div class="card-footer text-muted">
                2 days ago
            </div>
        </div>
        <div class="card text-center">
            <div class="card-header">
                Featured
            </div>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
            <div class="card-footer text-muted">
                2 days ago
            </div>
        </div>
        <div class="card text-center">
            <div class="card-header">
                Featured
            </div>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
            <div class="card-footer text-muted">
                2 days ago
            </div>
        </div>
    </div>

</div>
</body>
</html>