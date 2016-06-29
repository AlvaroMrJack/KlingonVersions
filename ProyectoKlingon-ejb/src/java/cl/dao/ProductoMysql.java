/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Cliente;
import cl.model.Conexion;
import cl.model.Empleado;
import cl.model.Producto;
import cl.model.Stock;
import cl.model.Sucursal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class ProductoMysql implements ProductoDAO{

    @Override
    public ArrayList<Producto> GetAllProductos() {
       ResultSet rs =Conexion.getResults("SELECT * FROM PRODUCTOS");
        ArrayList<Producto> producto= new ArrayList();
        CategoriaDao cc = new CategoriaMysql();
         try {    
            while(rs.next()){    
                Producto p=new Producto(rs.getInt("PROD_ID"),rs.getString("PROD_NOM"),rs.getInt("PROD_PRECIO"), cc.FindById(rs.getInt("PROD_ID_CAT"))); 
                producto.add(p);
            }
         return producto;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return producto;
    }

    @Override
    public Producto FindById(int id) {
    ResultSet rs =Conexion.getResults("SELECT * FROM PRODUCTOS WHERE PROD_ID="+id);
        Producto prod=null; 
        CategoriaDao cat = new CategoriaMysql();
         try {    
            while(rs.next()){           
                prod = new Producto(rs.getInt("PROD_ID"),rs.getString("PROD_NOM"),rs.getInt("PROD_PRECIO"),cat.FindById(rs.getInt("PROD_ID_CAT")));
            }
         return prod;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return prod;
    
    }

    @Override
    public void UpdateProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SaveProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stock ObtStockProd(Producto p, Sucursal s) {
     ResultSet rs =Conexion.getResults("SELECT * from stock where `STOCK_ID_PROD`="+p.getProd_id()+" and STOCK_ID_SUCURSAL="+s.getSuc_id());
     ProductoDAO pp = new ProductoMysql();
     SucursalDao ss = new SucursalMysql();
     Stock stock=null; 
         try {    
            while(rs.next()){           
               stock = new Stock(pp.FindById(rs.getInt("STOCK_ID_PROD")),ss.FindById(rs.getInt("STOCK_ID_SUCURSAL")),rs.getInt("STOCK_TRANSITO"),rs.getInt("STOCK_CRITICO"), rs.getInt("STOCK_CANTIDAD"));
            }
         return stock;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return stock;
        
    }

    @Override
    public ArrayList<Stock> ObtAllStock() {
        ResultSet rs =Conexion.getResults("SELECT * FROM STOCK");
        ArrayList<Stock> stock= new ArrayList();
        ProductoDAO pp = new ProductoMysql();
        SucursalDao ss = new SucursalMysql();
         try {    
            while(rs.next()){    
                Stock s=new Stock(pp.FindById(rs.getInt("STOCK_ID_PROD")),ss.FindById(rs.getInt("STOCK_ID_SUCURSAL")),rs.getInt("STOCK_TRANSITO"),rs.getInt("STOCK_CRITICO"), rs.getInt("STOCK_CANTIDAD")); 
                stock.add(s);
            }
         return stock;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return stock;
    }
    
    
}
