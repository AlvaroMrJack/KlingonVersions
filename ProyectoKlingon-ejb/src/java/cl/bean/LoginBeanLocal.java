/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.model.Empleado;
import cl.model.Interfaces;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Skitles
 */
@Local
public interface LoginBeanLocal{
    public Empleado ObtEmpleado(int rut,String pass);
    public ArrayList<Interfaces> ObtInterfaces(Empleado e);
}
