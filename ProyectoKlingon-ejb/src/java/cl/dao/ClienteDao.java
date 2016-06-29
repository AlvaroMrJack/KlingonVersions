/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Cliente;
import cl.model.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface ClienteDao {
    public ArrayList<Cliente> GetAllClientesByVendedor(Empleado e);
    public Cliente FindByRut(int rut);
    public void Save(Cliente c);
    public void CambiarEstado(int rut,String Estado);
}
