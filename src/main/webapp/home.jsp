<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="domain.Auto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
</style>
<title>Inicio</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/estiloInicio.css">
</head>
<body>

<header>
    <div class="header-top">
        <img src="img/TopCarLogo1.png" alt="Logo"> 
        <h1>Concesionaria Topcar</h1>
    </div>
     <div class="header-bottom">
        <a class="btn btn-primary" href="<%=request.getContextPath()%>/autoForm.jsp">Agregar Auto</a>
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
        <h3><%= auto.getMarca() %> - <%= auto.getModelo() %></h3>
        <p><strong>ID:</strong> <%= auto.getId() %></p>
        <p><strong>Descripcion:</strong> <%= auto.getDescripcion() %></p>
        <p><strong>Stock:</strong> <%= auto.getStock() %></p>
        <p><strong>Precio:</strong> $<%= auto.getPrecio() %></p>
        <p><strong>Sucursal ID:</strong> <%= auto.getSucursal_id() %></p>
        <p><strong>Disponibilidad:</strong> <%= auto.getDisponibilidad() %></p>

        <!--Aca le paso el ID del auto -->
       <% if ("RESERVADO".equalsIgnoreCase(auto.getDisponibilidad())) { %>
    <a class="btn btn-warning" href="<%=request.getContextPath()%>/actualizarEstadoAuto?autoId=<%=auto.getId()%>&accion=cancelar">Cancelar reserva</a>
      <% } else { %>
    <a class="btn btn-primary" href="<%=request.getContextPath()%>/datosCliente.jsp?id=<%=auto.getId()%>">Reservar Auto</a> <% } %>
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