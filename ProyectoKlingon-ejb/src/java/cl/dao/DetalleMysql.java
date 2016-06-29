/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Conexion;
import cl.model.Detalle;

/**
 *
 * @author Skitles
 */
public class DetalleMysql implements DetalleDao {

    @Override
    public void CreateDetalle(Detalle d) {
        Conexion.insertarEditarBorrar("INSERT INTO `detalle` (`DET_PROD_ID`, `DET_VEN_ID`, `DET_CANTIDAD`,"
    + " `DET_TOTAL`, `DET_PRECIO`) VALUES ('"+d.getProducto().getProd_id()+"','"+d.getVenta().getVen_id()+"','"+d.getDet_cantidad()+"','"+d.getProducto().getProd_precio()*d.getDet_cantidad()+"', '"+d.getProducto().getProd_precio()+"')");
   
    }
    
}
