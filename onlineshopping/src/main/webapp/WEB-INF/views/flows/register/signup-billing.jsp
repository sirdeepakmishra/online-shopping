<%@include file="../shared/flows-header.jsp"%>


<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>



<!-- Page Content -->

<div class="content">

	<div class="container">

		<!--  -->



<div class="col-md-offset-2 col-md-8">

	<div class="panel panel-primary">
		<div align="center" class="panel-heading">
			<h4>SignUp Address</h4>
		</div>

		<div class="panel-body">
			<!-- FORM ELEMENT -->
			<sf:form class="form-horizontal" modelAttribute="billVar"
				action="" method="POST"
				id="registerForm">

				<div class="form-group">
					<label class="control-label col-md-4" >addressLineOne:</label>
					<div class="col-md-8">
						<sf:input type="text" path="addressLineOne" placeholder="addressLineOne"
							class="form-control" />
						<sf:errors path="addressLineOne" cssClass="help-block" element="em" />

					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-4" >addressLineTwo:</label>
					<div class="col-md-8">
						<sf:input type="text" path="addressLineTwo" placeholder="addressLineTwo"
							class="form-control" />
						<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />

					</div>
				</div>

				

				<div class="form-group">
					<label class="control-label col-md-4" >city:</label>
					<div class="col-md-8">
						<sf:input type="text" path="city" placeholder="city"
							class="form-control" />
						<sf:errors path="city" cssClass="help-block" element="em" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-md-4" >postalCode:</label>
					<div class="col-md-8">
						<sf:input type="text" path="postalCode"
							placeholder="XXXXXX" class="form-control" />
						<sf:errors path="postalCode" cssClass="help-block"
							element="em" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-md-4">state:</label>
					<div class="col-md-8">
						<sf:input type="text" path="state" placeholder="state"
							class="form-control" />
						<sf:errors path="state" cssClass="help-block" element="em" />
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="control-label col-md-4">country:</label>
					<div class="col-md-8">
						<sf:input type="text" path="country" placeholder="country"
							class="form-control" />
						<sf:errors path="country" cssClass="help-block" element="em" />
					</div>
				</div>


				

				<!-- button -->

				<div class="form-group">

					<div class="col-md-offset-4 col-md-8">
					
					<button type="submit" class="btn btn-primary" name="_eventId_gotoPersonalView">
					<span class="glyphicon glyphicon-chevron-left"></span>Previous-Personal
					</button>
					
					
					<button type="submit" class="btn btn-primary" name="_eventId_gotoConfirmView">
					Next-Billing<span class="glyphicon glyphicon-chevron-right"></span>
					</button>

					</div>
				</div>

			</sf:form>
				</div>
			</div>
		</div>

	</div>


</div>



<%@include file="../shared/flows-footer.jsp"%>

