/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.dao.ProductoDAO;
import cl.dao.ProductoMysql;
import cl.dao.VentaDao;
import cl.dao.VentaMysql;
import cl.model.Producto;
import cl.model.Venta;
import java.util.ArrayList;
import javax.ejb.Stateful;

/**
 *
 * @author Skitles
 */
@Stateful
public class GenericBean implements GenericBeanLocal {
    ProductoDAO p = new ProductoMysql();
     VentaDao t = new VentaMysql();
    
    @Override
    public ArrayList<Producto> GetAllProductos() {
    return p.GetAllProductos();
    }
    
    @Override
    public int CreateVenta(Venta v) {
    return t.CreateVentaReturnId(v);
    }

    @Override
    public Venta FindById(int id) {
    return t.FindById(id);
    }



   
}
