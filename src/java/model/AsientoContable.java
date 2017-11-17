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
public class AsientoContable {

    public AsientoContable() {
    }
    
    
    private int id;
    private String cuenta;
    private String tipoMovimiento;
    private float Monto;
    private String fecha;
    private java.sql.Date fecha2;
    private java.util.Date fecha3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public java.sql.Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(java.sql.Date fecha2) {
        this.fecha2 = fecha2;
    }

    public java.util.Date getFecha3() {
        return fecha3;
    }

    public void setFecha3(java.util.Date fecha3) {
        this.fecha3 = fecha3;
    }

    
}
