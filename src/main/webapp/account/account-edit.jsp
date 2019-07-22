<%@ page import="domain.Account" %>
<%@ page import="domain.AccountType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../utils/include-bootstrap.jsp"/>
    <title>ACCOUNT Edit Page</title>
</head>
<body class="bg-warning">

<%Account cac = (Account) request.getAttribute("current-account");%>

<div class="container w-50 mt-5 pt-5 d-flex justify-content-center">
    <form class="w-75" action="../save-account" method="post">
        <div class="card text-center shadow-sm border-0">
            <div class="card-header display-4 bg-dark text-light">
                ACCOUNT INFO
            </div>

            <div class="card-body">
                <div class="form-group">
                    <input name="id" type="text" class="form-control" value="<%=cac.getId()%>"
                           hidden="hidden">
                    <input name="number" type="text" class="form-control" value="<%=cac.getNumber()%>"
                           hidden="hidden">
                    <input name="uid" type="number" class="form-control" value="<%=cac.getUser_id()%>"
                           hidden="hidden">
                    <input name="balance" type="number" class="form-control" value="<%=cac.getBalance()%>"
                           hidden="hidden">



                    <label for="title">Title</label>
                    <input name="title" type="text" class="form-control" id="title"
                           value="<%=cac.getTitle()%>">
                </div>
                <div class="form-group">
                    <label for="type">Type</label>
                    <select name="type" id="type" class="form-control">
                        <option><%=cac.getType()%>
                        </option>
                        <c:forEach items="${AccountType.values()}" var="t">
                            <option>${t}</option>
                        </c:forEach>
                    </select>
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