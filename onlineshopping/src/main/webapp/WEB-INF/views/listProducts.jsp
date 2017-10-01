<div class="container">

	<div class="row">


		<!--display side bar  -->	
		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>



		<!--display products  -->
		<div class="col-md-9">
			<!--  Added breadcrumb component-->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true }">
						<script>
						window.categoryId='';
						</script>
						
						
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					
					
					
					<c:if test="${userClickCategoryProducts == true }">
						<script>
						window.categoryId='${singleCategory.id}';
						</script>
						
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${singleCategory.name}</li>
						</ol>
					</c:if>
					
					
				</div>
			</div>


		<div class="row ">
		
		<div class="col-xs-12 col-md-12 col-sm-12">
		
		
		<table id="plt" class="table table-striped table-bordered table-responsive">
		
		
		<thead>
		
		<tr>
		<th></th>
		<th>Name</th>
		<th>Brand</th>
		<th>Price</th>
		<th>Quantity</th>
		<th></th>
		
		</tr>
		
		</thead>
		
		<tfoot>
		
		<tr>
		<th></th>
		<th>Name</th>
		<th>Brand</th>
		<th>Price</th>
		<th>Quantity</th>
		<th></th>
		
		</tr>
		
		</tfoot>
	
		
		</table>
		
		</div>
		</div>


		</div>
	</div>
</div>