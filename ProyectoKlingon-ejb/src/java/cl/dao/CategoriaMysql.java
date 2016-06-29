/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Categoria;
import cl.model.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class CategoriaMysql implements CategoriaDao {

    @Override
    public ArrayList<Categoria> GetAllCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria FindById(int id) {
    ResultSet rs =Conexion.getResults("SELECT * FROM CATEGORIA WHERE CAT_ID="+id);
        Categoria categoria=null;
         try {    
            while(rs.next()){     
              categoria = new Categoria(rs.getInt("CAT_ID"), rs.getString("CAT_NOM"));  
            }
         return categoria;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return categoria;
        
    }

    
}
