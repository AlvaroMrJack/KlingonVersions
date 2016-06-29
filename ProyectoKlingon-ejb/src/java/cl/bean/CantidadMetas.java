/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.dao.MetasDao;
import cl.dao.MetasMysql;
import cl.model.Empleado;
import javax.ejb.Stateless;

/**
 *
 * @author Usuario
 */
@Stateless
public class CantidadMetas implements CantidadMetasLocal {

    MetasDao mt = new MetasMysql();
    
    @Override
    public int obtVentas(String date, Empleado e) {
        
        return mt.ObtCantidadVentasSem(date, e);
    }

    @Override
    public int obtCliVisitados(String date, Empleado e) {
        return mt.ObtCantidadCli_Vistado(date, e);
    }

    @Override
    public int obtCliNuevos(String date, Empleado e) {
        return mt.ObtCantidadCliNuevos(date, e);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
