<html>
	<head>
		<meta charset="UTF-8">
		<title>Productos</title>
                <link rel="stylesheet" type="text/css" href="css/estiloA.css"/>	
	</head>

	<body background="">
		<header class="menuVertical">
			<ul>
				<li class="noactive"><a href="estadisticas.jsp">Estadísticas del vendedor</a></li>
				<li class="noactive"><a href="ventas.jsp">Ventas a clientes</a></li>
				<li class="active"><a href="productos.jsp">Productos</a></li>
				<li class="noactive"><a href="administrarmetas.jsp">Administrar metas</a></li>
				<li class="noactive"><a href="index.jsp">Desconectar</a></li>
			</ul>
		</header>
		
		
		<div class="esp"></div>
		
		
		<div class="marco">
			<h1>Seleccionar Producto</h1>
		
			<div class="vendedor">
				<form name="form" method="get" action="#">
					<br/>
					<FONT>Nombre   </FONT><input class="inputN" type="text" name="nombre" id="nombre"/>
					<br />
					<FONT>ID       </FONT><input class="inputID" type="text" name="id" id="id"/>
					<br />
					<FONT>Marca    </FONT><input class="inputM" type="text" name="marca" id="marca"/>
					<br />
					<FONT>Precio   </FONT><input class="inputP" type="text" name="precio" id="precio"/>
					<br />
					<input type="button" class="gc" value="Guardar Cambios">
				</form>
				
				<select class="listaP" id="producto">
					<option value="0">Escalera</option>
					<option value="1">Fierro</option>
					<option value="2">Adoquines</option>
					<option value="3">Plancha</option>
				</select>
				
				<hr/><br/>
				<h1>Listado de productos</h1>
				
			</div>
		
		</div>

	</body>
</html>