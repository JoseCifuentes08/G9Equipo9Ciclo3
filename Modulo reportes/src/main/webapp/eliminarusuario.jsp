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
<title>Eliminar usuario</title>
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
			<i class="fas fa-skull-crossbones"></i> Datos del usuario a eliminar
		</h1>
		<div class="container">


			<div id="error" class="alert alert-danger visually-hidden"
				role="alert">Error al eliminar el usuario, verifique que 
				exista un usuario con la cédula ingresada</div>

			<div id="correcto" class="alert alert-success visually-hidden"
				role="alert">Usuario eliminado con éxito</div>

			<form id="form1">
			
				<div class="input-group mb-3">
					<span class="input-group-text" style="width: 170px;" id="basic-addon1">Cédula</span> <input
						type="text" class="form-control"
						placeholder="Insertar cédula"
						aria-describedby="basic-addon1" required id="cedula_usuario">
				</div>

			</form>
			
			<button type="button" class="btn btn-danger" onclick="eliminar()">
				<i class="fas fa-skull-crossbones"></i> Eliminar usuario
			</button> <br> <br>
<center>
			<div class="btn-group" role="group" aria-label="Basic mixed styles example" style="position: relative;">
  				<button type="button" class="btn btn-success" onclick="window.location.href='/insertarusuario.jsp'"><i class="fas fa-plus-circle"></i> Agregar usuario</button>
  				<button type="button" class="btn btn-danger" onclick="window.location.href='/eliminarusuario.jsp'"><i class="fas fa-trash"></i> Eliminar usuario</button>
  				<button type="button" class="btn btn-warning" onclick="window.location.href='/actualizarusuario.jsp'"><i class="fas fa-pen-alt"></i> Actualizar usuario</button>
  				<button type="button" class="btn btn-info" onclick="window.location.href='/buscarusuario.jsp'"><i class="fas fa-search"></i> Buscar un usuario</button>
  				<button type="button" class="btn btn-primary" onclick="window.location.href='/listausuarios.jsp'"><i class="fas fa-search"></i> Listar todos los usuarios</button> 
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
		function eliminar() {
			var y = document.getElementById("cedula_usuario").value;
			var req = new XMLHttpRequest();
			var coincidencia = false;
			req.open('GET', 'http://localhost:8080/listarusuarios', false);
			req.send(null);
			var usuarios = null;
			if (req.status == 200)
				usuarios = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));
			for (i = 0; i < usuarios.length; i++) {
				
				console.log(usuarios[i].cedula_usuario);
				if (usuarios[i].cedula_usuario == y) {
					console.log(usuarios[i].cedula_usuario + " " + y);
					coincidencia = true
					break;
				}
			}
			console.log(coincidencia);
			if (coincidencia != false) {
				var cedula=document.getElementById("cedula_usuario").value;
				
				var xhr = new XMLHttpRequest();
				xhr.open("DELETE", "http://localhost:8080/eliminarusuario?cedula_usuario="+cedula);
				
				var element = document.getElementById("error");
				element.classList.add("visually-hidden");
				
				var element2 = document.getElementById("correcto");
				element2.classList.remove("visually-hidden");
				document.getElementById("cedula_usuario").value = "";
				xhr.send();
			} else {
				var element = document.getElementById("error");
				element.classList.remove("visually-hidden");
				
				var element2 = document.getElementById("correcto");
				element2.classList.add("visually-hidden");
				
				document.getElementById("cedula_usuario").value = "";;
			}
		}
	</script>

</body>
</html>