<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  
<%@ page import="java.util.List" %>
<%@ page import="domain.Auto"%>
<%@ page import="domain.Vendedor"%>
<%
Vendedor vendedor = (Vendedor) session.getAttribute("CURRENT_USER");
Integer sucursal = (Integer) session.getAttribute("SUCURSAL_ID");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
</style>
<title>Autos Reservados</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <link
	href="<%=request.getContextPath()%>/scripts/boostrap/css/bootstrap.min.css"
	rel="stylesheet">
      <link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/estiloListas.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/logout.js"></script>

<script type="text/javascript">
    var contextPath = '<%=request.getContextPath()%>';
    
    // Funciï¿½n para confirmar y eliminar auto
    function confirmarEliminar(button) {
        const id = button.getAttribute('data-id');
        if (confirm('Â¿Esta seguro que desea eliminar el auto con ID ' + id + '?')) {
            // Aquï¿½ puedes hacer una llamada ajax o redireccionar a un servlet que elimine el auto
            window.location.href = contextPath + '/EliminarAuto?id=' + id;
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
			<a  class="btn btn-primary" href="LeerAuto">Volver al Inicio</a>
				<a class="btn btn-primary"
					href="<%=request.getContextPath()%>/autoForm.jsp">Agregar Auto</a>
				<a class="btn btn-primary"
					href="<%=request.getContextPath()%>/autosReservados">Autos
					Reservados</a> 
				<a class="btn btn-primary"
					href="<%=request.getContextPath()%>/pedidos.jsp">Pedidos</a> 
				<a class="btn btn-primary"
					href="<%=request.getContextPath()%>/listarAutoExterno.jsp">Autos Externos</a>

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
	
	    <h2 class="mb-4 text-center">Lista de Autos Reservados</h2>
	

    <%
        // Obtener la lista de autos reservados enviada desde el servlet
        List<Auto> autosReservados = (List<Auto>) request.getAttribute("autosReservados");
        if (autosReservados == null || autosReservados.isEmpty()) {
    %>
        <div class="alert alert-info" role="alert">
            No hay autos reservados para mostrar.
        </div>
    <%
        } else {
    %>

    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Modelo</th>
                <th scope="col">Marca</th>
                <th scope="col">Descripcion</th>
                <th scope="col">Stock</th>
                <th scope="col">Precio</th>
                <th scope="col">Sucursal ID</th>
                <th scope="col">Disponibilidad</th>
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Auto auto : autosReservados) {
            %>
            <tr>
                <td><%= auto.getId() %></td>
                <td><%= auto.getModelo() %></td>
                <td><%= auto.getMarca() %></td>
                <td><%= auto.getDescripcion() %></td>
                <td><%= auto.getStock() %></td>
                <td><%= auto.getPrecio() %></td>
                <td><%= auto.getSucursal_id() %></td>
                <td><%= auto.getDisponibilidad() %></td>
                <td>
                    
    <a class="btn btn-warning" href="<%=request.getContextPath()%>/actualizarEstadoAuto?autoId=<%=auto.getId()%>&accion=cancelar">Cancelar Reserva</a> </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <%
        }
    %>

</div>
</body>
	<script
		src="<%=request.getContextPath()%>/scripts/boostrap/js/bootstrap.bundle.min.js"></script>
</html>
