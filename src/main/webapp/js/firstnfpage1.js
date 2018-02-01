(function () {

    $("#forms-directory").click();
    $("#error-message").empty();
    $("#error-message").hide();
    $("#details-edit-btn").hide();
    $("#site-info-edit-btn").hide();
    $("#resp-party-edit-btn").hide();
    $("#hzrd-sub-edit-btn").hide();
    $("#impacts-edit-btn").hide();

    $("#source-cause-edit-btn").hide();

    $("#cancel").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:7001/rresubmittal/";
    })
    var buttonId = ""
    var buttonClick = function () {

    };


    $(document).on('click', '.addmore', function (e) {
        e.preventDefault();
        var index = this.id.charAt(8);
        var addTo = "#responsibleParty" + index;
        var addRemove = "#button" + (index);
        var index = parseInt(index) + 1;
        var newInput = '<div id="responsibleParty' + index + '" class="elmt">' +
            '<div class="form-group row">' +
            '<div class="col-xs-6">' +
            '<span style="display: none" id="rparty-person-id' + index + '"></span>' +
            '<label for="rparty-fname' + index + '" >First name:</label> <input type="text"' +
            'class="form-control input-sm" id="rparty-fname' + index + '" name="fname" placeholder="Please enter the first name"> ' +
            '<span class="fname-rep-by error" style="display:none;">This is a required field.</span>' +
            '</div>' +
            '<div class="col-xs-6">' +
            '<label for="rparty-lname' + index + '">Last name:</label> <input type="text"' +
            'name="lname" class="form-control input-sm" id="rparty-lname' + index + '" placeholder="Please enter the last name"> ' +
            '<span class="lname-rep-by error" style="display:none;">This is a required field.</span>' +
            '</div>' +
            '</div>' +
            '<div class="form-group row"> ' +
            '<div class="col-xs-6"> ' +
            '<label for="rparty-cname' + index + '">Company</label> <input type="text"  ' +
            'class="form-control input-sm" id="rparty-cname' + index + '" name="companyName" placeholder="Please enter the company name"> ' +
            '</div> ' +
            '<div class="col-xs-3"> ' +
            '<label for="rparty-phone-number' + index + '">Phone Number</label> <input type="text" ' +
            'class="form-control input-sm" id="rparty-phone-number' + index + '" name="phoneNumber" placeholder="Please enter valid phone number"> ' +
            '</div>  ' +
            '<div class="col-xs-3">  ' +
            '<label for="rparty-email' + index + '">Email</label> <input type="email" ' +
            'class="form-control input-sm" id="rparty-email' + index + '" name="email" placeholder="Please enter valid email address"> ' +
            '</div> ' +
            '</div> ' +
            '<div class="form-group row"> ' +
            '<div class="col-xs-6"> ' +
            '<span style="display: none" id="rparty-person-addressid' + index + '"></span>' +
            '<label for="rparty-address' + index + '">Address:</label> <input type="text" ' +
            'class="form-control input-sm" onfocus="geolocate()" id="rparty-address' + index + '" name="address" placeholder="Please enter the address" onfocus="geolocate()"> ' +
            '</div>  ' +
            '<div class="col-xs-3">  ' +
            '<label for="rparty-city' + index + '">City:</label> <input type="text" ' +
            'class="form-control field input-sm" id="rparty-city' + index + '" name="city" readonly="readonly"> ' +
            '</div> ' +
            '<div class="col-xs-1"> ' +
            '<label for="rparty-state' + index + '">State:</label> <input type="text" ' +
            'class="form-control field input-sm" id="rparty-state' + index + '" name="state" readonly="readonly"> ' +
            '</div> ' +
            '<div class="col-xs-2"> ' +
            '<label for="rparty-zipcode' + index + '">ZIP code:</label> <input type="text" ' +
            'class="form-control field input-sm" id="rparty-zipcode' + index + '" name="zipcode" readonly="readonly">' +
            '</div> ' +
            '</div>' +
            '<div class="form-group">' +
            '<div id="button' + index + '">' +
            '<button id="add-more' + index + '"  class="btn btn-xs btn-primary addmore">Add More</button>' +
            '</div>' +
            '</div>' +
            '</div>';
        //	var newInput = ""

        var removeBtn = '<button id="remove' + (index - 1) + '" class="btn btn-xs btn-danger remove-me" >Remove</button>';
        $(addTo).after(newInput);
        $(addRemove).empty();
        $(addRemove).append(removeBtn);
        assignAutoCompl(index);

    });


    $(document).on('click', '.remove-me', function (e) {
        e.preventDefault();
        var fieldNum = this.id.charAt(this.id.length - 1);
        if(fieldNum == 0){
            $("#rparty-fname0").val("");
            $("#rparty-lname0").val("");
            $("#rparty-cname0").val("");
            $("#rparty-phone-number0").val("");
            $("#rparty-email0").val("");
            $("#rparty-address0").val("");
            $("#rparty-city0").val("");
            $("#rparty-state0").val("");
            $("#rparty-zipcode0").val("");
        }else {
            var fieldID = "#responsibleParty" + fieldNum;
            $(this).remove();
            $(fieldID).remove();
        }

    });


    $("#envImpactList").selectable({
        stop: function () {
            var result = $("#impact-select-result").empty();
            $(".ui-selected", this).each(function () {
                var index = $(".selectable li").index(this);
                result.append(index + 1);
                $("#envImpactMinusButton").css("display", "");
                $("#envImpactMinusButton").show();
            });
        }
    });


    $(document).on('click', '#envImpactMinusButton', function () {
        var result = $("#impact-select-result").text();
        $("#envImpactList #" + result).remove();
    })

    $(document).on('click', '#envImpactPlusButton', function () {
        $("#error-message").empty();
        $("#error-message").css("display", "none");
        var selectedValue = $("#envImpacts").find("option:selected").text();
        if ($('input[name=chkimpact-input]:checked').length <= 0) {
            $("#error-message").css("display", "");
            $("#error-message").append("Please select 'known' or 'potential' for the selected element");
            $("#error-message").show();
        } else {
            var index = $("#envImpactList").children().length + 1;
            var checkedImpact = $('input[name=chkimpact-input]:checked').val();
            var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it." id="' + index + '">' + checkedImpact + '-' + selectedValue + '</li>';
            $("#envImpactList").append(element);
        }
    });


    $("#datepickerui").datepicker();
    $("#notificationForm").validate({
        rules: {
            phoneNumber: {
                required: false,
                phoneUS: true
            },
            email: {
                required: false
            },
            zipcode: {
                required: false,
                zipcodeUS: true
            }
        }
    });


})();


