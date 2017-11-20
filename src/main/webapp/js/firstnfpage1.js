(function () {

    $("#errorMessage").empty();
    $("#errorMessage").hide();
    $("#detailsEditBtn").hide();
    $("#siteInfoEditBtn").hide();
    $("#respPartyEditBtn").hide();
    $("#hzrdSubEditBtn").hide();
    $("#impactsEditBtn").hide();
    $("#sourceCauseEditBtn").hide();

    $("#cancel").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:7001/RReSubmittal/";
    })
    var buttonId = ""
    var buttonClick = function () {

    };


    $(document).on('click', '.addmore', function (e) {
        e.preventDefault();
        var next = this.id.charAt(8);
        var addTo = "#responsibleParty" + next;
        var addRemove = "#button" + (next);
        next = parseInt(next) + 1;
        var newInput = '<div id="responsibleParty' + next + '">' +
            '<div class="form-group row">' +
            '<div class="col-xs-6" id="fnameGrp">' +
            '<label for="fname" class="control-label">First name:</label> <input type="text"' +
            'class="form-control input-sm" id="fname" name="fname" placeholder="Please enter the first name"> <span class="fnameRepBy error" style="display:none;">This is a required field.</span>' +
            '</div>' +
            '<div class="col-xs-6" id="lnameGrp">' +
            '<label for="lname">Last name:</label> <input type="text"' +
            'name="lname" class="form-control input-sm" id="lname" placeholder="Please enter the last name"> <span class="lnameRepBy error" style="display:none;">This is a required field.</span>' +
            '</div>' +
            '</div>' +
            '<div class="form-group row"> ' +
            '<div class="col-xs-6"> ' +
            '<label for="companyName">Company</label> <input type="text"  ' +
            'class="form-control input-sm" id="cname" name="companyName" placeholder="Please enter the company name"> ' +
            '</div> ' +
            '<div class="col-xs-3"> ' +
            '<label for="phoneNumber">Phone Number</label> <input type="text" ' +
            'class="form-control input-sm" id="phoneNumber" name="phoneNumber" placeholder="Please enter valid phone number"> ' +
            '</div>  ' +
            '<div class="col-xs-3">  ' +
            '<label for="email">Email</label> <input type="email" ' +
            'class="form-control input-sm" id="email" name="email" placeholder="Please enter valid email address"> ' +
            '</div> ' +
            '</div> ' +
            '<div class="form-group row"> ' +
            '<div class="col-xs-6"> ' +
            '<label for="address">Address:</label> <input type="text" ' +
            'class="form-control input-sm" onfocus="geolocate()" id="autocomplete_rp' + next + '" name="address" placeholder="Please enter the address"> ' +
            '</div>  ' +
            '<div class="col-xs-3">  ' +
            '<label for="city">City:</label> <input type="text" ' +
            'class="form-control field input-sm" id="city_rp' + next + '" name="city" readonly="readonly"> ' +
            '</div> ' +
            '<div class="col-xs-1"> ' +
            '<label for="state">State:</label> <input type="text" ' +
            'class="form-control field input-sm" id="state_rp' + next + '" name="state" readonly="readonly"> ' +
            '</div> ' +
            '<div class="col-xs-2"> ' +
            '<label for="zipcode">ZIP code:</label> <input type="text" ' +
            'class="form-control field input-sm" id="zipcode+rp' + next + '" name="zipcode" readonly="readonly">' +
            '</div> ' +
            '</div>' +
            '<div class="form-group">' +
            '<div id="button' + next + '">' +
            '<button id="add-more' + next + '"  class="btn-md btn-primary addmore">Add More</button>' +
            '</div>' +
            '</div>' +
            '</div>';
        //	var newInput = ""
        var removeBtn = '<button id="remove' + (next - 1) + '" class="btn-md btn-danger remove-me" >Remove</button>';
        $(addTo).after(newInput);
        $(addRemove).empty();
        $(addRemove).append(removeBtn);


    });
    $(document).on('click', '.remove-me', function (e) {
        e.preventDefault();
        var fieldNum = this.id.charAt(this.id.length - 1);
        var fieldID = "#responsibleParty" + fieldNum;
        $(this).remove();
        $(fieldID).remove();
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
        $("#errorMessage").empty();
        $("#errorMessage").css("display", "none");
        var selectedValue = $("#envImpacts").find("option:selected").text();
        if ($('input[name=chkimpact-input]:checked').length <= 0) {
            $("#errorMessage").css("display", "");
            $("#errorMessage").append("Please select 'known' or 'potential' for the selected element");
            $("#errorMessage").show();
        } else {
            var index = $("#envImpactList").children().length + 1;
            var checkedImpact = $('input[name=chkimpact-input]:checked').val();
            var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it." id="' + index + '">' + checkedImpact + '-' + selectedValue + '</li>';
            $("#envImpactList").append(element);
        }
    })

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
    autocomplete_rp1;

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
        /** @type {!HTMLInputElement} */ (document.getElementById('autocomplete')),
        {
            types: ['geocode']
        });

    autocomplete_rp1 = new google.maps.places.Autocomplete((document.getElementById('autocomplete_rp1')), {
        types: ['geocode']
    });


    // When the user selects an address from the dropdown, populate the address
    // fields in the form.
    autocomplete.addListener('place_changed', fillInAddress);
    autocomplete_rp1.addListener('place_changed', fillInAddress_rp)
}

function fillInAddress() {
    // Get the place details from the autocomplete object.
    var place = autocomplete.getPlace();

    for (var component in componentForm) {
        if ((component != "street_number") && (component != "route")) {
            document.getElementById(component).value = '';
            document.getElementById(component).disabled = false;
        }
    }

    // Get each component of the address from the place details
    // and fill the corresponding field on the form.
    var streetAddress = "";
    for (var i = 0; i < place.address_components.length; i++) {
        var addressType = place.address_components[i].types[0];

        if (componentForm[addressType]) {
            var val = place.address_components[i][componentForm[addressType]];
            if ((addressType != "street_number") && (addressType != "route")) {
                document.getElementById(addressType).value = val;
            } else {
                streetAddress = streetAddress + " " + val;
                document.getElementById('autocomplete').value = streetAddress;
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
            document.getElementById(component).value = '';
            document.getElementById(component).disabled = false;
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
                document.getElementById('city_rp1').value = val;
            } else if ((addressType === 'administrative_area_level_1')) {
                document.getElementById('state_rp1').value = val;
            } else if ((addressType === 'postal_code')) {
                document.getElementById('zipcode_rp1').value = val;
            } else {
                streetAddress = streetAddress + " " + val;
                document.getElementById('autocomplete_rp1').value = streetAddress;
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