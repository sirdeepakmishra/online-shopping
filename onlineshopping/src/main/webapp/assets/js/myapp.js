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
		
	default:
		$('#product').addClass('active');
	$('#a_'+menu).addClass('active');
		break;	
	
	}
	
	
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
		
	}
	
	
})