var placeSearch,
    autocomplete,
    _autocomplete,
    autocomplete_rp1,
    autocomplete_siteAddress;

var componentForm = {
    street_number: 'short_name',
    route: 'long_name',
    locality: 'long_name',
    administrative_area_level_1: 'short_name',
    postal_code: 'short_name'
};

function initAutoComplete() {
    // Create the autocomplete object, restricting the search to geographical
    // location types.
    autocomplete = new google.maps.places.Autocomplete(
        /** @type {!HTMLInputElement} */ (document.getElementById('reporter-address')),
        {
            types: ['geocode']
        });

    autocomplete_rp1 = new google.maps.places.Autocomplete((document.getElementsByClassName('rparty-autocomplete')[0]), {
        types: ['geocode']
    });


    autocomplete_siteAddress = new google.maps.places.Autocomplete((document.getElementById(('site-address'))), {
        types: ['geocode']
    });


    // When the user selects an address from the dropdown, populate the address
    // fields in the form.
    autocomplete.addListener('place_changed', fillInAddress);
    autocomplete_rp1.addListener('place_changed', fillInAddress_rp)
    autocomplete_siteAddress.addListener('place_changed', fillInSiteAddress)
}

// $("body").on("keydown.autocomplete", '.rparty-autocomplete', function() {
//     var id = this.id;
//     autocomplete_rp1.addListener('place_changed', fillInAddress_rp(id));
// });
function assignAutoCompl(index) {

    // _autocomplete.push(new google.maps.places.Autocomplete((document.getElementById('rparty-address' + _id)), {
    //     types: ['geocode']
    // }));
    var input = document.getElementById('rparty-address' + index);
    _autocomplete = new google.maps.places.Autocomplete(input, {
        types: ['geocode']
    });


    function fillinRPAddress(index) {
            // Get the place details from the autocomplete object.
            // alert(this.getAttribute('id'));

            var place = _autocomplete.getPlace();
            for (var component in componentForm) {
                if ((component != "street_number") && (component != "route")) {
                    if(component === 'locality') {
                        document.getElementById('rparty-city' + index).value = '';
                        document.getElementById('rparty-city' + index).disabled = false;
                    }else if(component === 'administrative_area_level_1'){
                        document.getElementById('rparty-state' + index).value = '';
                        document.getElementById('rparty-state' + index).disabled = false;
                    }else  if(component === 'postal_code'){
                        document.getElementById('rparty-zipcode'+ index).value = '';
                        document.getElementById('rparty-zipcode'+ index).disabled = false;
                    }
                }
            }

            // Get each component of the address from the place details
            // and fill the corresponding field on the form.
            var streetAddress = "";
            if (place != undefined)
                for (var i = 0; i < place.address_components.length; i++) {
                    var addressType = place.address_components[i].types[0];

                    if (componentForm[addressType]) {
                        var val = place.address_components[i][componentForm[addressType]];
                        if ((addressType === 'locality')) {
                            document.getElementById('rparty-city' + index).value = val;
                        } else if ((addressType === 'administrative_area_level_1')) {
                            document.getElementById('rparty-state' + index).value = val;
                        } else if ((addressType === 'postal_code')) {
                            document.getElementById('rparty-zipcode' + index).value = val;
                        } else {
                            streetAddress = streetAddress + " " + val;
                            document.getElementById('rparty-address' + index).value = streetAddress;
                        }
                    }
                }


    }

    google.maps.event.addListener(_autocomplete, 'place_changed', function () {
        fillinRPAddress(index);
    });
}




