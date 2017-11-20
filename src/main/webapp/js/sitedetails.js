(function () {
    var xvalue = $("#x-info").text();
    var yvalue = $("#y-info").text();

    $("#wtmx").val(xvalue);
    $("#wtmy").val(yvalue);
    var validateSiteInformation = function () {
        var isValid1 = false;
        var isValid2 = false;
        var isValid3 = false;

        if ($("#siteName").val() === "") {
            $("#siteNameDiv").addClass("has-error");
            $(".siteNameError").show();
            isValid1 = false;
        } else {
            $("#siteNameDiv").removeClass("has-error");
            $(".siteNameError").hide();
            isValid1 = true;
        }
        if ($("#siteLongitude").val() === "") {
            $("#siteLongitudeDiv").addClass("has-error");
            $(".siteLonError").show();
            isValid2 = false;
        } else {
            $("#siteLongitude").removeClass("has-error");
            $(".siteLonError").hide();
            isValid2 = true;
        }

        if ($("#siteLatitude").val() === "") {
            $("#siteLatitudeDiv").addClass("has-error");
            $(".siteLatError").show();
            isValid3 = false;
        } else {
            $("#siteLatitudeDiv").removeClass("has-error");
            $(".siteLatError").hide();
            isValid3 = true;
        }
        if (isValid1 && isValid2 && isValid3) {
            return true;
        } else {
            return false;
        }
    }


    $("#siteName").autocomplete({
        source: function (request, response) {
            $.ajax({
                url: "facilities",
                dataType: "json",
                data: {
                    name: request.term
                },
                success: function (data) {
                    //	response(data);
                    //					return $.map(data, function(item) {
                    //					//	alert(item.activityDetailName)
                    //						response({
                    //							label : item['activityDetailName'],
                    //							value : item['activityDetailName']
                    //						});
                    //					});

                    response($.map(data, function (value, key) {
                        return {
                            label: value.facilityName,
                            value: value.facilityName,
                            facilityName: value.facilityName,
                            address: value.address,
                        }
                    }));
                },
                error: function (data) {
                    alert(data);
                }
            });
        },
        minLength: 4,
        select: function (event, data) {
            console.log(data.item.label);
            console.log(data.item.facilityName);
            console.log(data.item.address.streetAddress1);
            console.log(data.item.address.city);
            console.log(data.item.address.county);
            console.log(data.item.address.zipcode);
            console.log(data.item.address.state);
            $("#siteAddress").val(data.item.address.streetAddress1);
            $("#siteCity").val(data.item.address.city);
            $("#siteCounty").val(data.item.address.county);
            $("#siteState").val(data.item.address.state);
            $("#siteZipcode").val(data.item.address.zipcode);
            var completeAddr = data.item.address.streetAddress1 + " " +
                data.item.address.city + " " +
                data.item.address.state + " " +
                data.item.address.zipcode;
            $("#siteCompleteAddr").val(completeAddr);
            $("#siteLocate").click();
        }
    });

    $("#siteToRespPartyBtn").click(function (evt) {
        evt.preventDefault();
        if (validateSiteInformation()) {
            $("#collapseTwo").collapse("hide");
            $("#collapseThree").collapse("show");
            $("#siteInfoEditBtn").show();
        }

    });


    $("#siteToDischBtn").click(function (evt) {
        evt.preventDefault();

        $("#collapseTwo").collapse("hide");
        $("#collapseOne").collapse("show");
        $("#siteInfoEditBtn").show();

    });
})();
var map,
    locator;
