$(function() {
	$("#btn-login").click(function(e) {
		e.preventDefault();
		var usuario = $("#usuario").val();
		var password = $("#password").val();

		$.ajax({
			url: contextPath + '/Ingresar',
			dataType: 'json',
			success: function(data) {
				Swal.fire({
					title: 'Registrado con exito!',
					text: 'El usuario se ha registrado exitosamente',
					icon: 'success',
					position: 'top-end',
					showConfirmButton: false,
					timer: 1500
				});

				setTimeout(function() {
					window.location.href = contextPath + '/LeerAuto';
				}, 1500);
			},

			error: function(xhr, status, error) {
				Swal.fire({
					title: 'Error',
					text: 'No se pudo registrar el usuario',
					icon: 'error'
				});
			},

			data: {
				usuario: usuario,
				password: password,
			},
			cache: true,
			type: 'post'
		});
	});


});