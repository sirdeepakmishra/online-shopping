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
	
})