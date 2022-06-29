var id = document.getElementById('id');
var clave = document.getElementById('clave');
var error = document.getElementById('error');
error.style.color = 'red';

function sesion(){
	console.log('Iniciando...');
	
	
	var mensajeError = [];
	
	if(id.value == null || id.value === '0'){
		mensajeError.push('ingrese el id');
	}
	
	if(clave.value == null || clave.value === ''){
		mensajeError.push('ingrese la clave');
	}
	
	error.innerHTML = mensajeError.join('<br> ');
	
	return false;
}