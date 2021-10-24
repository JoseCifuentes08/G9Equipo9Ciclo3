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
<title>Buscar proveedor</title>
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

		<h1 class="m-3">
			<i class="fas fa-search"></i> Buscando un proveedor
		</h1>
		<div class="container">


			<div id="error" class="alert alert-danger visually-hidden"
				role="alert">Error al buscar el proveedor, el proveedor no existe</div>

			<div id="correcto" class="alert alert-success visually-hidden"
				role="alert">Proveedor encontrado con éxito</div>

			<form id="form1">
			
				<div class="input-group mb-3">
					<span class="input-group-text" style="width: 170px;" id="basic-addon4">NIT del proveedor</span> <input
						type="text" class="form-control"
						placeholder="Insertar NIT"
						aria-describedby="basic-addon4" required id="nit_buscado" >
				</div>
				<br>
				
				<div class="input-group mb-3">
					<span class="input-group-text" style="width: 170px;" id="basic-addon1">NIT</span> <input
						type="text" class="form-control"
						aria-describedby="basic-addon1" required id="nit_proveedor" disabled="disabled">
				</div>
				

				<div class="input-group mb-3">
					<span class="input-group-text" style="width: 170px;" id="basic-addon1">Nombre</span> <input
						type="text" class="form-control"
						aria-describedby="basic-addon1" required id="nombre_proveedor" disabled="disabled">
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" style="width: 170px;" id="basic-addon2">Dirección</span> <input
						type="text" class="form-control"
						aria-describedby="basic-addon2" required id="direccion_proveedor" disabled="disabled">
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" style="width: 170px;" id="basic-addon3">Teléfono</span>
					<input type="text" class="form-control"
						aria-describedby="basic-addon3" required id="telefono_proveedor"  disabled="disabled">
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" style="width: 170px;" id="basic-addon4">Ciudad</span> <input
						type="text" class="form-control"
						aria-describedby="basic-addon4" required id="ciudad_proveedor"  disabled="disabled">
				</div>

			</form>

			<button type="button" class="btn btn-primary" onclick="enviar()"><i class="fas fa-search"></i> Buscar proveedor</button>
			
		</div> <br> <br>

<center>
			<div class="btn-group" role="group" aria-label="Basic mixed styles example" style="position: relative;">
  				<button type="button" class="btn btn-success" onclick="window.location.href='/insertarproveedor.jsp'"><i class="fas fa-plus-circle"></i> Agregar proveedor</button>
					<button type="button" class="btn btn-danger" onclick="window.location.href='/eliminarproveedor.jsp'"><i class="fas fa-trash"></i> Eliminar proveedor</button>
					<button type="button" class="btn btn-warning" onclick="window.location.href='/actualizarproveedor.jsp'"><i class="fas fa-pen-alt"></i> Actualizar proveedor</button>
					<button type="button" class="btn btn-info" onclick="window.location.href='/buscarproveedor.jsp'"><i class="fas fa-search"></i> Buscar un proveedor</button>
					<button type="button" class="btn btn-primary" onclick="window.location.href='/listaproveedores.jsp'"><i class="fas fa-search"></i> Listar todos los proveedores</button>
			</div>

	</div>
	
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

	<script>
		function enviar() {
				
				var req = new XMLHttpRequest();
				var coincidencia = false;
				var cl=   document.getElementById("nit_buscado").value;
				req.open('GET', 'http://localhost:8080/consultarproveedores?nit_proveedor='+cl, false);
				req.send(null);
				var proveedor = null;
				if (req.status == 200)
					proveedor = JSON.parse(req.responseText);
				console.log(JSON.parse(req.responseText));
				
			
				var element = document.getElementById("error");
				element.classList.add("visually-hidden");
				var element2 = document.getElementById("correcto");
				element2.classList.remove("visually-hidden");
				
				console.log(proveedor.toString());			
				
			if (proveedor.toString()!=""){
				document.getElementById("nit_proveedor").value = proveedor[0].nit_proveedor;
				document.getElementById("nombre_proveedor").value = proveedor[0].nombre_proveedor;
				document.getElementById("direccion_proveedor").value = proveedor[0].direccion_proveedor;
				document.getElementById("telefono_proveedor").value = proveedor[0].telefono_proveedor;
				document.getElementById("ciudad_proveedor").value = proveedor[0].ciudad_proveedor;
				
				document.getElementById("cedulacl").value = "";
			
			} else {
				var element = document.getElementById("error");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correcto");
				element2.classList.add("visually-hidden");
				document.getElementById("nit_proveedor").value = "";
				document.getElementById("nombre_proveedor").value = "";
				document.getElementById("direccion_proveedor").value = "";
				document.getElementById("telefono_proveedor").value = "";
				document.getElementById("ciudad_proveedor").value = "";
			}
		}
		
	</script>

</body>
</html>