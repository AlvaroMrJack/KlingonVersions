<html>
	<head>
		<meta charset="UTF-8">
		<title>Contacto</title>
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
				<li class="noactive"><a href="registrocliente.jsp">Registro de cliente</a></li>
				<li class="active"><a href="contacto.jsp">Contacto</a></li>
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
            
		<div class="marcoC1">
			<div class="texto">Contáctanos, explicanos cuál es el problema, queremos saber tu opinión 
			parar mejorar tu estación de trabajo de escritorio y móvil. Estamos al tanto de tu 
			seguimiento como tú a tus clientes.</div>
                    <img src="Imagenes/g2g.png" class="gggg"/>
		</div>
		
		<div class="marcoC2">
			</br>
			<FONT><strong>Asunto del mensaje</strong></FONT><br/><br/>
                        <form method="post" action="contacto.do">
			<input type="text" class="asunto" name="asunto"><br/><br/>
			<FONT><strong>Mensaje</strong></FONT><br/><br/>
			<textarea class="mensaje" name="mensaje"></textarea><br/><br/>
			<input type="submit" class="enviar" value="Enviar">
                        </form>
		</div>

	</body>
	
</html>
