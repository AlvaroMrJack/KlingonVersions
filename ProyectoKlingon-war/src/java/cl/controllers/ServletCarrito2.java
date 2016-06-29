/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controllers;

import cl.bean.CarritoBeanLocal;
import cl.bean.EmpleadoBeanLocal;
import cl.bean.GenericBeanLocal;
import cl.model.Cliente;
import cl.model.Detalle;
import cl.model.Empleado;
import cl.model.Stock;
import cl.model.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Skitles
 */
public class ServletCarrito2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    GenericBeanLocal gbl;
    @EJB
    EmpleadoBeanLocal ebl;
    @EJB
    CarritoBeanLocal cbl;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
       HttpSession sesion=request.getSession(); 
       Empleado u = (Empleado)sesion.getAttribute("rutlogin");
       String rut_cli =request.getParameter("rutcli");
       String flag =request.getParameter("flag");
        try {
        Cliente c = ebl.FindCliByRut(Integer.parseInt(rut_cli)); 
        ArrayList<Detalle> detalle = (ArrayList)cbl.detalle();
        request.setAttribute("detalle", detalle);
        Venta v = new Venta().GenerarVentaPorDetalle(detalle, c);
        request.setAttribute("venta", v);
        request.setAttribute("cliente", c);
        int ultimaventa;
        if(flag.equals("000")){
        ultimaventa =gbl.CreateVenta(v); 
        for(Detalle d: detalle){     
        d.setVenta(gbl.FindById(ultimaventa));
        ebl.CreateDetalle(d); 
        }
        } 
        
        if (flag.equals("0")) {
         request.getRequestDispatcher("micarrito.jsp").forward(request, response);   
         }else{
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Venta concretada exitosamente');");
        out.println("location='registrovisita.do';");
        out.println("</script>");   
         }
  
        } catch (NumberFormatException | ServletException | IOException e) {
        }
      
       
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
