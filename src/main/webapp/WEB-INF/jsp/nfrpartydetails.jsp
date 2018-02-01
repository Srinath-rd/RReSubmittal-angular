<div>
    <h6 class="bold">Responsible Party (RP) and/or RP Representative:</h6>
    <br>
    <div class="checkbox">
        <label> <input id="nfrparty-lgu-chkbox" type="checkbox"> Check this box if you are filling out this form for a local governmental unit claiming an exemption from state Spill Law and Solid
            Waste Management responsibilities for the discharge being reported, per Wis. Stat  292.11(9)(e) and 292.23.
        </label>

    </div>
    <div>
        <label>Responsible Party Name: Add business or owner name that
            is responsible for cleanup. If more than one, click on add more and
            add more.</label>
    </div>
    <div id="respParties">
        <div id="responsibleParty0" class="elmt">

            <div class="form-group row ">
                <div class="col-xs-6">
                    <span style="display: none" id="rparty-person-id0"></span>
                    <label for="rparty-fname0">First name:</label> <input type="text"
                                                                        class="form-control input-sm" id="rparty-fname0"
                                                                        name="fname"
                                                                        placeholder="Please enter the first name">
                </div>
                <div class="col-xs-6">
                    <label for="rparty-lname0">Last name:</label> <input type="text"
                                                                 name="lname" class="form-control input-sm"
                                                                 id="rparty-lname0"
                                                                 placeholder="Please enter the last name">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-6">
                    <label for="rparty-cname0">Company</label> <input type="text"
                                                                    class="form-control input-sm" id="rparty-cname0"
                                                                    name="companyName"
                                                                    placeholder="Please enter the company name.">
                </div>
                <div class="col-xs-3">
                    <label for="rparty-phone-number0">Phone Number</label> <input type="text"
                                                                               class="form-control input-sm"
                                                                               id="rparty-phone-number0"
                                                                               name="phoneNumber"
                                                                               placeholder="Please enter a valid phone number.">
                </div>
                <div class="col-xs-3">
                    <label for="rparty-email0">Email</label> <input type="email"
                                                            class="form-control input-sm" id="rparty-email0" name="email"
                                                            placeholder="Please enter a valid email.">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-6">
                    <span style="display: none" id="rparty-person-address-id0"></span>
                    <label for="rparty-address0">Address:</label> <input type="text"
                                                               id="rparty-address0" class="form-control input-sm rparty-autocomplete"
                                                               name="address"
                                                               placeholder="Please enter the address."
                                                               onfocus="geolocate()">
                </div>
                <div class="col-xs-3">
                    <label for="rparty-city0">City:</label> <input type="text"
                                                               class="form-control field input-sm" id="rparty-city0"
                                                               name="city"
                                                               readonly="readonly">
                </div>
                <div class="col-xs-1">
                    <label for="rparty-state0">State:</label> <input type="text"
                                                                 class="form-control field input-sm" id="rparty-state0"
                                                                 name="state"
                                                                 value="WI" readonly="readonly">
                </div>
                <div class="col-xs-2">
                    <label for="rparty-zipcode0">ZIP code:</label> <input type="text"
                                                                      class="form-control field input-sm"
                                                                      id="rparty-zipcode0"
                                                                      name="zipcode" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <div id="button0">
                    <button id="add-more0" class="btn btn-xs btn-primary addmore">Add More
                    </button>
                </div>
            </div>

        </div>
        <br> <br>
    </div>
    <div class="form-horizontal text-center">
        <button type="submit" value="Cancel" name="_cancel"
                class="btn btn-xs btn-primary " id="nfrparty-info-save">Save and Exit
        </button>
        <button type="submit" value="Cancel" name="_cancel"
                class="btn btn-xs btn-primary " id="cancel">Cancel
        </button>
        <button type="submit" value="Cancel" name="_cancel"
                class="btn btn-xs btn-primary " id="resp-party-info-to-site-info-btn">Previous
        </button>
        <button type="submit" value="Next" name="_target1"
                class="btn btn-xs btn-primary" id="resp-party-info-to-hzrd-info-btn">Next
        </button>
    </div>
</div>
