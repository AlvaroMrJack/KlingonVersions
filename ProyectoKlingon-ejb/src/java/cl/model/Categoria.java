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
public class Categoria {
    private int cat_id;
    private String cat_nom;

    public Categoria() {
    }

    public Categoria(int cat_id, String cat_nom) {
        this.cat_id = cat_id;
        this.cat_nom = cat_nom;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_nom() {
        return cat_nom;
    }

    public void setCat_nom(String cat_nom) {
        this.cat_nom = cat_nom;
    }
    
    
    
}
