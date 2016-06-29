/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controllers;

import cl.bean.CarritoBeanLocal;
import cl.bean.EmpleadoBeanLocal;
import cl.bean.GenericBeanLocal;
import cl.dao.ProductoDAO;
import cl.dao.ProductoMysql;
import cl.model.Cliente;
import cl.model.Detalle;
import cl.model.Producto;
import cl.model.Stock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Skitles
 */
public class ServletCarrito extends HttpServlet {

   
    @EJB
    CarritoBeanLocal cbl;
    @EJB
    EmpleadoBeanLocal ebl;
    @EJB
    GenericBeanLocal gbl;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut_cli =request.getParameter("rutcli");
        String prod_id =request.getParameter("prod_id");
        String cant_prod =request.getParameter("cant_prod");
        try {
        
        ArrayList<Producto> productos= gbl.GetAllProductos();
        Producto pp =ebl.FindByid(Integer.parseInt(prod_id));
        Detalle d = new Detalle(pp,Integer.parseInt(cant_prod), pp.getProd_precio());
        cbl.add(d);
        Cliente cc = ebl.FindCliByRut(Integer.parseInt(rut_cli));
        ArrayList<Stock> stock = (ArrayList)ebl.ObtAllStock();
        request.setAttribute("stock", stock);
        request.setAttribute("cliente", cc);
        request.setAttribute("productos", productos);  
        ArrayList<Detalle> detalle= (ArrayList<Detalle>) cbl.detalle();
        request.setAttribute("detalle", detalle);
        
        request.setAttribute("totaldetalle", cbl.count());
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
