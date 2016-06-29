<%@page import="cl.model.Metas"%>
<%@page import="cl.model.Empleado"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>



<html>
	<head>
         
          
	<meta charset="UTF-8">
		<title>Mis Estadisticas</title>
                <link rel="stylesheet" type="text/css" href="css/estiloV.css"/>	
                
	</head>

	<body>
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
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
            
            
            
            <%
            
            HttpSession sesion=request.getSession(); 
            Empleado u = (Empleado)sesion.getAttribute("rutlogin");
            Metas m = (Metas) sesion.getAttribute("metas");
            int vent = (int)sesion.getAttribute("vent");
            int visit = (int)sesion.getAttribute("cliVisit");
            int nuev = (int)sesion.getAttribute("cliNuevo");
            %>
           
		<header class="menuVertical">
			<ul>
				<li class="active"><a href="empestadisticas.do">Mis estadísticas</a></li>
                                <li class="noactive"><a href="registroruta.do">Registro de ruta</a></li>
				<li class="noactive"><a href="registrovisita.do">Visita / Venta</a></li>
				<li class="noactive"><a href="registrocliente.jsp">Registro de cliente</a></li>
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
            
		<div class="marcoI">
			
			<div class="metas">
				<div class="tit"><p>Meta semanal</p></div>
				<div class="mov">
                                    <FONT>Vender a: <%=m.getMeta_cant_ventas() %> y llevo: <%=vent%> </FONT> <br/><br/>
				<FONT>Visitar a: <%=m.getMeta_cant_visitas() %> y llevo: <%=visit%> </FONT><br/><br/>
				<FONT>Agregar clientes: <%=m.getMeta_cant_clientes() %>  y llevo: <%=nuev%></FONT>
				</div>
			</div>
			
			<br/>
			<p class="d"><strong>MIS DATOS</strong></p>
			<br/>
			<div class="mov1"><br/>
                            <FONT><strong>Nombre: </strong><%=u.getNombre()%></FONT><br/>
				<FONT><strong>Rut: </strong><%=u.getRut()%></FONT><br/>
				<FONT><strong>Zona: </strong><%=u.getZona().getZona_nom()%></FONT>
			</div>
		
			<div class="gr">
                        <img src="Imagenes/grafica<%=u.getRut()%>.png" />
			</div>
		
		</div>
   
	</body>
	
</html>