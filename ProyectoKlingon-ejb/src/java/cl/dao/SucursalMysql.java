/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Conexion;
import cl.model.Sucursal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class SucursalMysql implements SucursalDao {

    @Override
    public Sucursal FindById(int id) {
     ResultSet rs =Conexion.getResults("SELECT * FROM SUCURSAL WHERE SUC_ID="+id);
     ZonaDao z = new ZonaMysql();
        Sucursal sucursal=null; 
         try {    
            while(rs.next()){           
                sucursal = new Sucursal(rs.getInt("SUC_ID"), rs.getString("SUC_NOM"),z.FindById(rs.getInt("SUC_ID_ZONA")));
            }
         return sucursal;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return sucursal;    
 
    }

    @Override
    public ArrayList<Sucursal> GetAllSucursales() {
       ResultSet rs =Conexion.getResults("SELECT * FROM SUCURSAL");
       ZonaDao z = new ZonaMysql(); 
        ArrayList<Sucursal> sucursal = new ArrayList(); 
         try {    
            while(rs.next()){           
                Sucursal g1 = new Sucursal(rs.getInt("SUC_ID"), rs.getString("SUC_NOM"),z.FindById(rs.getInt("SUC_ID_ZONA")));
                sucursal.add(g1);
            }
         return sucursal;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return sucursal;
    }
    
    
}
