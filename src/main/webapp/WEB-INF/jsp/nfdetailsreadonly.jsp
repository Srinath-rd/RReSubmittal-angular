<body>

<div>
    <p>Notice: Hazardous substance discharges must be reported
        immediately according to s. 292.11 Wis. Stats. Non-emergency
        hazardous substance discharges may be reported by telefaxing or
        e-mailing a completed report to the Department, or calling or
        visiting a Department office in person. If you choose to notify the
        Department by telefax or by email, you should use this form to be
        sure that all necessary information is included. However, use of this
        form is not mandatory. Under s. 292.99, Wis. Stats., the penalty for
        violating the reporting requirements of ch. 292 Wis. Stats., shall be
        no less than $10 nor more than $5000 for each violation. Each day of
        continued violation is a separate offense. It is not the Department's
        intention to use any personally identifiable information from this
        form for any purpose other than program administration. However,
        information submitted on this form may also be made available to
        requesters under Wisconsin's Open Records Law (ss. 19.31-19.39, Wis.
        Stats.). Confirmatory laboratory data should be included with this
        form, to assist the DNR in processing this Hazardous Substance
        Release Notification. Complete this form. TYPE or PRINT LEGIBLY.
        NOTIFY appropriate DNR region (see next page) IMMEDIATELY upon
        discovery of a potential release from (check one):</p>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <span style="display: none" id="context">${context}</span>
    <div class="form-group" id="hzrd-type-radio-grp">
        <label>Please select the type of potential hazardous
            substance release</label>
        <div class="radio">
            <label><input type="radio" name="hzrd-type-radio"
                          id="underGround" class="generic-hazard-type" value="underground" disabled="true">Underground
                Petroleoum Storage Tank System</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="hzrd-type-radio"
                          id="above-ground-petrol" class="generic-hazard-type" value="aboveground" disabled="true">Above
                ground Petroleum Storage Tank System</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="hzrd-type-radio"
                          id="dry-cleaner" class="generic-hazard-type" value="drycleaner" disabled="true">Dry Cleaner Facility</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="hzrd-type-radio"
                          id="other-hazard-type" value="other">Other</label>
            <textarea class="form-control input-sm" rows="2" cols="3"
                      id="hazard-type-text-area" style="display: none;"
                      placeholder="Please enter the release type" disabled="true"></textarea>
        </div>
        <span class="hzrd-type-error error" style="display: none;">Please select a
				potential release type.</span>
    </div>
    <h6 class="bold">Discharge Reported By:</h6>
    <br>


    <div id="dischargeInfo">
        <div class="form-group row">
            <div class="col-xs-6" id="fname-grp">
                <label for="reporter-fname" class="control-label">First name:</label> <span
                    class="form-control" id="reporter-fname" disabled="true"></span>
            </div>
            <div class="col-xs-6" id="lname-grp">
                <label for="reporter-lname">Last name:</label> <span
                    class="form-control" id="reporter-lname" disabled="true"></span>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-xs-6">
                <span style="display: none" id="reporter-person-id"></span>
                <label for="reporter-cname">Company</label> <span class="form-control" id="reporter-cname" disabled="true"></span>
            </div>
            <div class="col-xs-3">
                <label for="reporter-phone-number">Phone Number</label> <span
                                                                     class="form-control" id="reporter-phone-number"  disabled="true"></span>
            </div>
            <div class="col-xs-3">
                <label for="reporter-email">Email</label> <span class="form-control" disabled="true"
                                                        id="reporter-email" ></span>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-xs-6">
                <span style="display: none" id="reporter-person-address-id"></span>
                <label for="reporter-address">Address:</label> <span
                                                             id="reporter-address"
                                                             class="form-control" disabled="true"></span>
            </div>
            <div class="col-xs-3">
                <label for="reporter-city">City:</label> <span
                    class="form-control" id="reporter-city" disabled="true" ></span>
            </div>
            <div class="col-xs-1">
                <label for="reporter-state">State:</label> <span
                                                         class="form-control"
                                                         id="reporter-state" disabled="true"></span>
            </div>
            <div class="col-xs-2">
                <label for="reporter-zipcode">ZIP code:</label> <span
                    class="form-control" id="reporter-zipcode" disabled="true"></span>
            </div>
        </div>

    </div>
    <div class="push"></div>
</div>


</body>