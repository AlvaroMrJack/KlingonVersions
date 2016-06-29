/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import cl.bean.EmpleadoBean;
import cl.bean.EmpleadoBeanLocal;
import cl.bean.LoginBeanLocal;
import cl.dao.ClienteDao;
import cl.dao.ClienteMysql;
import cl.dao.DetalleDao;
import cl.dao.DetalleMysql;
import cl.dao.EmpleadoDao;
import cl.dao.EmpleadoMysql;
import cl.dao.GrupoDao;
import cl.dao.GrupoMysql;
import cl.dao.MetasDao;
import cl.dao.MetasMysql;
import cl.dao.ProductoDAO;
import cl.dao.ProductoMysql;
import cl.dao.RutaDao;
import cl.dao.RutaMysql;
import cl.dao.VentaDao;
import cl.dao.VentaMysql;
import cl.dao.ZonaDao;
import cl.dao.ZonaMysql;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *String pass, Grupo grupo, Zona zona, int rut,
 * String dv, String nombre, String apellido,
 * int fono, String email, String estado, String direccion
 * 
 */
public class MainScrip {
    
    public static void main(String[] args) throws IOException {
     DetalleDao dd = new DetalleMysql();
     VentaDao vv = new VentaMysql();
     ProductoDAO pp= new ProductoMysql();
     
     
     Detalle d = new Detalle(pp.FindById(2),vv.FindById(1), 2121, 1232, 02131);
     dd.CreateDetalle(d);
    }
}