function fillInAddress() {
    // Get the place details from the autocomplete object.
    var place = autocomplete.getPlace();

    for (var component in componentForm) {
        if ((component != "street_number") && (component != "route")) {
            if(component === 'locality') {
                document.getElementById('reporter-city').value = '';
                document.getElementById('reporter-city').disabled = false;
            }else if(component === 'administrative_area_level_1'){
                document.getElementById('reporter-state').value = '';
                document.getElementById('reporter-state').disabled = false;
            }else  if(component === 'postal_code'){
                document.getElementById('reporter-zipcode').value = '';
                document.getElementById('reporter-zipcode').disabled = false;
            }
        }
    }

    // Get each component of the address from the place details
    // and fill the corresponding field on the form.
    var streetAddress = "";
    for (var i = 0; i < place.address_components.length; i++) {
        var addressType = place.address_components[i].types[0];

        if (componentForm[addressType]) {
            var val = place.address_components[i][componentForm[addressType]];
            // if ((addressType != "street_number") && (addressType != "route")) {
            //     document.getElementById(addressType).value = val;
            // } else {
            //     streetAddress = streetAddress + " " + val;
            //     document.getElementById('autocomplete').value = streetAddress;
            // }

            if ((addressType === 'locality')) {
                document.getElementById('reporter-city').value = val;
            } else if ((addressType === 'administrative_area_level_1')) {
                document.getElementById('reporter-state').value = val;
            } else if ((addressType === 'postal_code')) {
                document.getElementById('reporter-zipcode').value = val;
            } else {
                streetAddress = streetAddress + " " + val;
                document.getElementById('reporter-address').value = streetAddress;
            }
        }
    }
}

