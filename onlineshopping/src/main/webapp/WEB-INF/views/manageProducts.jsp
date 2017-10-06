<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container">

	<div class="row">

		<c:if test="${not empty msg}">
			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${msg}
				</div>


			</div>
		</c:if>




		<c:if test="${not empty msgWarn}">
			<div class="col-xs-12">

				<div class="alert alert-warning alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${msgWarn}
				</div>


			</div>
		</c:if>



		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">
				<div align="center" class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-body">
					<!-- FORM ELEMENT -->


					<!--same name rahega (productFromMC) controller me bhi -->
					<sf:form class="form-horizontal" modelAttribute="productFromMC"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description:</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price: &#8377</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price " class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Quantity:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>




						<!--FILE UPLOAD  -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="" />
								<sf:errors path="file" cssClass="help-block" element="em" />
								<!-- <em class="help-block" >Please Enter Quantity!</em> -->
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categoriesForMPjsp}"
									itemLabel="name" itemValue="id" />

								<!-- modelattribute==productFromMC isiliye c:if me (productFromMC) -->

								<c:if test="${productFromMC.id == 0}">
									<div class="text-right">

										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-xs">
											Add Category</button>


									</div>
								</c:if>




							</div>
						</div>
						<!-- button -->

						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="submit"
									class="btn btn-success" />


								<sf:hidden path="id"></sf:hidden>
								<sf:hidden path="code"></sf:hidden>
								<sf:hidden path="supplierId"></sf:hidden>
								<sf:hidden path="active"></sf:hidden>
								<sf:hidden path="purchases"></sf:hidden>
								<sf:hidden path="views"></sf:hidden>

							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>





	<!-- datatable for admin -->

	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />
		</div>


		<div class="col-xs-12">
			<div style="overflow: auto">

				<!--product table for admin (ID send to myapp.js) -->
				<table id="adminProductsTable"
					class="table table-striped table-bordered teble-responsive">

					<thead>
						<tr>
							<th>ID</th>
							<th>&nbsp;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>

					<%-- 			 		<tbody>
						<tr>
							<td>4</td>
							<td>
							<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg" alt="Macbook Pro"/>
							</td>
							<!--  class="adminDataTableImg" is used in myapp.js in a column-->
							
							<td>Macbook Pro</td>
							<td>apple</td>
							<td>2</td>
							<td>&#8377;	54000.00 /-</td>
							
							<td>
							<!-- toggle switch -->
							<label class="switch">
							<input type="checkbox" checked="checked" value="4"/>
							<div class="slider"></div>
							</label>
							</td>
							
							<td>
							<a href="${contextRoot}/manage/4/product" class="btn btn-warning" >
							<span class="glyphicon glyphicon-pencil"></span>
							</a>
							</td>
						</tr>
						
						<tr>
							<td>4</td>
							<td>
							<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg" alt="Macbook Pro"/>
							</td>
							<td>Macbook Pro</td>
							<td>apple</td>
							<td>2</td>
							<td>&#8377;	54000.00 /-</td>
							
							<td>
							<!-- toggle switch -->
							<label class="switch">
							<input type="checkbox"  value="4"/>
							<div class="slider"></div>
							</label>
							</td>
							
							<td>
							<a href="${contextRoot}/manage/4/product" class="btn btn-warning" >
							<span class="glyphicon glyphicon-pencil"></span>
							</a>
							</td>
							
						</tr>
					</tbody> 
 --%>


					<tfoot>
						<tr>
							<th>ID</th>
							<th>&nbsp;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>



				</table>

			</div>

		</div>

	</div>


	<div style="margin-top: 4%;" class="modal fade" id="myCategoryModal"
		role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">

					<h4 align="left" class="modal-title">Add New Category</h4>

					<button style="margin-left: 50%" type="button" class="close"
						data-dismiss="modal" aria-label="close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<!--Modal Body  -->

				<div class="modal-body">

					<!--CATEGORY FORM  -->
					<sf:form id="categoryForm" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST"
						class="form-horizontal">

						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category
								Name</label>
							<div class="col-md-8  validate">
								<sf:input type="text" path="name" id="category_name"
									class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<label for="cat_description" class="control-label col-md-4">Category
								Description</label>
							<div class="col-md-8  validate">
								<sf:textarea cols="" rows="5" path="description"
									id="cat_description" class="form-control" />
							</div>
						</div>
						
						
						<div class="form-group">	
							<div class="col-md-offset-4 col-md-8">
							<input type="submit" value="Add Category" class="btn btn-primary btn-sm"/>	
							</div>
						</div>


					</sf:form>

				</div>


			</div>
		</div>
	</div>


</div>