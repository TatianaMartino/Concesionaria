<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
</style>

<title>Iniciar Sesion</title>
<link rel="stylesheet" href="css/estiloLogin.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>

<script type="text/javascript">
			var contextPath = '<%=request.getContextPath()%>';
</script>

<script src="<%=request.getContextPath()%>/scripts/login.js"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> <!-- Sweet Alert -->

</head>
<body>

	<div class="container mt-4">

		<h1>Login</h1>
		<form class="form" id="#Login">
			<div class="form-group">
				<label>usuario</label> <input type="text" class="form-control"
					id="usuario" name="usuario" aria-describedby="emailHelp"
					placeholder="Enter user">
			</div>
			<div class="form-group">
				<label>password</label> <input type="password" class="form-control"
					id="password" name="password" placeholder="Enter contra">
			</div>

			<button type="button" class="btn btn-primary" id="btn-login">Submit</button>
		</form>
</body>
</html>