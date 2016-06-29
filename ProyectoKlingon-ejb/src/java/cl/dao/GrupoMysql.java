/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Conexion;
import cl.model.Grupo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class GrupoMysql implements GrupoDao {

    @Override
    public ArrayList<Grupo> findAll() {
        ResultSet rs =Conexion.getResults("SELECT * FROM GRUPOS");
        ArrayList<Grupo> grupo = new ArrayList(); 
         try {    
            while(rs.next()){           
                Grupo g1 = new Grupo(rs.getInt("GRU_ID"), rs.getString("GRU_NOM"));
                grupo.add(g1);
            }
         return grupo;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return grupo;
    }

    @Override
    public void saveGrupo(int gru_id, String gru_nom) {
        Conexion.insertarEditarBorrar("INSERT INTO GRUPOS (GRU_ID,GRU_NOM) VALUES ("+gru_id+","+gru_nom+")");
    }

    @Override
    public Grupo FindById(int gru_id) {
        ResultSet rs =Conexion.getResults("SELECT * FROM GRUPOS WHERE GRU_ID="+gru_id);
        Grupo grupo=null; 
         try {    
            while(rs.next()){           
                grupo = new Grupo(rs.getInt("GRU_ID"), rs.getString("GRU_NOM"));
            }
         return grupo;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return grupo;
    }
    
}
