<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
</style>

<title>Formulario para Ingresar Autos</title>
<link rel="stylesheet" href="css/estiloForm.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/jquery/localization/messages_es.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>

<script type="text/javascript">
	var contextPath = '<%= request.getContextPath() %>';
</script>

<script src="<%=request.getContextPath()%>/scripts/agregarAuto.js">
</script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> <!-- Sweet Alert -->


</head>
<body>

	<form class="form" id="formAuto" enctype="multipart/form-data">
		<div class="form-group">
			<label for="modelo">Modelo:</label> <input type="text"
				class="form-control" id="modelo" required name="modelo"
				aria-describedby="emailHelp" placeholder="Ingrese un modelo" >
		</div>
		
		<div class="form-group">
			<label for="modelo">Marca:</label> <input type="text"
				class="form-control" id="marca" required name="marca"
				aria-describedby="emailHelp" placeholder="Ingrese una marca">
		</div>
		
		<div class="form-group">
			<label for="descripcion">Descripción:</label> <input type="text"
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
    	
    	<!--  <div class="form-group">
    	   <label for="imagen">Inserte una imagen del auto:</label>
    	   <input type="file" class="form-control" id="imagen" name="imagen" accept="image/*" required>
    	</div> -->
    		
	<button type="button" class="btn btn-primary" id="btn-confirmar">Submit</button> <!-- lleva al agregarAuto.js para crear un auto -->
	</form>

</body>
</html>


<!-- JQUERY VALIDATION -->
<script>
$(document).ready(function () {
	//define las reglas que tiene que tener para que el ingreso sea valido
  $("#formAuto").validate({
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
    if ($("#formAuto").valid()) { // Retorna true si el formulario es válido, o false si hay errores.
    
    }
  });
});
</script>

 