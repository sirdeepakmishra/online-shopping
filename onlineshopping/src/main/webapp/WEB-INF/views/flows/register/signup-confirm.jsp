<%@include file="../shared/flows-header.jsp" %>



		<!-- Page Content -->

		<div class="content">
			
		<div class="row">
		
		
	<!-- column to display personal details -->
	<div class="col-sm-4 col-sm-offset-2">
	
	<div class="panel panel-primary">
	
	<div class="panel-heading">
	<h4>Personal Details</h4>
	</div>
	
	<div class="panel-body">
	
	<div class="text-center">
	
	<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
	
	<h5>Email: ${registerModel.user.email}</h5>
	
	<h5>Contact Number: ${registerModel.user.contactNumber}</h5>
		
	<h5>Role: ${registerModel.user.role}</h5>
	</div>
	
	</div>
	
	<div class="panel-footer">
	<a href="${flowExecutionUrl}&_eventId_gotoPersonalView" class="btn btn-primary">Edit</a>
	</div>
	
	</div>
	</div>
	
	
	
		<!-- column to display address -->
	<div class="col-sm-4">
	
	<div class="panel panel-primary">
	
	<div class="panel-heading">
	<h4>Billing Address</h4>
	</div>
	
	<div class="panel-body">
	
	<div class="text-center">
	
	<h4>${registerModel.billing.addressLineOne}</h4>
	<h4>${registerModel.billing.addressLineTwo}</h4>
	<h4>${registerModel.billing.city}-${registerModel.billing.postalCode}</h4>
	<h4>${registerModel.billing.state}-${registerModel.billing.country}</h4>

	</div>
	
	</div>
	
	<div class="panel-footer">
	<a href="${flowExecutionUrl}&_eventId_gotoBillingView" class="btn btn-primary">Edit</a>
	</div>
	
	</div>
	</div>

		</div>	
		
		
		<!-- to provide confirm button after displaying the details -->
		<div class="row">
		
		<div class="col-sm-4 col-sm-offset-4">
		
		<div class="text-center">
			<a href="${flowExecutionUrl}&_eventId_gotoSubmitActState" class="btn btn-primary">Confirm</a>
		
		</div>
		
		</div>
		
		</div>
		

		</div>

		
		
		<%@include file="../shared/flows-footer.jsp" %>

		