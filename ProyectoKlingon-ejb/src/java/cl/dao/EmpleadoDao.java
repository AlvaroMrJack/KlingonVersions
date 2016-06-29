/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.*;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface EmpleadoDao {
    public Empleado FindByRut(int Rut);
    public ArrayList<Empleado> FindAll();
    public void Save(Empleado e);
    public void CambiarEstado(Empleado e);
}
