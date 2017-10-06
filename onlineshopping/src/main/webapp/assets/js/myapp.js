$(function(){
	
	
	//solving the active menu
	switch(menu){
	
	case 'About Us':
		$('#about').addClass('active');
		break;
		
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
		
	case 'Home':
		$('#home').addClass('active');
		break;
		
	case 'All Products':
		$('#product').addClass('active');
		break;
		
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
		
	default:
		$('#product').addClass('active');
	$('#a_'+menu).addClass('active');
		break;	
	
	}//menu end
	
	
	//code for jquery datatable
	//create a dataset
	
/*	var products=[
		
		["1","ABC"],
		["2","XYZ"],
		["3","PQR"],
		["4","MNO"],
		["5","STU"],
		["6","WXY"],
	];*/
	
	var jsonUrl='';
	if(window.categoryId==''){
		jsonUrl=window.contextRoot+'/json/data/all/products';
	}
	
	else{
		
		jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
	}
	
	
	
	//datatable code
	var $table=$('#plt');
	
	//execute the below code only where we have this table
	if($table.length){
		console.log("inside table!!!");
		
		
		$table.DataTable({
			
			lengthMenu:[[3,5,10,-1],["3 Rec","5 Rec","10 Rec","All"]],
			pageLength:5,
			//data:products
			
			ajax:{
				url:jsonUrl,
				dataSrc:''		
			},
			
			columns:[
				
				{
					data:'code',
					bSortable:false,
					mRender:function(data,type,row){
						return ' <img src="'+window.contextRoot+'/resources/images/'+data+'.jpg"  class="dataTableImg"/>';
					}	
				},
				
				
				{
					data:'name'
				},
				
				{
					data:'brand'
				},
				
				{
					data:'unitPrice',
					mRender:function(data,type,row){
						return '&#8377;  '+data
					}
				},
				
				{
					data:'quantity',
						mRender:function(data,type,row){
							if(data < 1){
								return '<span style="color:red;">Out of stock!</span>';
							}
							
							return data;
							
						}
				},
				
				{
					data:'id',
					bSortable:false,
					mRender:function(data,type,row){
						
						var str='';
						str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						
						if(row.quantity < 1){
							str+='<a href="javascript:void(0)"class="btn btn-success disabled" ><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
						else{
							str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product"class="btn btn-success" ><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
						
						
						
						return str;  
					}
				}
			]
			
			
			
		});
		
	}//end table length
	
	//dismiss the alert after 4 sec
	
	var $alert = $('.alert');
	
	if($alert.length){
		
		setTimeout(function(){ $alert.fadeOut('slow'); },4000)
	}
	
	//---------------toggle swith bootbox--------------------
	
	$('.switch input[type="checkbox"]').on('change',function(){
		
		var checkbox=$(this);
		var checked = checkbox.prop('checked');
		var dMsg=(checked)? 'Are you want to activate the Product?':'Are you want to deActivate the Product?';
		var value=checkbox.prop('value');
		bootbox.confirm({
			size:'medium',
			title:'Product Activation & DeActivation',
		message:dMsg,
		callback:function(confirmed){
			if(confirmed){
				console.log(value);
				bootbox.alert({
					size:'medium',
					title:'Information', 
					message:'You are going to perform operation on product'+value
					});	
			}else{
				
				checkbox.prop('checked',!checked);
			}
		}
			
		});
	});
	
	//=====================================================================
	//datatable for ADMIN
	//=====================================================================
	
	//datatable code
	var $adminProductsTable=$('#adminProductsTable');  //id comes from manageproduct.jsp
	
	//execute the below code only where we have this table
	if($adminProductsTable.length){
		//console.log("inside table!!!");
		
		//context root coming from --------page.jsp
		///json/data/admin/all/products ----coming form jsonDataController
		var jsonUrl=window.contextRoot+'/json/data/admin/all/products';
		
		$adminProductsTable.DataTable({
			
			lengthMenu:[[10,30,50,-1],["10 Records","30 Records","50 Records","All"]],
			pageLength:30,
			//data:products
			
			ajax:{
				url:jsonUrl,
				dataSrc:''		
			},
			
			columns:[
				
				{
					data:'id',
					
				},
				
				
				{
					data:'code',
					bSortable:false,
					mRender:function(data,type,row){
						return ' <img src="'+window.contextRoot+'/resources/images/'+data+'.jpg"  class="adminDataTableImg"/>';
						//class="adminDataTableImg" coming from manageproduct.jsp ->line no.192
					}	
				},
				
				
				{
					data:'name'
				},
				
				{
					data:'brand'
				},
				
				
				{
					data:'quantity',
						mRender:function(data,type,row){
							if(data < 1){
								return '<span style="color:red;">Out of stock!</span>';
							}
							
							return data;
							
						}
				},
				
				{
					data:'unitPrice',
					mRender:function(data,type,row){
						return '&#8377;  '+data
					}
				},
				
				{
					data:'active',
					
				bSortable:false,
					mRender:function(data,type,row){
						var str='';
							
			str +='<label class="switch">';
		if(data){
			
			str +='	<input type="checkbox" checked="checked" value="'+row.id+'"/>';
			
		}else{
			
			str +='	<input type="checkbox"  value="'+row.id+'"/>';
		}
			
			
			str +='	<div class="slider"></div> </label>';
							
						
						return str;
					}
					
					
					
				},
				
				{
					data:'id',
					bSortable:false,
					mRender:function(data,type,row){
						 var str='';
						 
						 str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">'; 
						str += '<span class="glyphicon glyphicon-pencil"></span></a>';
						 
						 return str;
						
					}
					
					
				}
			],
			
			
			initComplete:function(){
				
				var api=this.api();
				api.$('.switch input[type="checkbox"]').on('change',function(){
					
					var checkbox=$(this);
					var checked = checkbox.prop('checked');
					var dMsg=(checked)? 'Are you want to activate the Product?':'Are you want to deActivate the Product?';
					var value=checkbox.prop('value');
					bootbox.confirm({
						size:'medium',
						title:'Product Activation & DeActivation',
					message:dMsg,
					callback:function(confirmed){
						if(confirmed){
							console.log(value);
							
							var activationURL=window.contextRoot + '/manage/product/'+value+'/activation';
							$.post(activationURL,function(data){
							
								bootbox.alert({
									size:'medium',
									title:'Information', 
									message:data   //ye data management controller se aayega aur activation url me set hoga
									});	
								
							})
							
							
						}else{
							
							checkbox.prop('checked',!checked);
						}
					}
						
					});
				});
			}
			
			
			
		});
		
	}//end table length
	
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//validation code for category client side validation
	var categoryForm =$('#categoryForm');
	if(categoryForm.length==0){
		
		console.log('hhhhhhhhhhhhhhhhh'),
		$categoryForm.validate({
			
			rules:{
				
				name : {
					required:true,
					minlength:2
						},
						
				description : {
					required:true
					}
			},
			
			messages: {
				
				name : {
					required:'Please add the category name!',
					minlength:'the category name should not be less than 2 character!'
						},
						
				description : {
					required:'Please add description for category !'
					}
				
			},
			errorElement: 'em',
			errorPlacement: function(error,element){
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}
		});
		
		
	}
	//---------------------------------------------------------------------------------------
	
	
	
})