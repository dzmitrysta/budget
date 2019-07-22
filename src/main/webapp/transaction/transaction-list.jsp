<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="domain.TransactionType" %>
<jsp:useBean id="as" class="services.AccountService"/>
<jsp:useBean id="cs" class="services.CategoryService"/>
<jsp:useBean id="ts" class="services.TransactionService"/>
<jsp:useBean id="user" class="domain.User" scope="session"/>

<button type="button" class="btn btn-primary btn-lg btn-block mb-3" data-toggle="modal"
        data-target="#TransCreateModal">ADD NEW
</button>
<table class="table table-hover table-sm">
    <thead class="thead-light">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Account</th>
        <th scope="col">Type</th>
        <th scope="col">Category</th>
        <th scope="col">Amount</th>
        <th scope="col">Description</th>
        <th scope="col">Date</th>
        <th class="text-center" scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach items="${ts.getTransactions(user.id)}" var="trans">
        <tr>
            <th scope="row">${trans.id}</th>
            <td>${as.getAccount(trans.accountId).number}</td>
            <td>${trans.type}</td>
            <td>${cs.getCategory(trans.categoryId).title}</td>
            <td>${trans.amount}</td>
            <td>${trans.description}</td>
            <td>${trans.date.toLocalDate()} / ${trans.date.toLocalTime()}</td>

            <td class="d-flex justify-content-center">
                    <%--                <a type="button" href="../edit-acc?id=${trans.id}" class="btn btn-success btn-sm mx-1">EDIT</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="transaction-create.jsp"/>



