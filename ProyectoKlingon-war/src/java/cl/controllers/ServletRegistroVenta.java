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
import cl.model.Empleado;
import cl.model.Producto;
import cl.model.Stock;
import java.io.IOException;
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
public class ServletRegistroVenta extends HttpServlet {
    @EJB
    GenericBeanLocal gbl;
    @EJB
    EmpleadoBeanLocal ebl;
    @EJB
    CarritoBeanLocal cbl;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       cbl.clear();
       HttpSession sesion=request.getSession(); 
       Empleado u = (Empleado)sesion.getAttribute("rutlogin");
       String rut = request.getParameter("id");
        System.out.println(rut);  
        try {
        ArrayList<Producto> productos= gbl.GetAllProductos();
        Cliente c = ebl.FindCliByRut(Integer.parseInt(rut));
        System.out.println(c.getApellido());
        request.setAttribute("productos", productos);
        request.setAttribute("cliente", c);
        ArrayList<Stock> stock = (ArrayList)ebl.ObtAllStock();
        request.setAttribute("stock", stock);
        request.getRequestDispatcher("registroventa.jsp").forward(request, response);
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
