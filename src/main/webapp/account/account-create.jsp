<jsp:useBean id="user" class="domain.User" scope="session"/>
<jsp:useBean id="categoryService" class="services.CategoryService"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="domain.AccountType" %>

<div class="modal fade" id="AccCreateModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">

        <div class="modal-content shadow-sm border-0">
            <form action="../open-acc" method="post">
                <div class="modal-header bg-dark text-light">
                    <h1>NEW ACCOUNT</h1>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input name="title" type="text" class="form-control" id="title" placeholder="account title">
                    </div>
                    <div class="form-group">
                        <label for="type">Type</label>
                        <select name="type" id="type" class="form-control">
                            <c:forEach items="${AccountType.values()}" var="t">
                                <option>${t}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="balance">Balance</label>
                        <input name="balance" type="number" class="form-control" id="balance">
                    </div>
                </div>

                <div class="modal-footer d-flex justify-content-center p-0">
                    <button type="submit" class="btn btn-primary">SAVE</button>
                </div>
            </form>
        </div>

    </div>
</div>