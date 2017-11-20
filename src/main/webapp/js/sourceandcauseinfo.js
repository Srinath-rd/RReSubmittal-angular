/**
 *
 */
(function () {
    $("#hzrdInfoToImpctsInfoBtn").click(function (evt) {
        evt.preventDefault();

    });

    $("#causeInfoToImpctsBtn").click(function (evnt) {
        event.preventDefault();
        $("#collapseFive").collapse("show");
        $("#collapseSix").collapse("hide");
        $("#sourceCauseEditBtn").show();
    });

    $("#submitNotifForm").click(function (evnt) {
        event.preventDefault();
        $("#notifForm").hide();
        $("#confirmationMsg").show();
        //window.location.href = "notificationFormFinish.jsp";
    });

    $("#energyDetailsCheckBox").click(function () {
        if ($(this).is(':checked')) {
            $("#energyDetails").hide();
        } else {
            $("#energyDetails").show();
        }

    })
})();