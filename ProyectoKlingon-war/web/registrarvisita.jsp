<html>
	<head>
	<meta charset="UTF-8">
		<title>Registrar visita</title>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <link rel="stylesheet" type="text/css" href="css/estiloV.css"/>
                <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
               
        </head>

	<body>  
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
            <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true?key=AIzaSyDf6T9z2kzSTV2JM_AIrVkpqI8vAnk9bqE"></script>
		<header class="menuVertical">
			<ul>
				<li class="noactive"><a href="empestadisticas.do">Mis estadísticas</a></li>
				<li class="noactive"><a href="registroruta.do">Registro de ruta</a></li>
				<li class="active"><a href="registrovisita.do">Visita / Venta</a></li>
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
		
		<div class="marco">
		
			<div class="map1">
                            <div id='map_canvas' style='width:100%; height:330px;'></div>
			</div>
                       <script type="text/javascript">
                                var map;
                                var latitud;
                                var longitud;

                                $(document).ready(function() {
                                    localizame(); /*Cuando cargue la página, cargamos nuestra posición*/                
                                  });

                                function localizame() {
                                    if (navigator.geolocation) { /* Si el navegador tiene geolocalizacion */
                                        navigator.geolocation.getCurrentPosition(coordenadas, errores);
                                    }else{
                                        alert('Oops! Tu navegador no soporta geolocalización. Bájate Chrome, que es gratis!');
                                    }
                                }

                                function coordenadas(position) {
                                    latitud = position.coords.latitude; /*Guardamos nuestra latitud*/
                                    longitud = position.coords.longitude; /*Guardamos nuestra longitud*/
                                    cargarMapa();
                                  
                                }

                                function errores(err) {
                                    /*Controlamos los posibles errores */
                                    if (err.code == 0) {
                                      alert("Oops! Algo ha salido mal");
                                    }
                                    if (err.code == 1) {
                                      alert("Oops! No has aceptado compartir tu posición");
                                    }
                                    if (err.code == 2) {
                                      alert("Oops! No se puede obtener la posición actual");
                                    }
                                    if (err.code == 3) {
                                      alert("Oops! Hemos superado el tiempo de espera");
                                    }
                                }

                               function cargarMapa() {
                                    var latlon = new google.maps.LatLng(latitud,longitud); 
                                    
                                     var formulario=$("#formulario");
                                        formulario.find("input[name='latitud']").val(latitud.toString());
                                        formulario.find("input[name='longitud']").val(longitud.toString());
                                    
                                    var myOptions = {
                                    zoom: 18,
                                    center: latlon,
                                    mapTypeId: google.maps.MapTypeId.ROADMAP
                                    };

                                    map = new google.maps.Map($("#map_canvas").get(0), myOptions); 

                                    var coorMarcador = new google.maps.LatLng(latitud,longitud);

                                    var marcador = new google.maps.Marker({
                                    position: coorMarcador, 
                                    map: map, 
                                    title: "Dónde estoy?" 
                                 });
                              }
                              
                                function Enviar(id){
                                    var href = "registrovisita.do?latitud="+latitud+"&longitud="+longitud+"&id="+id;
                                    window.location.href= href;
       
                                }
                                function Enviar2(id){
                                    var href = "registroventa.do?id="+id;
                                    window.location.href= href;
       
                                }
                                
                            </script>
	            
                    <div class="arr">
                       <input type="button" class="av1" value="Actualizar Ubicación" onclick="localizame()"/>
                    </div>
                            
                    <form id="formulario">
                        <div class="are">
                            <input type="text" name="latitud" class="latitud" id="latitud" disabled/>
                          <input type="text" name="longitud" class="longitud" id="longitud" disabled/>
                        </div>
                             
                            
             
       
                    <table border="1">
                        <caption ><strong>REGISTRO DE VISITA</strong></caption>
                            <thead>
                                <th>Ruta ID</th>
                                <th>Ruta Fecha</th>
                                <th>Nombre cliente</th>
                                <th>Fono Cliente</th>
                                <th>Comentario Cliente</th>
                                <th>Dirección Cliente</th>
                                <th>Estado</th>
                                <th>Visita</th>
                                <th>Venta</th>
                            </thead>
                            
                            <tbody>  
                                <c:forEach items="${requestScope.miruta}" var="pro">
                                    <tr>
                                        <td>${pro.getRu_id()}</td>
                                        <td>${pro.getRu_fecha()}</td>
                                        <td>${pro.getCliente().getNombre()}</td>
                                        <td>${pro.getCliente().getFono()}</td>
                                        <td>${pro.getCliente().getComentario()}</td>
                                        <td>${pro.getCliente().getDireccion()}</td>
                                        <td>${pro.getRu_estado()}</td>     
                                        
                                        <td><input type="button" onclick="Enviar(${pro.getRu_id()})" class="btnC"/></td>
                                        <td><input type="button" onclick="Enviar2(${pro.getCliente().getRut()})" class="btnV"/></td>
                                     </tr>
                                </c:forEach>
                            </tbody>
                      </table>
                    </form>
                       
		</div>     
	</body>
	
</html>