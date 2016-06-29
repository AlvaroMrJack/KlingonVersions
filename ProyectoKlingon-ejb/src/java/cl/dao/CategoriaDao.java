/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Categoria;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface CategoriaDao {
    public ArrayList<Categoria> GetAllCategorias();
    public Categoria FindById(int id);
}
