/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

/**
 *
 * @author Skitles
 */
public class Ruta {
    private int ru_id;
    private String ru_fecha;
    private Cliente cliente;
    private Empleado empleado;
    private String ru_hora;
    private float ru_latitud;
    private float ru_longitud;
    private String ru_estado;

    public Ruta() {
    }

    public Ruta(int ru_id, String ru_fecha, Cliente cliente, Empleado empleado, String ru_hora, float ru_latitud, float ru_longitud, String ru_estado) {
        this.ru_id = ru_id;
        this.ru_fecha = ru_fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.ru_hora = ru_hora;
        this.ru_latitud = ru_latitud;
        this.ru_longitud = ru_longitud;
        this.ru_estado = ru_estado;
    }

    public Ruta(int ru_id, String ru_fecha, Cliente cliente, Empleado empleado, String ru_estado) {
        this.ru_id = ru_id;
        this.ru_fecha = ru_fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.ru_estado = ru_estado;
    }
     
    

    public int getRu_id() {
        return ru_id;
    }

    public void setRu_id(int ru_id) {
        this.ru_id = ru_id;
    }

    public String getRu_fecha() {
        return ru_fecha;
    }

    public void setRu_fecha(String ru_fecha) {
        this.ru_fecha = ru_fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getRu_hora() {
        return ru_hora;
    }

    public void setRu_hora(String ru_hora) {
        this.ru_hora = ru_hora;
    }

    public float getRu_latitud() {
        return ru_latitud;
    }

    public void setRu_latitud(float ru_latitud) {
        this.ru_latitud = ru_latitud;
    }

    public float getRu_longitud() {
        return ru_longitud;
    }

    public void setRu_longitud(float ru_longitud) {
        this.ru_longitud = ru_longitud;
    }

    public String getRu_estado() {
        return ru_estado;
    }

    public void setRu_estado(String ru_estado) {
        this.ru_estado = ru_estado;
    }

   
    
    
}
