/**
 *
 */
(function () {

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
        $("#collapseFour").collapse("hide");
        $("#collapseFive").collapse("show");
        $("#hzrdSubEditBtn").show();

    });

    $("#hzrdInfoToRespPartyInfoBtn").click(function (evt) {
        evt.preventDefault();
        $("#collapseFour").collapse("hide");
        $("#collapseThree").collapse("show");
        $("#hzrdSubEditBtn").show();

    });

    $(document).on('click', '#hazardMinusButton', function () {
        var result = $("#select-result").text();
        $("#hazardSelList #" + result).remove();
    })

    $(document).on('click', '#hazardPlusButton', function () {
        var selectedValue = $("#hazardSubstances").find("option:selected").text();
        var index = $("#hazardSelList").children().length + 1;
        var element = '<li class="ui-widget-content list-group-item" title="Please select an item to delete it" id="' + index + '">' + selectedValue + '</li>';
        $("#hazardSelList").append(element);
    })

    $.getJSON("substances", function (data) {
        $.each(data, function (index, text) {
            $('#hazardSubstances').append(
                $('<option></option>').val(index).html(text.descriptionp + " ------ " + text.description1)
            );
        });
    });

})();