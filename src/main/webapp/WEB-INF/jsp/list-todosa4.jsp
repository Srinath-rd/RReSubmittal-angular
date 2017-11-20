<div>
    <h5 class="bold">Impacts to the Environment Information:</h5>

    <div id="errorDiv">

        <span style="display: none" class="errorMessage" id="errorMessage"></span>
    </div>

    <br> <label>Impacts to the environment (Please select from the list below and click on add button)</label> <span
        id="impact-select-result" style="display: none;">none</span>


    <div class="form-group row">
        <div class="col-xs-10">
            <select class="form-control form-control-sm input-sm" id="envImpacts">
            </select>
        </div>
        <div class="col-xs-2">
            <button type="button" class="btn-md btn-info btn-md"
                    id="envImpactPlusButton">
                Add
                <!-- 				<span class="glyphicon glyphicon-plus-sign"></span> -->
            </button>
            <button type="button" class="btn-md btn-danger btn-md"
                    id="envImpactMinusButton">
                Remove
                <!-- 				<span class="glyphicon glyphicon-minus-sign"></span> -->
            </button>

        </div>


    </div>
    <div class="form-group">
        <div id="checkImpactProb">
            <label class="radio-inline control-label"> <input id="radio1"
                                                              name="chkimpact-input" type="radio" value="Potential">
                Potential
            </label> <label class="radio-inline control-label"> <input
                id="radio2" name="chkimpact-input" type="radio" value="Known"> Known
        </label>
        </div>
    </div>
    <label>Please select an item to delete it</label>
    <ol class="selectable list-group" id="envImpactList" style="height: 200px; overflow: scroll;">
    </ol>
    <br> <br>


    <div id="lab-results">
        <label>Lab results:</label>
        <div class="form-group">
            <label class="checkbox-inline custom-control">
                <input type="checkbox" id="labResultsMailChkbox" value="">I will mail/email the lab results
            </label>
            <label class="checkbox-inline custom-control">
                <input type="checkbox" id="labResultsAttchmntChkbox" value="">I will attach the lab results right now
            </label>
        </div>
    </div>

    <div id="more-info" style="display: block">

        <div>

            <input id="fileupload" type="file" name="files[]" data-url="upload" multiple>

            <div id="dropzone" class="fade well">Drop files here</div>

            <div id="progress" class="progress">
                <div class="progress-bar bar" role="progressbar" style="width: 0%;"></div>
            </div>

            <table id="uploaded-files" class="table">
                <tr>
                    <th>File Name</th>
                    <th>File Size</th>
                    <th>File Type</th>
                    <th>Download</th>
                </tr>
            </table>

        </div>
    </div>

    <!-- 	`<div id="more-info"> -->
    <!-- 		<label>Contamination was discovered as result of </label> -->
    <!-- 		<div class="form-group row"> -->
    <!-- 			<div class="col-xs-3 checkbox"> -->
    <!-- 				<label><input type="checkbox" name="optradio" -->
    <!-- 					id="underGround" class="genericHazardType input-sm">Tank -->
    <!-- 					Closure assessment</label> -->

    <!-- 			</div> -->


    <!-- 		</div> -->
    <!-- 		<label class="col-xs-1">Date:</label> -->
    <!-- 		<div class="col-xs-1 input-group date" id="datetimepicker1"> -->
    <!-- 			<input type='text' class="form-control input-sm" id="datepickerui" /> -->
    <!-- 		</div> -->

    <!-- 		<div class="form-group row"> -->


    <!-- 			<div class="col-xs-3 checkbox"> -->
    <!-- 				<label><input type="checkbox" name="optradio" -->
    <!-- 					id="aboveGroundPetrol" class="genericHazardType input-sm">Site -->
    <!-- 					Assessment</label> -->
    <!-- 			</div> -->


    <!-- 		</div> -->

    <!-- 		<label class="col-xs-1">Date:</label> -->
    <!-- 		<div class="col-xs-1 input-group date" id="datetimepicker1"> -->
    <!-- 			<input type='text' class="form-control input-sm" id="datepickerui" /> -->
    <!-- 		</div> -->

    <!-- 		<div class="form-group row"> -->

    <!-- 			<div class="col-xs-3  checkbox"> -->
    <!-- 				<label><input type="checkbox" name="optradio" -->
    <!-- 					class="input-sm" id="otherHazardType">Other</label> -->
    <!-- 				<textarea class="form-control form-control-sm input-sm" rows="2" -->
    <!-- 					cols="3" id="hazardTypeTextArea" style="display: none;" -->
    <!-- 					placeholder="Please enter the release type"></textarea> -->
    <!-- 			</div> -->

    <!-- 		</div> -->

    <!-- 		<label class="col-xs-1">Date:</label> -->
    <!-- 		<div class="col-xs-1 input-group date" id="datetimepicker1"> -->
    <!-- 			<input type='text' class="form-control input-sm" id="datepickerui" /> -->
    <!-- 		</div> -->

    <!-- 	</div> -->

    <!-- 	<br> -->


    <!-- 		</div> -->

    <br>

    <div class="form-horizontal text-center">
        <button type="submit" value="Cancel" name="_cancel"
                class="btn-md btn-primary " id="cancel">Cancel
        </button>
        <button type="submit" value="Cancel" name="_cancel"
                class="btn-md btn-primary " id="impctsInfoToHzrdInfoBtn">Previous
        </button>
        <button type="submit" value="Next" name="_target1"
                class="btn-md btn-primary" id="impctsInfoToCauseInfoBtn">Next
        </button>
    </div>

    <!-- 	</div> -->


</div>
