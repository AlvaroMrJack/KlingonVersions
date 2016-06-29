/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.model.Cliente;
import cl.model.*;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Skitles
 */
@Local
public interface EmpleadoBeanLocal {
    public Metas GetAllMetas(Grupo g,String date);
    public ArrayList<Cliente> GetAllClientes(Empleado u);
    public void CreateRuta(Empleado e,Cliente c,String date);
    public ArrayList<Ruta>ObtAllRutas(Empleado u,String date);
    public void UpdateRuta(int id_ruta, float latitud, float longitud, String hora);
    public ArrayList<Venta> GetAllVentaByCli(Cliente c);
    public ArrayList<Detalle> GetAllDetalleByVenta(Venta v);
    public void UpdateCliente(Cliente c);
    public Empleado FindByRut(int rut);
    public Cliente FindCliByRut(int rut);
    public void CreateCliente(Cliente c);
    public void CreateDetalle(Detalle d);
    public Producto FindByid(int id);
    public Stock ObtStockProd(Producto p, Sucursal s);
    public ArrayList<Stock> ObtAllStock();
    
}
