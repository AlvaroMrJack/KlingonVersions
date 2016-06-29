<%@page import="java.util.ArrayList"%>
<%@page import="cl.model.Cliente"%>
<%@page import="cl.model.Cliente"%>
<%@page import="cl.model.Empleado"%>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Registro de ruta</title>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <link rel="stylesheet" type="text/css" href="css/estiloV.css"/>	
                <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
                
	</head>

	<body background="" > 
           <script type="text/javascript" src="https://maps.google.com/maps/api/js?key=AIzaSyDf6T9z2kzSTV2JM_AIrVkpqI8vAnk9bqE"></script>
           <script src="http://j.maxmind.com/app/geoip.js"></script>        
          
           
                        <script type="text/javascript">
                                        var map;
                                        var geocoder;
                                        var centerChangedLast;
                                        var reverseGeocodedLast;
                                        var currentReverseGeocodeResponse;
                                        var latitud;
                                        var longitud;

                                        function initialize(map_lat, map_lon, map_zoom) {

                                          map_lat   = typeof map_lat !== 'undefined' ? map_lat : '-33.44524518705943';
                                          map_lon   = typeof map_lon !== 'undefined' ? map_lon : '-70.65525428798833';
                                          map_zoom  = typeof map_zoom !== 'undefined' ? map_zoom : 12;

                                          var latlng = new google.maps.LatLng(map_lat, map_lon);

                                          var myOptions = {
                                            zoom: map_zoom,
                                            center: latlng,
                                            mapTypeId: google.maps.MapTypeId.ROADMAP
                                          };

                                          map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
                                          geocoder = new google.maps.Geocoder();
                                          setupEvents();
                                          centerChanged();
                                          var opt = { minZoom: 3 };
                                          map.setOptions(opt);

                                        }

                                        function setupEvents() {

                                          reverseGeocodedLast = new Date();
                                          centerChangedLast = new Date();

                                          setInterval(function() {
                                            if((new Date()).getSeconds() - centerChangedLast.getSeconds() > 1) {
                                              if(reverseGeocodedLast.getTime() < centerChangedLast.getTime())
                                                reverseGeocode();
                                            }
                                          }, 1000);

                                          google.maps.event.addListener(map, 'center_changed', centerChanged);
                                          google.maps.event.addDomListener(document.getElementById('crosshair'),'dblclick', function() {
                                             map.setZoom(map.getZoom() + 1);
                                          });

                                        }

                                        function getCenterLatLngText() {

                                          return '(' + map.getCenter().lat() +', '+ map.getCenter().lng() +')';

                                        }

                                        function centerChanged() {

                                          centerChangedLast = new Date();
                                          var latlng = getCenterLatLngText();
                                          var lat = map.getCenter().lat();
                                          var lng = map.getCenter().lng();
                                          document.getElementById('lat').value = lat;
                                          document.getElementById('lng').value = lng;
                                          reverseGeocode();

                                        }
                                        
                                        function insertar(direccion){
                                            document.getElementById('address').value = direccion;
                                            geocode();
                                            addMarkerAtCenter();
                                            
                                        }
                                        

                                        function reverseGeocode() {

                                          reverseGeocodedLast = new Date();
                                          geocoder.geocode({latLng:map.getCenter()},reverseGeocodeResult);

                                        }

                                        function reverseGeocodeResult(results, status) {

                                          currentReverseGeocodeResponse = results;

                                          if(status == 'OK') {
                                            if(results.length == 0) {
                                              document.getElementById('formatedAddress').innerHTML = '???';
                                            } else {
                                              document.getElementById('formatedAddress').innerHTML = results[0].formatted_address;
                                            }
                                          } else {
                                            document.getElementById('formatedAddress').innerHTML = '???';
                                          }

                                        }

                                        function geocode() {

                                          var address = document.getElementById("address").value;

                                          geocoder.geocode({
                                            'address': address,
                                            'partialmatch': true
                                          }, geocodeResult);

                                        }

                                        function geocodeResult(results, status) {

                                          if (status == 'OK' && results.length > 0) {
                                            map.fitBounds(results[0].geometry.viewport);
                                          } else {
                                            alert("Geocode was not successful for the following reason: " + status);
                                          }

                                        }

                                        function addMarkerAtCenter() {

                                          var marker = new google.maps.Marker({
                                              position: map.getCenter(),
                                              map: map
                                          });

                                          var text = 'Lat/Lng: ' + getCenterLatLngText();

                                          if(currentReverseGeocodeResponse) {
                                            var addr = '';
                                            if(currentReverseGeocodeResponse.size == 0) {
                                              addr = 'None';
                                            } else {
                                              addr = currentReverseGeocodeResponse[0].formatted_address;
                                            }
                                            text = text + '<br>' + 'Dirección: <br>' + addr;
                                          }

                                          var infowindow = new google.maps.InfoWindow({ content: text });

                                          google.maps.event.addListener(marker, 'click', function() {
                                            infowindow.open(map,marker);
                                          });

                                        }

                                        $(document).ready(function(){
                                              localizame();
                                              initialize();
                                              

                                        });

                                        $(document).keypress(function(event){

                                          var keycode = (event.keyCode ? event.keyCode : event.which);
                                          if(keycode == '13'){
                                            geocode();    
                                          }

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
                                   var coorMarcador = new google.maps.LatLng(latitud,longitud);
                                    var marcador = new google.maps.Marker({
                                    position: coorMarcador, 
                                    map: map, 
                                    title: 'Esta es su ubicación actual!' 
                                 });
                              }

                             function Enviar(id){
                                 var href = "registroruta.do?rut="+id;
                                 window.location.href= href;
                                }
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
            </script>
            
            
             <script>
                window.onload = function() {
                  loadShares();
                };
                </script>

            
		<header class="menuVertical">
			<ul>
				<li class="noactive"><a href="empestadisticas.do">Mis estadísticas</a></li>
				<li class="active"><a href="registroruta.do">Registro de ruta</a></li>
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
		
		<div class="marco">
                    
                    <div class="mark">
                    <p class="aaa"><strong>¿NECESITA MARCAR UN LUGAR EN EL MAPA?, INGRESE LA DIRECCIÓN AQUÍ</strong></p>
                     
                       
                  <div id="crosshair"></div>
                  
                    <div class="form">
                        <ul>
                          <li></li>
                          <li><input type="text" id="address" placeholder="Escribe aquí tu lugar..." class="input" /> <input type="button" value="Buscar" onclick="geocode()" class="button" /><input type="button" value="Insertar marcador" onclick="addMarkerAtCenter()" class="button" /></li>
                        </ul>
                    </div>
                    <div class="coordinates">
                      <em class="lat">Latitud</em>
                      <em class="lon">Longitud</em>
                      <input type="text" id="lat" onclick="select()" style="font-size: 20px" disabled/>
                      <input type="text" id="lng" onclick="select()" style="font-size: 20px" disabled/>
                    </div><br/>
                    <div class="address">
                      <span id="formatedAddress">...</span>
                    </div>  
                  
                    </div>
                 <div class="map1">
                     <div id='map_canvas' style='width:100%; height:330px;'></div>
	         </div>
                      <table border="1">
                          <caption ><strong>MI CARTERA DE CLIENTES</strong></caption>
                            <thead>
                                <th>Rut</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Dirección</th>
                                <th>Teléfono</th>
                                <th>Estado</th>
                                <th>Comentario</th>
                                <th>Fecha Ingreso</th>
                                <th>Añadir</th>
                                <th>Marcar</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.cartera}" var="pro">
                                    <tr>
                                        <td>${pro.getRut() }</td>
                                        <td>${pro.getNombre() }</td>
                                        <td>${pro.getApellido() }</td>
                                        <td>${pro.getDireccion()}</td>
                                        <td>${pro.getFono()}</td>
                                        <td>${pro.getEstado()}</td>
                                        <td>${pro.getComentario()}</td>
                                        <td>${pro.getFechaDeIngreso()}</td>
                                        <!--<td><a class="editar" href="registroruta.do?rut=${pro.getRut()}">Añadir</a></td>-->
                                        <td><input type="button" onclick="Enviar(${pro.getRut()})" class="edd"/></td>
                                        <td><input type="button" onclick="insertar('${pro.getDireccion()}')" class="editar"/></td>
                                        
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br/>
                        
                    
                            
                        <table border="1">
                            <caption ><strong>MI RUTA DIARIA</strong></caption>
                            <br/>
                            <thead>
                                <th>Ruta ID</th>
                                <th>Ruta Fecha</th>
                                <th>Nombre cliente</th>
                                <th>Fono Cliente</th>
                                <th>Comentario Cliente</th>
                                <th>Dirección Cliente</th>
                                <th>Estado</th>
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
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
			
		</div>
	</body>	
</html>
