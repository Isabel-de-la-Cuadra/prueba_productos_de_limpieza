<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Productos de Limpieza</title>
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
	background-image: linear-gradient(to right, rgba(241, 196, 15, 1),
		rgba(241, 196, 15, 0));
}
</style>

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light border border-warning"
		style="background-image: linear-gradient(to right, rgba(241, 196, 15, 1), rgba(241, 196, 15, 0));">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon">
				</span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="inicio">Inicio</a></li>
					<li class="nav-item"><a class="nav-link" href="crearProducto">Crear
							Producto</a></li>
					<li class="nav-item"><a class="nav-link"
						href="mostrarProducto">Mostrar Producto</a></li>
					<li class="nav-item"><a class="nav-link"
						href="modificarProducto">Modificar Producto</a></li>
					<li class="nav-item"><a class="nav-link"
						href="eliminarProducto">Eliminar Producto</a></li>
					<li class="nav-item"><a class="nav-link"
						href="listarProductos">Listar Productos</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<br>
	<br>
	<br>


	<section class="container">
		<section id="texto">
			<h1>Mostrar Productos de limpieza</h1>

		</section>
	</section>

	<br>
	<a id="link"
		href="http://localhost:8080/AA_Prueba_ProductosDeLimpieza/bienvenida.jsp">
		Ir a página de Inicio </a>

	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
		crossorigin="anonymous "></script>



</body>
</html>