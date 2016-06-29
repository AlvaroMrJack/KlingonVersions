/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Cliente;
import cl.model.Conexion;
import cl.model.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class ClienteMysql implements ClienteDao {

    @Override
    public ArrayList<Cliente> GetAllClientesByVendedor(Empleado e) {
        ResultSet rs =Conexion.getResults("SELECT * FROM CLIENTE WHERE CLI_EMP_RUT="+e.getRut()+" ORDER BY `CLI_APELLIDO`");
        ArrayList<Cliente> cliente= new ArrayList();
        EmpleadoDao o = new EmpleadoMysql();
        //String comentario, Empleado empleado, String FechaDeIngreso, int rut,
        //String dv, String nombre, String apellido, int fono, String email, 
        //String estado, String direccion
        //SELECT * FROM CLIENTE WHERE CLI_EMP_RUT=17672024 ORDER by `CLI_APELLIDO` DESC LIMIT 5
         try {    
            while(rs.next()){     
            Cliente c=  new Cliente(rs.getString("CLI_COMENTARIO"),o.FindByRut(rs.getInt("CLI_EMP_RUT"))
                    ,rs.getString("CLI_FECHA_INGRESO"),rs.getInt("CLI_RUT"),rs.getString("CLI_DV")
                    ,rs.getString("CLI_NOMBRE"),rs.getString("CLI_APELLIDO"),rs.getInt("CLI_FONO")
                    ,rs.getString("CLI_EMAIL"),rs.getString("CLI_ESTADO"),rs.getString("CLI_DIRECCION"));
            cliente.add(c);
            }
         return cliente;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return cliente;
    }

    @Override
    public Cliente FindByRut(int rut) {
        ResultSet rs =Conexion.getResults("SELECT * FROM CLIENTE WHERE CLI_RUT="+rut);
        Cliente cliente=null;
        EmpleadoDao o = new EmpleadoMysql();
        //String comentario, Empleado empleado, String FechaDeIngreso, int rut,
        //String dv, String nombre, String apellido, int fono, String email, 
        //String estado, String direccion
         try {    
            while(rs.next()){     
            cliente=  new Cliente(rs.getString("CLI_COMENTARIO"),o.FindByRut(rs.getInt("CLI_EMP_RUT"))
                    ,rs.getString("CLI_FECHA_INGRESO"),rs.getInt("CLI_RUT"),rs.getString("CLI_DV")
                    ,rs.getString("CLI_NOMBRE"),rs.getString("CLI_APELLIDO"),rs.getInt("CLI_FONO")
                    ,rs.getString("CLI_EMAIL"),rs.getString("CLI_ESTADO"),rs.getString("CLI_DIRECCION"));
            }
         return cliente;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return cliente;
    }

    @Override
    public void Save(Cliente c) {
        Conexion.insertarEditarBorrar("INSERT INTO `cliente` (`CLI_RUT`, `CLI_DV`, `CLI_NOMBRE`, `CLI_APELLIDO`, `CLI_DIRECCION`, `CLI_EMP_RUT`, `CLI_FONO`, `CLI_EMAIL`, `CLI_ESTADO`, `CLI_COMENTARIO`, `CLI_FECHA_INGRESO`)"
                + " VALUES ('"+c.getRut()+"', '"+c.getDv()+"', '"+c.getNombre()+"', '"+c.getApellido()+"', '"+c.getDireccion()+"', '"+c.getEmpleado().getRut()+"', '"+c.getFono()+"', '"+c.getEmail()+"', '"+c.getEstado()+"', '"+c.getComentario()+"', '"+c.getFechaDeIngreso()+"')");
    }

    @Override
    public void CambiarEstado(int rut,String estado) {
        Conexion.insertarEditarBorrar("UPDATE `cliente` SET `CLI_ESTADO` = '"+estado+"' WHERE `cliente`.`CLI_RUT` ="+rut);
    }
    
}
