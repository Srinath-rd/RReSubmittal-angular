<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Esubmittals</title>
</head>
<body>
<div class="container">
    <%@ include file="common/headera.jspf" %>
    <%@ include file="common/navigationa.jspf" %>
    <div class="row">
        <div class="col-md-12">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseOne"><span class="glyphicon glyphicon-file">
								</span>Details</a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">

                            <h5 class="important">*Emergency Discharges / Spills should
                                be reported via the 24-Hour Hotline: 1-800-943-0003</h5>
                            <p>Notice: Hazardous substance discharges must be reported
                                immediately according to s. 292.11 Wis. Stats. Non-emergency
                                hazardous substance discharges may be reported by telefaxing or
                                e-mailing a completed report to the Department, or calling or
                                visiting a Department office in person. If you choose to notify
                                the Department by telefax or by email, you should use this form
                                to be sure that all necessary information is included. However,
                                use of this form is not mandatory. Under s. 292.99, Wis.
                                Stats., the penalty for violating the reporting requirements of
                                ch. 292 Wis. Stats., shall be no less than $10 nor more than
                                $5000 for each violation. Each day of continued violation is a
                                separate offense. It is not the Department's intention to use
                                any personally identifiable information from this form for any
                                purpose other than program administration. However, information
                                submitted on this form may also be made available to requesters
                                under Wisconsin's Open Records Law (ss. 19.31-19.39, Wis.
                                Stats.). Confirmatory laboratory data should be included with
                                this form, to assist the DNR in processing this Hazardous
                                Substance Release Notification. Complete this form. TYPE or
                                PRINT LEGIBLY. NOTIFY appropriate DNR region (see next page)
                                IMMEDIATELY upon discovery of a potential release from (check
                                one):</p>
                            <div class="form-group">
                                <label>Please select the type of potential hazardous
                                    substance release</label>
                                <div class="radio">
                                    <label><input type="radio" name="optradio"
                                                  id="underGround" class="genericHazardType">Underground
                                        Petroleoum Storage Tank System</label>
                                </div>
                                <div class="radio">
                                    <label><input type="radio" name="optradio"
                                                  id="aboveGroundPetrol" class="genericHazardType">Above
                                        ground Petroleum Storage Tank System</label>
                                </div>
                                <div class="radio">
                                    <label><input type="radio" name="optradio"
                                                  id="dryCleaner" class="genericHazardType">Dry Cleaner
                                        Facility</label>
                                </div>
                                <div class="radio">
                                    <label><input type="radio" name="optradio"
                                                  id="otherHazardType">Other</label>
                                    <textarea class="form-control" rows="2" cols="3"
                                              id="hazardTypeTextArea" style="display: none;"
                                              placeholder="Please enter the release type"></textarea>
                                </div>

                            </div>
                            <h5 class="bold">Discharge Reported By:</h5>
                            <br>

                            <form>

                                <div class="form-group row">
                                    <div class="col-xs-6">
                                        <label for="email">First name:</label> <input type="text"
                                                                                      class="form-control" id="fname"
                                                                                      name="fname">
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="email">Last name:</label> <input type="text"
                                                                                     name="lname" class="form-control"
                                                                                     id="lname">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-6">
                                        <label for="pwd">Company</label> <input type="text"
                                                                                class="form-control" id="cname"
                                                                                name="companyName">
                                    </div>
                                    <div class="col-xs-3">
                                        <label for="pwd">Phone Number</label> <input type="text"
                                                                                     class="form-control"
                                                                                     id="phoneNumber"
                                                                                     name="phoneNumber">
                                    </div>
                                    <div class="col-xs-3">
                                        <label for="email">Email</label> <input type="email"
                                                                                class="form-control" id="email"
                                                                                name="email">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-xs-6">
                                        <label for="email">Address:</label> <input type="text"
                                                                                   class="form-control" id="address"
                                                                                   name="address">
                                    </div>
                                    <div class="col-xs-3">
                                        <label for="email">City:</label> <input type="text"
                                                                                class="form-control" id="address"
                                                                                name="address">
                                    </div>
                                    <div class="col-xs-1">
                                        <label for="email">State:</label> <input type="text"
                                                                                 class="form-control" id="address"
                                                                                 name="address">
                                    </div>
                                    <div class="col-xs-2">
                                        <label for="email">ZIP code:</label> <input type="text"
                                                                                    class="form-control" id="address"
                                                                                    name="address">
                                    </div>
                                </div>


                                <div class="form-horizontal text-center">
                                    <button type="submit" class="btn btn-primary" id="cancel">Cancel</button>
                                    <button type="submit" value="Next" class="btn btn-primary "
                                            id="next1">Next
                                    </button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo"><span
                                    class="glyphicon glyphicon-th-list"> </span>Site Information</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <h3>Notification For Hazardous Substance
                                Discharge(Non-Emergency Only)</h3>
                            <br>
                            <h5 class="important">*Emergency Discharges / Spills should
                                be reported via the 24-Hour Hotline: 1-800-943-0003</h5>

                            <h5 class="bold">Site Information:</h5>
                            <br>

                            <form>
                                <div class="form-group">
                                    <label for="siteName">Site Name:</label> <input type="text"
                                                                                    class="form-control" id="siteName">

                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-6">
                                        <label for="contactPhoneNumber">Phone Number</label> <input
                                            type="text" class="form-control" id="contactPhoneNumber">
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="contactEmail">Email</label> <input type="text"
                                                                                       class="form-control"
                                                                                       id="contactEmail">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-6">
                                        <label for="email">Address:</label> <input type="text"
                                                                                   class="form-control" id="address"
                                                                                   name="address">
                                    </div>
                                    <div class="col-xs-3">
                                        <label for="email">Municipality:</label> <input type="text"
                                                                                        class="form-control"
                                                                                        id="address" name="address">
                                    </div>
                                    <div class="col-xs-1">
                                        <label for="email">County</label> <input type="text"
                                                                                 class="form-control" id="address"
                                                                                 name="address">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-xs-8">
                                        <label for="email">Legal Description</label> <input
                                            type="text" class="form-control" id="address" name="address">
                                    </div>
                                    <div class="col-xs-2">
                                        <label for="email">WTM - X</label> <input type="text"
                                                                                  class="form-control" id="address"
                                                                                  name="address">
                                    </div>
                                    <div class="col-xs-2">
                                        <label for="email">WTM - Y</label> <input type="text"
                                                                                  class="form-control" id="address"
                                                                                  name="address">
                                    </div>
                                </div>

                                <br>


                                <div class="form-horizontal text-center">
                                    <button type="submit" value="Cancel" name="_cancel"
                                            class="btn btn-primary " id="cancel">Cancel
                                    </button>
                                    <button type="submit" value="Cancel" name="_cancel"
                                            class="btn btn-primary " id="previous1">Previous
                                    </button>
                                    <button type="submit" value="Next" name="_target1"
                                            class="btn btn-primary" id="next2">Next
                                    </button>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo"><span
                                    class="glyphicon glyphicon-th-list"> </span>Responsible Party</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <h5 class="bold">Responsible Party (RP) and/or RP
                                Representative:</h5>
                            <br>
                            <form>
                                <div id="respParties">
                                    <div id="responsibleParty0">
                                        <div class="form-group row">
                                            <div class="col-xs-6">
                                                <label for="email">First name:</label> <input type="text"
                                                                                              class="form-control"
                                                                                              id="fname" name="fname">
                                            </div>
                                            <div class="col-xs-6">
                                                <label for="email">Last name:</label> <input type="text"
                                                                                             name="lname"
                                                                                             class="form-control"
                                                                                             id="lname">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-xs-6">
                                                <label for="pwd">Company</label> <input type="text"
                                                                                        class="form-control" id="cname"
                                                                                        name="companyName">
                                            </div>
                                            <div class="col-xs-3">
                                                <label for="pwd">Phone Number</label> <input type="text"
                                                                                             class="form-control"
                                                                                             id="phoneNumber"
                                                                                             name="phoneNumber">
                                            </div>
                                            <div class="col-xs-3">
                                                <label for="email">Email</label> <input type="email"
                                                                                        class="form-control" id="email"
                                                                                        name="email">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-xs-6">
                                                <label for="email">Address:</label> <input type="text"
                                                                                           class="form-control"
                                                                                           id="address" name="address">
                                            </div>
                                            <div class="col-xs-3">
                                                <label for="email">City:</label> <input type="text"
                                                                                        class="form-control"
                                                                                        id="address" name="address">
                                            </div>
                                            <div class="col-xs-1">
                                                <label for="email">State:</label> <input type="text"
                                                                                         class="form-control"
                                                                                         id="address" name="address">
                                            </div>
                                            <div class="col-xs-2">
                                                <label for="email">ZIP code:</label> <input type="text"
                                                                                            class="form-control"
                                                                                            id="address" name="address">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div id="button0">
                                                <button id="add-more0" class="btn btn-primary addmore">Add
                                                    More
                                                </button>
                                            </div>
                                        </div>

                                    </div>
                                    <br> <br>
                                </div>
                                <div class="form-horizontal text-center">
                                    <button type="submit" value="Cancel" name="_cancel"
                                            class="btn btn-primary " id="cancel">Cancel
                                    </button>
                                    <button type="submit" value="Cancel" name="_cancel"
                                            class="btn btn-primary " id="previous1">Previous
                                    </button>
                                    <button type="submit" value="Next" name="_target1"
                                            class="btn btn-primary" id="next3">Next
                                    </button>
                                </div>

                            </form>


                        </div>
                    </div>
                </div>
                <!-- Another one -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo"><span
                                    class="glyphicon glyphicon-th-list"> </span>Hazardous Substance
                                Information</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <h5 class="bold">Hazardous Substance Information:</h5>
                            <br> <span id="select-result" style="display: none;">none</span>
                            <form:form class="form-group" modelAttribute="notificationForm"
                                       method="post" action="wizardform4">
                                <label>Identify hazardous substance discharged</label>
                                <div class="form-group row">
                                    <div class="col-xs-8">
                                        <select class="form-control form-control-lg"
                                                id="hazardSubstances">
                                            <option>PCE</option>
                                            <option>TCE</option>
                                            <option>Other Chlorinated</option>
                                            <option>Diesel</option>
                                            <option>Fuel Oil</option>
                                            <option>Gasoline</option>
                                            <option>Hydraulic Oil</option>
                                            <option>Jet Fuel</option>
                                            <option>PAHs</option>
                                        </select>
                                    </div>
                                    <div class="col-xs-2">
                                        <button type="button" class="btn btn-info btn-md"
                                                id="hazardPlusButton">
                                            <span class="glyphicon glyphicon-plus-sign"></span>
                                        </button>
                                        <button type="button" class="btn btn-danger btn-md"
                                                style="display: none;" id="hazardMinusButton">
                                            <span class="glyphicon glyphicon-minus-sign"></span>
                                        </button>
                                    </div>

                                </div>

                                <ol class="selectable" id="hazardSelList">
                                </ol>


                                <br>
                                <div class="form-horizontal text-center">
                                    <button type="submit" value="Cancel" name="_cancel"
                                            class="btn btn-primary ">Cancel
                                    </button>
                                    <button type="submit" value="Next" name="_target1"
                                            class="btn btn-primary ">Next
                                    </button>
                                </div>
                            </form:form>


                        </div>
                    </div>
                </div>

                <!-- Another one -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo"><span
                                    class="glyphicon glyphicon-th-list"> </span>Impacts to the
                                Environment</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <h5 class="bold">Impacts to the Environment Information:</h5>

                            <div id="errorDiv">

									<span style="display: none" class="errorMessage"
                                          id="errorMessage"></span>
                            </div>

                            <br> <label>Impacts to the environment</label> <span
                                id="impact-select-result" style="display: none;">none</span>


                            <div class="form-group row">
                                <div class="col-xs-10">
                                    <select class="form-control form-control-sm" id="envImpacts">
                                        <option>Air Contamination</option>
                                        <option>Co-mingled</option>
                                        <option>Contamination</option>
                                        <option>Air Contamination</option>
                                    </select>
                                </div>
                                <div class="col-xs-2">
                                    <button type="button" class="btn btn-info btn-md"
                                            id="envImpactPlusButton">
                                        <span class="glyphicon glyphicon-plus-sign"></span>
                                    </button>
                                    <button type="button" class="btn btn-danger btn-md"
                                            style="display: none;" id="envImpactMinusButton">
                                        <span class="glyphicon glyphicon-minus-sign"></span>
                                    </button>

                                </div>


                            </div>
                            <div class="form-group">
                                <div id="checkImpactProb">
                                    <label class="custom-control custom-radio"> <input
                                            id="radio1" name="chkimpact-input" type="radio"
                                            class="chkimpact-input" value="Potential"> <span
                                            class="custom-control-indicator"></span> <span
                                            class="custom-control-description">Potential</span>
                                    </label> <label class="custom-control custom-radio"> <input
                                        id="radio2" name="chkimpact-input" type="radio"
                                        class="chkImpact-input" value="Known"> <span
                                        class="custom-control-indicator"></span> <span
                                        class="custom-control-description">Known</span>
                                </label>
                                </div>
                            </div>
                            <ol class="selectable" id="envImpactList">
                            </ol>
                            <br> <br>
                            <div id="more-info">
                                <label>Contamination was discovered as result of </label>
                                <div class="form-group row">
                                    <div class="col-xs-3 checkbox">
                                        <label><input type="checkbox" name="optradio"
                                                      id="underGround" class="genericHazardType">Tank
                                            Closure assessment</label>

                                    </div>


                                </div>
                                <label class="col-xs-1">Date:</label>
                                <div class="col-xs-1 input-group date" id="datetimepicker1">
                                    <input type='text' class="form-control" id="datepickerui"/>
                                </div>

                                <div class="form-group row">


                                    <div class="col-xs-3 checkbox">
                                        <label><input type="checkbox" name="optradio"
                                                      id="aboveGroundPetrol" class="genericHazardType">Site
                                            Assessment</label>
                                    </div>


                                </div>

                                <label class="col-xs-1">Date:</label>
                                <div class="col-xs-1 input-group date" id="datetimepicker1">
                                    <input type='text' class="form-control" id="datepickerui"/>
                                </div>

                                <div class="form-group row">

                                    <div class="col-xs-3  checkbox">
                                        <label><input type="checkbox" name="optradio"
                                                      id="otherHazardType">Other</label>
                                        <textarea class="form-control" rows="2" cols="3"
                                                  id="hazardTypeTextArea" style="display: none;"
                                                  placeholder="Please enter the release type"></textarea>
                                    </div>

                                </div>

                                <label class="col-xs-1">Date:</label>
                                <div class="col-xs-1 input-group date" id="datetimepicker1">
                                    <input type='text' class="form-control" id="datepickerui"/>
                                </div>

                            </div>

                            <br>
                            <div id="lab-results">
                                <label>Lab results:</label>
                                <div class="form-group">
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="labresults"
                                                      id="labResults">Lab results will be mailed upon
                                            receipt</label>

                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="labresults"
                                                      id="labResults">Attach lab results</label>
                                    </div>
                                    <div style="margin-bottom: 20px;">
                                        <div>
                                            <input type="file" id="exampleInputFile">
                                        </div>

                                    </div>


                                </div>
                                <br>

                                <div class="form-horizontal text-center">
                                    <button type="submit" value="Cancel" name="_cancel"
                                            class="btn btn-primary " id="cancel">Cancel
                                    </button>
                                    <button type="submit" value="Cancel" name="_cancel"
                                            class="btn btn-primary " id="previous3">Previous
                                    </button>
                                    <button type="submit" value="Next" name="_target1"
                                            class="btn btn-primary" id="next4">Next
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Another one -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseTwo"><span
                                        class="glyphicon glyphicon-th-list"> </span>Federal Energy
                                    Requirements</a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <div class="panel-body">
                                <br>
                                <form:form class="form-group" modelAttribute="notificationForm"
                                           method="post" action="wizardform6">
                                    <div class="form-group">
                                        <label>Select Source</label>
                                        <div>
                                            <select class="form-control form-control-sm" id="envImpacts">
                                                <option>Tank</option>
                                                <option>Piping</option>
                                                <option>Dispenser</option>
                                                <option>Submersible Turbine Pump</option>
                                                <option>Delivery Problem</option>
                                                <option>Other</option>
                                            </select>
                                        </div>
                                        <br> <label>Select Cause</label>
                                        <div>
                                            <select class="form-control form-control-sm" id="envImpacts">
                                                <option>Spill</option>
                                                <option>Overfill</option>
                                                <option>Corrosion</option>
                                                <option>Physical or Mechanical Damage</option>
                                                <option>Installation Problem</option>
                                                <option>Other</option>
                                                <option>Unknown</option>
                                            </select>
                                        </div>

                                    </div>
                                    <br>
                                    <label>Please select your region</label>
                                    <div>
                                        <select class="form-control form-control-sm" id="envImpacts">
                                            <option>Northeast Region</option>
                                            <option>Northern Region</option>
                                            <option>South Central Region</option>
                                            <option>Southeast Region</option>
                                            <option>Installation Problem</option>
                                            <option>West Central Region</option>
                                        </select>
                                    </div>
                                    <br>
                                    <div class="form-horizontal text-center">
                                        <button type="submit" value="Cancel" name="_cancel"
                                                class="btn btn-primary " id="cancel">Cancel
                                        </button>
                                        <button type="submit" value="Cancel" name="_cancel"
                                                class="btn btn-primary " id="previous1">Previous
                                        </button>
                                        <button type="submit" value="Next" name="_target1"
                                                class="btn btn-primary" id="next3">Confirm
                                        </button>
                                    </div>

                                </form:form>

                            </div>
                        </div>
                    </div>

                    <!-- Another one -->

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseTwo"><span
                                        class="glyphicon glyphicon-th-list"> </span>Confirmation</a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <div class="panel-body">
                                <h3>Notification For Hazardous Substance
                                    Discharge(Non-Emergency Only)</h3>
                                <br>
                                <h5 class="important">*Emergency Discharges / Spills
                                    should be reported via the 24-Hour Hotline: 1-800-943-0003</h5>

                                <h5 class="bold">Site Information:</h5>
                                <br>

                                <form>
                                    <div class="form-group">
                                        <label for="siteName">Site Name:</label> <input type="text"
                                                                                        class="form-control"
                                                                                        id="siteName">

                                    </div>
                                    <div class="form-group row">
                                        <div class="col-xs-6">
                                            <label for="contactPhoneNumber">Phone Number</label> <input
                                                type="text" class="form-control" id="contactPhoneNumber">
                                        </div>
                                        <div class="col-xs-6">
                                            <label for="contactEmail">Email</label> <input type="text"
                                                                                           class="form-control"
                                                                                           id="contactEmail">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-xs-6">
                                            <label for="email">Address:</label> <input type="text"
                                                                                       class="form-control" id="address"
                                                                                       name="address">
                                        </div>
                                        <div class="col-xs-3">
                                            <label for="email">Municipality:</label> <input type="text"
                                                                                            class="form-control"
                                                                                            id="address" name="address">
                                        </div>
                                        <div class="col-xs-1">
                                            <label for="email">County</label> <input type="text"
                                                                                     class="form-control" id="address"
                                                                                     name="address">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-xs-8">
                                            <label for="email">Legal Description</label> <input
                                                type="text" class="form-control" id="address"
                                                name="address">
                                        </div>
                                        <div class="col-xs-2">
                                            <label for="email">WTM - X</label> <input type="text"
                                                                                      class="form-control" id="address"
                                                                                      name="address">
                                        </div>
                                        <div class="col-xs-2">
                                            <label for="email">WTM - Y</label> <input type="text"
                                                                                      class="form-control" id="address"
                                                                                      name="address">
                                        </div>
                                    </div>

                                    <br>


                                    <div class="form-horizontal text-center">
                                        <button type="submit" value="Cancel" name="_cancel"
                                                class="btn btn-primary " id="cancel">Cancel
                                        </button>
                                        <button type="submit" value="Cancel" name="_cancel"
                                                class="btn btn-primary " id="previous1">Previous
                                        </button>
                                        <button type="submit" value="Next" name="_target1"
                                                class="btn btn-primary" id="next2">Next
                                        </button>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <%@ include file="common/footera.jspf" %>
    <!-- end container -->
</body>
</html>