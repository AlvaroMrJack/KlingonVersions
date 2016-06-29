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
public class Interfaces {
    private int interf_id;
    private String nom;

    public Interfaces() {
    }

    public Interfaces(int interf_id, String nom) {
        this.interf_id = interf_id;
        this.nom = nom;
    }

    public int getInterf_id() {
        return interf_id;
    }

    public void setInterf_id(int interf_id) {
        this.interf_id = interf_id;
    }

    public String getNom() {
        return nom;
    }

    public void setPass(String nom) {
        this.nom = nom;
    }
    
    
}
