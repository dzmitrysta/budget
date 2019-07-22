<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:useBean id = "uservice" class = "services.UserService" />

<table class="table table-hover table-sm">
    <thead class="thead-light">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Login</th>
        <th scope="col">Email</th>
        <th scope="col">Type</th>
        <th class="text-center" scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${uservice.allUsers}" var="item">
        <tr>
            <th scope="row">${item.id}</th>
            <td>${item.login}</td>
            <td>${item.email}</td>
            <td>${item.type}</td>
            <td class="d-flex justify-content-center">
                <a type="button" href="/editu?uid=${item.id}" class="btn btn-outline-success btn-sm mx-1" >EDIT</a>
                <a type="button" class="btn btn-outline-danger btn-sm">DELETE</a>
            </td>
        </tr>
    </c:forEach>


    </tbody>
</table>