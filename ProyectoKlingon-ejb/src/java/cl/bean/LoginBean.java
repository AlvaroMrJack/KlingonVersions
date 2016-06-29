/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.dao.EmpleadoDao;
import cl.dao.EmpleadoMysql;
import cl.dao.GrupoDao;
import cl.dao.GrupoMysql;
import cl.dao.InterfacesDao;
import cl.dao.InterfacesMysql;
import cl.model.*;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Skitles
 */
@Stateless
public class LoginBean implements LoginBeanLocal {
    InterfacesDao y = new InterfacesMysql();
    GrupoDao gg = new GrupoMysql();
    Empleado empleado = null;
    EmpleadoDao t = new EmpleadoMysql();
    ArrayList<Interfaces> interfaces;
    Grupo grupo;
    Zona zona;
    
    @Override
    public Empleado ObtEmpleado(int rut, String pass) {
    empleado = t.FindByRut(rut);
        if (empleado != null && empleado.getPass().equals(pass)) {
            return empleado;
        }else{
        empleado =null;
        }
        return empleado;
    }

    @Override
    public ArrayList<Interfaces> ObtInterfaces(Empleado e) {
        grupo =gg.FindById(e.getGrupo().getGru_id());
        interfaces =y.findAll(grupo);
        return interfaces;
    }

    

}
