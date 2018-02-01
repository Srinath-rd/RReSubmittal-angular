<div>

    <h5 class="bold">Hazardous Substance Information:</h5>
    <br> <span id="select-result" style="display: none;">none</span> <label>Identify
    hazardous substance discharged (Please select from the list below and click on add button)</label>
    <div class="form-group row">
        <div class="col-xs-10">
            <select class="form-control form-control-sm input-sm"
                    id="hazardSubstancesSubList" disabled>
                <option value="0">Select from below</option>
                <option value="1">VOC: Tetralchloroethene</option>
                <option value="2">VOC: Trichloroethene</option>
                <option value="3">VOC: Chlorinated Solvent</option>
                <option value="4">VOC: Other</option>
                <option value="5">Metals: Arsenic</option>
                <option value="6">Metals: Chromium</option>
                <option value="7">Metals: Lead</option>
                <option value="8">Metals: Other</option>
                <option value="9">PFOS/PFOA</option>
                <option value="10">Petroleum: Diesel</option>
                <option value="11">Petroleum: Engine/Waste Oil</option>
                <option value="12">Fuel Oil</option>
                <option value="13">Gasoline</option>
                <option value="14">Hydraulic Oil</option>
                <option value="15">Jet Fuel</option>
                <option value="16">PAHs</option>
                <option value="17">Petroleum- Unknown Type</option>
                <option value="18">Other</option>
                <option value="19">Ag Chem</option>
                <option value="20">Ag Chem: Pesticides</option>
                <option value="21">Ag Chem: Fertilizer</option>
                <option value="22">Ag Chem: Anhydrous</option>
                <option value="23">Mineral Oil</option>
                <option value="24">PCBs</option>
                <option value="25">Industrial- Cyanide</option>
                <option value="26">Leachate</option>
                <option value="27">RCRA Hazardous Waste</option>
                <option value="28">Other</option>
                <option value="29">Unknown</option>
            </select>
        </div>

    </div>
    <label>The below list contains names of substances that may closely match the substance name you want to enter but can't find in the above list.
    Selecting 'Other' above will show complete list. </label>
    <div class="form-group row">

        <div class="col-xs-10">
            <select class="form-control form-control-sm input-sm"
                    id="hazardSubstances" disabled>

            </select>
        </div>
    </div>
    <label>Please select an item to delete it</label>
    <ol class="list-group" id="hazardSelList" style="
    height: 200px; overflow: scroll; width: 60%">
    </ol>


    <br>
</div>

