/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.model.Producto;
import cl.model.Venta;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Skitles
 */
@Local
public interface GenericBeanLocal {
    public ArrayList<Producto> GetAllProductos();
    public int CreateVenta(Venta v);
    public Venta FindById(int id);
    
}
