<div>
    <h6 class="bold">Responsible Party (RP) and/or RP Representative:</h6>
    <br>
    <div class="checkbox">
        <label> <input type="checkbox"> A local governmental
            unit claiming an exemption from state Spill Law and Solid Waste
            Management responsibilities for the discharge being reported, per
            Wis. Stat. �� 292.11(9)(e) and 292.23, should: 1) check this box; 2)
            review DNR publication RR-055; and 3) provide documentation to DNR
            that demonstrates compliance with the statutory requirements of the
            liability exemptions. Local governmental units may also request a
            fee-based liability clarification letter from DNR by using DNR Form
            4400-237.
        </label>

    </div>
    <div>
        <label>Responsible Party Name: Add business or owner name that
            is responsible for cleanup. If more than one, click on add more and
            add more.</label>
    </div>
    <div id="respParties">
        <div id="responsibleParty0">

            <div class="form-group row">
                <div class="col-xs-6">
                    <label for="rpartyfname">First name:</label> <input type="text"
                                                                        class="form-control input-sm" id="rpartyfname"
                                                                        name="fname"
                                                                        placeholder="Please enter the first name">
                </div>
                <div class="col-xs-6">
                    <label for="email">Last name:</label> <input type="text"
                                                                 name="lname" class="form-control input-sm"
                                                                 id="rpartyLname"
                                                                 placeholder="Please enter the last name">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-6">
                    <label for="rpartyCname">Company</label> <input type="text"
                                                                    class="form-control input-sm" id="rpartyCname"
                                                                    name="companyName"
                                                                    placeholder="Please enter the company name.">
                </div>
                <div class="col-xs-3">
                    <label for="rpartyPhoneNumber">Phone Number</label> <input type="text"
                                                                               class="form-control input-sm"
                                                                               id="rpartyPhoneNumber"
                                                                               name="phoneNumber"
                                                                               placeholder="Please enter a valid phone number.">
                </div>
                <div class="col-xs-3">
                    <label for="email">Email</label> <input type="email"
                                                            class="form-control input-sm" id="email" name="email"
                                                            placeholder="Please enter a valid email.">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-6">
                    <label for="email">Address:</label> <input type="text"
                                                               id="autocomplete_rp1" class="form-control input-sm"
                                                               name="address"
                                                               placeholder="Please enter the address."
                                                               onfocus="geolocate()">
                </div>
                <div class="col-xs-3">
                    <label for="city_rp1">City:</label> <input type="text"
                                                               class="form-control field input-sm" id="city_rp1"
                                                               name="address"
                                                               readonly="readonly">
                </div>
                <div class="col-xs-1">
                    <label for="state_rp1">State:</label> <input type="text"
                                                                 class="form-control field input-sm" id="state_rp1"
                                                                 name="state"
                                                                 value="WI" readonly="readonly">
                </div>
                <div class="col-xs-2">
                    <label for="zipcode_rp1">ZIP code:</label> <input type="text"
                                                                      class="form-control field input-sm"
                                                                      id="zipcode_rp1"
                                                                      name="zipcode" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <div id="button0">
                    <button id="add-more0" class="btn-md btn-primary addmore">Add
                        More
                    </button>
                </div>
            </div>

        </div>
        <br> <br>
    </div>
    <div class="form-horizontal text-center">
        <button type="submit" value="Cancel" name="_cancel"
                class="btn-md btn-primary " id="cancel">Cancel
        </button>
        <button type="submit" value="Cancel" name="_cancel"
                class="btn-md btn-primary " id="respPartyInfoToSiteInfoBtn">Previous
        </button>
        <button type="submit" value="Next" name="_target1"
                class="btn-md btn-primary" id="respPartyInfoToHzrdInfoBtn">Next
        </button>
    </div>
</div>
