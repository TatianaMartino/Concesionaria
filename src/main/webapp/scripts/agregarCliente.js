$(function() { //peticion ajax al controller para agregar un clinte

	$("#btn-confirmar").click(function(e) {
		e.preventDefault();
		var nombre = $("#nombre").val();
		//
		var apellido = $("#apellido").val();
		var correo = $("#correo").val();
		var dni = $("#dni").val();
		var codigo_postal = $("#codigo_postal").val();
		var dato_tarjeta = $("#sucursal_id").val();
		var telefono = $("#telefono").val();


		$.ajax({
			url: contextPath + '/CrearCliente',
			dataType: 'json',
			success: function(data) {
				Swal.fire({
					title: 'Guardado con exito!',
					text: 'El cliente se ha guardado exitosamente',
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
					text: 'No se pudo guardar el cliente',
					icon: 'error'
				});
			},
			data: {
				nombre: nombre,
				apellido: apellido,
				correo: correo,
				dni: dni,
				codigo_postal: codigo_postal,
				dato_tarjeta: dato_tarjeta,
				telefono: telefono
			},
			cache: true,
			type: 'post'
		});
	});
});
