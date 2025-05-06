<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="domain.Auto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/estiloInicio.css">
</head>
<body>

<header>
    <img src="img/logo.png" alt="Logo"> 
    <h1>Concesionaria</h1>
</header>

<div>
	<a class="btn btn-primary"  href="<%=request.getContextPath()%>/autoForm.jsp" > Agregar Auto </a> 
</div>

<br>
<section>
    <% 
    List<Auto> autos = (List<Auto>) request.getAttribute("autos");
    if (autos != null && !autos.isEmpty()) {
        for (Auto auto : autos) {
    %>

    <article style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
    <img src="img/autos-2.jpg" alt="Imagen de autos">
        <h3><%= auto.getMarca() %> - <%= auto.getModelo() %></h3>
        <p><strong>ID:</strong> <%= auto.getId() %></p>
        <p><strong>Descripcion:</strong> <%= auto.getDescripcion() %></p>
        <p><strong>Stock:</strong> <%= auto.getStock() %></p>
        <p><strong>Precio:</strong> $<%= auto.getPrecio() %></p>
        <p><strong>Sucursal ID:</strong> <%= auto.getSucursal_id() %></p>
        <p><strong>Disponibilidad:</strong> <%= auto.getDisponibilidad() %></p>

        <form action="ReservarAutoServlet" method="post" style="display:inline;">
            <input type="hidden" name="autoId" value="<%= auto.getId() %>">         
          <a class="btn btn-primary"  href="<%=request.getContextPath()%>/datosCliente.jsp" > Reservar Auto </a> 
        </form>

        <form action="ComprarAutoServlet" method="post" style="display:inline;">
            <input type="hidden" name="autoId" value="<%= auto.getId() %>">
            <a class="btn btn-primary"  href="<%=request.getContextPath()%>/datosCliente.jsp" > Comprar Auto </a> 
        </form>
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

</body>
</html>
