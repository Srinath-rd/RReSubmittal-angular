<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Esubmittals</title>
</head>
<body>
<div class="container">
    <div class="wrapper">
        <!-- end container -->
        <%@ include file="common/headera.jspf" %>
        <%--<%@ include file="common/navigationa.jspf" %>--%>
        <div>
            <div>  <button class="pull-left btn btn-xs btn-primary"   onclick="window.location='/rresubmittal/api/';">Back</button></div>
            <div><button class="btn-xs btn btn-primary hidden-print pull-right" onclick="printpage()"><span class="glyphicon glyphicon-print" aria-hidden="true"></span> Print</button></div>
        </div>
        <h6 class="important" style="text-align: center">*Emergency Discharges / Spills should be
            reported via the 24-Hour Hotline: 1-800-943-0003</h6>
        <span style="display: none" id="reportId">${report.reportId}</span>
        <span style="display: none" id="userFirstname">${user.firstName}</span>
        <span style="display: none" id="userLastname">${user.lastName}</span>
        <span style="display: none" id="username">${user.username}</span>
        <span style="display: none" id="userEmail">${user.email}</span>
        <div id="notifForm">
            <div>
                <form id="notificationForm">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default ">
                            <div class="panel-heading ">
                                <h6 class="align-left">
                                    <span class="badge badge-primary">1 </span>Details
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapse-one"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="details-edit-btn-readonly">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapse-one" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <%@ include file="nfdetailsreadonly.jsp" %>

                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h6>
                                    <span class="badge">2</span>Site Information
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapse-two"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="site-info-edit-btn-readonly">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapse-two" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <%@ include file="nfsiteinforeadonly.jsp" %>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h6>
                                    <span class="badge">3 </span>Responsible Party
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapse-three"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="resp-party-edit-btn-readonly">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapse-three" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <%@ include file="nfrpartydetailsreadonly.jsp" %>
                                </div>
                            </div>
                        </div>
                        <!-- Another one -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h6>
                                    <span class="badge">4</span>Hazardous Substance Information
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapse-four"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="hzrd-sub-edit-btn-readonly">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapse-four" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <%@ include file="nfhazardsubinforeadonly.jsp" %>

                                </div>
                            </div>
                        </div>

                        <!-- Another one -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h6>
                                    <span class="badge">5</span>Impacts to the Environment
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapse-five"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="impacts-edit-btn-readonly">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapse-five" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <%@ include file="nfimpactsinforeadonly.jsp" %>
                                </div>
                            </div>

                            <!-- Another one -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h6>
                                        <span class="badge">6</span>Federal Energy Requirements
                                        <button type="button" data-toggle="collapse"
                                                data-parent="#accordion" data-target="#collapse-six"
                                                class="pull-right btn btn-secondary btn-sm"
                                                id="source-cause-edit-btn-readonly">Edit
                                        </button>
                                    </h6>
                                </div>
                                <div id="collapse-six" class="panel-collapse collapse in">
                                    <div class="panel-body">
                                        <%@ include file="nfsourcesinforeadonly.jsp" %>

                                    </div>
                                </div>
                            </div>

                            <!-- Another one -->
                        </div>
                    </div>
                </form>
            </div>

        </div>
        <div id="confirmationMsg" style="display: none; height: 600px">
            <p>Thanks for submitting the information! A notification email
                will be sent to you shortly.</p>

        </div>
    </div>

    <%@ include file="common/footera.jspf" %>

</div>
</body>
</html>