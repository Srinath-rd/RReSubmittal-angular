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
        <%@ include file="common/navigationa.jspf" %>
        <h6 class="important">*Emergency Discharges / Spills should be
            reported via the 24-Hour Hotline: 1-800-943-0003</h6>
        <div id="notifForm">
            <div>
                <form id="notificationForm">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default ">
                            <div class="panel-heading ">
                                <h6 class="align-left">
                                    <span class="badge badge-primary">1 </span>Details
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapseOne"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="detailsEditBtn">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <%@ include file="list-todosa.jsp" %>

                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h6>
                                    <span class="badge">2</span>Site Information
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapseTwo"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="siteInfoEditBtn">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapseTwo" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <%@ include file="list-todosa1.jsp" %>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h6>
                                    <span class="badge">3 </span>Responsible Party
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapseThree"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="respPartyEditBtn">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapseThree" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <%@ include file="list-todosa2.jsp" %>
                                </div>
                            </div>
                        </div>
                        <!-- Another one -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h6>
                                    <span class="badge">4</span>Hazardous Substance Information
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapseFour"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="hzrdSubEditBtn">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapseFour" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <%@ include file="list-todosa3.jsp" %>

                                </div>
                            </div>
                        </div>

                        <!-- Another one -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h6>
                                    <span class="badge">5</span>Impacts to the Environment
                                    <button type="button" data-toggle="collapse"
                                            data-parent="#accordion" data-target="#collapseFive"
                                            class="pull-right btn btn-secondary btn-sm"
                                            id="impactsEditBtn">Edit
                                    </button>
                                </h6>
                            </div>
                            <div id="collapseFive" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <%@ include file="list-todosa4.jsp" %>
                                </div>
                            </div>

                            <!-- Another one -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h6>
                                        <span class="badge">6</span>Federal Energy Requirements
                                        <button type="button" data-toggle="collapse"
                                                data-parent="#accordion" data-target="#collapseSix"
                                                class="pull-right btn btn-secondary btn-sm"
                                                id="sourceCauseEditBtn">Edit
                                        </button>
                                    </h6>
                                </div>
                                <div id="collapseSix" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <%@ include file="list-todosa5.jsp" %>

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