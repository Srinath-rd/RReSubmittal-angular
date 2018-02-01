(function () {
    var contextPath = $("#context").text();
    var reportId = $("#reportId").text();
    var userFirstName = $("#userFirstname").text();
    var userLastName = $("#userLastname").text();
    var userEmail = $("#userEmail").text();

    if (reportId != null && reportId != undefined && reportId != '') {
        // $.getJSON("users/" + username + "/applications/pending", function (data) {
        //
        // })

        $.get('eforms/' + reportId, function (data) {
            var reportType = data.reportType;
            if (reportType === 'drycleaner') {
                $("#dry-cleaner").prop("checked", true);
            } else if (reportType === 'aboveground') {
                $("#above-ground-petrol").prop("checked", true);

            } else if (reportType === 'underground') {
                $("#underGround").prop("checked", true);

            } else {
                reportType = 'other';
                var otherText = reportType.split('-')[1];
                $("#other-hazard-type").prop("checked", true);
                $("#hazardTypeTextArea").html(otherText);

            }
            var rpartySize = 0;
            if (data.reportPersons != null || data.reportPersons != undefined) {
                jQuery.each(data.reportPersons, function (index, reportPerson) {

                    if (reportPerson.personType === 'reporter') {
                        if (data.status === 'PENDING') {
                            $("#reporter-person-id").text(reportPerson.person.personId);
                            $("#reporter-person-address-id").text(reportPerson.person.addresses[0].addressId);
                            $("#reporter-fname").val(reportPerson.person.firstName);
                            $("#reporter-lname").val(reportPerson.person.lastName);
                            $("#reporter-cname").val(reportPerson.person.companyName);
                            $("#reporter-phone-number").val(reportPerson.person.phoneNumber);
                            $("#reporter-email").val(reportPerson.person.email);
                            $("#reporter-address").val(reportPerson.person.addresses[0].address1);
                            $("#reporter-city").val(reportPerson.person.addresses[0].city);
                            $("#reporter-state").val(reportPerson.person.addresses[0].state);
                            $("#reporter-zipcode").val(reportPerson.person.addresses[0].zipcode);
                        } else {
                            $("#reporter-person-id").text(reportPerson.person.personId);
                            $("#reporter-person-address-id").text(reportPerson.person.addresses[0].addressId);
                            $("#reporter-fname").text(reportPerson.person.firstName);
                            $("#reporter-lname").text(reportPerson.person.lastName);
                            $("#reporter-cname").text(reportPerson.person.companyName);
                            $("#reporter-phone-number").text(reportPerson.person.phoneNumber);
                            $("#reporter-email").text(reportPerson.person.email);
                            $("#reporter-address").text(reportPerson.person.addresses[0].address1);
                            $("#reporter-city").text(reportPerson.person.addresses[0].city);
                            $("#reporter-state").text(reportPerson.person.addresses[0].state);
                            $("#reporter-zipcode").text(reportPerson.person.addresses[0].zipcode);
                        }
                    } else if (reportPerson.personType === 'responsibleParty') {
                        if (rpartySize > 0) {
                            if (data.status === 'PENDING') {
                                $("#add-more0").click();
                            } else {
                                var addTo = "#responsibleParty" + (rpartySize - 1);
                                var newInput = '<div id="responsibleParty' + index + '" class="elmt">' +
                                    '<div class="form-group row">' +
                                    '<div class="col-xs-6">' +
                                    '<span style="display: none" id="rparty-person-id' + index + '"></span>' +
                                    '<label for="rparty-fname' + index + '" >First name:</label> <span ' +
                                    'class="form-control" id="rparty-fname' + index + '" disabled="true">' + reportPerson.person.firstName + '</span> ' +
                                    '</div>' +
                                    '<div class="col-xs-6">' +
                                    '<label for="rparty-lname' + index + '">Last name:</label> <span ' +
                                    'class="form-control" id="rparty-lname' + index + '" disabled="true">' + reportPerson.person.lastName + '</span> ' +
                                    '</div>' +
                                    '</div>' +
                                    '<div class="form-group row"> ' +
                                    '<div class="col-xs-6"> ' +
                                    '<label for="rparty-cname' + index + '">Company</label> <span ' +
                                    'class="form-control" id="rparty-cname' + index + '" disabled="true">' + reportPerson.person.companyName + '</span> ' +
                                    '</div> ' +
                                    '<div class="col-xs-3"> ' +
                                    '<label for="rparty-phone-number' + index + '">Phone Number</label> <span ' +
                                    'class="form-control" id="rparty-phone-number' + index + '" disabled="true">' + reportPerson.person.phoneNumber + '</span> ' +
                                    '</div>  ' +
                                    '<div class="col-xs-3">  ' +
                                    '<label for="rparty-email' + index + '">Email</label> <span ' +
                                    'class="form-control" id="rparty-email' + index + '" disabled="true">' + reportPerson.person.email + '</span> ' +
                                    '</div> ' +
                                    '</div> ' +
                                    '<div class="form-group row"> ' +
                                    '<div class="col-xs-6"> ' +
                                    '<span style="display: none" id="rparty-person-addressid' + index + '">' + reportPerson.person.addresses[0].addressId + '</span>' +
                                    '<label for="rparty-address' + index + '">Address:</label> <span ' +
                                    'class="form-control" id="rparty-address' + index + '" disabled="true">' + reportPerson.person.addresses[0].address1 + '</span> ' +
                                    '</div>  ' +
                                    '<div class="col-xs-3">  ' +
                                    '<label for="rparty-city' + index + '">City:</label> <span ' +
                                    'class="form-control" id="rparty-city' + index + '" disabled="true">' + reportPerson.person.addresses[0].city + '</span> ' +
                                    '</div> ' +
                                    '<div class="col-xs-1"> ' +
                                    '<label for="rparty-state' + index + '">State:</label> <span ' +
                                    'class="form-control" id="rparty-state' + index + '" disabled="true">' + reportPerson.person.addresses[0].state + '</span> ' +
                                    '</div> ' +
                                    '<div class="col-xs-2"> ' +
                                    '<label for="rparty-zipcode' + index + '">ZIP code:</label> <span ' +
                                    'class="form-control" id="rparty-zipcode' + index + '" disabled="true">' + reportPerson.person.addresses[0].zipcode + '</span>' +
                                    '</div> ' +
                                    '</div>' +
                                    '<div class="form-group">' +
                                    '</div>' +
                                    '</div>';
                                $(addTo).after(newInput);
                                rpartySize = rpartySize + 1;
                            }
                        }
                        if (data.status === 'PENDING') {
                            $("#rparty-person-id" + rpartySize).text(reportPerson.person.personId);
                            $("#rparty-person-address-id" + rpartySize).text(reportPerson.person.addresses[0].addressId);
                            $("#rparty-fname" + rpartySize).val(reportPerson.person.firstName);
                            $("#rparty-lname" + rpartySize).val(reportPerson.person.lastName);
                            $("#rparty-cname" + rpartySize).val(reportPerson.person.companyName);
                            $("#rparty-phone-number" + rpartySize).val(reportPerson.person.phoneNumber);
                            $("#rparty-email" + rpartySize).val(reportPerson.person.email);
                            $("#rparty-address" + rpartySize).val(reportPerson.person.addresses[0].address1);
                            $("#rparty-city" + rpartySize).val(reportPerson.person.addresses[0].city);
                            $("#rparty-state" + rpartySize).val(reportPerson.person.addresses[0].state);
                            $("#rparty-zipcode" + rpartySize).val(reportPerson.person.addresses[0].zipcode);
                            rpartySize = rpartySize + 1;
                        } else {
                            $("#rparty-person-id" + rpartySize).text(reportPerson.person.personId);
                            $("#rparty-person-address-id" + rpartySize).text(reportPerson.person.addresses[0].addressId);
                            $("#rparty-fname" + rpartySize).text(reportPerson.person.firstName);
                            $("#rparty-lname" + rpartySize).text(reportPerson.person.lastName);
                            $("#rparty-cname" + rpartySize).text(reportPerson.person.companyName);
                            $("#rparty-phone-number" + rpartySize).text(reportPerson.person.phoneNumber);
                            $("#rparty-email" + rpartySize).text(reportPerson.person.email);
                            $("#rparty-address" + rpartySize).text(reportPerson.person.addresses[0].address1);
                            $("#rparty-city" + rpartySize).text(reportPerson.person.addresses[0].city);
                            $("#rparty-state" + rpartySize).text(reportPerson.person.addresses[0].state);
                            $("#rparty-zipcode" + rpartySize).text(reportPerson.person.addresses[0].zipcode);
                            rpartySize = rpartySize + 1;
                        }
                    }
                });
            }
            if (data.facility != null) {
                $("#site-id").text(data.facility.facilityId);
                if (data.status === 'PENDING') {
                    $("#site-name").val(data.facility.facilityName);
                } else {
                    $("#site-name").text(data.facility.facilityName);
                }
                if (data.facility.addresses != null && data.facility.addresses != undefined && $.isArray(data.facility.addresses) && data.facility.addresses.length > 0) {
                    if (data.status === 'PENDING') {
                        $("#site-address-id").text(data.facility.addresses[0].addressId)
                        $("#site-address").val(data.facility.addresses[0].address1);
                        $("#site-city").val(data.facility.addresses[0].city);
                        $("#site-county").val(data.facility.addresses[0].county);
                        $("#site-municipality").val(data.facility.addresses[0].municipality);
                        $("#site-latitude").val(data.facility.addresses[0].latitude);
                        $("#site-longitude").val(data.facility.addresses[0].longitude);
                        $("#site-state").val(data.facility.addresses[0].state);
                        $("#site-zipcode").val(data.facility.addresses[0].zipcode);
                    } else {
                        $("#site-address-id").text(data.facility.addresses[0].addressId)
                        $("#site-address").text(data.facility.addresses[0].address1);
                        $("#site-city").text(data.facility.addresses[0].city);
                        $("#site-county").text(data.facility.addresses[0].county);
                        $("#site-municipality").text(data.facility.addresses[0].municipality);
                        $("#site-latitude").text(data.facility.addresses[0].latitude);
                        $("#site-longitude").text(data.facility.addresses[0].longitude);
                        $("#site-state").text(data.facility.addresses[0].state);
                        $("#site-zipcode").text(data.facility.addresses[0].zipcode);
                    }
                }
            }

            if (data.substances != null && data.substances != undefined && $.isArray(data.substances) && data.substances.length > 0) {
                jQuery.each(data.substances, function (index, substance) {

                    var index = $("#hazardSelList").children().length + 1;
                    var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it" id="' + index + '">' + substance.substanceName + '</li>';
                    $("#hazardSelList").append(element);
                });
            }

            if (data.impacts != null && data.impacts != undefined && $.isArray(data.impacts) && data.impacts.length > 0) {
                jQuery.each(data.impacts, function (index, impact) {

                    var index = $("#envImpactList").children().length + 1;
                    var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it" id="' + index + '">' + impact.impactName + '</li>';
                    $("#envImpactList").append(element);
                });
            }

            if (data.sources != null && data.sources != undefined && $.isArray(data.sources) && data.sources.length > 0) {
                jQuery.each(data.sources, function (index, source) {

                    var index = $("#hzrd-source-list").children().length + 1;
                    var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it" id="' + index + '">' + source.sourceName + '</li>';
                    $("#hzrd-source-list").append(element);
                });
            }
            if (data.causes != null && data.causes != undefined && $.isArray(data.causes) && data.causes.length > 0) {
                jQuery.each(data.causes, function (index, cause) {

                    var index = $("#hzrd-cause-list").children().length + 1;
                    var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it" id="' + index + '">' + cause.causeName + '</li>';
                    $("#hzrd-cause-list").append(element);
                });
            }
            if (data.attachments != null && data.attachments != undefined && $.isArray(data.attachments) && data.attachments.length > 0) {
                jQuery.each(data.attachments, function (index, file) {

                    if (data.status === 'PENDING') {
                        $("#uploaded-files").append(
                            $('<tr id="attchtr' + index + '"/>')
                                .append($('<td/>').text(file.attachmentFileName))
                                .append($('<td/>').text('1 kb'))
                                .append($('<td/>').text(file.attachmentFileType))
                                .append($('<td style="display: none" id="attchId' + index + '"/>').text(file.attachmentId))
                                .append($('<td/>').html(" <button type='button'  class='btn btn-xs btn-danger delete deleteNFormFile' id='nformFileIndex" + index +
                                    "' <i class='glyphicon glyphicon-trash'></i>" +
                                    "<span>Delete</span>" +
                                    "</button>"))
                        ) //end $("#uploaded-files").append()
                    }else {
                        $("#uploaded-files").append(
                            $('<tr id="attchtr' + index + '"/>')
                                .append($('<td/>').text(file.attachmentFileName))
                                .append($('<td/>').text('1 kb'))
                                .append($('<td/>').text(file.attachmentFileType))
                                .append($('<td style="display: none" id="attchId' + index + '"/>').text(file.attachmentId))
                                .append($('<td/>').html(" <a type='button'  href='/rresubmittal/eforms/" + reportId + "/downloadFile/" + file.attachmentId +"','class='btn btn-xs btn-info downloadNFormFile' id='nformFileIndex" + index +
                                    "' <i class='glyphicon glyphicon-download'></i>" +
                                    "<span>Download</span>" +
                                    "</a>"))
                        ) //end $("#uploaded-files").append()

                    }
                });
            }

        });
    } else {
        $("#reporter-fname").val(userFirstName);
        $("#reporter-lname").val(userLastName);
        $("#reporter-email").val(userEmail);
    }
    var validationNformDetails = function () {
        var isValid1 = false;
        var isValid2 = false;
        var isValid3 = false;
        if (!$('input[name = hzrd-type-radio]:checked').val()) {
            $("#hzrd-type-radio-grp").addClass("has-error");
            $(".hzrd-type-error").show();
            isValid1 = false;
        } else {
            $("#hzrd-type-radio-grp").removeClass("has-error");
            $(".hzrd-type-error").hide();
            isValid1 = true;
        }

        if ($("#reporter-fname").val() === "") {
            $("#fname-grp").addClass("has-error");
            $(".fname-rep-by").show();
            isValid2 = false;
        } else {
            $("#fname-grp").removeClass("has-error");
            $(".fname-rep-by").hide();
            isValid2 = true;
        }
        if ($("#reporter-lname").val() === "") {
            $("#lname-grp").addClass("has-error");
            $(".lname-rep-by").show();
            isValid3 = false;
        } else {
            $("#lname-grp").removeClass("has-error");
            $(".lname-rep-by").hide();
            isValid3 = true;
        }
        return isValid1 && isValid2 && isValid3;
    };

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
        var reporterPersonId = $("#reporter-person-id").text();
        var reporterPersonAddressId = $("#reporter-person-address-id").text();

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
                }]

        };
        return report;
    };

    $("#hazard-type-text-area").hide();
    $(".hzrd-type-error").hide();
    $(".fname-rep-by").hide();
    $(".lname-rep-by").hide();


    $(".generic-hazard-type").click(function () {
        $("hazard-type-text-area").css("display", "none");
        $("#hazardType-text-area").hide();

    });

    $("#other-hazard-type").click(function () {
        $("hazard-type-text-area").css("display", "");
        $("#hazard-type-text-area").show();

    });

    $("#disch-to-site-btn").click(function (evt) {
        evt.preventDefault();
        if (validationNformDetails()) {
            $("#collapse-one").collapse("hide");
            $("#collapse-two").collapse("show");
            $("#details-edit-btn").show();
        }
    });


    //save nfdetails to the database using jquery call.
    $("#nfdetailssave").click(function (evt) {
        evt.preventDefault();
        if (validationNformDetails()) {
            var jsonObject = buildJsonObject();
            //sending the data to /
            var token = $("meta[name='_csrf']").attr("content");
            $.ajax({
                type: 'post',
                contentType: 'application/json',
                url: contextPath + '/eforms/save',
                data: JSON.stringify(jsonObject),
                dataType: 'json',
                headers: {
                    'X-CSRF-TOKEN': token
                },
                success: function () {
                    alert("success");
                    $(location).attr('href', contextPath + '/home')
                },
                error: function () {
                    alert("error");
                }
            });
        }
    });

})();