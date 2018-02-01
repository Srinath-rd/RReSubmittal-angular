<body>


<div>

    <h5 class="bold">Site Information:</h5>
    <br>

    <div id="siteInfo">
        <div class="form-group ui-widget" id="site-name-div">
            <span style="display: none" id="site-id"></span>
            <label for="site-name">Site Name: </label> (Name of site at which discharge occurred. Include local name of
            site/business, not responsible party name, unless a residence/vacant property)
            <span class="form-control" id="site-name" disabled="true" > </span>
        </div>
        <div class="form-group">
            <span style="display: none" id="site-address-id"></span>
            <label for="site-address">Address:</label> Include state address, not PO Box. If no street address, describe
            as precisely as possible. i.e. ,
            1/4 mile NW of CTHs o60 & 123 on E side of CTH 60
            <span class="form-control" id="site-address" disabled="true" ></span>

        </div>
        <div class="form-group row">

            <div class="col-xs-4">
                <label for="site-address">City:</label> <span
                                                              class="form-control" id="site-city"
                                                              disabled="true"></span>
            </div>
            <div class="col-xs-2">
                <label for="site-address">State:</label> <span
                    class="form-control" id="site-state" disabled="true">WI</span>
            </div>
            <div class="col-xs-2">

                <label for="site-address">ZIP code:</label>
                <div class="row">
                    <div class="col-xs-6">
                        <span  class="form-control" id="site-zipcode" disabled="true"></span>
                    </div>
                    <div class="col-xs-6">
                    </div>

                </div>
            </div>
            <div class="col-xs-4">
                <label for="site-county">County</label> <span
                    class="form-control" id="site-county" disabled="true"></span>
            </div>

            <div style="display: none;">
                <input id="site-complete-addr" hidden="">
            </div>
        </div>

        <div class="form-group row">
                <div class="col-xs-5">
                    <label for="site-municipality">Municipality(Specify municipality in which the site is located)</label> <span
                        class="form-control" id="site-municipality" disabled="true"></span>
                </div>
                <div class="col-xs-5">
                    <label for="site-municipality">Select type of coordinates</label> <select
                        type="dropdown" class="form-control input-sm" id="coordinates-type"
                        name="municipality" disabled="true">
                    <option>WTM</option>
                    <option>Regular</option>
                </select>
                </div>
            <div class="col-xs-1 site-longitude" id="site-longitude-div">
                <label for="site-longitude">Longitude</label> <span
                    class="form-control" id="site-longitude" disabled="true"> </span>
                <span class="site-lon-error error"
                      style="display: none;">Please click on the map to select Longitude</span>
            </div>
            <div class="col-xs-1 " id="site-latitude-div">
                <label for="site-latitude">Latitude</label> <span
                                                                   class="form-control" id="site-latitude"
                                                                  disabled="true"></span>

                <span class="site-lat-error error"
                      style="display: none;">Please click on the map to select Latitude</span>
            </div>
        </div>
        <!-- <div id="map"></div> -->
        <br>

        <br>
        <div id="x-info" style="display: none;"></div>
        <div id="y-info" style="display: none;"></div>
        <%--<div id="map"--%>
             <%--style="position: relative; width: 900px; height: 600px; border: 1px solid #000;">--%>
				<%--<span id="info"--%>
                      <%--style="position: absolute; left: 15px; bottom: 5px; color: #000; z-index: 50;"></span>--%>
        <%--</div>--%>

    </div>
</div>


</body>