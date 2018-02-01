(function () {
    var contextPath = $("#context").text();
    var xvalue = $("#x-info").text();
    var yvalue = $("#y-info").text();

    $("#wtmx").val(xvalue);
    $("#wtmy").val(yvalue);

    var reportId = $("#reportId").text();



    var validateSiteInformation = function () {
        var isValid1 = false;
        var isValid2 = false;
        var isValid3 = false;

        if ($("#sit-name").val() === "") {
            $("#site-name-div").addClass("has-error");
            $(".site-name-error").show();
            isValid1 = false;
        } else {
            $("#site-name-div").removeClass("has-error");
            $(".site-name-error").hide();
            isValid1 = true;
        }
        if ($("#site-longitude").val() === "") {
            $("#site-longitude-div").addClass("has-error");
            $(".site-lon-error").show();
            isValid2 = false;
        } else {
            $("#site-longitude").removeClass("has-error");
            $(".site-lon-error").hide();
            isValid2 = true;
        }

        if ($("#site-latitude").val() === "") {
            $("#site-latitude-div").addClass("has-error");
            $(".site-lat-error").show();
            isValid3 = false;
        } else {
            $("#site-latitude-div").removeClass("has-error");
            $(".site-lat-error").hide();
            isValid3 = true;
        }
        if (isValid1 && isValid2 && isValid3) {
            return true;
        } else {
            return false;
        }
    }


    $("#site-name").autocomplete({
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
            $("#site-address").val(data.item.address.streetAddress1);
            $("#site-city").val(data.item.address.city);
            $("#site-county").val(data.item.address.county);
            $("#site-state").val(data.item.address.state);
            $("#site-zipcode").val(data.item.address.zipcode);
            var completeAddr = data.item.address.streetAddress1 + " " +
                data.item.address.city + " " +
                data.item.address.state + " " +
                data.item.address.zipcode;
            $("#site-complete-addr").val(completeAddr);
            $("#site-locate").click();
        }
    });

    $("#site-to-resp-party-btn").click(function (evt) {
        evt.preventDefault();
        if (validateSiteInformation()) {
            $("#collapse-two").collapse("hide");
            $("#collapse-three").collapse("show");
            $("#site-info-edit-btn").show();
        }

    });


    $("#site-to-disch-btn").click(function (evt) {
        evt.preventDefault();

        $("#collapse-two").collapse("hide");
        $("#collapse-one").collapse("show");
        $("#site-info-edit-btn").show();

    });


    var buildJsonObject = function () {
        var report;
        var checkSelector = $('input[name=hzrd-type-radio]:checked');
        var reportType = checkSelector.val();
        var reportTypeText = '';
        if (reportType === 'other') {
            reportTypeText = reportType + '-' + $("#hazard-type-text-area").text();
        } else {
            reportTypeText = reportType;
        }

        var reporterFname = $("#reporter-fname").val();
        var reporterLname = $("#reporter-lname").val();
        var reporterEmail = $("#reporter-email").val();
        var reporterCname = $("#reporter-cname").val();
        var reporterPhoneNumber = $("#reporter-phone-number").val();
        var reporterAddress = $("#reporter-address").val();
        var reporterCity = $("#reporter-city").val();
        var reporterState = $("#reporter-state").val();
        var reporterZipcode = $("#reporter-zipcode").val();


        var siteName = $("#site-name").val();
        var siteAddress = $("#site-address").val();
        var siteMunicipality = $("#site-municipality").val();
        var siteCity = $("#site-city").val();
        var siteState = $("#site-state").val();
        var siteZipcode = $("#site-zipcode").val();
        var siteCounty= $("#site-county").val();
        var longitude = $("#site-longitude").val();
        var latitude = $("#site-latitude").val();
        var reporterPersonId = $("#reporter-person-id").text();
        var reporterPersonAddressId = $("#reporter-person-address-id").text();

        var facilityId = $("#site-id").text();
        var facilityAddId = $("#site-address-id").text();
        report = {
            "reportId": reportId,
            "reportType": reportTypeText,
            "reportPersons": [
                {
                    "person": {
                        "personId": reporterPersonId,
                        "firstName": reporterFname,
                        "lastName": reporterLname,
                        "companyName": reporterCname,
                        "email": reporterEmail,
                        "phoneNumber": reporterPhoneNumber,
                        "addresses": [
                            {
                                "addressId": reporterPersonAddressId,
                                "address1": reporterAddress,
                                "city": reporterCity,
                                "state": reporterState,
                                "zipcode": reporterZipcode
                            }
                        ]
                    },
                    "personType": "reporter"
                }],
            "facility": {
                "facilityId": facilityId,
                "facilityName": siteName,
                "addresses": [
                    {
                        "addressId": facilityAddId,
                        "address1": siteAddress,
                        "address2": '',
                        "city": siteCity,
                        "county": siteCounty,
                        "municipality": siteMunicipality,
                        "latitude": latitude,
                        "longitude": longitude,
                        "zipcode": siteZipcode,
                        "state": siteState
                    }
                ]
            }

        };
        return report;
    };
    //save nfdetails to the database using jquery call.
    $("#nfsite-info-save").click(function (evt) {
        evt.preventDefault();
        if (validateSiteInformation()) {
            var jsonObject = buildJsonObject();
            //sending the data to /
            var token = $("meta[name='_csrf']").attr("content");
            $.ajax({
                type: 'post',
                contentType: 'application/json',
                url: contextPath + '/eforms/save',
                data: JSON.stringify(jsonObject),
                dataType: 'json',
                headers : {
                    'X-CSRF-TOKEN' : token
                },
                success: function(){
                    alert("success");
                    $(location).attr('href', contextPath + '/')
                },
                error: function(){
                    alert("error");
                }
            });
        }
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

    dojo.connect(dojo.byId("site-locate"), "onclick", locate);

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
        dom.byId("site-longitude").value = mp.x.toFixed(3);
        dom.byId("site-latitude").value = mp.y.toFixed(3);
    }

    function locate() {
        var addr = dom.byId("site-address").value;
        var city = dom.byId("site-city").value;
        var zipcode = dom.byId("site-zipcode").value;
        var state = dom.byId("site-state").value;
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
            dom.byId("site-address").value = address.Address;
            dom.byId("site-city").value = address.City;
            if (address.Region === "Wisconsin") {
                dom.byId("site-state").value = "WI";
            }
            dom.byId("site-county").value = address.Subregion;
            dom.byId("site-zipcode").value = address.Postal;
        }
    });

});