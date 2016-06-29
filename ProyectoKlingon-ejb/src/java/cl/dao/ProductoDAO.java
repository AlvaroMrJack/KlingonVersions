/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Empleado;
import cl.model.Producto;
import cl.model.Stock;
import cl.model.Sucursal;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface ProductoDAO{
    public ArrayList<Producto> GetAllProductos();
    public Producto FindById(int id);
    public void UpdateProducto(Producto p);
    public void SaveProducto();
    public Stock ObtStockProd(Producto p,Sucursal s);
    public ArrayList<Stock> ObtAllStock();
}
