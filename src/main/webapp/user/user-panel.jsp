<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../utils/include-bootstrap.jsp"/>
    <title>Client panel</title>
</head>
<body class="bg-warning">
<jsp:include page="../navs/default-menu.jsp"/>

<div class="container mt-5">
    <div class="card border-0">
        <h5 class="card-header bg-dark text-light">Client panel</h5>
        <div class="card-body">
            <div class="row">
                <div class="col-3">
                    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home"
                           role="tab"
                           aria-controls="v-pills-home" aria-selected="true">Categories</a>
                        <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile"
                           role="tab"
                           aria-controls="v-pills-profile" aria-selected="false">Accounts</a>
                        <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages"
                           role="tab"
                           aria-controls="v-pills-messages" aria-selected="false">Transactions</a>
                    </div>
                </div>
                <div class="col-9 ">
                    <div class="tab-content" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                             aria-labelledby="v-pills-home-tab">
                            <div class="display-4 text-white bg-secondary p-2 text-center">CATEGORY LIST</div>
                          <jsp:include page="../category/category-list.jsp"/>
                        </div>
                        <div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
                             aria-labelledby="v-pills-profile-tab">
                            <div class="display-4 text-white bg-secondary p-2 text-center">ACCOUNTS LIST</div>
                            <jsp:include page="../account/account-list.jsp"/>
                        </div>
                        <div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
                             aria-labelledby="v-pills-messages-tab">
                            <div class="display-4 text-white bg-secondary p-2 text-center">TRANSACTIONS LIST</div>
                            <jsp:include page="../transaction/transaction-list.jsp"/>
                        </div>
                        <div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
                             aria-labelledby="v-pills-settings-tab">
                            ...
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
