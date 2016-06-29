<html>
	<head>
		<meta charset="UTF-8">
		<title>Administrar metas</title>
                <link rel="stylesheet" type="text/css" href="css/estiloA.css"/>	
	</head>

	<body background="">
		<header class="menuVertical">
			<ul>
				<li class="noactive"><a href="estadisticas.jsp">Estadísticas del vendedor</a></li>
				<li class="noactive"><a href="ventas.jsp">Ventas a clientes</a></li>
				<li class="noactive"><a href="productos.jsp">Productos</a></li>
				<li class="active"><a href="administrarmetas.jsp">Administrar metas</a></li>
				<li class="noactive"><a href="index.jsp">Desconectar</a></li>
			</ul>
		</header>
		<div class="esp"></div>
		<div class="marco">
		
			<h1>Administrar metas semanales</h1>
			
			<div class="vendedor">
				<form name="form" method="get" action="#">
					<br/>
					<FONT>Fecha de inicio	  </FONT><input class="inputI" type="text" name="inicio" id="inicio"/>
					<br />
					<FONT>Fecha de término	  </FONT><input class="inputT2" type="text" name="termino" id="termino"/>
					<br />
					<FONT>Cantidad de ventas  </FONT><input class="inputVE" type="text" name="ventas" id="ventas"/>
					<br />
					<FONT>Cantidad de visitas </FONT><input class="inputV" type="text" name="vistas" id="vistas"/>
					<br />
					<FONT>Nuevos clientes     </FONT><input class="inputC3" type="text" name="clientes" id="clientes"/>
					<br />
					<input type="button" class="gc3" value="Guardar Cambios">
				</form>
			<br/>
			<hr/><br/>
				<h1>Buscador de metas pasadas</h1>
			
		</div>
	</body>
</html>