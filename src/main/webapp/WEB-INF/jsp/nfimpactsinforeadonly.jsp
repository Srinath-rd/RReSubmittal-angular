<div>
    <h5 class="bold">Impacts to the Environment Information:</h5>

    <div id="errorDiv">

        <span style="display: none" class="errorMessage" id="error-message"></span>
    </div>

    <br> <label>Impacts to the environment (Please select from the list below and click on add button)</label> <span
        id="impact-select-result" style="display: none;">none</span>


    <div class="form-group row">
        <div class="col-xs-10">
            <select class="form-control form-control-sm input-sm" id="envImpacts" disabled>
            </select>
        </div>


    </div>
    <div class="form-group">
        <div id="checkImpactProb">
            <label class="radio-inline control-label"> <input id="radio1"
                                                              name="chkimpact-input" type="radio" value="Potential" disabled>
                Potential
            </label> <label class="radio-inline control-label"> <input
                id="radio2" name="chkimpact-input" type="radio" value="Known" disabled> Known
        </label>
        </div>
    </div>
    <ol class="list-group" id="envImpactList" style="height: 200px; overflow: scroll; width: 60%">
    </ol>
    <br> <br>


    <div id="lab-results">
        <label>Lab results:</label>
        <div class="form-group">
            <label class="checkbox-inline custom-control">
                <input type="checkbox" id="labResultsMailChkbox" value="" disabled>I will mail/email the lab results
            </label>
            <label class="checkbox-inline custom-control">
                <input type="checkbox" id="labResultsAttchmntChkbox" value="" disabled>I will attach the lab results right now
            </label>
        </div>
    </div>

    <div id="more-info" style="display: block">

        <div>

            <table id="uploaded-files" class="table table-striped">
                <tr>
                    <th>File Name</th>
                    <th>File Size</th>
                    <th>File Type</th>
                    <th>Delete</th>
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


    <!-- 	</div> -->


</div>
