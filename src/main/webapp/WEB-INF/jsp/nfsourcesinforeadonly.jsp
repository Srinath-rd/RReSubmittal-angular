<div>
    <h6 class="bold">Federal Energy Act Requirements:</h6>
    <br>

    <div class="form-group">
        <label>For all confirmed releases from USTs occurring after
            9/30/2007 please provide the following information:</label>
        <br>
        <label> <input
                type="checkbox" id="energyDetailsCheckBox" disabled> Please check box if it does not apply.
        </label> <br>

        <div id="energyDetails">
            <br> <label>Select Source (Please select from the list below and click on add button)</label><span
                id="source-select-result" style="display: none;">none</span>
            <div class="form-group row">
                <div class="col-xs-10">
                    <select class="form-control form-control-sm input-sm"
                            id="hzrd-sources" disabled>
                        <option value="0">Tank</option>
                        <option value="1">Piping</option>
                        <option value="2">Dispenser</option>
                        <option value="3">Submersible Turbine Pump</option>
                        <option value="4">Delivery Problem</option>
                        <option value="5">Other</option>
                    </select>
                </div>
                <div class="col-xs-2">
                </div>
            </div>
            <label>Please select an item to delete it</label>
            <ol class="list-group" id="hzrd-source-list" style="height: 200px; overflow: scroll; width: 60%;">
            </ol>
            <br>
            <br>
            <label>Select cause (Please select from the list below and click on add button)</label><span
                id="cause-select-result" style="display: none;">none</span>
            <div class="form-group row">
                <div class="col-xs-10">
                    <select class="form-control form-control-sm input-sm"
                            id="hzrd-causes" disabled>
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

                </div>

            </div>

            <label>Please select an item to delete it</label>
            <ol class=" list-group" id="hzrd-cause-list" style="height: 200px; overflow: scroll; width: 60%">
            </ol>
        </div>


    </div>
    <br>

</div>

