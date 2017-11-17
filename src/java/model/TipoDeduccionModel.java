/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class TipoDeduccionModel {

    public TipoDeduccionModel() {
    }
    
    private int id;
    private String nombre;
    private int dependeDeSalario;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDependeDeSalario() {
        return dependeDeSalario;
    }

    public void setDependeDeSalario(int dependeDeSalario) {
        this.dependeDeSalario = dependeDeSalario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
