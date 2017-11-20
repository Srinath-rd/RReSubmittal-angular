/**
 *
 */
(function () {
    $("#respPartyInfoToHzrdInfoBtn").click(function (evt) {
        evt.preventDefault();
        $("#collapseThree").collapse("hide");
        $("#collapseFour").collapse("show");
        $("#respPartyEditBtn").show();

    });
    $("#respPartyInfoToSiteInfoBtn").click(function (evt) {
        evt.preventDefault();
        $("#collapseThree").collapse("hide");
        $("#collapseTwo").collapse("show");
        $("#respPartyEditBtn").show();

    });

})();