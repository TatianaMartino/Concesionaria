<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.*"%>
<%@page import="domain.Auto"%> <!-- importamos la clase auto -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Lista Autos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

	<script type="text/javascript">
			var contextPath='<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/scripts/eliminarAuto.js"> </script>


</head>
<body>

<div class="container mt-4">

<span>
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/autoForm.jsp" > Nuevo </a> <!--lleva al formulario -->
</span>

<%      List<Auto> autos  = (List) request.getAttribute("autos");%> <!-- Obtiene la lista de autos -->


<table class="table">
  <thead>
    <tr> 
      <th scope="col">id</th>
      <th scope="col">Modelo</th>
      <th scope="col">Marca</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Stock</th>
      <th scope="col">Precio</th>
      <th scope="col">Sucursal id</th>
      <th scope="col">Disponibilidad</th>
    </tr>
  </thead>
  <tbody>

  <!-- Recorre la lista para poner los datos en la tabla -->
<%for(int i=0;i<autos.size();i++){
	%>

<tr bgcolor="white">
	<td><%=autos.get(i).getId() %></td>
	<td><%=autos.get(i).getModelo() %></td>
	<td><%=autos.get(i).getMarca()%></td>
	<td><%=autos.get(i).getDescripcion()%></td>
	
	<td><%=autos.get(i).getStock()%></td>
	<td><%=autos.get(i).getPrecio()%></td>
	<td><%=autos.get(i).getSucursal_id()%></td>
	<td><%=autos.get(i).getDisponibilidad()%></td>
	<td> 
	
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/LoadAutoForm?id=<%=autos.get(i).getId()%>" > editar </a> <!-- lleva a LoadAutoForm para editar un dato -->
	 	<button class="btn btn-danger"  data-id="<%=autos.get(i).getId()%>"  onClick="myFunction(this)" > eliminar </button> <!-- lleva a un js para eliminar -->
	 </td>
<%		
}
%>
 </tbody>

</table>

</div>
</body>
</html>




