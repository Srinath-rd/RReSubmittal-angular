/**
 *
 */
(function () {
    var contextPath = $("#context").text();
    var reportId = $("#reportId").text();
    var createCausesArray = function () {
        var substances = ['select from below', 'VOC-Tetrachloroethene', 'VOC-Trichloroethene', 'VOC-Chlorinated Solvent', 'VOC-Other', 'Metals-Arsenic', 'Metals-Chromium', 'Metals-Lead', 'Metals-Other', 'PFOS',
            'Petroleum-Diesel', 'Petroleum:Engine/Waste oil', 'Fuel oil', 'Gasoline', 'Hydraulic Oil', 'Jet Fuel', 'PAHs', 'Petroleum-Unknown Type', 'Other', 'Ag Chem', 'Ag Chem-Pesticides',
            'Ag Chem-Fertilizer', 'Ag Chem-Anhydrous', 'Mineral Oil', 'PCB', 'Industrial-Cyanide', 'Leachate', 'RCRA Hazardous Waste', 'Other', 'Unknown'
        ];
        return substances;
    };

    var createSourcesArray = function () {
        var substances = ['select from below', 'VOC-Tetrachloroethene', 'VOC-Trichloroethene', 'VOC-Chlorinated Solvent', 'VOC-Other', 'Metals-Arsenic', 'Metals-Chromium', 'Metals-Lead', 'Metals-Other', 'PFOS',
            'Petroleum-Diesel', 'Petroleum:Engine/Waste oil', 'Fuel oil', 'Gasoline', 'Hydraulic Oil', 'Jet Fuel', 'PAHs', 'Petroleum-Unknown Type', 'Other', 'Ag Chem', 'Ag Chem-Pesticides',
            'Ag Chem-Fertilizer', 'Ag Chem-Anhydrous', 'Mineral Oil', 'PCB', 'Industrial-Cyanide', 'Leachate', 'RCRA Hazardous Waste', 'Other', 'Unknown'
        ];
        return substances;
    };
    $("#hzrdInfoToImpctsInfoBtn").click(function (evt) {
        evt.preventDefault();

    });

    $("#causeInfoToImpctsBtn").click(function (evnt) {
        event.preventDefault();
        $("#collapse-five").collapse("show");
        $("#collapse-six").collapse("hide");
        $("#source-cause-edit-btn").show();
    });



    $("#energyDetailsCheckBox").click(function () {
        if ($(this).is(':checked')) {
            $("#energyDetails").hide();
        } else {
            $("#energyDetails").show();
        }

    });



    $(document).on('click', '#hzrd-cause-minus-button', function () {
        var result = $("#cause-select-result").text();
        $("#hazardSelList #" + result).remove();
    });

    $(document).on('click', '#hzrd-cause-plus-button', function () {
        var selectedValue = $("#hzrd-causes").find("option:selected").text();
        var index = $("#hzrd-cause-list").children().length + 1;
        var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it" id="' + index + '">' + selectedValue + '</li>';
        $("#hzrd-cause-list").append(element);
    });

    $(document).on('click', '#hzrd-source-minus-button', function () {
        var result = $("#source-select-result").text();
        $("#hzrd-source-list #" + result).remove();
    });

    $(document).on('click', '#hzrd-source-plus-button', function () {
        var selectedValue = $("#hzrd-sources").find("option:selected").text();
        var index = $("#hzrd-source-list").children().length + 1;
        var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it" id="' + index + '">' + selectedValue + '</li>';
        $("#hzrd-source-list").append(element);
    });


    $("#hzrd-cause-list").selectable({
        stop: function () {
            var result = $("#cause-select-result").empty();
            $(".ui-selected", this).each(function () {
                var index = $(".selectable li").index(this);
                result.append(index + 1);
                $("#envImpactMinusButton").css("display", "");
                $("#envImpactMinusButton").show();
            });
        }
    });

    $("#hzrd-source-list").selectable({
        stop: function () {
            var result = $("#source-select-result").empty();
            $(".ui-selected", this).each(function () {
                var index = $(".selectable li").index(this);
                result.append(index + 1);
                $("#envImpactMinusButton").css("display", "");
                $("#envImpactMinusButton").show();
            });
        }
    });
    function validateImpactsInformation() {
        return true;
    }

    function buildJsonObject() {
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
        var siteCounty = $("#site-county").val();
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
            }];

        //getting responsible party details
        $("#respParties > .elmt").each(function (index) {
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
        var substances = [];
        $("#hazardSelList").each(function (index) {
            index = index + 1;
            var substanceName = $(this).text();
            var substance = {
                "substanceName": substanceName
            };

            substances.push(substance);
        });

        var impacts = [];
        $("#envImpactList li").each(function (index) {
            index = index + 1;
            var impactName = $(this).text();
            var impact = {
                "impactName": impactName
            };
            impacts.push(impact);
        });


        var filesList = $('#fileupload').prop('files');

        $("filesList").each(function(index){
            var fileName = $(this).find("#fileName").text();
            var fileType = $(this).find("#fileType").text();
            var fileSize = $(this).find("#fileSize").text();
        });

        var causes = [];
        $("#hzrd-cause-list li").each(function (index) {
            index = index + 1;
            var causeName = $(this).text();
            var cause = {
                "causeName": causeName
            };
            causes.push(cause);
        });

        var sources = [];
        $("#hzrd-source-list li").each(function (index) {
            index = index + 1;
            var sourceName = $(this).text();
            var source = {
                "sourceName": sourceName
            };
            sources.push(source);
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
            },
            "substances": substances,
            "impacts": impacts,
            "sources": sources,
            "causes": causes
        };
        return report;
    }

    //save nfdetails to the database using jquery call.
    $("#submitNotifForm").click(function (evt) {
        evt.preventDefault();
        if (validateImpactsInformation()) {
            var jsonObject = buildJsonObject();
            //sending the data to /
            var token = $("meta[name='_csrf']").attr("content");
            $.ajax({
                type: 'post',
                contentType: 'application/json',
                url: contextPath + '/eforms/save?submit=true',
                data: JSON.stringify(jsonObject),
                dataType: 'json',
                headers: {
                    'X-CSRF-TOKEN': token
                },
                success: function (data) {
                    event.preventDefault();
                    $("#notifForm").hide();
                    $("#saveNformAndExit").hide();
                    $("#confirmationMsg").show();
                    $("#confirmationMsg").append( '<p class="alert-success">Your confirmation Id for this application form is :' + data.confirmationNumber + '</p>');

                },
                error: function () {
                    alert("error");
                }
            });
        }
    });


})();