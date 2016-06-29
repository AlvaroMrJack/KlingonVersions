/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Conexion;
import cl.model.Zona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class ZonaMysql implements ZonaDao{

    @Override
    public ArrayList<Zona> findAll() {
       ResultSet rs =Conexion.getResults("SELECT * FROM GRUPOS");
        ArrayList<Zona> zona = new ArrayList(); 
         try {    
            while(rs.next()){           
                Zona g1 = new Zona(rs.getInt("ZONA_ID"), rs.getString("ZONA_NOM"));
                zona.add(g1);
            }
         return zona;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return zona;
    }

    @Override
    public void saveZona(int zona_id, String zona_nom) {
     Conexion.insertarEditarBorrar("INSERT INTO ZONA (ZONA_ID,ZONA_NOM) VALUES ("+zona_id+",'"+zona_nom+"')");
    }

    @Override
    public Zona FindById(int zona_id) {
    ResultSet rs =Conexion.getResults("SELECT * FROM ZONA WHERE ZONA_ID="+zona_id);
        Zona zona=null; 
         try {    
            while(rs.next()){           
                zona = new Zona(rs.getInt("ZONA_ID"), rs.getString("ZONA_NOM"));
            }
         return zona;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return zona;
    }
    
}
