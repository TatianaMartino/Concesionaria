$(function() {
	$("#btn-login").click(function(e) {
		e.preventDefault();
		var usuario = $("#usuario").val();
		var password = $("#password").val();
		$.ajax({
			url: contextPath + '/Ingresar',
			dataType: 'json',
			success: function(data) {
				alert(data.mensaje);
				window.location.href = contextPath + '/LeerAuto';
			},
			error: function(data) {
				alert(data.responseJSON.mensaje);
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