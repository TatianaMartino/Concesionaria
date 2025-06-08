$(function() { //peticion ajax al controller para agregar un auto

	$("#btn-confirmar").click(function(e) {
		e.preventDefault();
		var modelo = $("#modelo").val();
		var marca = $("#marca").val();
		var descripcion = $("#descripcion").val();
		var stock = $("#stock").val();
		var precio = $("#precio").val();
		var sucursal_id = $("#sucursal_id").val();
		var disponibilidad = $("#disponibilidad").val();


		$.ajax({
			url: contextPath + '/crearAuto',
			dataType: 'json',
			success: function(data) {
				Swal.fire({
					title: 'Guardado con exito!',
					text: 'El auto se ha creado exitosamente',
					icon: 'success',
					position: 'top-end',
					showConfirmButton: false,
					timer: 1500
				});

				// Redirigir después del mensaje (espera 1.5 segundos)
				setTimeout(function() {
					window.location.href = contextPath + '/LeerAuto';
				}, 1500);
			},
			error: function(xhr, status, error) {
				Swal.fire({
					title: 'Error',
					text: 'No se pudo crear el auto',
					icon: 'error'
				});
			},
			data: {
				modelo: modelo,
				marca: marca,
				descripcion: descripcion,
				stock: stock,
				precio: precio,
				sucursal_id: sucursal_id,
				disponibilidad: disponibilidad
			},
			cache: true,
			type: 'post'
		});
	});
});
