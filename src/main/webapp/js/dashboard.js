(function () {

    var userId = $("#userId").text();
    $('#forms-directory').click();
    var contextPath = $("#home-context").text();
    $("#homepage-errormsg").hide();
    $("#homepage-successmsg").hide();
    var token = $("meta[name='_csrf']").attr("content");
    $("#forms-directory").click(function () {
        $("#applicationlist").empty();
        $.getJSON("users/applications/all", function (data) {
            var thtml = '';
            $.each(data, function (index, text) {
                var formName = '';
                var formTag = '';
                if (text.formName === 'NOTIFICATION_FORM') {
                  //  formName = 'Notification Form';
                 //   formTag += '<td style="text-align: center"> <a href="'+contextPath +'nform">' + formName +'</a></td>'
                    formTag += '  <a href="' + contextPath +'/nform" class="list-group-item list-group-item-action flex-column align-items-start active">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Notification Form</h5>\n' +
                        '                                <small>3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Notification Form for reporting Hazard substance spillages</p>\n' +
                        '                            <small>Deadline: </small>\n' +
                        '                        </a>';
                }
                else if (text.formName === 'CLOSURE_FORM') {
                 //   formName = 'Closure Form';
                  //  formTag += '<td style="text-align: center" <a href="#">'+ formName + '</td>'
                    formTag +=  '                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Technical Assistance Form</h5>\n' +
                        '                                <small class="text-muted">3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Technical Assistance Form for obtaining assistance.</p>\n' +
                        '                            <small class="text-muted">Deadline:</small>\n' +
                        '                        </a>';
                } else if (text.formName === 'TECHNICAL_ASSISTANCE_FORM') {
                  //  formName = 'Technical Assistance Form';
                  //  formTag += '<td style="text-align: center" <a href="#">' + formName + '</td>'
                    formTag += '                        <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Closure Form</h5>\n' +
                        '                                <small class="text-muted">3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Closure form for closing accounts.</p>\n' +
                        '                            <small class="text-muted">Deadline: </small>\n' +
                        '                        </a>';
                }
                thtml +=  formTag;

            });
            $("#applicationlist").append('' +
                '<h3 style="text-align: center">Directory</h3>' +
                '<div class="list-group">' + thtml + '</div>');
        });
    });



    $("#forms-completed").click(function () {
        $("#applicationlist").empty();
        $.getJSON("users/" + userId + "/applications/completed", function (data) {
            var thtml = '';
            $.each(data, function (index, text) {
                var formName = '';
                var formTag = '';
                if (text.formName === 'NOTIFICATION_FORM') {
                    formTag += '  <a href="'+ contextPath +'/nform" class="list-group-item list-group-item-action flex-column align-items-start active">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Notification Form</h5>\n' +
                        '                                <small>3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Notification Form for reporting Hazard substance spillages</p>\n' +
                        '                            <small>Deadline: </small>\n' +
                        '                        </a>';
                }
                else if (text.formName === 'CLOSURE_FORM') {
                    //   formName = 'Closure Form';
                    //  formTag += '<td style="text-align: center" <a href="#">'+ formName + '</td>'
                    formTag +=  '                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Technical Assistance Form</h5>\n' +
                        '                                <small class="text-muted">3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Technical Assistance Form for obtaining assistance.</p>\n' +
                        '                            <small class="text-muted">Deadline:</small>\n' +
                        '                        </a>';
                } else if (text.formName === 'TECHNICAL_ASSISTANCE_FORM') {
                    //  formName = 'Technical Assistance Form';
                    //  formTag += '<td style="text-align: center" <a href="#">' + formName + '</td>'
                    formTag += '                        <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Closure Form</h5>\n' +
                        '                                <small class="text-muted">3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Closure form for closing accounts.</p>\n' +
                        '                            <small class="text-muted">Deadline: </small>\n' +
                        '                        </a>';
                }
                thtml +=  formTag;

            });
            $("#applicationlist").append('' +
                '<h3 style="text-align: center">Completed Applications</h3>' +
                '<div class="list-group">' + thtml + '</div>');
        });
    });

    $("#forms-submitted").click(function () {
        $("#applicationlist").empty();
        $.getJSON("users/" + userId + "/applications/submitted", function (data) {
            var thtml = '';
            $.each(data, function (index, text) {
                var formName = '';
                var formTag = '';
                if (text.form.formName === 'NOTIFICATION_FORM') {
                    formTag += '  <a href="'+ contextPath +'/nform?reportId='+ text.reportId  +'"  class="list-group-item list-group-item-action flex-column align-items-start">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Notification Form</h5>\n' +
                        '                                <small>3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Notification Form for reporting Hazard substance spillages</p>\n' +
                        '                            <small>Deadline: </small>\n' +
                        '                        </a>';
                }
                else if (text.form.formName === 'CLOSURE_FORM') {
                    //   formName = 'Closure Form';
                    //  formTag += '<td style="text-align: center" <a href="#">'+ formName + '</td>'
                    formTag +=  '                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Technical Assistance Form</h5>\n' +
                        '                                <small class="text-muted">3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Technical Assistance Form for obtaining assistance.</p>\n' +
                        '                            <small class="text-muted">Deadline:</small>\n' +
                        '                        </a>';
                } else if (text.form.formName === 'TECHNICAL_ASSISTANCE_FORM') {
                    //  formName = 'Technical Assistance Form';
                    //  formTag += '<td style="text-align: center" <a href="#">' + formName + '</td>'
                    formTag += '                        <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Closure Form</h5>\n' +
                        '                                <small class="text-muted">3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Closure form for closing accounts.</p>\n' +
                        '                            <small class="text-muted">Deadline: </small>\n' +
                        '                        </a>';
                }
                thtml +=  formTag;

            });
            $("#applicationlist").append('' +
                '<h3 style="text-align: center">Submitted Applications</h3>' +
                '<div class="list-group">' + thtml + '</div>');
        });
    });

    $("#forms-in-progress").click(function () {
        $("#applicationlist").empty();
        $.getJSON("users/" + userId + "/applications/pending", function (data) {
            var thtml = '';
            $.each(data, function (index, text) {
                var formName = '';
                var formTag = '';
                if (text.form.formName === 'NOTIFICATION_FORM') {
                    formTag += '<div class="list-group-item list-group-item-action flex-column align-items-start"> <a href="'+ contextPath +'/nform?reportId='+ text.reportId  +'">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Notification Form</h5>\n' +
                        '                                <small>3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Notification Form for reporting Hazard substance spillages</p>\n' +
                        '                            <p class="mb-1"><small>Deadline: </small></p>\n' +
                        '                        </a>' +
                        ' <button type="button" href="'+ contextPath +'/nform?reportId='+ text.reportId  +'" class="continue btn btn-xs btn-primary pull-left mb-1 continue-nform" id="'+ text.reportId +'" value="Continue">Continue</button> ' +
                        ' <button type="button" class="delete btn btn-xs  btn-danger pull-right mb-1 delete-nform"  id="'+ text.reportId +'" value="Delete">Delete</button> </div>';
                }
                else if (text.form.formName === 'CLOSURE_FORM') {
                    //   formName = 'Closure Form';
                    //  formTag += '<td style="text-align: center" <a href="#">'+ formName + '</td>'
                    formTag +=  '                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Technical Assistance Form</h5>\n' +
                        '                                <small class="text-muted">3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Technical Assistance Form for obtaining assistance.</p>\n' +
                        '                            <small class="text-muted">Deadline:</small>\n' +
                        '                        </a>';
                } else if (text.form.formName === 'TECHNICAL_ASSISTANCE_FORM') {
                    //  formName = 'Technical Assistance Form';
                    //  formTag += '<td style="text-align: center" <a href="#">' + formName + '</td>'
                    formTag += '                        <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                        '                            <div class="d-flex w-100 justify-content-between">\n' +
                        '                                <h5 class="mb-1">Closure Form</h5>\n' +
                        '                                <small class="text-muted">3 days ago</small>\n' +
                        '                            </div>\n' +
                        '                            <p class="mb-1">Closure form for closing accounts.</p>\n' +
                        '                            <small class="text-muted">Deadline: </small>\n' +
                        '                        </a>';
                }
                thtml +=  formTag;

            });
            $("#application-header").html("'<h3 style=\"text-align: center\">In Progress Applications</h3>'");
            $("#applicationlist").append('' +
                '<div class="list-group">' + thtml + '</div>');
        });
    });

    $("body").on('click', '.delete-nform', function () {
        var reportId = this.id;
        $.ajaxSetup({
            headers : {
                'X-CSRF-TOKEN' : token
            }
        });
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: contextPath + "/eforms/delete/" + reportId ,
            dataType: 'json',
            headers: {
                'X-CSRF-TOKEN': token
            },
            success: function () {
                $("#applicationlist").empty();
                $.getJSON("users/" + userId + "/applications/pending", function (data) {
                    var thtml = '';
                    $.each(data, function (index, text) {
                        var formName = '';
                        var formTag = '';
                        if (text.formName === 'NOTIFICATION_FORM') {
                            formTag += '  <a href="'+ contextPath +'/nform" class="list-group-item list-group-item-action flex-column align-items-start active">\n' +
                                '                            <div class="d-flex w-100 justify-content-between">\n' +
                                '                                <h5 class="mb-1">Notification Form</h5>\n' +
                                '                                <small>3 days ago</small>\n' +
                                '                            </div>\n' +
                                '                            <p class="mb-1">Notification Form for reporting Hazard substance spillages</p>\n' +
                                '                            <small>Deadline: </small>\n' +
                                '                        </a>';
                        }
                        else if (text.formName === 'CLOSURE_FORM') {
                            //   formName = 'Closure Form';
                            //  formTag += '<td style="text-align: center" <a href="#">'+ formName + '</td>'
                            formTag +=  '                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                                '                            <div class="d-flex w-100 justify-content-between">\n' +
                                '                                <h5 class="mb-1">Technical Assistance Form</h5>\n' +
                                '                                <small class="text-muted">3 days ago</small>\n' +
                                '                            </div>\n' +
                                '                            <p class="mb-1">Technical Assistance Form for obtaining assistance.</p>\n' +
                                '                            <small class="text-muted">Deadline:</small>\n' +
                                '                        </a>';
                        } else if (text.formName === 'TECHNICAL_ASSISTANCE_FORM') {
                            //  formName = 'Technical Assistance Form';
                            //  formTag += '<td style="text-align: center" <a href="#">' + formName + '</td>'
                            formTag += '                        <a href="#" class="list-group-item list-group-item-action flex-column align-items-start link-disabled">\n' +
                                '                            <div class="d-flex w-100 justify-content-between">\n' +
                                '                                <h5 class="mb-1">Closure Form</h5>\n' +
                                '                                <small class="text-muted">3 days ago</small>\n' +
                                '                            </div>\n' +
                                '                            <p class="mb-1">Closure form for closing accounts.</p>\n' +
                                '                            <small class="text-muted">Deadline: </small>\n' +
                                '                        </a>';
                        }
                        thtml +=  formTag;

                    });

                    $("#applicationlist").append('' +

                        '<div class="list-group">' + thtml + '</div>');
                });
            },
            error: function (data) {
                $("#homepage-errormsg").show();
                $("#homepage-errormsg").append("Application couldn't be deleted. Please try again later");
            }
        });
    });

    $("body").on('click' , '.continue-nform', function () {
       var id =  this.id;
       location.href = "'+ contextPath + '/nform?reportId=" + id;
    });

})();

