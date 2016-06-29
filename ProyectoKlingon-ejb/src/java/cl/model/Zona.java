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
public class Zona {
    private int zona_id;
    private String zona_nom;

    public Zona() {
    }

    public Zona(int zona_id, String zona_nom) {
        this.zona_id = zona_id;
        this.zona_nom = zona_nom;
    }

    public int getZona_id() {
        return zona_id;
    }

    public void setZona_id(int zona_id) {
        this.zona_id = zona_id;
    }

    public String getZona_nom() {
        return zona_nom;
    }

    public void setZona_nom(String zona_nom) {
        this.zona_nom = zona_nom;
    }
    
    
    
}
