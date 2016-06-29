/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Skitles
 */
public class Empleado extends Persona{
    private String pass;
    private Grupo grupo;
    private Zona zona;

    public Empleado() {
    }

    public Empleado(String pass, Grupo grupo, Zona zona) {
        this.pass = pass;
        this.grupo = grupo;
        this.zona = zona;
    }

    public Empleado(String pass, Grupo grupo, Zona zona, int rut, String dv, String nombre, String apellido, int fono, String email, String estado, String direccion) {
        super(rut, dv, nombre, apellido, fono, email, estado, direccion);
        this.pass = pass;
        this.grupo = grupo;
        this.zona = zona;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public static String fechaactual(){
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        return año+"-"+(mes+1)+"-"+dia;
        
        }
   
     public static String horaactual(){
        Calendar fecha = new GregorianCalendar();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minutos = fecha.get(Calendar.MINUTE);
        int segundos = fecha.get(Calendar.SECOND);
        
        return hora+":"+minutos+":"+segundos;
        
        }
     
}
