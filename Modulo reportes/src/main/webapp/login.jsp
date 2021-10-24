<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>TIENDA LA K J</title>
    <!--estilos en la página-->
    <link href="style.css" rel="stylesheet" type="text/css" />
        <!--Bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!-- font awesome-->
    <script src="https://kit.fontawesome.com/8e9e769e03.js" crossorigin="anonymous">
    </script>
  </head>

  <body>
<center>
    <!--barra de navegación-->
<nav class="navbar navbar-light" style="background-color: #e3f2fd">
  <!-- Navbar content -->
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
    <i class="fas fa-shopping-cart"></i> Bienvenido
    </a></div>
</nav>

<div class="cajapadre" style="top: 50px; width:584px; height:761px; background-image: url(image-login.jpg); position: cover; opacity: 0.95;">
	<div class="iniciars" style="color: #000233; position: relative; top: 320px;">
		<h1>Iniciar Sesión</h1><svg width="18px" height="8px"></svg>
	</div>

	<div class="usuario" style="color: #000233; position: relative; top: 320px;">
		<span class="nombreu"><i class="far fa-user"></i> Usuario</span> 
		<label class="inputusuario"> <input type="username" name="username" id="inputuser" required/> </label> 
	</div> 

	<div class="contraseña" style="color: #000233; position: relative; top: 350px; left:3px;"> 
		<span class="nombrec"><i class="fas fa-lock"></i> Contraseña</span> <label  class="inputcontraseña">
		<input type="password" name="password" id="inputpass" required/></label> <span class="icon-eyes">
		<button type="button" class="btn btn-link" style= "width: 10px; position: relative; left:-10px;" id= "Eye" onclick="mostrar()"><i class="far fa-eye"></i></button></span>
	</div>
	
	<div style= "position: relative; top:370px; text-align: center;">
		<button type="button" class="btn btn-success" onclick="comparar()">
			<i class="fas fa-sign-in-alt"></i> Iniciar Sesión
		</button>
		
		<div id="error" class="alert alert-danger visually-hidden" 
  		style = "position:relative; top:140px;" >Usuario o contraseña incorrecta!
		</div>
</center>

<footer class="footer" style="background: rgb(210, 252, 246); width: 100%; 
height: 125px; opacity: 0.93; margin: auto; margin-top: 100.9px;">
  <div class="caja-footer">
       <center>
        <a class="d-inline-flex align-items-center mb-2 link-dark text-decoration-none" href="/" aria-label="tienda">
          <title>Tienda Genérica</title><path fill-rule="evenodd" clip-rule="evenodd" fill="currentColor"></path>
          <div class = "tienda"><span class="fs-4">Tienda Genérica</span></div>
        </a>
        <ul class="list-unstyled small text-muted">
          <div class="descripcion"><li class="mb-2">Proyecto orientado al aplicativo web</div>
          <div class="valores"><li class="mb-2"> Scrum 9 - 2021</div>
        </ul>
        </center>
      </div>
    </div>
  </div>
</footer>

<script src="script.js"></script>
	
	<!-- Script que trae la informacion de la api y la compara con las entradas -->
	<script>
		function comparar() {
			//trayendo texto de input de username
			var x = document.getElementById("inputuser").value;
			//trayendo texto de input de password
			var y = document.getElementById("inputpass").value;
			//url de la api 
			var baseurl = "http://localhost:8080/listarusuarios";
			//creando un objeto de manipulacion de solicitudes
			var xmlhttp = new XMLHttpRequest();
			//abriendo la api
			xmlhttp.open("GET", baseurl, true);
			//funcion interna que compara la información
			xmlhttp.onreadystatechange = function() {
				//si se obtiene un 200 (Conexion correcta)
				if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
					//convirtiendo JSON en variable javascrip
					var usuarios = JSON.parse(xmlhttp.responseText);
					
					//verificando uno por uno si existe ese usuario
					for (i = 0; i < usuarios.length; i++) {
						
						//imprimiendo en la consola del navegador pata verificar
						console.log(usuarios);
						console.log(x);
						console.log(usuarios[i].usuario);
						console.log(y);
						console.log(usuarios[i].password);
						
						//si el nombre coincide
						if (usuarios[i].usuario === x) {
							//si la clave coincide
							if (usuarios[i].password === y) {
								console.log("si");
								var element = document.getElementById("error");
								element.classList.add("visually-hidden");
								document.getElementById("inputuser").value = "";
								document.getElementById("inputpass").value = "";
								window.location.href = "listausuarios.jsp";
								return;
							} else {
								//si la clave NO coincide
								console.log("error clave");
								var element = document.getElementById("error");
								element.classList.remove("visually-hidden");
								document.getElementById("inputuser").value = "";
								document.getElementById("inputpass").value = "";
								return;
							}
						}
					}
					//Si no existe el usuario
					console.log("no encontrado");
					
					//quitando la capacidad de ocultacion del error para mostrarlo
					var element = document.getElementById("error");
					element.classList.remove("visually-hidden");
					document.getElementById("inputuser").value = "";
					document.getElementById("inputpass").value = "";
					return;
				}
			};
			//ejecutando
			xmlhttp.send();
		}
		
	</script>
	
	<script type="text/javascript">
	var eye = document.getElementById('Eye');
	var input = document.getElementById('inputpass');
	eye.addEventListener("click", function mostrar(){
	    if (input.type === "password") {
	        input.type = "text";
	        eye.style.opacity = 0.9;
	    } else {
	        input.type = "password";
	        eye.style.opacity = 0.5;
	    }
	})
	</script>

</body>

</html>