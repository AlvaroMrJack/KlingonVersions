/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.model.Empleado;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface CantidadMetasLocal {
    
    public int obtVentas(String date, Empleado e);
    public int obtCliVisitados(String date, Empleado e);
    public int obtCliNuevos(String date, Empleado e);
    
}
