/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Cliente;
import cl.model.Conexion;
import cl.model.Empleado;
import cl.model.Ruta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class RutaMysql implements RutaDao {

    @Override
    public ArrayList<Ruta> GetAllRutas() {
        ResultSet rs =Conexion.getResults("SELECT * FROM RUTA");
        ArrayList<Ruta> ruta= new ArrayList();
        ClienteDao l = new ClienteMysql();
        EmpleadoDao m = new EmpleadoMysql();
         try {    
         //int ru_id, Date ru_fecha, Cliente cliente, Empleado empleado, 
         //Date ru_hora, float ru_latitud, float ru_longitud, String ru_estado    
            while(rs.next()){    
                Ruta u=new Ruta(rs.getInt("RU_ID"),rs.getDate("RU_FECHA").toString(),
                        l.FindByRut(rs.getInt("RU_CLI_RUT")),m.FindByRut(rs.getInt("RU_EMP_RUT"))
                        ,rs.getTime("RU_HORA").toString(),rs.getFloat("RU_LATITUD"),
                        rs.getFloat("RU_LONGITUD"),rs.getString("RU_ESTADO")); 
                ruta.add(u);
            }
         return ruta;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return ruta;
    }

    @Override
        public ArrayList<Ruta> GetAllRutasByEmpleadoAndFecha(Empleado e,String fecha) {
        ResultSet rs =Conexion.getResults("SELECT * FROM ruta WHERE `RU_EMP_RUT`='"+e.getRut()+"' AND `RU_FECHA`='"+fecha+"'");
        ArrayList<Ruta> ruta= new ArrayList();
        ClienteDao l = new ClienteMysql();
        EmpleadoDao m = new EmpleadoMysql();
         try {    
        //int ru_id, String ru_fecha, Cliente cliente, Empleado empleado, String ru_estado
            while(rs.next()){    
                Ruta u=new Ruta(rs.getInt("RU_ID"),rs.getDate("RU_FECHA").toString(),
                        l.FindByRut(rs.getInt("RU_CLI_RUT")),m.FindByRut(rs.getInt("RU_EMP_RUT")),rs.getString("RU_ESTADO")); 
                ruta.add(u);
            }
         return ruta;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return ruta;
    }

    @Override
    public void SaveRutaByMiRuta(Empleado e, Cliente c,String fecha) {
       Conexion.insertarEditarBorrar("INSERT INTO `ruta` (`RU_FECHA`, `RU_CLI_RUT`, `RU_EMP_RUT`,`RU_ESTADO`) VALUES ('"+fecha+"', '"+c.getRut()+"', '"+e.getRut()+"','PROCESO')");
    }

    @Override
    public Ruta FindById(int id) {
        ResultSet rs =Conexion.getResults("SELECT * FROM RUTA WHERE RU_ID="+id);
        Ruta ruta=null;
        ClienteDao l = new ClienteMysql();
        EmpleadoDao m = new EmpleadoMysql();
         try {    
            while(rs.next()){     
            ruta=  new Ruta(rs.getInt("RU_ID"),rs.getDate("RU_FECHA").toString(),
                        l.FindByRut(rs.getInt("RU_CLI_RUT")),m.FindByRut(rs.getInt("RU_EMP_RUT"))
                        ,rs.getTime("RU_HORA").toString(),rs.getFloat("RU_LATITUD"),
                        rs.getFloat("RU_LONGITUD"),rs.getString("RU_ESTADO"));
            }
         return ruta;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return ruta;
    }

    @Override
    public void UpdateRutaByGenerarVisita(int id_ruta, float latitud, float longitud, String hora) {
    Conexion.insertarEditarBorrar("UPDATE `ruta` SET `RU_HORA` = '"+hora+"', `RU_LATITUD` = '"+latitud+"', `RU_LONGITUD` = '"+longitud+"', `RU_ESTADO` = 'VISITADO' WHERE `ruta`.`RU_ID` ="+id_ruta);
    }
    
}
