(function () {
    var validationNformDetails = function () {
        var isValid1 = false;
        var isValid2 = false;
        var isValid3 = false;
        if (!$('input[name = hzrdTypeRadio]:checked').val()) {
            $("#hzrdTypeRadioGrp").addClass("has-error");
            $(".hzrdTypeError").show();
            isValid1 = false;
        } else {
            $("#hzrdTypeRadioGrp").removeClass("has-error");
            $(".hzrdTypeError").hide();
            isValid1 = true;
        }

        if ($("#fname").val() === "") {
            $("#fnameGrp").addClass("has-error");
            $(".fnameRepBy").show();
            isValid2 = false;
        } else {
            $("#fnameGrp").removeClass("has-error");
            $(".fnameRepBy").hide();
            isValid2 = true;
        }
        if ($("#lname").val() === "") {
            $("#lnameGrp").addClass("has-error");
            $(".lnameRepBy").show();
            isValid3 = false;
        } else {
            $("#lnameGrp").removeClass("has-error");
            $(".lnameRepBy").hide();
            isValid3 = true;
        }
        if (isValid1 && isValid2 && isValid3) {
            return true;
        } else {
            return false;
        }
    }

    $("#hazardTypeTextArea").hide();
    $(".hzrdTypeError").hide();
    $(".fnameRepBy").hide();
    $(".lnameRepBy").hide();


    $(".genericHazardType").click(function () {
        $("hazardTypeTextArea").css("display", "none");
        $("#hazardTypeTextArea").hide();

    })

    $("#otherHazardType").click(function () {
        $("hazardTypeTextArea").css("display", "");
        $("#hazardTypeTextArea").show();

    })

    $("#dischToSiteBtn").click(function (evt) {
        evt.preventDefault();
        if (validationNformDetails()) {
            $("#collapseOne").collapse("hide");
            $("#collapseTwo").collapse("show");
            $("#detailsEditBtn").show();
        }
    });


})();