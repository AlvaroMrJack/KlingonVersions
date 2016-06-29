/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Sucursal;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface SucursalDao {
public Sucursal FindById(int id);
public ArrayList<Sucursal> GetAllSucursales();
}
