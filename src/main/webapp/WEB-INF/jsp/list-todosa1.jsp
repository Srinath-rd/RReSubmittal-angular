<body>


<div>

    <h5 class="bold">Site Information:</h5>
    <br>

    <div id="siteInfo">
        <div class="form-group ui-widget" id="siteNameDiv">
            <label for="siteName">Site Name:</label> <input type="text"
                                                            class="form-control input-sm" id="siteName" name="siteName"
                                                            placeholder="Please enter the site name"> <span
                class="siteNameError error" style="display: none;">Please
					select enter a site name.</span>
        </div>
        <div class="form-group row">
            <div class="col-xs-6">
                <label for="sitePhoneNumber">Phone Number</label> <input
                    type="text" class="form-control input-sm" id="sitePhoneNumber"
                    name="phoneNumber" placeholder="Please enter a valid phone number">
            </div>
            <div class="col-xs-6">
                <label for="siteEmail">Email</label> <input type="text"
                                                            class="form-control input-sm" id="siteEmail" name="email"
                                                            placeholder="please enter a valid emaill address">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-xs-5">
                <label for="siteAddress">Address:</label> <input type="text"
                                                                 class="form-control input-sm" id="siteAddress"
                                                                 name="address"
                                                                 placeholder="please enter a valid address">
            </div>
            <div class="col-xs-2">
                <label for="siteAddress">City:</label> <input type="text"
                                                              class="form-control input-sm" id="siteCity"
                                                              name="siteCity">
            </div>
            <div class="col-xs-1">
                <label for="siteAddress">State:</label> <input type="text"
                                                               class="form-control input-sm" id="siteState"
                                                               name="siteState"
                                                               readonly="readonly" value="WI">
            </div>
            <div class="col-xs-2">
                <label for="siteAddress">ZIP code:</label>
                <div class="row">
                    <div class="col-xs-6">
                        <input type="text" class="form-control input-sm" id="siteZipcode"
                               name="zipcode">
                    </div>
                    <div class="col-xs-6">
                        <div class="row">
                            <button type="button" class="btn-md btn-info" id="siteLocate"
                                    title="Please enter an address and click the locate button">Locate
                            </button>
                        </div>
                    </div>

                </div>
            </div>
            <div class="col-xs-2">
                <label for="siteCounty">County</label> <input type="text"
                                                              class="form-control input-sm" id="siteCounty"
                                                              name="county">
            </div>

            <div style="display: none;">
                <input id="siteCompleteAddr" hidden="">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-xs-2">
                <label for="siteLegalDesc">Legal Description </label> <input
                    type="text" class="form-control input-sm" id="siteLegalDesc"
                    name="siteLegalDesc">
            </div>
            <div class="col-xs-1">
                <label for="siteLegalDesc1">1/4 of </label> <input type="text"
                                                                   class="form-control input-sm" id="siteLegalDesc1"
                                                                   name="siteLegalDesc1">
            </div>
            <div class="col-xs-1">
                <label for="siteLegalDesc2">Section</label> <input type="text"
                                                                   class="form-control input-sm" id="siteLegalDesc2"
                                                                   name="siteLegalDesc2">
            </div>
            <div class="col-xs-1">
                <label for="siteLegalDesc3">Town </label> <input type="text"
                                                                 class="form-control input-sm" id="siteLegalDesc3"
                                                                 name="siteLegalDesc3">
            </div>
            <div class="col-xs-4">
                <label for="siteLegalDesc4">Range</label>
                <div class="row">
                    <div class="col-xs-6 form-group">
                        <input type="text" class="form-control input-sm"
                               id="siteLegalDesc4" name="siteLegalDesc4">
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label class="radio-inline control-label" id="siteLegalDescDir">
                                <input type="radio" name="siteDescDirRadio">East
                            </label> <label class="radio-inline control-label" id="dir"> <input
                                type="radio" name="siteDescDirRadio">West
                        </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-1">
                <label for="siteMunicipality">Municipality</label> <input
                    type="text" class="form-control input-sm" id="siteMunicipality"
                    name="municipality">
            </div>
            <div class="col-xs-1 siteLongitude" id="siteLongitudeDiv">
                <label for="siteLongitude">Longitude</label> <input type="text"
                                                                    class="form-control input-sm" id="siteLongitude"
                                                                    name="siteLongitude" readonly="readonly">
                <span class="siteLonError error"
                      style="display: none;">Please click on the map to select Longitude</span>
            </div>
            <div class="col-xs-1 " id="siteLatitudeDiv">
                <label for="siteLatitude">Latitude</label> <input type="text"
                                                                  class="form-control input-sm" id="siteLatitude"
                                                                  name="siteLatitude" readonly="readonly">

                <span class="siteLatError error"
                      style="display: none;">Please click on the map to select Latitude</span>
            </div>
        </div>
        <!-- <div id="map"></div> -->
        <br>


        <div class="form-horizontal text-center">
            <button type="submit" value="Cancel" name="_cancel"
                    class="btn-md btn-primary " id="cancel">Cancel
            </button>
            <button type="submit" value="Cancel" name="_cancel"
                    class="btn-md btn-primary " id="siteToDischBtn">Previous
            </button>
            <button type="submit" value="Next" name="_target1"
                    class="btn-md btn-primary" id="siteToRespPartyBtn">Next
            </button>
        </div>
        <br>
        <div id="x-info" style="display: none;"></div>
        <div id="y-info" style="display: none;"></div>
        <div id="map"
             style="position: relative; width: 900px; height: 600px; border: 1px solid #000;">
				<span id="info"
                      style="position: absolute; left: 15px; bottom: 5px; color: #000; z-index: 50;"></span>
        </div>

    </div>
</div>


</body>