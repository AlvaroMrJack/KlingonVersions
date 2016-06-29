<html>
	<head>
	<meta charset="UTF-8">
		<title>Registro de cliente</title>
                <link rel="stylesheet" type="text/css" href="css/estiloV.css"/>	
                <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	</head>

	<body background="">
                        <script>
        function flotante(tipo){

                if (tipo==1){
                $('#contenedor').show();
            $('#flotante').animate({
              marginTop: "-152px"
            });
                }
                if (tipo==2){
            $('#flotante').animate({
              marginTop: "-756px"
            });
                setTimeout(function(){
                $('#contenedor').hide();

                },500)
                }

        }
        </script>
		<header class="menuVertical">
			<ul>
				<li class="noactive"><a href="empestadisticas.do">Mis estadísticas</a></li>
				<li class="noactive"><a href="registroruta.do">Registro de ruta</a></li>
				<li class="noactive"><a href="registrovisita.do">Visita / Venta</a></li>
				<li class="active"><a href="registrocliente.jsp">Registro de cliente</a></li>
				<li class="noactive"><a href="contacto.jsp">Contacto</a></li>
				<li class="noactive"><a href="index.jsp">Desconectar</a></li>
			</ul>
		</header>
              <div id="contenedor" style="display:none">
                <div id="flotante"><h1>Esta Pestaña solo esta disponible desde registrar visita</h1>
                        <input type="button" onclick="flotante(2)" class="segB" value="Volver"/>
                </div>

                <div id="fondo"></div>

                </div>
                
                <div class="esp"></div>
		
		<div class="marco">
		
                    <div class="marcoN">
		
				<p class="re"><strong>REGISTRAR NUEVO CLIENTE</strong></p>
                        <form action="registrocliente.do" method="post" >
                            <div class="lis">
                                    <p class="sub">Rut</p>
                                    <input type="text" class="inn" name="rut" size="11"> - <input type="text" class="inn" name="dv" size="1">
                                    <p class="sub">Nombre</p>
                                    <input type="text" class="in" name="nombre">
                                    <p class="sub">Apellido</p>
                                    <input type="text" class="in" name="apellido">
                                    <p class="sub">Dirección</p>
                                    <input type="text" class="in" name="direccion">
                            </div>
				
                            <div class="lis1">
                                    <p class="sub">Comentario</p>
                                    <textarea rows="4" cols="50" name="comentario" class="innn">
                                    </textarea>
                                    <p class="sub">Correo</p>
                                    <input type="email" class="in" name="correo">
                                    <p class="sub">Teléfono</p>
                                    <input type="tel" class="in" name="fono">
                                    <p class="sub">Estado del cliente</p>

                                    <select class="listaCN" id="clienteN" name="estado">
                                            <option value="0">Seleccionar</option>
                                            <option value="1">Activo</option>
                                            <option value="2">NoActivo</option>
                                    </select><br/>
                                    <div class="b">
                                        <input type="submit" class="ac" value="Agregar cliente"/>
                                    </div>
                                    
                            </div>
                        </form>
                    </div>
		
			
                    <br/><br/>
		</div>

	</body>
	
</html>
