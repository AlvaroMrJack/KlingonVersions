/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skitles
 */
public class Detalle {
    private Producto producto;
    private Venta venta;
    private int det_cantidad;
    private int det_total;
    private int det_precio;

    public Detalle() {
    }

    public Detalle(Producto producto, Venta venta, int det_cantidad, int det_total, int det_precio) {
        this.producto = producto;
        this.venta = venta;
        this.det_cantidad = det_cantidad;
        this.det_total = det_total;
        this.det_precio = det_precio;
    }

    public Detalle(Producto producto, int det_cantidad, int det_precio) {
        this.producto = producto;
        this.det_cantidad = det_cantidad;
        this.det_precio = det_precio;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getDet_cantidad() {
        return det_cantidad;
    }

    public void setDet_cantidad(int det_cantidad) {
        this.det_cantidad = det_cantidad;
    }

    public int getDet_total() {
        return this.det_precio*this.det_cantidad;
    }

    public void setDet_total(int det_total) {
        this.det_total = det_total;
    }

    public int getDet_precio() {
        return det_precio;
    }

    public void setDet_precio(int det_precio) {
        this.det_precio = det_precio;
    }
    
 
}
