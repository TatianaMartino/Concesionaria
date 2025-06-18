$(function() {
	$("#btn-logout").click(function(e) {
		e.preventDefault();

		$.ajax({
			url: contextPath + "/LogOut",
			type: "get",
			dataType: "json",
			success: function(data) {
				Swal.fire({
					title: 'Sesion cerrada!',
					text: 'La sesion se ha cerrado exitosamente',
					icon: 'success',
					position: 'top-end',
					showConfirmButton: false,
					timer: 1500
				});

				setTimeout(function() {
					window.location.href = contextPath + "/login.jsp";
				}, 1500);
			},
			error: function(xhr, status, error) {
				Swal.fire({
					title: 'Error',
					text: 'No se pudo cerrar la sesiOn',
					icon: 'error'
				});
			}
		});
	});
}); 
