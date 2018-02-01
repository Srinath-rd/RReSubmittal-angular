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
                          id="underGround" class="generic-hazard-type" value="underground">Underground
                Petroleoum Storage Tank System</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="hzrd-type-radio"
                          id="above-ground-petrol" class="generic-hazard-type" value="aboveground">Above
                ground Petroleum Storage Tank System</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="hzrd-type-radio"
                          id="dry-cleaner" class="generic-hazard-type" value="drycleaner">Dry Cleaner Facility</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="hzrd-type-radio"
                          id="other-hazard-type" value="other">Other</label>
            <textarea class="form-control input-sm" rows="2" cols="3"
                      id="hazard-type-text-area" style="display: none;"
                      placeholder="Please enter the release type"></textarea>
        </div>
        <span class="hzrd-type-error error" style="display: none;">Please select a
				potential release type.</span>
    </div>
    <h6 class="bold">Discharge Reported By:</h6>
    <br>


    <div id="dischargeInfo">
        <div class="form-group row">
            <div class="col-xs-6" id="fname-grp">
                <label for="reporter-fname" class="control-label">First name:</label> <input
                    type="text" class="form-control input-sm" id="reporter-fname" name="fname"
                    placeholder="Please enter the first name"> <span
                    class="fname-rep-by error" style="display: none;">This is a required field.</span>
            </div>
            <div class="col-xs-6" id="lname-grp">
                <label for="reporter-lname">Last name:</label> <input type="text"
                                                             name="lname" class="form-control input-sm" id="reporter-lname"
                                                             placeholder="Please enter the last name" > <span
                    class="lname-rep-by error" style="display: none;">This is a required field.</span>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-xs-6">
                <span style="display: none" id="reporter-person-id"></span>
                <label for="reporter-cname">Company</label> <input type="text"
                                                                class="form-control input-sm" id="reporter-cname"
                                                                name="companyName"
                                                                placeholder="Please enter company name" >
            </div>
            <div class="col-xs-3">
                <label for="reporter-phone-number">Phone Number</label> <input type="text"
                                                                     class="form-control input-sm" id="reporter-phone-number"
                                                                     name="phoneNumber"
                                                                     placeholder="Please enter valid phone number">
            </div>
            <div class="col-xs-3">
                <label for="reporter-email">Email</label> <input type="email"
                                                        class="form-control input-sm" id="reporter-email" name="email"
                                                        placeholder="Please enter valid email address">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-xs-6">
                <span style="display: none" id="reporter-person-address-id"></span>
                <label for="reporter-address">Address:</label> <input type="text"
                                                             id="reporter-address" placeholder="Enter your address"
                                                             class="form-control input-sm" onFocus="geolocate()"
                                                             name="address">
            </div>
            <div class="col-xs-3">
                <label for="reporter-city">City:</label> <input type="text"
                                                       class="form-control field input-sm" id="reporter-city" name="address"
                                                       readonly="readonly">
            </div>
            <div class="col-xs-1">
                <label for="reporter-state">State:</label> <input type="text"
                                                         class="form-control field input-sm "
                                                         id="reporter-state" name="state"
                                                         readonly="readonly" value="WI">
            </div>
            <div class="col-xs-2">
                <label for="reporter-zipcode">ZIP code:</label> <input type="text"
                                                            class="form-control field input-sm" id="reporter-zipcode"
                                                            name="zipcode" readonly="readonly">
            </div>
        </div>


        <div class="form-horizontal text-center">
            <button type="save" class="btn btn-xs btn-primary" id="nfdetailssave">Save and Exit</button>
            <button type="submit" class="btn btn-xs btn-primary" id="cancel">Cancel</button>
            <button type="submit" value="Next" class="btn btn-xs btn-primary "
                    id="disch-to-site-btn">Next
            </button>
        </div>
    </div>
    <div class="push"></div>
</div>


</body>