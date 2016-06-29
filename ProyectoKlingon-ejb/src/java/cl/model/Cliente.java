/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Skitles
 */
public class Cliente extends Persona {
    private String comentario;
    private Empleado empleado;
    private String FechaDeIngreso;

    public Cliente() {
    }

    public Cliente(String comentario, Empleado empleado, String FechaDeIngreso) {
        this.comentario = comentario;
        this.empleado = empleado;
        this.FechaDeIngreso = FechaDeIngreso;
    }

    public Cliente(String comentario, Empleado empleado, String FechaDeIngreso, int rut, String dv, String nombre, String apellido, int fono, String email, String estado, String direccion) {
        super(rut, dv, nombre, apellido, fono, email, estado, direccion);
        this.comentario = comentario;
        this.empleado = empleado;
        this.FechaDeIngreso = FechaDeIngreso;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getFechaDeIngreso() {
        return FechaDeIngreso;
    }

    public void setFechaDeIngreso(String FechaDeIngreso) {
        this.FechaDeIngreso = FechaDeIngreso;
    }

    

   public static String fechaactual(){
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        return año+"-"+(mes+1)+"-"+dia;
        
        }
   
   public static String ObtEstado(int indice){
   switch(indice){
       case 0:return null;
       case 1:return "ACTIVO";
       case 2:return "NOACTIVO";
   }
   return null;
   }

    

    
}
