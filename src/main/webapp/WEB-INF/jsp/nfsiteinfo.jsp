<body>


<div>

    <h5 class="bold">Site Information:</h5>
    <br>

    <div id="siteInfo">
        <div class="form-group ui-widget" id="site-name-div">
            <span style="display: none" id="site-id"></span>
            <label for="site-name">Site Name: </label> (Name of site at which discharge occurred. Include local name of
            site/business, not responsible party name, unless a residence/vacant property)
            <input type="text"
                   class="form-control input-sm" id="site-name" name="site-name"
                   placeholder="Please enter the site name"> <span
                class="site-name-error error" style="display: none;">Please
					select enter a site name.</span>
        </div>
        <%--<div class="form-group row">--%>
        <%--<div class="col-xs-6">--%>
        <%--<label for="site-phone-number">Phone Number</label> <input--%>
        <%--type="text" class="form-control input-sm" id="site-phone-number"--%>
        <%--name="phone-number" placeholder="Please enter a valid phone number">--%>
        <%--</div>--%>
        <%--<div class="col-xs-6">--%>
        <%--<label for="site-email">Email</label> <input type="text"--%>
        <%--class="form-control input-sm" id="site-email" name="email"--%>
        <%--placeholder="please enter a valid emaill address">--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="form-group">
            <span style="display: none" id="site-address-id"></span>
            <label for="site-address">Address:</label> Include state address, not PO Box. If no street address, describe
            as precisely as possible. i.e. ,
            1/4 mile NW of CTHs o60 & 123 on E side of CTH 60
            <input type="text" class="form-control input-sm" id="site-address"
                   name="address"
                   placeholder="please enter a valid address">

        </div>
        <div class="form-group row">

            <div class="col-xs-4">
                <label for="site-address">City:</label> <input type="text"
                                                              class="form-control input-sm" id="site-city"
                                                              name="siteCity">
            </div>
            <div class="col-xs-2">
                <label for="site-address">State:</label> <input type="text"
                                                               class="form-control input-sm" id="site-state"
                                                               name="site-state"
                                                               readonly="readonly" value="WI">
            </div>
            <div class="col-xs-2">

                <label for="site-address">ZIP code:</label>
                <div class="row">
                    <div class="col-xs-6">
                        <input type="text" class="form-control input-sm" id="site-zipcode"
                               name="zipcode">
                    </div>
                    <div class="col-xs-6">
                        <div class="row">
                            <button type="button" class="btn btn-xs btn-info" id="site-locate"
                                    title="Please enter an address and click the locate button">Locate
                            </button>
                        </div>
                    </div>

                </div>
            </div>
            <div class="col-xs-4">
                <label for="site-county">County</label> <input type="text"
                                                              class="form-control input-sm" id="site-county"
                                                              name="county">
            </div>

            <div style="display: none;">
                <input id="site-complete-addr" hidden="">
            </div>
        </div>

        <div class="form-group row">
            <%--<div class="col-xs-2">--%>
                <%--<label for="site-legal-desc">Legal Description </label> <input--%>
                    <%--type="text" class="form-control input-sm" id="site-legal-desc"--%>
                    <%--name="siteLegalDesc">--%>
            <%--</div>--%>
            <%--<div class="col-xs-1">--%>
                <%--<label for="site-legal-desc1">1/4 of </label> <input type="text"--%>
                                                                     <%--class="form-control input-sm" id="site-legal-desc1"--%>
                                                                     <%--name="site-legal-desc1">--%>
            <%--</div>--%>
            <%--<div class="col-xs-1">--%>
                <%--<label for="site-legal-desc2">Section</label> <input type="text"--%>
                                                                     <%--class="form-control input-sm" id="site-legal-desc2"--%>
                                                                     <%--name="site-legal-desc2">--%>
            <%--</div>--%>
            <%--<div class="col-xs-1">--%>
                <%--<label for="site-legal-desc3">Town </label> <input type="text"--%>
                                                                   <%--class="form-control input-sm" id="site-legal-desc3"--%>
                                                                   <%--name="site-legal-desc3">--%>
            <%--</div>--%>
            <%--<div class="col-xs-4">--%>
                <%--<label for="site-legal-desc-dir">Range</label>--%>
                <%--<div class="row">--%>
                    <%--<div class="col-xs-6 form-group">--%>
                        <%--<input type="text" class="form-control input-sm"--%>
                               <%--id="site-legal-desc4" name="site-legal-desc4">--%>
                    <%--</div>--%>
                    <%--<div class="col-xs-6">--%>
                        <%--<div class="form-group">--%>
                            <%--<label class="radio-inline control-label" id="site-legal-desc-dir">--%>
                                <%--<input type="radio" name="site-desc-dir-radio">East--%>
                            <%--</label> <label class="radio-inline control-label" id="dir"> <input--%>
                                <%--type="radio" name="site-desc-dir-radio">West--%>
                        <%--</label>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
                <div class="col-xs-5">
                    <label for="site-municipality">Municipality(Specify municipality in which the site is located)</label> <input
                        type="text" class="form-control input-sm" id="site-municipality"
                        name="municipality">
                </div>
                <div class="col-xs-5">
                    <label for="site-municipality">Select type of coordinates</label> <select
                        type="dropdown" class="form-control input-sm" id="coordinates-type"
                        name="municipality">
                    <option>WTM</option>
                    <option>Regular</option>
                </select>
                </div>
            <div class="col-xs-1 site-longitude" id="site-longitude-div">
                <label for="site-longitude">Longitude</label> <input type="text"
                                                                     class="form-control input-sm" id="site-longitude"
                                                                     name="site-longitude">
                <span class="site-lon-error error"
                      style="display: none;">Please click on the map to select Longitude</span>
            </div>
            <div class="col-xs-1 " id="site-latitude-div">
                <label for="site-latitude">Latitude</label> <input type="text"
                                                                   class="form-control input-sm" id="site-latitude"
                                                                   name="site-latitude">

                <span class="site-lat-error error"
                      style="display: none;">Please click on the map to select Latitude</span>
            </div>
        </div>
        <!-- <div id="map"></div> -->
        <br>


        <div class="form-horizontal text-center">
            <button type="submit" value="save" name="_cancel"
                    class="btn btn-xs btn-primary " id="nfsite-info-save">Save and Exit
            </button>
            <button type="submit" value="Cancel" name="_cancel"
                    class="btn btn-xs btn-primary " id="cancel">Cancel
            </button>
            <button type="submit" value="Cancel" name="_cancel"
                    class="btn btn-xs btn-primary " id="site-to-disch-btn">Previous
            </button>
            <button type="submit" value="Next" name="_target1"
                    class="btn btn-xs btn-primary" id="site-to-resp-party-btn">Next
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