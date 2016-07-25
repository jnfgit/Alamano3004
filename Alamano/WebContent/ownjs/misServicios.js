function buttons(pend){
	if (pend == 1){
		document.getElementById("pendientes").style.display = "block";
		document.getElementById("anteriores").style.display = "none";	
		
		$('#btnAnteriores').addClass('btn-invert-primary');
		$('#btnPendientes').removeClass('btn-invert-primary');
	}else{
		document.getElementById("pendientes").style.display = "none";
		document.getElementById("anteriores").style.display = "block";	
		
		$('#btnPendientes').addClass('btn-invert-primary');
		$('#btnAnteriores').removeClass('btn-invert-primary');
	}
}