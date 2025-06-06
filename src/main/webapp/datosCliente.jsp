<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
</style>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
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
				class="form-control" id="nombre" name="nombre"
				placeholder="Ingrese su nombre" required><span>(obligatorio)</span>
		</div>

		<div class="form-group">
			<label for="apellido">Apellido:</label><input type="text"
				class="form-control" id="apellido" name="apellido"
				placeholder="Ingrese su apellido" required><span>(obligatorio)</span>
		</div>

		<div class="form-group">
			<label for="correo">Correo:</label> <input type="email"
				class="form-control" id="correo" name="correo"
				placeholder="Ingrese su email" required><span>(obligatorio)</span>
		</div>

		<div class="form-group">
			<label for="dni">DNI:</label> <input type="text" class="dni" id="dni"
				name="dni" placeholder="Ingrese su dni" required><span>(obligatorio)</span>
		</div>
			

			<div class="form-group">
				<label for="codigo_postal">Código postal:</label> <input type="text"
					class="codigo_postal" id="codigo_postal" name="codigo_postal"
					placeholder="Ingrese su codigo postal" required>
			</div>

			<div class="form-group">
				<label for="dato_tarjeta">Dato tarjeta:</label> <input type="text"
					class="dato_tarjeta" id="dato_tarjeta" name="dato_tarjeta"
					placeholder="Ingrese su numero de tarjeta" required><span>(obligatorio)</span>
			</div>

			<div class="form-group">
				<label for="telefono">Teléfono:</label> <input type="text"
					class="telefono" id="telefono" name="telefono"
					placeholder="Ingrese su numero de telefono" required><span>(obligatorio)</span>
			</div>

			<button type="submit">Enviar</button>
	</form>
	
	<!-- Validación con jQuery Validation -->
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
          required: true,
          creditcard: true
        },
        telefono: {
          required: true,
          digits: true,
          minlength: 7,
          maxlength: 15
        }
      },
      messages: {
        nombre: "Por favor, ingrese su nombre.",
        apellido: "Por favor, ingrese su apellido.",
        correo: "Ingrese un correo válido.",
        dni: "Ingrese un DNI válido (7 u 8 dígitos).",
        codigo_postal: "Ingrese un código postal válido.",
        dato_tarjeta: "Ingrese un número de tarjeta válido.",
        telefono: "Ingrese un teléfono válido."
      },
      errorClass: "error",
      validClass: "valid"
    });
  });
</script>
	
	
</body>

</html>
