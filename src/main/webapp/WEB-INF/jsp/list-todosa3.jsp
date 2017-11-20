<div>

    <h5 class="bold">Hazardous Substance Information:</h5>
    <br> <span id="select-result" style="display: none;">none</span> <label>Identify
    hazardous substance discharged (Please select from the list below and click on add button)</label>
    <div class="form-group row">
        <div class="col-xs-10">
            <select class="form-control form-control-sm input-sm"
                    id="hazardSubstances">

            </select>
        </div>
        <div class="col-xs-2">
            <button type="button" class="btn-md btn-info btn-md"
                    id="hazardPlusButton">Add
            </button>
            <button type="button" class="btn-md btn-danger btn-md"
                    id="hazardMinusButton">
                Remove
                <!-- 					<span class="glyphicon glyphicon-minus-sign"></span> -->
            </button>
        </div>

    </div>
    <label>Please select an item to delete it</label>
    <ol class="selectable list-group" id="hazardSelList" style="height: 200px; overflow: scroll;">
    </ol>


    <br>
    <div class="form-horizontal text-center">
        <button type="submit" value="Cancel" name="_cancel"
                class="btn-md btn-primary " id="hzrdInfoCancelBtn">Cancel
        </button>
        <button type="submit" value="Previous" name="_previous"
                class="btn-md btn-primary " id="hzrdInfoToRespPartyInfoBtn">Previous
        </button>
        <button type="submit" value="Next" name="_target1"
                class="btn-md btn-primary " id="hzrdInfoToImpctsInfoBtn">Next
        </button>
    </div>
</div>

