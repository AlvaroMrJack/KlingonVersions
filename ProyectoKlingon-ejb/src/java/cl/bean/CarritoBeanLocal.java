/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.model.Detalle;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Skitles
 */
@Local
public interface CarritoBeanLocal {
    public void add(Detalle d);
    public void remove(Detalle d);
    public Collection detalle();
    public int count();
    public void clear();
    
    
}
