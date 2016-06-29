/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Conexion;
import cl.model.Empleado;
import cl.model.Grupo;
import cl.model.Zona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class EmpleadoMysql implements EmpleadoDao {

    @Override
    public Empleado FindByRut(int Rut) {
       ResultSet rs =Conexion.getResults("SELECT * FROM EMPLEADO WHERE EMP_RUT="+Rut);
        Empleado empleado=null;
        GrupoDao gg = new GrupoMysql();
        ZonaDao uu = new ZonaMysql();
         try {    
            while(rs.next()){     
            empleado=  new Empleado(rs.getString("EMP_PASS"),gg.FindById(rs.getInt("EMP_GRU_ID"))
                    ,uu.FindById(rs.getInt("EMP_ZONA_ID")),rs.getInt("EMP_RUT"),rs.getString("EMP_DV")
                    ,rs.getString("EMP_NOMBRE"),rs.getString("EMP_APELLIDO"),rs.getInt("EMP_FONO")
                    ,rs.getString("EMP_EMAIL"),rs.getString("EMP_ESTADO"),rs.getString("EMP_DIRECCION"));
            }
         return empleado;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return empleado;
    }

    @Override
    public ArrayList<Empleado> FindAll() {
        ResultSet rs =Conexion.getResults("SELECT * FROM EMPLEADO");
        ArrayList<Empleado> empleado= new ArrayList();
        GrupoDao gg = new GrupoMysql();
        ZonaDao uu = new ZonaMysql();
         try {    
            while(rs.next()){    
                Empleado u=(new Empleado(rs.getString("EMP_PASS"),gg.FindById(rs.getInt("EMP_GRU_ID"))
                    ,uu.FindById(rs.getInt("EMP_ZONA_ID")),rs.getInt("EMP_RUT"),rs.getString("EMP_DV")
                    ,rs.getString("EMP_NOMBRE"),rs.getString("EMP_APELLIDO"),rs.getInt("EMP_FONO")
                    ,rs.getString("EMP_EMAIL"),rs.getString("EMP_ESTADO"),rs.getString("EMP_DIRECCION"))); 
                empleado.add(u);
            }
         return empleado;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return empleado;
        
    }

    @Override
    public void Save(Empleado e) {
        Conexion.insertarEditarBorrar("INSERT INTO EMPLEADO (EMP_RUT,EMP_DV,EMP_NOMBRE,EMP_APELLIDO,EMP_DIRECCION,EMP_FONO,EMP_EMAIL,EMP_ESTADO,EMP_PASS,EMP_GRU_ID,EMP_ZONA_ID)"
                + "VALUES ("+e.getRut()+",'"+e.getDv()+"','"+e.getNombre()+"','"+e.getApellido()+"','"+e.getDireccion()+"',"+e.getFono()+",'"+e.getEmail()+"','"+e.getEstado()+
                "','"+e.getPass()+"',"+e.getGrupo().getGru_id()+","+e.getZona().getZona_id()+")");
    }

    @Override
    public void CambiarEstado(Empleado e) {
       Conexion.insertarEditarBorrar("UPDATE EMPLEADO SET EMP_ESTADO = '"+e.getEstado()+"' WHERE EMPLEADO.EMP_RUT="+e.getRut());
    }

 
    
}