require([
    "esri/map", "esri/geometry/webMercatorUtils", "esri/tasks/locator", "esri/layers/OpenStreetMapLayer", "dojo/dom", "dijit/registry", "dojo/parser", "dojo/_base/array",
    "esri/symbols/SimpleMarkerSymbol", "esri/symbols/SimpleLineSymbol", "esri/Color", "dojo/number", "dojo/json", "esri/graphic",
    "esri/symbols/Font", "esri/symbols/TextSymbol", "esri/geometry/Extent", "esri/SpatialReference", "dojo/domReady!"
], function (Map, webMercatorUtils, Locator, OpenStreetMapLayer, dom, registry, parser, arrayUtils,
             SimpleMarkerSymbol, SimpleLineSymbol, Color, number, JSON, Graphic, Font, TextSymbol, Extent, SpatialReference) {
    parser.parse();
    map = new Map("map", {
        basemap: "streets",
        center: [-89.574, 44.532],
        zoom: 10
    });
    locator = new Locator("https://geocode.arcgis.com/arcgis/rest/services/World/GeocodeServer");

    dojo.connect(dojo.byId("siteLocate"), "onclick", locate);

    openStreetMapLayer = new OpenStreetMapLayer();
    map.addLayer(openStreetMapLayer);
    map.on("load", function () {
        //after map loads, connect to listen to mouse move & drag events
        map.on("click", showCoordinates);
        //map.on("mouse-drag", showCoordinates);
    });

    function showCoordinates(evt) {
        //the map is in web mercator but display coordinates in geographic (lat, long)
        locator.locationToAddress(webMercatorUtils.webMercatorToGeographic(evt.mapPoint), 100);
        var mp = webMercatorUtils.webMercatorToGeographic(evt.mapPoint);

        //display mouse coordinates
        dom.byId("x-info").innerHTML = mp.x.toFixed(3);
        dom.byId("y-info").innerHTML = mp.y.toFixed(3);
        dom.byId("siteLongitude").value = mp.x.toFixed(3);
        dom.byId("siteLatitude").value = mp.y.toFixed(3);
    }

    function locate() {
        var addr = dom.byId("siteAddress").value;
        var city = dom.byId("siteCity").value;
        var zipcode = dom.byId("siteZipcode").value;
        var state = dom.byId("siteState").value;
        var completeAddress = addr + " " + city + " " + zipcode + " " + state;
        var address = {
            SingleLine: completeAddress
        };
        var options = {
            address: address,
            outFields: ["*"]
        };
        //optionally return the out fields if you need to calculate the extent of the geocoded point
        locator.addressToLocations(options);
    }

    //Draw and zoom to the result when the geocoding is complete
    locator.on("address-to-locations-complete", function (evt) {
        map.graphics.clear();

        arrayUtils.forEach(evt.addresses, function (geocodeResult, index) {
            //create a random color for the text and marker symbol
            var r = Math.floor(Math.random() * 250);
            var g = Math.floor(Math.random() * 100);
            var b = Math.floor(Math.random() * 100);

            var symbol = new SimpleMarkerSymbol(
                SimpleMarkerSymbol.STYLE_CIRCLE,
                20,
                new SimpleLineSymbol(
                    SimpleLineSymbol.STYLE_SOLID,
                    new Color([r, g, b, 0.5]),
                    10
                ), new Color([r, g, b, 0.9]));
            var pointMeters = webMercatorUtils.geographicToWebMercator(geocodeResult.location);
            var locationGraphic = new Graphic(pointMeters, symbol);

            var font = new Font().setSize("12pt").setWeight(Font.WEIGHT_BOLD);
            var textSymbol = new TextSymbol(
                (index + 1) + ".) " + geocodeResult.address,
                font,
                new Color([r, g, b, 0.8])
            ).setOffset(5, 15);
            //add the location graphic and text with the address to the map
            map.graphics.add(locationGraphic);
            map.graphics.add(new Graphic(pointMeters, textSymbol));

        });
        var ptAttr = evt.addresses[0].attributes;
        var minx = parseFloat(ptAttr.Xmin);
        var maxx = parseFloat(ptAttr.Xmax);
        var miny = parseFloat(ptAttr.Ymin);
        var maxy = parseFloat(ptAttr.Ymax);

        var esriExtent = new Extent(minx, miny, maxx, maxy, new SpatialReference({
            wkid: 4326
        }));
        map.setExtent(webMercatorUtils.geographicToWebMercator(esriExtent));

    });


    locator.on("location-to-address-complete", function (evt) {
        if (evt.address.address) {
            var address = evt.address.address;
            dom.byId("siteAddress").value = address.Address;
            dom.byId("siteCity").value = address.City;
            if (siteState === "Wisconsin") {
                dom.byId("siteState").value = "WI";
            }
            dom.byId("siteCounty").value = address.Subregion;
            dom.byId("siteZipcode").value = address.Postal;
        }
    });

});