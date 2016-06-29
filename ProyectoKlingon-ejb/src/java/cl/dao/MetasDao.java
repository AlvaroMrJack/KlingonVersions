/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Empleado;
import cl.model.Grupo;
import cl.model.Metas;
import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public interface MetasDao {
   public Metas FindById(int id);
   public ArrayList<Metas> FindAll();
   public void Save (Metas m);
   public Metas FindByDateAndGroup(String date,Grupo g);
   public  int ObtCantidadCli_Vistado(String date,Empleado e);
   public  int ObtCantidadCliNuevos(String date, Empleado e);
   public  int ObtCantidadVentasSem(String date, Empleado e);
}
