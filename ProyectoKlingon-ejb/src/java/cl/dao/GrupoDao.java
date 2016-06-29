/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Grupo;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface GrupoDao {
    public ArrayList<Grupo> findAll();
    public void saveGrupo(int gru_id,String gru_nom);
    public Grupo FindById(int gru_id); 
}
