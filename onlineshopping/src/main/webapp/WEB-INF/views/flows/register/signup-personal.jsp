<%@include file="../shared/flows-header.jsp"%>


<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>



<!-- Page Content -->

<div class="content">

	<div class="container">

		<!--  -->



<div class="col-md-offset-2 col-md-8">

	<div class="panel panel-primary">
		<div align="center" class="panel-heading">
			<h4>Sign Up</h4>
		</div>

		<div class="panel-body">
			<!-- FORM ELEMENT -->
			<sf:form class="form-horizontal" modelAttribute="userVar"
				action="" method="POST"
				id="registerForm">

				<div class="form-group">
					<label class="control-label col-md-4" for="firstName">First
						Name:</label>
					<div class="col-md-8">
						<sf:input type="text" path="firstName" placeholder="First Name"
							class="form-control" />
						<sf:errors path="firstName" cssClass="help-block" element="em" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-4" for="lastName">Last
						Name:</label>
					<div class="col-md-8">
						<sf:input type="text" path="lastName" placeholder="Last Name"
							class="form-control" />
						<sf:errors path="lastName" cssClass="help-block" element="em" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-4" for="email">Email:</label>
					<div class="col-md-8">
						<sf:input type="text" path="email" placeholder="abc@xyz.com"
							class="form-control" />
						<sf:errors path="email" cssClass="help-block" element="em" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-md-4" for="contactNumber">Contact
						Number:</label>
					<div class="col-md-8">
						<sf:input type="text" path="contactNumber"
							placeholder="XXXXXXXXXX" class="form-control" />
						<sf:errors path="contactNumber" cssClass="help-block"
							element="em" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-md-4" for="password">password:</label>
					<div class="col-md-8">
						<sf:input type="password" path="password" placeholder="password"
							class="form-control" />
						<sf:errors path="password" cssClass="help-block" element="em" />
					</div>
				</div>
				
				
				
				<div class="form-group">
					<label class="control-label col-md-4" for="confirmPassword">Confirm Password:</label>
					<div class="col-md-8">
						<sf:input type="password" path="confirmPassword" placeholder="Re-enter Password"
							class="form-control" />
						<sf:errors path="confirmPassword" cssClass="help-block" element="em" />
					</div>
				</div>


					<!-- radio -->
				<div class="form-group">
					<label class="control-label col-md-4" >Select Role:</label>
					<div class="col-md-8">
						<label class="radio-inline">
						<sf:radiobutton path="role"  value="USER" checked="checked"/>User
						</label>
						<label class="radio-inline">
						<sf:radiobutton path="role"  value="SUPPLIER" />Supplier
						</label>
					</div>
				</div>

				<!-- button -->

				<div class="form-group">

					<div class="col-md-offset-4 col-md-8">
					
					
					<button type="submit" class="btn btn-primary" name="_eventId_gotoBillingView">
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

