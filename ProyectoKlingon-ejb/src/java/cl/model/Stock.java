/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

/**
 *
 * @author Skitles
 */
public class Stock {
    private Producto producto;
    private Sucursal sucursal;
    private int stock_transito;
    private int stock_critico;
    private int stock_cantidad;

    public Stock() {
    }

    public Stock(Producto producto, Sucursal sucursal, int stock_transito, int stock_critico, int stock_cantidad) {
        this.producto = producto;
        this.sucursal = sucursal;
        this.stock_transito = stock_transito;
        this.stock_critico = stock_critico;
        this.stock_cantidad = stock_cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public int getStock_transito() {
        return stock_transito;
    }

    public void setStock_transito(int stock_transito) {
        this.stock_transito = stock_transito;
    }

    public int getStock_critico() {
        return stock_critico;
    }

    public void setStock_critico(int stock_critico) {
        this.stock_critico = stock_critico;
    }

    public int getStock_cantidad() {
        return stock_cantidad;
    }

    public void setStock_cantidad(int stock_cantidad) {
        this.stock_cantidad = stock_cantidad;
    }
    
    
    
}
