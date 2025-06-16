<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.Auto"%>
<%@ page import="domain.Vendedor"%>
<%
Vendedor vendedor = (Vendedor) session.getAttribute("CURRENT_USER");
Integer sucursal = (Integer) session.getAttribute("SUCURSAL_ID");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
</style>
<title>Inicio</title>

<link
	href="<%=request.getContextPath()%>/scripts/boostrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/estiloInicio.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
			var contextPath='<%=request.getContextPath()%>';
</script>
<script src="<%=request.getContextPath()%>/scripts/eliminarAuto.js"></script>
<script src="<%=request.getContextPath()%>/scripts/logout.js"></script>


<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<!-- Agregamos SweetAlert -->


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
	<section>


		<%
		List<Auto> autos = (List<Auto>) request.getAttribute("autos");
		if (autos != null && !autos.isEmpty()) {
			for (Auto auto : autos) {
		%>

		<article style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
			<img src="img/autos-2.jpg" alt="Imagen de autos">
			<h3><%=auto.getMarca()%>-<%=auto.getModelo()%></h3>
			<p><strong>ID:</strong><%=auto.getId()%></p>
			<p><strong>Descripcion:</strong><%=auto.getDescripcion()%></p>
			<p><strong>Stock:</strong><%=auto.getStock()%></p>
			<p><strong>Precio:</strong> $<%=auto.getPrecio()%></p>
			<p><strong>Sucursal ID:</strong><%=auto.getSucursal_id()%></p>
			<p><strong>Disponibilidad:</strong><%=auto.getDisponibilidad()%></p>

			<!--Aca le paso el ID del auto -->

			<%
			if ("RESERVADO".equalsIgnoreCase(auto.getDisponibilidad())) {
			%>
			<a class="btn btn-warning"
				href="<%=request.getContextPath()%>/actualizarEstadoAuto?autoId=<%=auto.getId()%>&accion=cancelar">
				Cancelar reserva</a>
			<%
			} else {
			%>
			<!-- Si NO está reservado, mostramos el botón para reservar -->
			<%
			if (auto.getSucursal_id() != sucursal) {
			%>
			<button class="btn btn-warning"
				onclick="solicitarTraslado(<%=auto.getId()%>, <%=sucursal%>, <%=auto.getSucursal_id()%>)">Reservar
				Auto</button>
			<%
			} else {
			%>
			<a class="btn btn-primary"
				href="<%=request.getContextPath()%>/datosCliente.jsp?id=<%=auto.getId()%>">Reservar
				Auto</a>
			<%
			}
			%>
			<%
			}
			%>
			<button class="btn btn-danger" data-id="<%=auto.getId()%>"
				onclick="myFunction(this)">Eliminar</button>
		</article>

		<%
		}
		} else {
		%>
		<p>No hay autos disponibles.</p>
		<%
		}
		%>
	</section>
	<script
		src="<%=request.getContextPath()%>/scripts/boostrap/js/bootstrap.bundle.min.js"></script>
</body>
<script>
function solicitarTraslado(autoId, origen, destino) {
    Swal.fire({
        title: 'Este auto pertenece a otra sucursal',
        text: "¿Deseás solicitar el traslado?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí, solicitar traslado',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch(contextPath + "/crearTraslado", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body: `autoId=${autoId}&sucursalOrigen=${origen}&sucursalDestino=${destino}`
            })
            .then(response => {
                if (response.redirected) {
                    window.location.href = contextPath + "/verPedidos";
                } else {
                    Swal.fire('Error', 'No se pudo crear el traslado', 'error');
                }
            })
            .catch(error => {
                console.error("Error:", error);
                Swal.fire('Error', 'Ocurrió un error al solicitar traslado', 'error');
            });
        }
    });
}
</script>
</html>

