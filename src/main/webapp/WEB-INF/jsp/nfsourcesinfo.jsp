<div>
    <h6 class="bold">Federal Energy Act Requirements:</h6>
    <br>

    <div class="form-group">
        <label>For all confirmed releases from USTs occurring after
            9/30/2007 please provide the following information:</label>
        <br>
        <label> <input
                type="checkbox" id="energyDetailsCheckBox"> Please check box if it does not apply.
        </label> <br>

        <div id="energyDetails">
            <br> <label>Select Source (Please select from the list below and click on add button)</label><span
                id="source-select-result" style="display: none;">none</span>
            <div class="form-group row">
                <div class="col-xs-10">
                    <select class="form-control form-control-sm input-sm"
                            id="hzrd-sources">
                        <option value="0">Tank</option>
                        <option value="1">Piping</option>
                        <option value="2">Dispenser</option>
                        <option value="3">Submersible Turbine Pump</option>
                        <option value="4">Delivery Problem</option>
                        <option value="5">Other</option>
                    </select>
                </div>
                <div class="col-xs-2">
                    <button type="button" class="btn btn-xs btn-info"
                            id="hzrd-source-plus-button">
                        Add
                        <!-- 				<span class="glyphicon glyphicon-plus-sign"></span> -->
                    </button>
                    <button type="button" class="btn btn-xs btn-danger"
                            id="hzrd-source-minus-button">
                        Remove
                        <!-- 				<span class="glyphicon glyphicon-minus-sign"></span> -->
                    </button>

                </div>
            </div>
            <label>Please select an item to delete it</label>
            <ol class="selectable list-group" id="hzrd-source-list" style="height: 200px; overflow: scroll;">
            </ol>
            <br>
            <br>
            <label>Select cause (Please select from the list below and click on add button)</label><span
                id="cause-select-result" style="display: none;">none</span>
            <div class="form-group row">
                <div class="col-xs-10">
                    <select class="form-control form-control-sm input-sm"
                            id="hzrd-causes">
                        <option value="0">Spill</option>
                        <option value="1">Overfill</option>
                        <option value="2">Corrosion</option>
                        <option value="3">Physical or Mechanical Damage</option>
                        <option value="4">Installation Problem</option>
                        <option value="5">Other</option>
                        <option value="6">Unknown</option>
                    </select>
                </div>
                <div class="col-xs-2">
                    <button type="button" class="btn-info btn btn-xs"
                            id="hzrd-cause-plus-button">
                        Add
                        <!-- 				<span class="glyphicon glyphicon-plus-sign"></span> -->
                    </button>
                    <button type="button" class="btn-danger btn btn-xs"
                            id="hzrd-cause-minus-button">
                        Remove
                        <!-- 				<span class="glyphicon glyphicon-minus-sign"></span> -->
                    </button>

                </div>

            </div>

            <label>Please select an item to delete it</label>
            <ol class="selectable list-group" id="hzrd-cause-list" style="height: 200px; overflow: scroll;">
            </ol>
        </div>


    </div>
    <br>
    <div class="form-horizontal text-center">
        <button type="submit" value="Cancel" name="_cancel"
                class="btn btn-xs btn-primary " id="cancel">Cancel
        </button>
        <button type="submit" value="Cancel" name="_cancel"
                class="btn btn-xs btn-primary " id="causeInfoToImpctsBtn">Previous
        </button>
        <button type="submit" value="Next" name="_target1"
                class="btn btn-xs btn-primary" id="submitNotifForm">Submit
        </button>
    </div>

</div>

