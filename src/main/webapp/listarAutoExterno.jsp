<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.Auto"%>
<%@ page import="domain.Vendedor"%>

<%
Vendedor vendedor = (Vendedor) session.getAttribute("CURRENT_USER");
Integer sucursal = (Integer) session.getAttribute("SUCURSAL_ID");
List<Auto> autos = (List<Auto>) request.getAttribute("autos");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap')
	;
</style>
<title>Autos de Otras Sucursales</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/estiloInicio.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
  var contextPath = '<%=request.getContextPath()%>';
</script>
<script src="<%=request.getContextPath()%>/scripts/eliminarAuto.js"></script>
<script src="<%=request.getContextPath()%>/scripts/logout.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
function solicitarTraslado(autoId, origen, destino) {
    if (confirm("Queres solicitar el traslado de este auto?")) {
        var form = document.createElement("form");
        form.method = "POST";
        form.action = contextPath + "/crearTraslado";

        var inputAuto = document.createElement("input");
        inputAuto.type = "hidden";
        inputAuto.name = "autoId";
        inputAuto.value = autoId;
        form.appendChild(inputAuto);

        var inputOrigen = document.createElement("input");
        inputOrigen.type = "hidden";
        inputOrigen.name = "sucursalOrigen";
        inputOrigen.value = origen;
        form.appendChild(inputOrigen);

        var inputDestino = document.createElement("input");
        inputDestino.type = "hidden";
        inputDestino.name = "sucursalDestino";
        inputDestino.value = destino;
        form.appendChild(inputDestino);

        document.body.appendChild(form);
        form.submit();
    }
}
</script>
</head>

<body>
	<header>
		<div class="header-top">
			<img src="img/TopCarLogo1.png" alt="Logo">
			<h1>Concesionaria Topcar</h1>
		</div>

		<div class="header-bottom">
			<div class="left-buttons">
				<a class="btn btn-primary"
					href="<%=request.getContextPath()%>/autoForm.jsp">Agregar Auto</a>
				<a class="btn btn-secondary"
					href="<%=request.getContextPath()%>/autosReservados">Autos
					Reservados</a> <a class="btn btn-info"
					href="<%=request.getContextPath()%>/verPedidos">Ver Pedidos de
					Traslado</a> <a class="btn btn-info"
					href="<%=request.getContextPath()%>/LeerAutoExterno">Ver Autos
					de otras sucursales</a>

				<button type="button" class="btn btn-primary">
					Notifications <span class="badge text-bg-secondary"></span>
				</button>
			</div>

			<button id="btn-logout" class="btn btn-danger">Cerrar sesion</button>
		</div>
	</header>

	<%
	if (vendedor != null && sucursal != null) {
	%>
	<p>
		Usuario logueado:
		<%=vendedor.getUsuario()%></p>
	<p>
		Sucursal:
		<%=sucursal%></p>
	<br>
	<section>
		<%
		if (autos != null && !autos.isEmpty()) {
			for (Auto auto : autos) {
		%>

		<article style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
			<img src="img/autos-2.jpg" alt="Imagen de autos">
			<h3><%=auto.getMarca()%>
				-
				<%=auto.getModelo()%></h3>
			<p>
				<strong>ID:</strong>
				<%=auto.getId()%></p>
			<p>
				<strong>Descripcion:</strong>
				<%=auto.getDescripcion()%></p>
			<p>
				<strong>Stock:</strong>
				<%=auto.getStock()%></p>
			<p>
				<strong>Precio:</strong> $<%=auto.getPrecio()%></p>
			<p>
				<strong>Sucursal ID:</strong>
				<%=auto.getSucursal_id()%></p>
			<p>
				<strong>Disponibilidad:</strong>
				<%=auto.getDisponibilidad()%></p>


			<a class="btn btn-success" href="#" onclick="solicitarTraslado(<%=auto.getId()%>, <%=auto.getSucursal_id()%>, <%=sucursal%>)">Solicitar traslado</a>

		</article>

		<%
		}
		} else {
		%>
		<p>No hay autos disponibles de otras sucursales.</p>
		<%
		}
		%>
	</section>
	<%
	}
	%>

</body>
</html>
