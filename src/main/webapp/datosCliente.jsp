<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
</style>
<script src="<%=request.getContextPath()%>/scripts/jquery/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/jquery/localization/messages_es.min.js"></script>

<title>Datos del Cliente</title>
<link rel="stylesheet" href="css/estiloForm.css">
</head>
<body>
	<form class="form" id="formCliente" action="<%=request.getContextPath()%>/GuardarDatosCliente" method="post">
	<h1>Ingrese sus datos</h1>

		<input type="hidden" name="id" value="<%=request.getParameter("id")%>" />
		<!-- Guarda el id del auto que el cliente eligió -->
		<!-- Oculto el ID del auto reservado para que el usuario no tenga que ver ese dato ya que no es imporatnte para el.
		Se le pasa el Id para que el servlet "GuardarDatosCliente" puede saber qué auto está reservando/comprando el cliente -->

		<div class="form-group">
			<label for="nombre">Nombre: </label> <input type="text"
				class="form-control" id="nombre" required name="nombre"
				placeholder="Ingrese su nombre">
		</div>

		<div class="form-group">
			<label for="apellido">Apellido:</label><input type="text"
				class="form-control" id="apellido" required name="apellido"
				placeholder="Ingrese su apellido">
		</div>

		<div class="form-group">
			<label for="correo">Correo:</label> <input type="email"
				class="form-control" id="correo" required name="correo"
				placeholder="Ingrese su email">
		</div>

		<div class="form-group">
			<label for="dni">DNI:</label> <input type="text" class="dni" id="dni" required
				name="dni" placeholder="Ingrese su dni">
		</div>
			
			<div class="form-group">
				<label for="codigo_postal">Código postal:</label> <input type="text"
					class="codigo_postal" id="codigo_postal" required name="codigo_postal"
					placeholder="Ingrese su codigo postal">
			</div>

			<div class="form-group">
				<label for="dato_tarjeta">Dato tarjeta:</label> <input type="text"
					class="dato_tarjeta" id="dato_tarjeta" required name="dato_tarjeta"
					placeholder="Ingrese su numero de tarjeta">
			</div>

			<div class="form-group">
				<label for="telefono">Teléfono:</label> <input type="text"
					class="telefono" id="telefono" required name="telefono"
					placeholder="Ingrese su numero de telefono">
			</div>

			<button type="submit">Enviar</button>
	</form>
	
<!-- JQUERY VALIDATION -->
<script>
  $(document).ready(function () {
    $("#formCliente").validate({
      rules: {
        nombre: {
          required: true,
          minlength: 2
        },
        apellido: {
          required: true,
          minlength: 2
        },
        correo: {
          required: true,
          email: true
        },
        dni: {
          required: true,
          digits: true,
          minlength: 7,
          maxlength: 8
        },
        codigo_postal: {
          required: true,
          digits: true
        },
        dato_tarjeta: {
          required: true
          digits: true
        },
        telefono: {
          required: true,
          digits: true,
          minlength: 7,
          maxlength: 15
        }
      },
      messages: {
    	nombre: {
    		required: "Por favor, ingrese su nombre.",
    		minlength: "El nombre debe tener al menos 2 caracteres"
    	},
        apellido: {
    		required: "Por favor, ingrese su apellido.",
    		minlength: "El modelo debe tener al menos 2 caracteres"
    	},
    	correo: {
    		required: "Por favor, ingrese su correo.",
    		email: "Ingrese un correo válido, por ejemplo: usuario@dominio.com"
    	},
    	dni: {
    		required: "Por favor, ingrese su DNI.",
    		digits: "Solo se permiten números",
    		minlength: "El DNI debe tener al menos 7 dígitos",
    	    maxlength: "El DNI no puede tener más de 8 dígitos"
    	},
        codigo_postal: {
    		required: "Por favor, ingrese su código postal.",
    		digits: "Solo se permiten números"
    	},
        dato_tarjeta: {
    		required: "Por favor ingrese el número de tarjeta",
    		digits: "Solo se permiten números"
    	},
        telefono: {
    		 required: "Por favor ingrese un teléfono",
    	     digits: "Solo se permiten números",
    	     minlength: "El teléfono debe tener al menos 7 dígitos",
    	     maxlength: "El teléfono no puede tener más de 15 dígitos"
    	}
      },
      errorElement: "div", //coloca el error en cada div
      errorClass: "invalid-feedback", 
      highlight: function (element) {
        $(element).addClass("is-invalid"); //agrega la clase is-invalid al campo que tiene un error.
      },
      unhighlight: function (element) {
        $(element).removeClass("is-invalid"); //quita la clase is-invalid cuando el campo se vuelve válido nuevamente.
      }
    });

    });
</script>
	
	
</body>

</html>
