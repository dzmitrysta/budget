<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:useBean id="gs" class="services.CategoryService"/>

<button type="button" class="btn btn-primary btn-lg btn-block mb-3" data-toggle="modal"
        data-target="#createModal">ADD NEW
</button>
<table class="table table-hover table-sm">
    <thead class="thead-light">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Created</th>

        <th class="text-center" scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${gs.categoryList}" var="group">
        <tr>
            <th scope="row">${group.id}</th>
            <td>${group.title}</td>
            <td>${group.created.toLocalDate()} / ${group.created.toLocalTime()}</td>

            <td class="d-flex justify-content-center">
                <a type="button" href="../edit-category?id=${group.id}" class="btn btn-success btn-sm mx-1">EDIT</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="category-create.jsp"/>



