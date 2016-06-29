/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controllers;

import cl.bean.EmpleadoBeanLocal;
import cl.model.Empleado;
import cl.model.Ruta;
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
public class ServletRegistroVisita extends HttpServlet {

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
        String id = request.getParameter("id");
        String latit = request.getParameter("latitud");
        String longi = request.getParameter("longitud");
        /*
        PrintWriter out = response.getWriter();
        out.print(latit);
        out.print(longi);
        out.print(id);
        */
        
        if (id != null) { 
            
            ebl.UpdateRuta(Integer.parseInt(id), Float.parseFloat(latit+"f"), Float.parseFloat(longi+"f"), Empleado.horaactual());       
        }
       
        try{
        ArrayList<Ruta> rutas = ebl.ObtAllRutas(u, Empleado.fechaactual());
        request.setAttribute("miruta", rutas);
        request.getRequestDispatcher("registrarvisita.jsp").forward(request, response);     
        }
        catch(ServletException | IOException ex)
        {
            System.out.println(ex.getMessage());
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
