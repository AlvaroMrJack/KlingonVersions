/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.model.*;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Skitles
 */
@Local
public interface AdminBeanLocal {
   public ArrayList<Ruta>GetAllRutas(Empleado e); 
   public ArrayList<Empleado>GetAllEmpleados(Grupo g);
   public void UpdateEmpleado (Empleado e);
   public ArrayList<Venta>GetAllVentas(Cliente c);
   public ArrayList<Detalle>GetAllDetalle(Venta v);
   public ArrayList<Producto>GetAllProductos();
   public ArrayList<Stock>GetAllStock();
   public void UpdateProducto(Producto p);
   public void CreateMetas(Grupo g);
   public ArrayList<Metas> GetAllMetasByGrupo(Grupo g);
   public void UpdateMetas(Metas m);
   public ArrayList<Metas>GetAllMetas();
}
