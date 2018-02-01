/**
 *
 */
(function () {
    var contextPath = $("#context").text();
    var reportId = $("#reportId").text();
    var files = null;
    var createImpactsArray = function () {
        var substances = ['select from below', 'VOC-Tetrachloroethene', 'VOC-Trichloroethene', 'VOC-Chlorinated Solvent', 'VOC-Other', 'Metals-Arsenic', 'Metals-Chromium', 'Metals-Lead', 'Metals-Other', 'PFOS',
            'Petroleum-Diesel', 'Petroleum:Engine/Waste oil', 'Fuel oil', 'Gasoline', 'Hydraulic Oil', 'Jet Fuel', 'PAHs', 'Petroleum-Unknown Type', 'Other', 'Ag Chem', 'Ag Chem-Pesticides',
            'Ag Chem-Fertilizer', 'Ag Chem-Anhydrous', 'Mineral Oil', 'PCB', 'Industrial-Cyanide', 'Leachate', 'RCRA Hazardous Waste', 'Other', 'Unknown'
        ];
        return substances;
    };
    $("#impctsInfoToCauseInfoBtn").click(function (evt) {
        evt.preventDefault();
        $("#collapse-five").collapse("hide");
        $("#collapse-six").collapse("show");
        $("#impacts-edit-btn").show();
    });

    $("#impctsInfoToHzrdInfoBtn").click(function (evnt) {
        event.preventDefault();

        $("#collapseFour").collapse("show");
        $("#collapseFive").collapse("hide");

        $("#impacts-edit-btn").show();
    });

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
            },
        ];

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

        $("filesList").each(function (index) {
            var fileName = $(this).find("#fileName").text();
            var fileType = $(this).find("#fileType").text();
            var fileSize = $(this).find("#fileSize").text();
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
            "impacts": impacts
        };
        return report;
    }

    var token = $("meta[name='_csrf']").attr("content");
    var header1 = $("meta[name='_csrf_header']").attr("content");
    var filesList = [];
    // var formData = new FormData();
    // formData.append("json", JSON.stringify(buildJsonObject()));

    // var jsonObject = buildJsonObject();
    $('#fileupload').fileupload({

        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': token
        },
        add: function (e, data) {
            var formData = new FormData();
            formData.append("json", JSON.stringify(buildJsonObject()));
            data.formData = formData;

            data.submit();
        },

        error: function (data) {
            alert(data);
        },
        done: function (e, data) {
            $("#reportId").text(data.result.reportId);
            $("tr:has(td)").remove();
            $.each(data.result.attachments, function (index, file) {

                $("#uploaded-files").append(
                    $('<tr id="attchtr' + index + '"/>')
                        .append($('<td/>').text(file.attachmentFileName))
                        .append($('<td/>').text('1 kb'))
                        .append($('<td/>').text(file.attachmentFileType))
                        .append($('<td style="display: none" id="attchId' + index +'"/>').text(file.attachmentId))
                        .append($('<td/>').html(" <button type='button'  class='btn btn-danger delete deleteNFormFile' id='nformFileIndex" + index +
                            "' <i class='glyphicon glyphicon-trash'></i>" +
                            "<span>Delete</span>" +
                            "</button>"))
                ) //end $("#uploaded-files").append()
            });
        },

        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress').show();
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
            if (progress === 100) {
                $('#progress').hide();
            }
        },

        dropZone: $('#dropzone')
    });

    // $('#fileupload').fileupload('add', {files: filesList});

    // $('#fileupload').on('click', function(){
    //      $(this).files.each(function (data, index) {
    //
    //          $("#uploaded-files").append(
    //              $('<tr/>')
    //                  .append($('<td/>').text(data.name))
    //                  .append($('<td/>').text(file.size))
    //                  .append($('<td/>').text(file.type))
    //                  .append($('<td/>').html(" <button type='button'  class='btn btn-danger delete deleteNFormFile' id='nformFileIndex'" + index +
    //                      "                   ' <i class='glyphicon glyphicon-trash'></i>" +
    //                      "                    <span>Delete</span>" +
    //                      "                </button>"))
    //          )
    //      });
    //
    //
    // });

    $.getJSON("impacts", function (data) {
        $.each(data, function (index, text) {
            $('#envImpacts').append(
                $('<option></option>').val(index).html(text.impactDescription)
            );
        });
    });


    $("#labResultsAttchmntChkbox").click(function () {
        if ($(this).is(':checked')) {
            $("#more-info").show();
        } else {
            $("#more-info").hide();
        }

    });

    $(document).on('click', '.deleteNFormFile', function () {
        var index = this.id;
        var index1 = index.substring(14);
        var attachmentId = $(this).parents('tr').find('#attchId' + index1).text();
        $.ajax({
            type: 'post',
            contentType: 'application/json',
            url: contextPath + '/eforms/'+ reportId + '/deleteFile/' + attachmentId,
            dataType: 'json',
            headers: {
                'X-CSRF-TOKEN': token
            },
            success: function () {
                alert("success");
                $('#attchtr' + index1).remove();
            },
            error: function () {
                alert("error");
            }
        });

    });

    // $(document).on('click', '.downloadNFormFile', function () {
    //     var index = this.id.substring(14);
    //     var attachmentId = $(this).parents('tr').find('#attchId' + index).text();
    //     $.ajax({
    //         type: 'get',
    //         contentType: 'application/json',
    //         url: contextPath + '/eforms/'+ reportId + '/downloadFile/' + attachmentId,
    //         dataType: 'json',
    //         headers: {
    //             'X-CSRF-TOKEN': token
    //         },
    //         success: function () {
    //             alert("success");
    //         },
    //         error: function () {
    //             alert("error");
    //         }
    //     });
    //
    // });


    function validateImpactsInformation() {
        return true;
    }


    //save nfdetails to the database using jquery call.
    $("#nfimpacts-info-save").click(function (evt) {
        evt.preventDefault();
        if (validateImpactsInformation()) {
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
                    //  $(location).attr('href', '/rresubmittal/')
                },
                error: function () {
                    alert("error");
                }
            });
        }
    });

})();