/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import java.util.ArrayList;

/**
 *
 * @author Skitles
 */
public class Venta {
    private int ven_id;
    private String ven_fecha;
    private Cliente ciente;
    private int ven_neto;
    private int ven_dscto;
    private int subtotal;
    private int ven_iva;
    private int ven_total;
    private String ven_estado;

    public Venta() {
    }

    public Venta(int ven_id, String ven_fecha, Cliente ciente, int ven_neto, int ven_dscto, int subtotal, int ven_iva, int ven_total, String ven_estado) {
        this.ven_id = ven_id;
        this.ven_fecha = ven_fecha;
        this.ciente = ciente;
        this.ven_neto = ven_neto;
        this.ven_dscto = ven_dscto;
        this.subtotal = subtotal;
        this.ven_iva = ven_iva;
        this.ven_total = ven_total;
        this.ven_estado = ven_estado;
    }

    public Venta(String ven_fecha, Cliente ciente, int ven_neto, int ven_dscto, int subtotal, int ven_iva, int ven_total) {
        this.ven_fecha = ven_fecha;
        this.ciente = ciente;
        this.ven_neto = ven_neto;
        this.ven_dscto = ven_dscto;
        this.subtotal = subtotal;
        this.ven_iva = ven_iva;
        this.ven_total = ven_total;
    }
 
    public Venta(String ven_fecha, Cliente ciente) {
        this.ven_fecha = ven_fecha;
        this.ciente = ciente;
    }
      

    public int getVen_id() {
        return ven_id;
    }

    public void setVen_id(int ven_id) {
        this.ven_id = ven_id;
    }

    public String getVen_fecha() {
        return ven_fecha;
    }

    public void setVen_fecha(String ven_fecha) {
        this.ven_fecha = ven_fecha;
    }

    public Cliente getCiente() {
        return ciente;
    }

    public void setCiente(Cliente ciente) {
        this.ciente = ciente;
    }

    public int getVen_neto() {
        return ven_neto;
    }

    public void setVen_neto(int ven_neto) {
        this.ven_neto = ven_neto;
    }

    public int getVen_dscto() {
        return ven_dscto;
    }

    public void setVen_dscto(int ven_dscto) {
        this.ven_dscto = ven_dscto;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getVen_iva() {
        return ven_iva;
    }

    public void setVen_iva(int ven_iva) {
        this.ven_iva = ven_iva;
    }

    public int getVen_total() {
        return ven_total;
    }

    public void setVen_total(int ven_total) {
        this.ven_total = ven_total;
    }

    public String getVen_estado() {
        return ven_estado;
    }

    public void setVen_estado(String ven_estado) {
        this.ven_estado = ven_estado;
    }

    public Venta GenerarVentaPorDetalle(ArrayList<Detalle> detalle, Cliente c){
        this.ven_neto=0;
        this.ven_dscto=0;
        this.subtotal=0;
        this.ven_id=0;
        this.ven_total=0;
        for(Detalle d: detalle){
         ven_neto = ven_neto + d.getDet_total();
        }
        ven_dscto= (ven_neto*ven_dscto)/100;
        subtotal = ven_neto-ven_dscto;
        ven_iva = (subtotal*19)/100;
        ven_total = subtotal+ven_iva; 
        
        
        Venta v = new Venta(Empleado.fechaactual(), c, ven_neto, ven_dscto, subtotal, ven_iva, ven_total);
        return v;
    }
    
    
}
