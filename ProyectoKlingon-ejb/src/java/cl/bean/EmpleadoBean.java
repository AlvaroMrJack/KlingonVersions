/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.dao.ClienteDao;
import cl.dao.ClienteMysql;
import cl.dao.DetalleDao;
import cl.dao.DetalleMysql;
import cl.dao.EmpleadoDao;
import cl.dao.EmpleadoMysql;
import cl.dao.MetasDao;
import cl.dao.MetasMysql;
import cl.dao.ProductoDAO;
import cl.dao.ProductoMysql;
import cl.dao.RutaDao;
import cl.dao.RutaMysql;
import cl.dao.VentaDao;
import cl.dao.VentaMysql;
import cl.model.*;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Skitles
 */
@Stateless
public class EmpleadoBean implements EmpleadoBeanLocal {
    ProductoDAO pp = new ProductoMysql();
    
    @Override
    public Metas GetAllMetas(Grupo g, String date) {
       MetasDao m = new MetasMysql();
       return m.FindByDateAndGroup(date, g);
    }

    @Override
    public ArrayList<Cliente> GetAllClientes(Empleado u) {
        ClienteDao cc = new ClienteMysql();
        return cc.GetAllClientesByVendedor(u);
    }

    @Override
    public void CreateRuta(Empleado e, Cliente c, String date) {
        RutaDao d = new RutaMysql();
        d.SaveRutaByMiRuta(e, c, date);
    }

    @Override
    public void UpdateRuta(int id_ruta, float latitud, float longitud, String hora) {
    RutaDao r = new RutaMysql();
    r.UpdateRutaByGenerarVisita(id_ruta, latitud, longitud, hora);
    }


    @Override
    public ArrayList<Venta> GetAllVentaByCli(Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Detalle> GetAllDetalleByVenta(Venta v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateCliente(Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado FindByRut(int rut) {
        EmpleadoDao m = new EmpleadoMysql();
        return m.FindByRut(rut);
    }

    @Override
    public Cliente FindCliByRut(int rut) {
    ClienteDao c = new ClienteMysql();
    return c.FindByRut(rut);
    }

    @Override
    public ArrayList<Ruta> ObtAllRutas(Empleado u, String date) {
    RutaDao r = new RutaMysql();
    return r.GetAllRutasByEmpleadoAndFecha(u, date);
    }

    @Override
    public void CreateCliente(Cliente c) {
    ClienteDao g = new ClienteMysql();
    g.Save(c);
    }

    @Override
    public void CreateDetalle(Detalle d) {
    DetalleDao f = new DetalleMysql();
    f.CreateDetalle(d);
    }

    @Override
    public Producto FindByid(int id) {
    return pp.FindById(id);
    }

    @Override
    public Stock ObtStockProd(Producto p, Sucursal s) {
    return pp.ObtStockProd(p, s);
    }

    @Override
    public ArrayList<Stock> ObtAllStock() {
    return pp.ObtAllStock();
    }
    
}
