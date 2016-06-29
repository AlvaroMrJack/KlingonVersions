/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

/**
 *
 * @author Usuario
 */
public class PruebaSQL {
    
    private int id;
    private String conexion;
    private String estado;
    private int valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public PruebaSQL() {
    }

    public PruebaSQL(int id, String conexion, String estado, int valor) {
        this.id = id;
        this.conexion = conexion;
        this.estado = estado;
        this.valor = valor;
    }
    
    
    
}
