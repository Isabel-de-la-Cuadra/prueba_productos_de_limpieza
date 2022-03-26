<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>login</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Isabel de la Cuadra Lunas">


<!-- Bootstrap CSS 5.1.3-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
body {
	background-image: linear-gradient(to right, rgba( 241, 196, 15 ,1), rgba( 241, 196, 15 ,0));
}
</style>

</head>

<!-- Implementar un mecanismo de autenticación, que restrinja el acceso a la página de bienvenida
solicitando nombre de usuario y contraseña.
 -->


<body>

	<br>
	<br>
	<br>
	
	<div class="container ms-4">
		
		<br>
		<h4 style="margin-left: 15%;">Ingresa tu nombre de usuario y contraseña</h4>
		<br> <br>
	</div>

	<div class="container" style="margin-left: 15%;">

		<c:if test="${msgError !=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msgError}"></c:out>
			</div>
		</c:if>

		<h1>Formulario de Ingreso</h1>

		<form action="loginProcesa" method="post">

			<label for="disabledTextInput" class="form-label">Usuario: </label>
			<input type="text" class="form-control" name="usuario" placeholder="Ingresa tu nombre de usuario">
			
			<br>
			
			<label for="password" class="form-label">Password: </label>
			<input type="password" class="form-control" id="password" name="password" placeholder="Ingresa tu password">
			
			<br>
			<br>

			<!--botones-->

			<button type="reset" class="btn btn-warning border border-dark mb-4 me-4 p-2">Limpiar</button>
			
			<button type="submit" class="btn btn-warning border border-dark mb-4 me-4 p-2">Ingresar</button>

		</form>
	</div>


	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
		crossorigin="anonymous "></script>


</body>

</html>