<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Productos de Limpieza</title>
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
				<span class="navbar-toggler-icon"></span>
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
		<section id="texto">
			<h3>Estos son los Productos de limpieza que tenemos</h3>

			<div class="container mt-5 ">
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th scope="col">Id Producto</th>
							<th scope="col">Nombre</th>
							<th scope="col" class="text-end">Precio</th>
							<th scope="col">Descripcion</th>
							<th scope="col">Categoria</th>
							<th scope="col">Opción</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="producto" items="${listaProductos}">
							<tr>
								<td><c:out
										value="${producto.getProducto().getId_producto()}"></c:out></td>
								<td><c:out
										value="${producto.getProducto().getNombre_producto()}"></c:out></td>
								<td class="text-end">$ <fmt:formatNumber
										value="${producto.getProducto().getPrecio_producto()}"
										pattern="#,##0" /></td>
								<td><c:out
										value="${producto.getProducto().getDescripcion_producto()}"></c:out></td>
								<td><c:out
										value="${producto.getCategoria().getNombre_categoria()}"></c:out></td>
								<td>
									<div class="btn-group-vertical">
										<a
											href="/AA_Prueba_ProductosDeLimpieza/modificarProducto?id_producto=${producto.getProducto().getId_producto()}"
											class="btn btn-warning border border-dark mb-4 p-2">
											Modificar </a> <a
											href="/AA_Prueba_ProductosDeLimpieza/eliminarProducto?id_producto=${producto.getProducto().getId_producto()}"
											class="btn btn-warning border border-dark mb-4 p-2">
											Eliminar </a>
									</div>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</section>

		<br> <a id="link"
			href="http://localhost:8080/AA_Prueba_ProductosDeLimpieza/bienvenida.jsp">
			Ir a página de Inicio </a>

	</section>



</body>
</html>