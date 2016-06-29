/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.model.Detalle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Skitles
 */
@Stateless
public class CarritoBean implements CarritoBeanLocal {
private static List detalle = new ArrayList();
    
    
    @Override
    public void add(Detalle d) {
        detalle.add(d);
    }

    @Override
    public void remove(Detalle d) {
        detalle.remove(d);
    }

    @Override
    public Collection detalle() {
        return detalle;
    }

    @Override
    public int count() {
        return detalle.size();
    }

    @Override
    public void clear() {
      detalle.clear();
    }

    
}
