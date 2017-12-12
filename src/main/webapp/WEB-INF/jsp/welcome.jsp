<div class="container">
    <%@ include file="common/headera.jspf" %>
    <%@ include file="common/navigationa.jspf" %>
    <div class="wrapper">
        <div>
            <h4>Welcome, Joe</h4></div>
        <div id="content" class="row-fluid">
            <div class="row row-offcanvas row-offcanvas-left">

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <ul class="nav nav-bar-nav">
                        <li><a href="/RReSubmittal/users/10/applications/pending">In Progress</a></li>
                        <li><a href="/RReSubmittal/applications/all">Directory</a></li>
                        <li><a href="/RReSubmittal/users/10/applications/completed">Completed</a></li>
                    </ul>
                </div>
                <div class="col-xs-6 col-sm-9" id="applicationlist">
                    <table class="table table-striped">
                        <tr>
                            <td><a href="/RReSubmittal/list-todos-alt3">Notification Form</a></td>
                        </tr>
                        <tr>
                            <td><a>Technical Assistance Form</a></td>
                        </tr>
                        <tr>
                            <td><a>Closure Form</a></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="common/footera.jspf" %>
</div>
