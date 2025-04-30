<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form class="form" id="formAuto" action="<%=request.getContextPath()%>/GuardarDatosCliente" method="get">
		<div class="form-group">
			<label for="nombre">Nombre:</label> <input type="text"
				class="form-control" id="nombre" name="nombre"
				aria-describedby="emailHelp" placeholder="Ingrese su nombre: ">
		</div>

		<div class="form-group">
			<label for="apellido">Apellido:</label> <input type="text"
				class="form-control" id="apellido" name="apellido"
				aria-describedby="emailHelp" placeholder="Ingrese su apellido">
		</div>

		<div class="form-group">
			<label for="correo">Correo:</label> <input type="text"
				class="form-control" id="correo" name="correo"
				aria-describedby="emailHelp" placeholder="Ingrese su correo">
		</div>

		<div class="form-group">
			<label for="dni">Dni:</label> <input type="text" class="form-control"
				id="dni" name="dni" aria-describedby="emailHelp"
				placeholder="Ingrese su dni">
		</div>

		<div class="form-group">
			<label for="codigo_postal">Codigo postal</label> <input type="text"
				class="codigo_postal" id="codigo_postal" name="codigo_postal"
				aria-describedby="emailHelp" placeholder="Ingrese su codigo postal">
		</div>

		<div class="form-group">
			<label for="dato_tarjeta">Dato tarjeta: </label> <input type="text"
				class="dato_tarjeta" id="dato_tarjeta" name="dato_tarjeta"
				placeholder="Ingrese los datos de la tarjeta">
		</div>

		<div class="form-group">
			<label for="telefono">Telefono</label> <input type="text"
				class="telefono" id="telefono" name="telefono"
				aria-describedby="emailHelp" placeholder="Ingrese su telefono: ">
		</div>
		
		<button type="submit" class="btn btn-primary">Enviar</button>
	
	</form>
</body>
</html>