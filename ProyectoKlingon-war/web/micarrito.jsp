<%@page import="cl.model.Venta"%>
<%@page import="cl.model.Detalle"%>
<%@page import="cl.model.Cliente"%>
<%@page import="cl.model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.model.Empleado"%>


<html>

	<head>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<title>Registro de venta</title>
                <link rel="stylesheet" type="text/css" href="css/estiloV.css"/>
                <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	</head>
        
        
	<body background="">
            <script>
         function Enviar(rut){
                  var href = "carrito2.do?flag=000&rutcli="+rut;
                 window.location.href= href;
       
          }   
          
         </script>
            
            
            <%
            HttpSession sesion=request.getSession(); 
            Empleado u = (Empleado)sesion.getAttribute("rutlogin");    
            //ArrayList<Detalle> detalle = (ArrayList)request.getAttribute("detalle");
            Cliente c = (Cliente)request.getAttribute("cliente");
            Venta v = (Venta)request.getAttribute("venta");
            try{
            
            if (u != null) {
                    
                
             
            %>
		<header class="menuVertical">
			<ul>
				<li class="noactive"><a href="empestadisticas.do">Mis estadísticas</a></li>
				<li class="noactive"><a href="registroruta.do">Registro de ruta</a></li>
				<li class="noactive"><a href="registrovisita.do">Visita / Venta</a></li>
				<li class="noactive"><a href="registrocliente.jsp">Registro de cliente</a></li>
				<li class="active"><a href="#####">Registro de Venta</a></li>
				<li class="noactive"><a href="contacto.jsp">Contacto</a></li>
				<li class="noactive"><a href="index.jsp">Desconectar</a></li>
			</ul>
		</header>
		<div class="esp"></div>
<div class="marco">
	
                    <p class="re"><strong>Mi Carrito de compras</strong></p>
                    
        <div class="mainFact">
	<p> </p>
            <div class="datE">
                    <p> DATOS VENDEDOR: <%=u.getNombre()+"  "+u.getApellido()+" RUT "+u.getRut() %> </p>
            </div>

            <div class="numF">
                    <h3>NÚMERO DE FACTURA</h3>
            </div>

            <div class="fechE">
                    <p> FECHA VENTA: ${requestScope.venta.getVen_fecha()}   </p>
            </div>
	
	<div class="masD">
	<table class="demo">
		<tbody>
			<tr>
				<td>Señor(es)</td>
				<td>${requestScope.venta.getCiente().getNombre()}  ${requestScope.venta.getCiente().getApellido()}</td>
				<td>Rut</td>
				<td>${requestScope.venta.getCiente().getRut()}</td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td>${requestScope.venta.getCiente().getDireccion()}</td>
				<td>Teléfono</td>
				<td>${requestScope.venta.getCiente().getFono()}</td>
			</tr>
		<tbody>
	</table>
	</div>
	
	
	
	
	<table border="1">
            <caption ><strong>DETALLE DE <%=c.getNombre()+" "+c.getApellido() %></strong></caption>
                <thead>
                    <th>Codigo</th>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Total</th>
                </thead>

            <tbody>  
                <c:forEach items="${requestScope.detalle}" var="pro">
                    <tr>
                        <td>${pro.getProducto().getProd_id()}</td>
                        <td>${pro.getProducto().getProd_nom()}</td>
                        <td>${pro.getDet_cantidad()}</td>
                        <td>$ ${pro.getDet_precio()}</td>
                        <td>$ ${pro.getDet_total()}</td>

                     </tr>
                </c:forEach>
            </tbody>
      </table>
                
	
	
	<div class="fact">
		<div class="dts">
			<h3>Usuario: <%=c.getNombre()+" "+c.getApellido() %></h3>
		</div>
            
		<table class="tbV">
                  <tr>
			<th>NETO</th>
			<td>$ ${requestScope.venta.getVen_neto()}</td>
		  </tr>
		  <tr>
			<th>SUB TOTAL</th>
			<td>$ ${requestScope.venta.getSubtotal()}</td>
		  </tr>
		  <tr>
			<th>DESCUENTO</th>
			<td>$ ${requestScope.venta.getVen_dscto()}</td>
		  </tr>
		  <tr>
			<th>IVA</th>
			<td>$ ${requestScope.venta.getVen_iva()}</td>
		  </tr>
                  <tr>
			<th>TOTAL</th>
			<td>$ ${requestScope.venta.getVen_total()}</td>
		  </tr>
		</table>
	</div>
    </div>
        <input type="submit" onclick="Enviar(<%=c.getRut()%>)" class="ll" value="Generar Venta" />
</div>                       
                

      <%        
            }
            
            }catch(Exception ex){
            response.sendRedirect("index.jsp");
            }
         
         %>              
	</body>
	
</html>