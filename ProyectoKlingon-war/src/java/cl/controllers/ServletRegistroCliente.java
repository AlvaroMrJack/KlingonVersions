/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controllers;

import cl.bean.EmpleadoBeanLocal;
import cl.model.Cliente;
import cl.model.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Skitles
 */
@WebServlet(name = "ServletRegistroCliente", urlPatterns = {"/registrocliente.do"})
public class ServletRegistroCliente extends HttpServlet {

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
    EmpleadoBeanLocal ebl;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession sesion=request.getSession(); 
       Empleado u = (Empleado)sesion.getAttribute("rutlogin"); 
       String rut = request.getParameter("rut");
       String dv = request.getParameter("dv");
       String nom = request.getParameter("nombre");
       String apellido = request.getParameter("apellido");
       String fono = request.getParameter("fono");
       String correo = request.getParameter("correo");
       String direccion = request.getParameter("direccion");
       String comentario = request.getParameter("comentario");
       String estado = request.getParameter("estado");
       //String comentario, Empleado empleado, String FechaDeIngreso, int rut, 
       //String dv, String nombre, String apellido, int fono, String email, String estado, String direccion 
        try {
          Cliente c = new Cliente(comentario, u, Cliente.fechaactual(), Integer.parseInt(rut),
          dv, nom, apellido, Integer.parseInt(fono), correo, Cliente.ObtEstado(Integer.parseInt(estado)), direccion);
          ebl.CreateCliente(c);
          
           PrintWriter out = response.getWriter();
           out.println("<script type=\"text/javascript\">");
           out.println("alert('Cliente Agregado exitosamente');");
           out.println("location='registrocliente.jsp';");
           out.println("</script>"); 

       }
       catch(NumberFormatException ex){
           response.sendRedirect("registrocliente.jsp");
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
