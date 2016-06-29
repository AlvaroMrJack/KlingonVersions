<html>
	<head>
		<meta charset="UTF-8">
		<title>Ventas a clientes</title>
                <link rel="stylesheet" type="text/css" href="css/estiloA.css"/>	
	</head>

	<body background="">
		<header class="menuVertical">
			<ul>
				<li class="noactive"><a href="estadisticas.jsp">Estadísticas del vendedor</a></li>
				<li class="active"><a href="ventas.jsp">Ventas a clientes</a></li>
				<li class="noactive"><a href="productos.jsp">Productos</a></li>
				<li class="noactive"><a href="administrarmetas.jsp">Administrar metas</a></li>
				<li class="noactive"><a href="index.jsp">Desconectar</a></li>
			</ul>
		</header>
		
            
		<div class="esp"></div>
		<div class="marco">
			<h1>Seleccionar cliente</h1>
			
			<div class="vendedor">
				<form name="form" method="get" action="#">
					<br/>
					<FONT>Nombre   </FONT><input class="inputN" type="text" name="nombre" id="nombre"/>
					<br />
					<FONT>Rut      </FONT><input class="inputA" type="text" name="apellidos" id="apellidos"/>
					<br />
					<FONT>Dirección</FONT><input class="inputD2" type="text" name="direccion" id="direccion"/>
					<br />
					<FONT>Teléfono </FONT><input class="inputT" type="text" name="telefono" id="telefono"/>
					<br />
					<FONT>Correo   </FONT><input class="inputC" type="text" name="correo" id="correo"/>
					<br />
					<FONT>Vendedor </FONT><input class="inputC2" type="text" name="vendedor" id="vendedor"/>
					<br />
					<FONT>Estado </FONT>
					<select class="listaE" id="estado">
						<option value="0">Cliente activo</option>
						<option value="1">No cliente</option>
						<option value="2">Cliente rechazado</option>
						<option value="3">Cliente en proceso</option>						
					</select>
					<input type="button" class="gc2" value="Guardar Cambios">
				</form>
				
				
				<select class="listaC" id="cliente">
					<option value="0">Mario2</option>
					<option value="1">Luigi</option>
					<option value="2">Princesa</option>
					<option value="3">Diablo</option>
				</select>
				
				<hr/><br/>
				<h1>Ventas al cliente</h1>
				
			</div>
		</div>
	</body>
</html>
