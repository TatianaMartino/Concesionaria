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
	<input type="hidden" name="idAuto" value="<%=request.getParameter("id")%>" />
		<!-- Guarda el id del auto que el cliente eligió -->
		<!-- Oculto el ID del auto reservado para que el usuario no tenga que ver ese dato ya que no es imporatnte para el.
		Se le pasa el Id para que el servlet "GuardarDatosCliente" puede saber qué auto está reservando/comprando el cliente -->
		
		<div class="form-group">
			<label for="nombre">Nombre:</label> <input type="text"
				class="form-control" id="nombre" required name="nombre"
				aria-describedby="emailHelp" placeholder="Ingrese un nombre" >
		</div>
		
		<div class="form-group">
			<label for="apellido">Apelido:</label> <input type="text"
				class="form-control" id="apellido" required name="apellido"
				aria-describedby="emailHelp" placeholder="Ingrese un apellido">
		</div>
		
		<div class="form-group">
			<label for="correo">Correo:</label> <input type="email"
				class="form-control" id="descripcion" required name="descripcion"
				aria-describedby="emailHelp" placeholder="Ingrese una descripcion">
		</div>
	
		<div class="form-group">
			<label for="stock">Stock:</label>
			<select id="stock" required name="stock" class="form-control">
        		<option value="1">1</option>
        	</select>
		</div>

		<div class="form-group">
			<label for="precio">Precio</label> <input type="text"
				class="form-control" id="precio" required name="precio"
				aria-describedby="emailHelp" placeholder="Ingrese un precio">
		</div>
		
		<div class="form-group">
			<label for="sucursal_id">Selecciona una sucursal:</label>
			<select id="sucursal_id" required name="sucursal_id" class="form-control">
        		<option value="1">Sucursal 1</option>
       			<option value="2">Sucursal 2</option>
        	</select>
		</div>
			
		<div class="form-group"> 
			<label for="disponibilidad">Seleccione disponibilidad:</label>
  		  	<select id="disponibilidad" name="disponibilidad" class="form-control">
        		<option value="DISPONIBLE">DISPONIBLE</option>
    		</select>
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
      modelo: {
        required: true,
        minlength: 2
      },
      marca: {
        required: true,
        minlength: 2
      },
      descripcion: {
        required: true,
        minlength: 10
      },
      precio: {
        required: true,
        number: true
      },
      sucursal_id: {
        required: true
      },
      disponibilidad: {
        required: true
      }
    },
    messages: {
      modelo: {
        required: "Por favor, ingrese un modelo",
        minlength: "El modelo debe tener al menos 2 caracteres"
      },
      marca: {
        required: "Por favor, ingrese una marca",
        minlength: "La marca debe tener al menos 2 caracteres"
      },
      descripcion: {
        required: "Por favor, ingrese una descripción",
        minlength: "La descripción debe tener al menos 10 caracteres"
      },
      precio: {
        required: "Por favor, ingrese un precio",
        number: "Ingrese un valor numérico válido"
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