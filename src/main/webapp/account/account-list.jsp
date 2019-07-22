<%@ page import="domain.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:useBean id="as" class="services.AccountService"/>
<jsp:useBean id="user" class="domain.User" scope="session"/>

<button type="button" class="btn btn-primary btn-lg btn-block mb-3" data-toggle="modal"
        data-target="#AccCreateModal">ADD NEW
</button>
<table class="table table-hover table-sm">
    <thead class="thead-light">
    <tr>
        <th scope="col">Number</th>
        <th scope="col">Title</th>
        <th scope="col">Type</th>
        <th scope="col">Balance</th>
        <th scope="col">Created</th>
        <th class="text-center" scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${as.getAccounts(user.id)}" var="account">
        <tr>
            <th scope="row">${account.number}</th>
            <td>${account.title}</td>
            <td>${account.type}</td>
            <td>${account.balance}</td>
            <td>${account.created.toLocalDate()} / ${account.created.toLocalTime()}</td>

            <td class="d-flex justify-content-center">
                <a type="button" href="../edit-acc?id=${account.id}" class="btn btn-success btn-sm mx-1">EDIT</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="account-create.jsp"/>



