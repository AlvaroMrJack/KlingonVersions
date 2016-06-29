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
	</head>

	<body background="">
            <%
            HttpSession sesion=request.getSession(); 
            Empleado u = (Empleado)sesion.getAttribute("rutlogin");    
            ArrayList<Producto> prod = (ArrayList)request.getAttribute("productos");
            Cliente c = (Cliente)request.getAttribute("cliente");
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
		
			<p class="re"><strong>FORMULARIO DE VENTA</strong></p>
			<div class="tre">
                    <form  action="carrito.do" method="post">
			<div class="tra">
                            
                            <div class="carrito">
                                <span><a href="carrito2.do?rutcli=<%=c.getRut()%>&flag=0" class="nCarrito">${requestScope.totaldetalle+0}</a></span>
                                <IMG SRC="Imagenes/carrito.png" class="imgpng">
                            </div>
                            
                            
				<p class="gg">Venta a cliente</p>
                                <input class="listardc" type="text" value="<%=c.getNombre()+" "+c.getApellido()%>" disabled >
                                <input type="text" name="rutcli" value="<%=c.getRut()%>" hidden/>
				<br/>
				<p class="gg">Producto</p>
				<select class="listardc" id="producto" name="prod_id">
                                    <option value="0" >Seleccionar </option>
                                    <%    for(Producto p: prod){                %>
                                    <option value="<%=p.getProd_id()%>"> <%=p.getProd_nom()%> </option>
                                     <%     }         %>           
				</select>
				
			</div>
			<div class="tra2">
				<p class="gg">Cantidad del producto</p>
                                <input type="text" class="bb" name="cant_prod" required>

			</div>
                                <input type="submit" class="ll" value="Añadir"></input>
                    </form> 
                                
			</div>
			<br/><br/><br/><hr/>
                                             <table border="1">
                        <caption ><strong>STOCK</strong></caption>
                            <thead>
                                <th>PRODUCTO</th>
                                <th>PRECIO</th>
                                <th>CANTIDAD</th>
                                <th>SUCURSAL</th>
                            </thead>
                            
                       <tbody>  
                           <c:forEach items="${requestScope.stock}" var="pro">
                                    <tr>
                                        <td>${pro.getProducto().getProd_nom()}</td>
                                        <td>${pro.getProducto().getProd_precio()}</td>
                                        <td>${pro.getStock_cantidad() }</td>
                                        <td>${pro.getSucursal().getSuc_nom() }</td>
                                      
                                     </tr>
                           </c:forEach>
                            </tbody>
                      </table>   
		</div>                       
                

      <%        
            }
            
            }catch(Exception ex){
            response.sendRedirect("index.jsp");
            }
         
         %>              
	</body>
	
</html>