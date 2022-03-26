<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.desafiolatam.models.Producto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar Productos de Limpieza</title>
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
				<span class="navbar-toggler-icon"> </span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="bienvenida.jsp">Inicio</a></li>
					<li class="nav-item"><a class="nav-link" href="crearProducto">Crear
							Producto</a></li>
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

		<c:if test="${msgError !=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msgError}"></c:out>
			</div>
		</c:if>

		<c:if test="${msgExito !=null}">
			<div class="alert alert-success" role="alert">
				<c:out value="${msgExito}"></c:out>
			</div>
		</c:if>

		<section id="texto">
			<h1>Eliminación de Productos de limpieza</h1>
		</section>

		<section id="form">
			<h3>¿Qué producto de limpieza deseas eliminar?</h3>
			<form action="eliminarProducto" method="POST">
				<label for="id_producto" class="form-label">Revisa si está
					bien el id del producto de limpieza que quieres eliminar: </label> <input
					type="text" class="form-control" id="id_producto"
					name="id_producto" value="${producto.id_producto}"> <br>
				<!--botones-->
				<button type="submit"
					class="btn btn-warning border border-dark mb-4 p-2">Eliminar
					Producto</button>

				<button type="reset"
					class="btn btn-warning border border-dark mb-4 me-4 p-2">Limpiar
					Información</button>

				<br>

			</form>
		</section>

		<br> <a id="link"
			href="http://localhost:8080/AA_Prueba_ProductosDeLimpieza/bienvenida.jsp">
			Ir a página de Inicio </a>

	</section>

</body>
</html>