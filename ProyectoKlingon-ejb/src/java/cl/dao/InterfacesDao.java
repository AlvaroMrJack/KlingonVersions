/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Grupo;
import cl.model.Interfaces;
import java.util.ArrayList;

/**
 
 */
public interface InterfacesDao {
    public ArrayList<Interfaces> findAll(Grupo g);
    public void saveInterfaces(Interfaces i,Grupo g);
}
