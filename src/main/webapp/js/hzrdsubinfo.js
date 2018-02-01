/**
 *
 */
(function () {

    var contextPath = $("#context").text();
    var reportId = $("#reportId").text();
    var createSubstancesArray = function () {
        var substances = ['select from below', 'VOC-Tetrachloroethene', 'VOC-Trichloroethene', 'VOC-Chlorinated Solvent', 'VOC-Other', 'Metals-Arsenic', 'Metals-Chromium', 'Metals-Lead', 'Metals-Other', 'PFOS',
                          'Petroleum-Diesel', 'Petroleum:Engine/Waste oil', 'Fuel oil', 'Gasoline', 'Hydraulic Oil', 'Jet Fuel', 'PAHs', 'Petroleum-Unknown Type', 'Other', 'Ag Chem', 'Ag Chem-Pesticides',
                          'Ag Chem-Fertilizer', 'Ag Chem-Anhydrous', 'Mineral Oil', 'PCB', 'Industrial-Cyanide', 'Leachate', 'RCRA Hazardous Waste', 'Other', 'Unknown'
                         ];
        return substances;
    };
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

    $("#hzrdInfoToImpctsInfoBtn").click(function (evt) {
        evt.preventDefault();
        $("#collapse-four").collapse("hide");
        $("#collapse-five").collapse("show");
        $("#hzrd-sub-edit-btn").show();

    });

    $("#hzrdInfoToRespPartyInfoBtn").click(function (evt) {
        evt.preventDefault();
        $("#collapseFour").collapse("hide");
        $("#collapseThree").collapse("show");
        $("#hzrd-sub-edit-btn").show();

    });

    $(document).on('click', '#hazard-sublist-plus-btn', function () {
        var result = $("#select-result").text();
        $("#hazardSelList #" + result).remove();
    })

    $(document).on('click', '#hazard-sublist-plus-btn', function () {
        var selectedMainValue = $("#hazardSubstancesSubList").find("option:selected").text();
        var selectedSubValue =  $("#hazardSubstances").find("option:selected").val();
        var selectedValue = '';
        if(selectedSubValue === undefined || selectedSubValue === '-1'){
            selectedValue = selectedMainValue;
        }else {
            selectedValue = $("#hazardSubstances").find("option:selected").text();
        }
        var index = $("#hazardSelList").children().length + 1;
        var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it" id="' + index + '">' + selectedValue + '</li>';
        $("#hazardSelList").append(element);
    })



    $("#hazardSubstancesSubList").on('change', function () {
         var selectedIndex = $(this).val();
         var substanceArray = createSubstancesArray();
         if(substanceArray[selectedIndex].indexOf('-') > -1) {
             var substance1 = substanceArray[selectedIndex].split('-')[0].trim();
             var substance2 = substanceArray[selectedIndex].split('-')[1].trim();
         }else {
             substance1= substanceArray[selectedIndex].trim();
             substance2 = '';
         }

         if(selectedIndex != 0) {
             if (substance1 === 'Other') {
                 $('#hazardSubstances').prop("disabled", false);
                 $("#hazardSubstances").empty();
                 $.getJSON("substances", function (data) {
                     $('#hazardSubstances').append(
                         $('<option></option>').val(-1).html('Select from below.')
                     );
                     $.each(data, function (index, text) {
                         $('#hazardSubstances').append(
                             $('<option></option>').val(index).html(text.descriptionp + " ------ " + text.description1)
                         );
                     });
                 });
             } else {
                 $('#hazardSubstances').prop("disabled", false);
                 $("#hazardSubstances").empty();
                 $.getJSON("substances/sublist?substance1=" + substance1 + "&substance2=" + substance2, function (data) {
                     $('#hazardSubstances').append(
                         $('<option></option>').val(-1).html('Select from below.')
                     );
                     $.each(data, function (index, text) {
                         $('#hazardSubstances').append(
                             $('<option></option>').val(index).html(text.descriptionp + " ------ " + text.description1)
                         );
                     });
                 });
             }
         }
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

        $("#hazardSelList li").each(function (index) {
            index = index + 1;
            var substanceName = $(this).text();
            var substance = {
                    "substanceName": substanceName
            };

            substances.push(substance);
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
            "substances": substances
        }
        ;
        return report;
    };


    function validateHzrdInformation() {
        return true;
    }

    //save nfdetails to the database using jquery call.
    $("#hzrdInfoSaveBtn").click(function (evt) {
        evt.preventDefault();
        if (validateHzrdInformation()) {
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

})();