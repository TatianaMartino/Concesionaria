<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ver Encargados</title>
</head>
<body>
	<header>
		<h1>Listado de Encargados</h1>
	</header>

	<section>
		<%
		ResultSet conjuntoResultados = (ResultSet) request.getAttribute("conjuntoResultados");

		if (conjuntoResultados != null) {
			while (conjuntoResultados.next()) {

				String nombre = conjuntoResultados.getString("nombre");
				String apellido = conjuntoResultados.getString("apellido");
				String usuario = conjuntoResultados.getString("usuario");
				String contra = conjuntoResultados.getString("contra");
				String correo = conjuntoResultados.getString("correo");
				int idSucursal = conjuntoResultados.getInt("idSucursal");
		%>
		<!-- Mostrar empleado -->
		<article>
			<h2>Encargado:</h2>
			<p>
				Nombre:
				<%=nombre%></p>
			<p>
				Apellido:
				<%=apellido%></p>
			<p>
				Usuario:
				<%=usuario%></p>
			<p>
				Contraseña:
				<%=contra%></p>
			<p>
				Correo:
				<%=correo%>
			</p>
			<p>
				Id Sucursal:
				<%=idSucursal%></p>


		</article>
		<%
		}
		}
		%>
	</section>

	<a href="/LoadEncargadoForm" class="boton-volver">Volver a Inicio</a>
	</div>

</body>
</html>