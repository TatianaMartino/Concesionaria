<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario para Ingresar Autos</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>

<script type="text/javascript">
	var contextPath = '<%= request.getContextPath() %>';
</script>

<script src="<%=request.getContextPath()%>/scripts/agregarAuto.js">
	
</script>
</head>
<body>

	<form class="form" id="formAuto">
		<div class="form-group">
			<label for="modelo">Modelo:</label> <input type="text"
				class="form-control" id="modelo" name="modelo"
				aria-describedby="emailHelp" placeholder="Ingrese un modelo">
		</div>
		
		<div class="form-group">
			<label for="modelo">Marca:</label> <input type="text"
				class="form-control" id="marca" name="marca"
				aria-describedby="emailHelp" placeholder="Ingrese una marca">
		</div>
		
		<div class="form-group">
			<label for="descripcion">Descripción:</label> <input type="text"
				class="form-control" id="descripcion" name="descripcion"
				aria-describedby="emailHelp" placeholder="Ingrese una descripcion">
		</div>
		
		<div class="form-group">
			<label for="stock">Stock:</label> <input type="text"
				class="form-control" id="stock" name="stock"
				aria-describedby="emailHelp" placeholder="Ingrese el stock">
		</div>

		<div class="form-group">
			<label for="exampleInputPassword1">Precio</label> <input type="text"
				class="precio" id="precio" name="precio"
				aria-describedby="emailHelp" placeholder="Ingrese un precio">
		</div>
		
		<div class="form-group">
			<label for="sucursal_id">Selecciona una sucursal:</label>
			<select id="sucursal_id" name="sucursal_id" class="form-control">
        		<option value="1">Sucursal 1</option>
       			<option value="2">Sucursal 2</option>
        	</select>
		</div>
			
		<div class="form-group"> 
			<label for="disponibilidad">Seleccione disponibilidad:</label>
  		  	<select id="disponibilidad" name="disponibilidad" class="form-control">
        		<option value="Disponible">Disponible</option>
    		</select>
    	</div>
    		
	<button type="button" class="btn btn-primary" id="btn-confirmar">Submit</button> <!-- lleva al agregarAuto.js para crear un auto -->
	</form>



</body>
</html>
 