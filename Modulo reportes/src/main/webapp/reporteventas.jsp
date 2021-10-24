<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<!-- paquete de caracteres -->
<meta charset="utf-8">
<!-- Tamaño de la pantalla -->
<meta name="viewport" content="width=device-width">
<!-- titulo de la pestaña -->
<title>Reporte ventas</title>
<!-- bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">

<!-- Cargando mi hoja de estilo -->
<link href="style.css" rel="stylesheet" type="text/css" />


</head>


<body>
	
	<!-- Navbar-->
	<nav class="navbar navbar-light" style="background: rgb(210, 252, 246); width: 100%; height: 80px; margin: auto;">
		<div class="container-fluid">
			<a class="navbar-brand links" href="index.html"><i
				class="fas fa-shopping-cart"></i>Tienda LA K J</a>
			<!-- Navbar modulos-->
			<a class="navbar-brand links" href="listausuarios.jsp">
				<i class="fas fa-users"></i> Usuarios</a> 
			<a class="navbar-brand links" href="Listaclientes.jsp">
				<i class="fas fa-address-book"></i> Clientes</a>
			<a class="navbar-brand links" href="listaproveedores.jsp"> 
				<i class="fas fa-truck"></i> Proveedores</a> 
			<a class="navbar-brand links" href="listaproductos.jsp"> 
				<i class="fas fa-apple-alt"></i> Productos</a> 
			<a class="navbar-brand links" href="ventas.jsp"> 
				<i class="fas fa-money-check-alt"></i> Ventas</a> 
			<a class="navbar-brand links" href="reportes.jsp"> 
				<i class="fas fa-clipboard-list"></i> Reportes</a>
		</div>
	</nav>
<center>
	<button type="button" class="btn btn-primary col-4 mt-5" onclick="window.location.href='/reportes.jsp'"><i class="fas fa-hand-point-left"></i> Regresar</button>
		<footer class="footer mt-5" style="background: rgb(210, 252, 246);">
  			<div class="caja-footer mt-5">
       			<center>
        		<a class="d-inline-flex align-items-center mb-2 link-dark text-decoration-none" href="/" aria-label="tienda">
          			<title>Tienda LA KJ</title><path fill-rule="evenodd" clip-rule="evenodd" fill="currentColor"></path>
          			<div class = "tienda"><span class="fs-4">Tienda LA KJ</span></div>
        		</a>
        		<ul class="list-unstyled small text-muted">
          			<div class="descripcion"><li class="mb-2">Proyecto orientado al aplicativo web</div>
          			<div class="valores"><li class="mb-2"> Scrum 9 - 2021</div>
        		</ul>
        		</center>
    		</div>
		</footer>
</center>
</body>
</html>