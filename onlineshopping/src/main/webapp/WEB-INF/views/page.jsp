
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot ="${contextRoot}";
</script>

<!-- Bootstrap core CSS -->

<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap readable theme CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


<!-- datatable 4CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">



<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->

		<%@ include file="./shared/navbar.jsp"%>



		<!-- Page Content -->

		<div class="content">
			<!--load when click home content-->
			<c:if test="${userClickHome == true }">
				<%@ include file="home.jsp"%>
			</c:if>


			<!--load when user click about -->
			<c:if test="${userClickAbout == true }">
				<%@ include file="about.jsp"%>
			</c:if>


			<!--load when  user click contact -->
			<c:if test="${userClickContact == true }">
				<%@ include file="contact.jsp"%>
			</c:if>
			
			
			<!--load when user click AllProducts-->
			<c:if test="${userClickAllProducts == true  or userClickCategoryProducts == true }">
				<%@ include file="listProducts.jsp"%>
			</c:if>
			
			
			<!--load when user click Show Product-->
		<c:if test="${userClickShowProduct == true }">
				<%@ include file="singleProduct.jsp"%>
			</c:if>
			
			
			<!--load when user click manage Product-->
		<c:if test="${userClickManageProducts == true }">
				<%@ include file="manageProducts.jsp"%>
			</c:if>
			
		

		</div>

		<!-- /.container -->

		<!-- Footer comes here -->
		<%@ include file="./shared/footer.jsp"%>





		<!-- jquery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- jquery validate -->
		<script src="${js}/jquery.validate.js"></script>
		
		<script src="${js}/popper.min.js"></script>
		
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
			<!-- DATA TABLE plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
	
			<!-- DATA TABLE bootstrap -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		<!-- BOOT BOX  -->
		<script src="${js}/bootbox.min.js"></script>
		
		
		<!--self coded javascript  -->
		<script src="${js}/myapp.js"></script>
		
			


	</div>
</body>

</html>

