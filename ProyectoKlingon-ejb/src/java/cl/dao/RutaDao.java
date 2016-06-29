/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Cliente;
import cl.model.Empleado;
import cl.model.Ruta;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface RutaDao {
    public ArrayList<Ruta> GetAllRutas();
    public ArrayList<Ruta> GetAllRutasByEmpleadoAndFecha(Empleado e,String fecha);
    public void SaveRutaByMiRuta(Empleado e,Cliente c,String fecha);
    public Ruta FindById(int id);
    public void UpdateRutaByGenerarVisita(int id_ruta,float latitud,float longitud,String hora);
    
    
}
