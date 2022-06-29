function reporte(){
	
	var fecha1 = document.getElementById("fecha").value;
	var fecha2 = document.getElementById("fecha1").value;
	var tip0 = document.getElementById("tipo").value;
	
	
	window.open("http://localhost:8080/report/ventas/download?fechaInicio="+fecha1+"&fechaFin="+fecha2+"&tipo="+tip0);
	
}

function inventario(){
	
	
	var tip0 = "PDF";
	
	
	window.open("http://localhost:8080/report/ventas/download2?tipo="+tip0);
	
}

function reporte3(){
	
	var fecha1 = document.getElementById("fecha").value;
	var fecha2 = document.getElementById("fecha1").value;
	var tip0 = document.getElementById("tipo").value;
	
	
	window.open("http://localhost:8080/report/ventas/download3?fechainicio="+fecha1+"&fechafin="+fecha2+"&tipo="+tip0);
	
}

function reporte4(){
	
	var fecha1 = document.getElementById("fecha").value;
	var fecha2 = document.getElementById("fecha1").value;
	var tip0 = document.getElementById("tipo").value;
	
	
	window.open("http://localhost:8080/report/ventas/download4?fechainicio="+fecha1+"&fechafin="+fecha2+"&tipo="+tip0);
	
}

