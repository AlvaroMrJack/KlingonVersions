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
public class Metas {
    private int meta_id;
    private String meta_fecha_inicio;
    private String meta_fecha_termino;
    private int meta_cant_ventas;
    private int meta_cant_visitas;
    private int meta_cant_clientes;
    private Grupo grupo;

    public Metas() {
    }

    public Metas(int meta_id, String meta_fecha_inicio, String meta_fecha_termino, int meta_cant_ventas, int meta_cant_visitas, int meta_cant_clientes, Grupo grupo) {
        this.meta_id = meta_id;
        this.meta_fecha_inicio = meta_fecha_inicio;
        this.meta_fecha_termino = meta_fecha_termino;
        this.meta_cant_ventas = meta_cant_ventas;
        this.meta_cant_visitas = meta_cant_visitas;
        this.meta_cant_clientes = meta_cant_clientes;
        this.grupo = grupo;
    }

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    public String getMeta_fecha_inicio() {
        return meta_fecha_inicio;
    }

    public void setMeta_fecha_inicio(String meta_fecha_inicio) {
        this.meta_fecha_inicio = meta_fecha_inicio;
    }

    public String getMeta_fecha_termino() {
        return meta_fecha_termino;
    }

    public void setMeta_fecha_termino(String meta_fecha_termino) {
        this.meta_fecha_termino = meta_fecha_termino;
    }

    public int getMeta_cant_ventas() {
        return meta_cant_ventas;
    }

    public void setMeta_cant_ventas(int meta_cant_ventas) {
        this.meta_cant_ventas = meta_cant_ventas;
    }

    public int getMeta_cant_visitas() {
        return meta_cant_visitas;
    }

    public void setMeta_cant_visitas(int meta_cant_visitas) {
        this.meta_cant_visitas = meta_cant_visitas;
    }

    public int getMeta_cant_clientes() {
        return meta_cant_clientes;
    }

    public void setMeta_cant_clientes(int meta_cant_clientes) {
        this.meta_cant_clientes = meta_cant_clientes;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }


    
    
}
