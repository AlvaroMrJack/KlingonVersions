/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface ClienteBeanLocal {
    
    public void findAllCli();
    public void removeCli();
    public void addCli();
    public void updateCli();
    
}
