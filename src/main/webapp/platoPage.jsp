<%--
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@page import="java.util.*"%>
  <%@page import="com.sample.core.domain.Plato"%>

<!--    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<%  List<Plato> platos  =  (List) request.getAttribute("platos"); %>



<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">precio</th>
      <th scope="col">Descripcion</th>
      <th scope="col">operaciones</th>
    </tr>
  </thead>
  <tbody>
<%for(int i=0;i<platos.size();i++){
	%>
	 
	<tr bgcolor="white">
	<td><%=platos.get(i).getId() %></td>
	<td><%=platos.get(i).getPrecio()%></td>
	<td><%=platos.get(i).getDescripcion()%></td>
	<td> 
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/loadPLatoForm?id=<%=platos.get(i).getId()%>" > editar </a>
	 	<button class="btn btn-danger"> eliminar </button>
	 </td>
<%		
}
%>
 </tbody>

</table>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

-->
--%>