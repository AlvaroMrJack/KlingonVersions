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
public class Sucursal {
    private int suc_id;
    private String suc_nom;
    private Zona zona;

    public Sucursal() {
    }

    public Sucursal(int suc_id, String suc_nom, Zona zona) {
        this.suc_id = suc_id;
        this.suc_nom = suc_nom;
        this.zona = zona;
    }

    public int getSuc_id() {
        return suc_id;
    }

    public void setSuc_id(int suc_id) {
        this.suc_id = suc_id;
    }

    public String getSuc_nom() {
        return suc_nom;
    }

    public void setSuc_nom(String suc_nom) {
        this.suc_nom = suc_nom;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    
}
