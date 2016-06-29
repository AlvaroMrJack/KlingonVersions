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
public class Producto {
    private int prod_id;
    private String prod_nom;
    private int prod_precio;
    private Categoria categoria;

    public Producto() {
    }

    public Producto(int prod_id, String prod_nom, int prod_precio, Categoria categoria) {
        this.prod_id = prod_id;
        this.prod_nom = prod_nom;
        this.prod_precio = prod_precio;
        this.categoria = categoria;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_nom() {
        return prod_nom;
    }

    public void setProd_nom(String prod_nom) {
        this.prod_nom = prod_nom;
    }

    public int getProd_precio() {
        return prod_precio;
    }

    public void setProd_precio(int prod_precio) {
        this.prod_precio = prod_precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
