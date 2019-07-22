<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="domain.TransactionType" %>
<jsp:useBean id="as" class="services.AccountService"/>
<jsp:useBean id="cs" class="services.CategoryService"/>
<jsp:useBean id="ts" class="services.TransactionService"/>
<jsp:useBean id="user" class="domain.User" scope="session"/>
<div class="modal fade" id="TransCreateModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">

        <div class="modal-content shadow-sm border-0">
            <form action="../create-trans" method="post">
                <div class="modal-header bg-dark text-light">
                    <h1>NEW TRANSACTION</h1>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <label for="type">Type</label>
                        <select name="type" id="type" class="form-control">
                            <c:forEach items="${TransactionType.values()}" var="t">
                                <option>${t}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="account">Account</label>
                        <select name="account" id="account" class="form-control">
                            <c:forEach items="${as.getAccounts(user.id)}" var="ac">
                                <option value="${ac.id}">${ac.title}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="cat">Category</label>
                        <select name="category" id="cat" class="form-control">
                            <c:forEach items="${cs.categoryList}" var="ct">
                                <option value="${ct.id}">${ct.title}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="amount">Amount</label>
                        <input name="amount" type="number" class="form-control" id="amount">
                    </div>

                    <div class="form-group">
                        <label for="desc">Description</label>
                        <input name="desc" type="text" class="form-control" id="desc">
                    </div>
                </div>

                <div class="modal-footer d-flex justify-content-center">
                    <button type="submit" class="btn btn-primary">SAVE</button>
                </div>
            </form>
        </div>

    </div>
</div>