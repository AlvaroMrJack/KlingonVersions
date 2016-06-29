/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controllers;


import cl.model.Empleado;
import cl.model.Metas;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.bean.*;
import cl.dao.MetasMysql;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Skitles
 */
public class ServletLogin extends HttpServlet {

    @EJB
    LoginBeanLocal lbl;
    @EJB
    EmpleadoBeanLocal ebl;
    @EJB
    CantidadMetas cm;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        
        String rut = request.getParameter("rut");
        String pass = request.getParameter("pass");
        Empleado u = lbl.ObtEmpleado(Integer.parseInt(rut), pass);
        
        if(rut.length()<4){
            if (u != null) {
                
                int vent = cm.obtVentas(Empleado.fechaactual(), u);
                int cliV = cm.obtCliVisitados(Empleado.fechaactual(), u);
                int cliN = cm.obtCliNuevos(Empleado.fechaactual(), u);
                
                HttpSession sesion;
                sesion=request.getSession(true);
                
                int grupo =u.getGrupo().getGru_id();
                switch(grupo){
                case 1:
                    MetasMysql.GenerarGrafico(Empleado.fechaactual(),u.getGrupo(),u);
                    Metas m = ebl.GetAllMetas(u.getGrupo(), Empleado.fechaactual());
                    sesion.setAttribute("rutlogin",u);
                    sesion.setAttribute("metas", m);
                    
                    sesion.setAttribute("vent", vent);
                    sesion.setAttribute("cliVisit", cliV);
                    sesion.setAttribute("cliNuevo", cliN);
                    
                    sesion.setMaxInactiveInterval(5000);
                    response.sendRedirect("inicio.jsp");
                    break;
                case 2:
                    sesion.setAttribute("rutlogin",u);
                    sesion.setMaxInactiveInterval(5000);
                    response.sendRedirect("estadisticas.jsp");
                    break;
                default:
                    response.sendRedirect("index.jsp");
                    break;
               }   
            }
            else
            {
              PrintWriter out = response.getWriter();
              out.println("<script type=\"text/javascript\">");
              out.println("alert('Usuario o Clave Incorrecto, Favor intentar nuevamente');");
              out.println("location='index.jsp';");
              out.println("</script>");
            }
        }else{
            PrintWriter out = response.getWriter();
          out.println("<script type=\"text/javascript\">");
          out.println("alert('Clave Demasiada Corta, Favor intentar nuevamente');");
          out.println("location='index.jsp';");
          out.println("</script>");
        }
    }catch(NumberFormatException | IOException ex){
          PrintWriter out = response.getWriter();
          out.println("<script type=\"text/javascript\">");
          out.println("alert('Usuario o Clave Incorrecto, Favor intentar nuevamente');");
          out.println("location='index.jsp';");
          out.println("</script>");
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
