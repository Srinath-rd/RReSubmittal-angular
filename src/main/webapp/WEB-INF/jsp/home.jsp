<div class="container">
    <%@ include file="common/headera.jspf" %>
    <%@ include file="common/navigationa.jspf" %>
    <div class="wrapper">
        <div>
            <h4>Welcome, ${name}</h4></div>
            <span style="display: none" id="userFirstname">${name}</span>
        <span style="display: none" id="userId">${useremail}</span>
        <div id="homepage-errormsg" style="display: none" class="error error-message"></div>
        <div id="homepage-successmsg" style="display: none" class="alert-success"></div>
        <c:set var="homeContext" value="${pageContext.request.contextPath}"/>
        <span style="display: none" id="home-context">${homeContext}</span>
        <div id="content" class="row-fluid">
            <div class="row row-offcanvas row-offcanvas-left">

                <div class="col-xs-3 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <ul class="nav nav-bar-nav">
                        <li><a id="forms-in-progress">In Progress</a></li>
                        <li><a id="forms-directory" class="active">Directory</a></li>
                        <li><a  id="forms-submitted">Submitted</a></li>
                        <li><a  id="forms-completed">Completed</a></li>
                    </ul>
                </div>
                <div class="col-xs-9 col-sm-9" id="applicationDiv">
                    <div id="application-header">

                    </div>
                    <div id="applicationlist">

                    </div>

                </div>
            </div>

        </div>

    </div>
    <%@ include file="common/footera.jspf" %>
</div>
