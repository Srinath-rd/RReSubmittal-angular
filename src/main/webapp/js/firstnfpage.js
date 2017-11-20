(function () {
    $("#hazardTypeTextArea").hide();
    $("#errorMessage").empty();
    $("#errorMessage").hide();
    $("#otherHazardType").click(function () {
        $("hazardTypeTextArea").css("display", "");
        $("#hazardTypeTextArea").show();

    })

    $(".generichazardType").click(function () {
        $("hazardTypeTextArea").css("display", "none");
        $("#hazardTypeTextArea").hide();

    })


    $("#cancel").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:8080/RReSubmittal/";
    })

    $("#next1").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:8080/RReSubmittal/wizardform1";
    })

    $("#next2").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:8080/RReSubmittal/wizardform2";
    })

    $("#next3").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:8080/RReSubmittal/wizardform3";
    })
    $("#next4").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:8080/RReSubmittal/wizardform4";
    })
    $("#next5").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:8080/RReSubmittal/wizardform5";
    })
    $("#previous1").click(function (e) {
        e.preventDefault();
        window.location.href = "http://localhost:8080/RReSubmittal/list-todos";
    })

    $(document).on('click', '.addmore', function (e) {
        e.preventDefault();
        var next = this.id.charAt(8);
        var addTo = "#responsibleParty" + next;
        var addRemove = "#button" + (next);
        next = parseInt(next) + 1;
        var newInput = '<div id="responsibleParty' + next + '">' +
            '<div class="form-group row">' +
            '<div class="col-xs-6">' +
            '<label for="email">First name:</label> <input type="text"' +
            'class="form-control" id="fname" name="fname">' +
            '</div>' +
            '<div class="col-xs-6">' +
            '<label for="email">Last name:</label> <input type="text"' +
            'name="lname" class="form-control" id="lname">' +
            '</div>' +
            '</div>' +
            '<div class="form-group row"> ' +
            '<div class="col-xs-6"> ' +
            '<label for="pwd">Company</label> <input type="text"  ' +
            'class="form-control" id="cname" name="companyName"> ' +
            '</div> ' +
            '<div class="col-xs-3"> ' +
            '<label for="pwd">Phone Number</label> <input type="text" ' +
            'class="form-control" id="phoneNumber" name="phoneNumber"> ' +
            '</div>  ' +
            '<div class="col-xs-3">  ' +
            '<label for="email">Email</label> <input type="email" ' +
            'class="form-control" id="email" name="email"> ' +
            '</div> ' +
            '</div> ' +
            '<div class="form-group row"> ' +
            '<div class="col-xs-6"> ' +
            '<label for="email">Address:</label> <input type="text" ' +
            'class="form-control" id="address" name="address"> ' +
            '</div>  ' +
            '<div class="col-xs-3">  ' +
            '<label for="email">City:</label> <input type="text" ' +
            'class="form-control" id="address" name="address"> ' +
            '</div> ' +
            '<div class="col-xs-1"> ' +
            '<label for="email">State:</label> <input type="text" ' +
            'class="form-control" id="address" name="address"> ' +
            '</div> ' +
            '<div class="col-xs-2"> ' +
            '<label for="email">ZIP code:</label> <input type="text" ' +
            'class="form-control" id="address" name="address">' +
            '</div> ' +
            '</div>' +
            '<div class="form-group">' +
            '<div id="button' + next + '">' +
            '<button id="add-more' + next + '"  class="btn btn-primary addmore">Add More</button>' +
            '</div>' +
            '</div>' +
            '</div>';
        var removeBtn = '<button id="remove' + (next - 1) + '" class="btn btn-danger remove-me" >Remove</button>';
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


    $("#hazardSelList").selectable({
        stop: function () {
            var result = $("#select-result").empty();
            $(".ui-selected", this).each(function () {
                var index = $(".selectable li").index(this);
                result.append(index + 1);
                $("#hazardMinusButton").css("display", "");
                $("#hazardMinusButton").show();
            });
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

    $(document).on('click', '#hazardMinusButton', function () {
        var result = $("#select-result").text();
        $("#hazardSelList #" + result).remove();
    })

    $(document).on('click', '#hazardPlusButton', function () {
        var selectedValue = $("#hazardSubstances").find("option:selected").text();
        var index = $("#hazardSelList").children().length + 1;
        var element = '<li class="ui-widget-content" id="' + index + '">' + selectedValue + '</li>';
        $("#hazardSelList").append(element);
    })

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
            var element = '<li class="ui-widget-content" id="' + index + '">' + checkedImpact + '-' + selectedValue + '</li>';
            $("#envImpactList").append(element);
        }
    })

    $("#datepickerui").datepicker();
    $("#notificationForm").validate({
        rules: {
            phoneNumber: {
                required: true,
                phoneUS: true
            }
        }
    });

})();


var placeSearch,
    autocomplete;
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

    // When the user selects an address from the dropdown, populate the address
    // fields in the form.
    autocomplete.addListener('place_changed', fillInAddress);
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