<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario para agregar un encargado</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/estiloForm.css">
</head>
<body>
	<div class="form-container">
		<h1>Agregar Encargado</h1>

		<form action="<%=request.getContextPath()%>/CrearEncargado"
			method="get">

			<label for="nombre">Nombre: </label> <input type="text" id="nombre"
				name="nombre" required> <br> <br> <label
				for="apellido">Apellido: </label> <input type="text" id="apellido"
				name="apellido" required> <br> <br> <label
				for="usuario">Usuario: </label> <input type="text" id="usuario"
				name="usuario" required> <br> <br> <label
				for="contra">Contrasena: </label> <input type="text" id="pr"
				name="contra" required> <br> <br> <label
				for="correo">Correo:</label> <input type="text" id="pr"
				name="correo" required> <br> <br> <label
				for="opciones">Selecciona una opción:</label> <select
				id="idSucursal" name="idSucursal">
				<option value="1">sucursal 1</option>
				<option value="2">sucursal 2</option>
			</select> <br> <br> <input type="submit" value="Enviar">
		</form>
	</div>


</body>
</html>