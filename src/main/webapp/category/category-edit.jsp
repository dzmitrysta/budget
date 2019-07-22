<%@ page import="domain.Category" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../utils/include-bootstrap.jsp"/>
    <title>Category Edit Page</title>
</head>
<body class="bg-warning">

<%Category currentCategory = (Category) request.getAttribute("current-category");%>

<div class="container w-50 mt-5 pt-5 d-flex justify-content-center">
    <form class="w-75" action="../save-category" method="post">
        <div class="card text-center shadow-sm border-0">
            <div class="card-header display-4 bg-dark text-light">
                CATEGORY INFO
            </div>

            <div class="card-body">
                <div class="form-group">
                    <input name="id" type="text" class="form-control" value="<%=currentCategory.getId()%>"
                           hidden="hidden">
                    <label for="title">Title</label>
                    <input name="title" type="text" class="form-control" id="title"
                           value="<%=currentCategory.getTitle()%>">
                </div>
            </div>
            <div class="card-footer">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>