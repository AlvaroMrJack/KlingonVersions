/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Cliente;
import cl.model.Empleado;
import cl.model.Venta;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface VentaDao {
    public ArrayList<Venta> GetAllVentasByVendedor(Empleado e);
    public int CreateVentaReturnId(Venta v);
    public void UpdateVenta(Venta v);
    public Venta FindById(int id);
}