function fillInAddress_rp() {


    // Get the place details from the autocomplete object.
    // alert(this.getAttribute('id'));
    var place = autocomplete_rp1.getPlace();
    for (var component in componentForm) {
        if ((component != "street_number") && (component != "route")) {
            if(component === 'locality') {
                document.getElementById('rparty-city0').value = '';
                document.getElementById('rparty-city0').disabled = false;
            }else if(component === 'administrative_area_level_1'){
                document.getElementById('rparty-state0').value = '';
                document.getElementById('rparty-state0').disabled = false;
            }else  if(component === 'postal_code'){
                document.getElementById('rparty-zipcode0').value = '';
                document.getElementById('rparty-zipcode0').disabled = false;
            }
        }
    }

    // Get each component of the address from the place details
    // and fill the corresponding field on the form.
    var streetAddress = "";
    for (var i = 0; i < place.address_components.length; i++) {
        var addressType = place.address_components[i].types[0];

        if (componentForm[addressType]) {
            var val = place.address_components[i][componentForm[addressType]];
            if ((addressType === 'locality')) {
                document.getElementById('rparty-city0').value = val;
            } else if ((addressType === 'administrative_area_level_1')) {
                document.getElementById('rparty-state0').value = val;
            } else if ((addressType === 'postal_code')) {
                document.getElementById('rparty-zipcode0').value = val;
            } else {
                streetAddress = streetAddress + " " + val;
                document.getElementById('rparty-address0').value = streetAddress;
            }
        }
    }
}
function fillInSiteAddress() {


    // Get the place details from the autocomplete object.
    // alert(this.getAttribute('id'));
    var place = autocomplete_siteAddress.getPlace();
    for (var component in componentForm) {
        if ((component != "street_number") && (component != "route")) {
            if(component === 'locality') {
                document.getElementById('site-city').value = '';
                document.getElementById('site-city').disabled = false;
            }else if(component === 'administrative_area_level_1'){
                document.getElementById('site-state').value = '';
                document.getElementById('site-state').disabled = false;
            }else  if(component === 'postal_code'){
                document.getElementById('site-zipcode').value = '';
                document.getElementById('site-zipcode').disabled = false;
            }
        }
    }

    // Get each component of the address from the place details
    // and fill the corresponding field on the form.
    var streetAddress = "";
    for (var i = 0; i < place.address_components.length; i++) {
        var addressType = place.address_components[i].types[0];

        if (componentForm[addressType]) {
            var val = place.address_components[i][componentForm[addressType]];
            if ((addressType === 'locality')) {
                document.getElementById('site-city').value = val;
            } else if ((addressType === 'administrative_area_level_1')) {
                document.getElementById('site-state').value = val;
            } else if ((addressType === 'postal_code')) {
                document.getElementById('site-zipcode').value = val;
            } else {
                streetAddress = streetAddress + " " + val;
                document.getElementById('site-address').value = streetAddress;
            }
        }
    }
}

// Bias the autocomplete object to the user's geographical location,
// as supplied by the browser's 'navigator.geolocation' object.
function geolocate() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var geolocation = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            var circle = new google.maps.Circle({
                center: geolocation,
                radius: position.coords.accuracy
            });
            autocomplete.setBounds(circle.getBounds());
            autocomplete_siteAddress.setBounds(circle.getBounds());
            autocomplete_rp1.setBounds(circle.getBounds());
            _autocomplete.setBounds(circle.getBounds());
        });
    }
}


// Note: This example requires that you consent to location sharing when
// prompted by your browser. If you see the error "The Geolocation service
// failed.", it means you probably did not give permission for the browser to
// locate you.
var map,
    infoWindow;

function initMap() {
    var pos = {
        lat: -25.363,
        lng: 131.044
    };
    map = new google.maps.Map(document.getElementById('map'), {
        center: {
            lat: -34.397,
            lng: 150.644
        },
        zoom: 6
    });
    infoWindow = new google.maps.InfoWindow;

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            infoWindow.setContent(pos.lat + " " + pos.lng);
            infoWindow.open(map);
            map.setCenter(pos);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }


    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 4,
        center: pos
    });

    var marker = new google.maps.Marker({
        position: pos,
        map: map,
        title: 'Click to zoom'
    });
    //Add listener
    map.addListener("click", function (event) {
        var latitude = event.latLng.lat();
        var longitude = event.latLng.lng();
        console.log(latitude + ', ' + longitude);
        pos = {
            lat: latitude,
            lng: longitude
        };
        infoWindow.setPosition(pos);
        infoWindow.setContent('Location found.');
        infoWindow.setContent(latitude + " " + longitude);
        radius = new google.maps.Circle({
            map: map,
            radius: 100,
            center: event.latLng,
            fillColor: '#777',
            fillOpacity: 0.1,
            strokeColor: '#AA0000',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            draggable: true, // Dragable
            editable: true // Resizable
        });

        // Center of map
        map.panTo(new google.maps.LatLng(latitude, longitude));

    }); //end addListener
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
    infoWindow.open(map);
}

function initialize() {
    //	   initMap();
    initAutoComplete();
}

function printpage() {
    window.print();
}