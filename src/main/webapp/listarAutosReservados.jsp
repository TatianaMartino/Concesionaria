<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  
<%@ page import="java.util.List" %>
<%@ page import="domain.Auto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autos Reservados</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

<script type="text/javascript">
    var contextPath = '<%=request.getContextPath()%>';
    
    // Funci�n para confirmar y eliminar auto
    function confirmarEliminar(button) {
        const id = button.getAttribute('data-id');
        if (confirm('¿Esta seguro que desea eliminar el auto con ID ' + id + '?')) {
            // Aqu� puedes hacer una llamada ajax o redireccionar a un servlet que elimine el auto
            window.location.href = contextPath + '/EliminarAuto?id=' + id;
        }
    }
</script>

</head>
<body>

<div class="container mt-4">

    <h2 class="mb-4 text-center">Lista de Autos Reservados</h2>

    <span>
        <a class="btn btn-primary mb-3" href="<%=request.getContextPath()%>/autoForm.jsp">Nuevo Auto</a>
    </span>

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
    %>s

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
                    
    <a class="btn btn-warning btn-sm" href="<%=request.getContextPath()%>/actualizarEstadoAuto?autoId=<%=auto.getId()%>&accion=cancelar">Cancelar Reserva</a> </td>
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
</html>
