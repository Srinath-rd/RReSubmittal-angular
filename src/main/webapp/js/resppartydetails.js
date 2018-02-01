/**
 *
 */
(function () {
    var contextPath = $("#context").text();
    var reportId = $("#reportId").text();
    $("#resp-party-info-to-hzrd-info-btn").click(function (evt) {
        evt.preventDefault();
        $("#collapse-three").collapse("hide");
        $("#collapse-four").collapse("show");
        $("#resp-party-edit-btn").show();

    });
    $("#resp-party-info-to-site-info-btn").click(function (evt) {
        evt.preventDefault();
        $("#collapse-three").collapse("hide");
        $("#collapse-two").collapse("show");
        $("#resp-party-edit-btn").show();

    });

    function validateRpartyInformation() {
        return true;
    }

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


        var siteName = $("#site-name").val();
        var siteAddress = $("#site-address").val();
        var siteMunicipality = $("#site-municipality").val();
        var siteCity = $("#site-city").val();
        var siteState = $("#site-state").val();
        var siteZipcode = $("#site-zipcode").val();
        var siteCounty= $("#site-county").val();
        var longitude = $("#site-longitude").val();
        var latitude = $("#site-latitude").val();
        var reportedBy = "reporter";

        var facilityId = $("#site-id").text();
        var facilityAddId = $("#site-address-id").text();
        var reportPersons = [
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
                "personType": reportedBy
            }]

        //getting responsible party details
        $("#respParties > .elmt").each(function(index){
             var rpartyFname = $(this).find('#rparty-fname' + index).val();
             var rpartyLname = $(this).find('#rparty-lname' + index).val();
             var rpartyCname = $(this).find('#rparty-cname' + index).val();
             var rpartyPhoneNumber = $(this).find('#rparty-phone-number' + index).val();
            var rpartyEmail = $(this).find('#rparty-email' + index).val();
            var rpartyAddress = $(this).find('#rparty-address' + index).val();
            var rpartyCity = $(this).find('#rparty-city' + index).val();
            var rpartyState = $(this).find('#rparty-state' + index).val();
            var rpartyZipcode = $(this).find('#rparty-zipcode' + index).val();
            var personId = $(this).find('#rparty-person-id' + index).text();
            var addressId = $(this).find('#rparty-person-address-id' + index).text();
            reportedBy = "responsibleParty";
            var reportPerson = {
                "person": {
                    "personId": personId,
                    "firstName": rpartyFname,
                    "lastName": rpartyLname,
                    "companyName": rpartyCname,
                    "email": rpartyEmail,
                    "phoneNumber": rpartyPhoneNumber,
                    "addresses": [
                        {
                            "addressId": addressId,
                            "address1": rpartyAddress,
                            "city": rpartyCity,
                            "state": rpartyState,
                            "zipcode": rpartyZipcode
                        }
                    ]
                },
                "personType": reportedBy
            };

            reportPersons.push(reportPerson);

        });

        report = {
            "reportId": reportId,
            "reportType": reportTypeText,
            "reportPersons": reportPersons,
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
    $("#nfrparty-info-save").click(function (evt) {
        evt.preventDefault();
        if (validateRpartyInformation()) {
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
                    $(location).attr('href', '/rresubmittal/')
                },
                error: function () {
                    alert("error");
                }
            });
        }
    });

    $("#nfrparty-lgu-chkbox").click(function () {
        confirm(message);
    });

})();