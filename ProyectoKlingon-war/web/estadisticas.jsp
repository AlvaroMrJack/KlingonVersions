<html>
	<head>
		<meta charset="UTF-8">
		<title>Estadisticas del vendedor</title>
                <link rel="stylesheet" type="text/css" href="css/estiloA.css"/>	
	</head>

	<body background="">
		<header class="menuVertical">
			<ul>
				<li class="active"><a href="estadisticas.jsp">Estadísticas del vendedor</a></li>
				<li class="noactive"><a href="ventas.jsp">Ventas a clientes</a></li>
				<li class="noactive"><a href="productos.jsp">Productos</a></li>
				<li class="noactive"><a href="administrarmetas.jsp">Administrar metas</a></li>
				<li class="noactive"><a href="index.jsp">Desconectar</a></li>
			</ul>
		</header>
		<div class="esp"></div>
		<div class="marco">
			<h1>Seleccionar vendedor</h1>
			
			<div class="vendedor">
				<form name="form" method="get" action="#">
					<FONT>Nombre   </FONT><input class="inputN" type="text" name="nombre" id="nombre"/>
					<br />
					<FONT>Rut      </FONT><input class="inputA" type="text" name="apellidos" id="apellidos"/>
					<br />
					<FONT>Zona     </FONT><input class="inputD" type="text" name="direccion" id="direccion"/>
					<br />
					<FONT>Teléfono </FONT><input class="inputT" type="text" name="telefono" id="telefono"/>
					<br />
					<FONT>Correo   </FONT><input class="inputC" type="text" name="correo" id="correo"/>
					<br />
					<input type="button" class="gc" value="Guardar Cambios"></input>
				</form>
				
				<select class="lista" id="vendedor">
					<option value="0">Mario</option>
					<option value="1">Luigi</option>
					<option value="2">Princesa</option>
					<option value="3">Diablo</option>
				</select>
				
			</div>
			<hr/><br/>			
			<h1>Ruta diaria del vendedor</h1>
			
			
			
			
			
			
			
			<hr/><br/>			
			<h1>Estado de metas del vendedor</h1>
			
			
			
			
		</div>

	</body>
</html>