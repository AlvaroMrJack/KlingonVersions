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
public class Permisos {
    private Grupo grupo;
    private Interfaces interfaces;

    public Permisos() {
    }

    public Permisos(Grupo grupo, Interfaces interfaces) {
        this.grupo = grupo;
        this.interfaces = interfaces;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Interfaces getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Interfaces interfaces) {
        this.interfaces = interfaces;
    }
    
    
    
}
