function myFunction(button) {
	var autoId = $(button).data('id');
	console.log('Id del auto a eliminar:', autoId);

	//agregamos sweet alert
	Swal.fire({
		title: "Esta seguro que desea eliminar el Auto?",
		text: "El auto sera eliminado!",
		icon: "warning",
		showCancelButton: true,
		confirmButtonColor: "#3085d6",
		cancelButtonColor: "#d33",
		confirmButtonText: "Si, estoy seguro!"
	}).then((result) => {
		if (result.isConfirmed) {
			//agregamos ajax
			$.ajax({
				type: "get",
				url: contextPath + "/AutoEliminar?id=" + autoId,
				dataType: "json",
				success: function(response) {
					//agregamos sweet alert
					Swal.fire({
						title: "Eliminado!",
						text: "El auto se elimino correctamente.",
						icon: "success",
						showConfirmButton: true,
					}).then(response => {
						if (response.isConfirmed) {
							location.reload();
						}
					})
					//fin sweet alert


				}
			});
			//fin ajax

		}
	});
}
