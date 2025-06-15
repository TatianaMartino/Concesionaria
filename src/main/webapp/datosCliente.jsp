<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
</style>

<title>Formulario para Clientes</title>
<link rel="stylesheet" href="css/estiloForm.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/jquery/localization/messages_es.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>

<script type="text/javascript">
	var contextPath = '<%= request.getContextPath() %>';
</script>

<script src="<%=request.getContextPath()%>/scripts/agregarCliente.js">
</script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> <!-- Sweet Alert -->


</head>
<body>

	<form class="form" id="formCliente" enctype="form-data">
	<input type="hidden" name="idAuto" id="idAuto" value="<%=request.getParameter("id")%>" />
		<!-- Guarda el id del auto que el cliente eligió -->
		<!-- Oculto el ID del auto reservado para que el usuario no tenga que ver ese dato ya que no es imporatnte para el.
		Se le pasa el Id para que el servlet "GuardarDatosCliente" puede saber qué auto está reservando/comprando el cliente -->
		
		<div class="form-group">
			<label for="nombre">Nombre:</label> <input type="text"
				class="form-control" id="nombre" required name="nombre" placeholder="Ingrese su nombre" >
		</div>
		
		<div class="form-group">
			<label for="apellido">Apelido:</label> <input type="text"
				class="form-control" id="apellido" required name="apellido" placeholder="Ingrese su apellido">
		</div>
		
		<div class="form-group">
			<label for="correo">Correo:</label> <input type="email"
				class="form-control" id="correo" required name="correo" placeholder="Ingrese su correo">
		</div>
	
		<div class="form-group">
			<label for="dni">Dni:</label> <input type="text"
				class="form-control" id="dni" required name="dni" placeholder="Ingrese su dni">
		</div>

		<div class="form-group">
			<label for="codigo_postal">Codigo postal:</label> <input type="text"
				class="form-control" id="codigo_postal" required name="codigo_postal"  placeholder="Ingrese su codigo postal">
		</div>
		
		<div class="form-group">
			<label for="dato_tarjeta">Numero de tarjeta:</label> <input type="text"
				class="form-control" id="dato_tarjeta" required name="dato_tarjeta"  placeholder="Ingrese su numero de tarjeta">
		</div>
		
		<div class="form-group">
			<label for="telefono">Telefono:</label> <input type="text"
				class="form-control" id="telefono" required name="telefono" placeholder="Ingrese su telefono">
		</div>
			
    		
	<button type="button" class="btn btn-primary" id="btn-confirmar">Submit</button> <!-- lleva al agregarAuto.js para crear un auto -->
	</form>

</body>
</html>


<!-- JQUERY VALIDATION -->
<script>
$(document).ready(function () {
	//define las reglas que tiene que tener para que el ingreso sea valido
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
        number: true,
        minlength: 7
      },
      codigo_postal: {
        required: true,
        number: true
      },
      dato_tarjeta: {
        required: true
      },
      telefono: {
          required: true,
          number: true,
          minlength: 10
        }
    },
    messages: {
    	nombre: {
        required: "Por favor, ingrese un nombre",
        minlength: "El modelo debe tener al menos 2 caracteres"
      },
      apellido: {
        required: "Por favor, ingrese un apellido",
        minlength: "La marca debe tener al menos 2 caracteres"
      },
      correo: {
    	  required: "Por favor, ingrese un correo electrónico",
    	  email: "Ingrese un correo válido (ej: nombre@dominio.com)"
      },
      dni: {
        required: "Por favor, ingrese un precio",
        number: "Ingrese un valor numérico válido",
        minlength: "El dni debe tener al menos 7 caracteres"
      },
      codigo_postal: {
          required: "Por favor, ingrese un codigo postal",
          number: "Ingrese un valor numérico válido"
        },
      dato_tarjeta: {
    	  required: "Por favor, ingrese su numero de tarjeta"
      },
      telefono: {
    	  required: "Por favor, ingrese un telefono",
    	  number: "Ingrese un valor numérico válido",
          minlength: "El telefono debe tener al menos 10 caracteres"

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

  $("#btn-confirmar").click(function () { //cuando tocas el boton, valida si hay erores
    if ($("#formCliente").valid()) { // Retorna true si el formulario es válido, o false si hay errores.
    
    }
  });
});
</script>