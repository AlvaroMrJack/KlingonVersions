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
public class Grupo {
    private int gru_id;
    private String gru_nom;

    public Grupo() {
    }

    public Grupo(int gru_id, String gru_nom) {
        this.gru_id = gru_id;
        this.gru_nom = gru_nom;
    }

    public int getGru_id() {
        return gru_id;
    }

    public void setGru_id(int gru_id) {
        this.gru_id = gru_id;
    }

    public String getGru_nom() {
        return gru_nom;
    }

    public void setGru_nom(String gru_nom) {
        this.gru_nom = gru_nom;
    }
    
    
    
}
