<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.Traslado"%>
<%@ page import="domain.Vendedor"%>
<%
Vendedor vendedor = (Vendedor) session.getAttribute("CURRENT_USER");
Integer sucursal = (Integer) session.getAttribute("SUCURSAL_ID");
%>

<html>
<head>
<meta charset="UTF-8">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap')
	;
</style>
<title>Pedidos de Traslado</title>
<link
	href="<%=request.getContextPath()%>/scripts/boostrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/estiloPedidos.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
			var contextPath='<%=request.getContextPath()%>';
</script>
<script src="<%=request.getContextPath()%>/scripts/logout.js"></script>

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
				<a class="btn btn-primary"
					href="<%=request.getContextPath()%>/autosReservados">Autos
					Reservados</a> <a class="btn btn-primary"
					href="<%=request.getContextPath()%>/verPedidos">Pedidos</a> <a
					class="btn btn-primary"
					href="<%=request.getContextPath()%>/listarAutoExterno.jsp">Autos
					Externos</a>
				<!--  <button type="button" class="btn btn-primary">
					Notifications <span class="badge text-bg-secondary"></span>
				</button>-->

				<div class="dropdown ms-auto">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">
						<i class="fas fa-user"></i>
						<%=vendedor.getUsuario()%>
					</button>
					<ul class="dropdown-menu dropdown-menu-end">
						<li><span class="dropdown-item-text"><strong>Usuario:</strong>
								<%=vendedor.getUsuario()%></span></li>
						<li><span class="dropdown-item-text"><strong>Sucursal:</strong>
								<%=sucursal%></span></li>
						<li><hr class="dropdown-divider"></li>
						<li><span class="dropdown-item-text">Mi Perfil</span></li>
						<li><a class="dropdown-item text-danger" href="#"
							id="btn-logout">Cerrar sesión</a></li>
					</ul>
				</div>
	</header>

	<br>


	<h1>Pedidos de Traslado para la Sucursal</h1>

	<%
	// Obtener la lista de pedidos desde el request (la envía el servlet)
	List<Traslado> pedidos = (List<Traslado>) request.getAttribute("pedidos");
	if (pedidos == null || pedidos.isEmpty()) {
	%>
	<p>No hay pedidos pendientes para esta sucursal.</p>
	<%
	} else {
	%>

	<table border="1" cellpadding="5" cellspacing="0">
		<thead>
			<tr>
				<th>ID Pedido</th>
				<th>ID Auto</th>
				<th>Sucursal Origen</th>
				<th>Sucursal Destino</th>
				<th>Estado</th>
				<th>Acción</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Traslado t : pedidos) {
			%>
			<tr>
				<td><%=t.getId()%></td>
				<td><%=t.getAutoId()%></td>
				<td><%=t.getSucursalOrigenId()%></td>
				<td><%=t.getSucursalDestinoId()%></td>
				<td>PENDIENTE</td>
				<td>
					<!-- Form para aceptar el pedido -->
					<form action="aceptarTraslado" method="post" style="margin: 0;">
						<input type="hidden" name="id" value="<%=t.getId()%>" /> <input
							type="hidden" name="sucursalOrigen" value="<%=t.getSucursalDestinoId()%>" />
						<%
						if (t.getSucursalDestinoId() == sucursal) {
						%>
						<button type="submit" class="btn btn-success">Aceptar</button>
						<%
						} else {
						%>
						<button type="submit" class="btn btn-secondary" disabled>No
							disponible</button>
						<%
						}
						%>
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<%
	}
	%>

	<p>
		<a href="LeerAuto" class="volver-inicio">Volver al Inicio</a>
	</p>
	<script
		src="<%=request.getContextPath()%>/scripts/boostrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>