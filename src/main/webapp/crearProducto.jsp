<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Productos de Limpieza</title>
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


		<h3>Formulario de Registro</h3>

		<form action="crearProducto" method="post">
			<label for="nombre_producto" class="form-label">Nombre: </label> <input
				type="text" class="form-control" id="nombre_producto"
				name="nombre_producto" placeholder="Ingresa el nombre del producto">
			<br> <label for="precio_producto" class="form-label">Precio:
			</label> <input type="number" class="form-control" id="precio_producto"
				name="precio_producto" placeholder="Ingresa el precio del producto">
			<br> <label for="descripcion_producto" class="form-label">Descripción:
			</label> <input type="text" class="form-control" id="descripcion_producto"
				name="descripcion_producto"
				placeholder="Ingresa la descripción del producto"> <br>
			<label for="id_categoria" class="form-label">Categoría: </label> <select
				name="id_categoria" id="id_categoria">
				<c:forEach items="${categorias}" var="categoria">
					<option value="${categoria.getId_categoria()}">${categoria.getNombre_categoria()}</option>
				</c:forEach>
			</select> <br> <br>

			<!--botones-->
			<button type="submit"
				class="btn btn-warning border border-dark mb-4 p-2">Registrar</button>

			<button type="reset"
				class="btn btn-warning border border-dark mb-4 me-4 p-2">Limpiar
				Información</button>

		</form>

		<br> <a id="link"
			href="http://localhost:8080/AA_Prueba_ProductosDeLimpieza/bienvenida.jsp">
			Ir a página de Inicio </a>

	</section>


	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
		crossorigin="anonymous "></script>



</body>
</html>