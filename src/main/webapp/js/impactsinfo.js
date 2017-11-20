/**
 *
 */
(function () {
    $("#impctsInfoToCauseInfoBtn").click(function (evt) {
        evt.preventDefault();
        $("#collapseFive").collapse("hide");
        $("#collapseSix").collapse("show");
        $("#impactsEditBtn").show();
    });

    $("#impctsInfoToHzrdInfoBtn").click(function (evnt) {
        event.preventDefault();

        $("#collapseFour").collapse("show");
        $("#collapseFive").collapse("hide");

        $("#impactsEditBtn").show();
    });

    var token = $("meta[name='_csrf']").attr("content");
    var header1 = $("meta[name='_csrf_header']").attr("content");
    $('#fileupload').fileupload({

        dataType: 'json',

        headers : {
            'X-CSRF-TOKEN' : token
        },
        done: function (e, data) {
            $("tr:has(td)").remove();
            $.each(data.result, function (index, file) {

                $("#uploaded-files").append(
                    $('<tr/>')
                        .append($('<td/>').text(file.fileName))
                        .append($('<td/>').text(file.fileSize))
                        .append($('<td/>').text(file.fileType))
                        .append($('<td/>').html("<a href='rest/controller/get/" + index + "'>Click</a>"))
                ) //end $("#uploaded-files").append()
            });
        },

        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        },

        dropZone: $('#dropzone')
    });

    $.getJSON("impacts", function (data) {
        $.each(data, function (index, text) {
            $('#envImpacts').append(
                $('<option></option>').val(index).html(text.impactDescription)
            );
        });
    });

    $("#labResultsAttchmntChkbox").click(function(){
        if ($(this).is(':checked')) {
            $("#more-info").show();
        } else {
            $("#more-info").hide();
        }

    });

})();