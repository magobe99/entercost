function borrar(id){
swal({
  title: "¿Esta seguro de eliminar?",
  text: "Si desea eliminar, borrará los datos permanentemente",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
		$.ajax({
			url:"/eliminarUsuario/"+id,
			success: function(res){
				console.log(res);
			}
		}).then((ok)=>{
			if(ok){
				location.href= "/tablausuario";
			}
		});
    swal("Se ha borrados los datos exitosamente!", {
      icon: "success",
    });
  } else {
    swal("La opción de borrar ha sido cancelada!");
  }
});

}