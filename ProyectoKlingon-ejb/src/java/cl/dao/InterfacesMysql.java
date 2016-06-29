/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Conexion;
import cl.model.Empleado;
import cl.model.Grupo;
import cl.model.Interfaces;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class InterfacesMysql implements InterfacesDao{
    
    @Override
    public ArrayList<Interfaces> findAll(Grupo g) {
        ResultSet rs =Conexion.getResults("SELECT interfaces.INTERF_ID,interfaces.INTERF_NOM from interfaces JOIN permisos ON interfaces.INTERF_ID=permisos.PER_INTERF_ID where permisos.PER_GRU_ID="+g.getGru_id());
        ArrayList<Interfaces> interfaces = new ArrayList(); 
         try {    
            while(rs.next()){           
                Interfaces e1 = new Interfaces(rs.getInt("INTERF_ID"), rs.getString("INTERF_NOM"));
                interfaces.add(e1);
            }
         return interfaces;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return interfaces;
    }

    @Override
    public void saveInterfaces(Interfaces i, Grupo g) {
      Conexion.insertarEditarBorrar("INSERT INTO PERMISOS (PER_GRU_ID,PER_INTERF_ID) VALUES ("+g.getGru_id()+","+i.getInterf_id()+")");    
    }
    
}
