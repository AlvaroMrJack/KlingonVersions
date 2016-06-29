/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Zona;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface ZonaDao {
    public ArrayList<Zona> findAll();
    public void saveZona(int zona_id,String zona_nom);
    public Zona FindById(int zona_id); 
}
