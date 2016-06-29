/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Cliente;
import cl.model.Conexion;
import cl.model.Empleado;
import cl.model.Venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class VentaMysql implements VentaDao {

    @Override
    public ArrayList<Venta> GetAllVentasByVendedor(Empleado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int CreateVentaReturnId(Venta v) {
       Conexion.insertarEditarBorrar("INSERT INTO `venta` (`VEN_FECHA`, `VEN_CLI_RUT`, `VEN_NETO`, `VEN_DSCTO`, `VEN_SUBTOTAL`, `VEN_IVA`, `VEN_TOTAL`, `VEN_ESTADO`) VALUES ('"+v.getVen_fecha()+"', '"+v.getCiente().getRut()+"', '"+v.getVen_neto()+"', '"+v.getVen_dscto()+"', '"+v.getSubtotal()+"', '"+v.getVen_iva()+"', '"+v.getVen_total()+"', 'REALIZADA');");
        ResultSet rs =Conexion.getResults("SELECT LAST_INSERT_ID(VEN_ID) as ULTIMOID FROM VENTA ORDER BY VEN_ID DESC LIMIT 1");
        int UltimoId=0;
         try {    
            while(rs.next()){     
              UltimoId = rs.getInt("ULTIMOID");  
            }
             return UltimoId;    
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return UltimoId;
    }

    @Override
    public void UpdateVenta(Venta v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta FindById(int id) {
    ResultSet rs =Conexion.getResults("SELECT * FROM VENTA WHERE VEN_ID="+id);
    ClienteDao c = new ClienteMysql();
        Venta ven=null; 
         try {    
            while(rs.next()){           
                ven = new Venta(rs.getInt("VEN_ID"), rs.getDate("VEN_FECHA").toString(), c.FindByRut(rs.getInt("VEN_CLI_RUT")), rs.getInt("VEN_NETO"),rs.getInt("VEN_DSCTO"), rs.getInt("VEN_SUBTOTAL"), rs.getInt("VEN_IVA"),rs.getInt("VEN_SUBTOTAL"), rs.getString("VEN_ESTADO"));
            }
         return ven;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return ven;
    }
    
}
