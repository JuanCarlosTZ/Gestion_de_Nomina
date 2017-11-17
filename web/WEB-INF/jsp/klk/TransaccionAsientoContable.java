/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class TransaccionAsientoContable {

    public TransaccionAsientoContable() {
    }
    
    private TransaccionModel transaccionModel;
    private List<AsientoContableModel> listaAsientoContableModel = new ArrayList<AsientoContableModel>();

    public TransaccionModel getTransaccionModel() {
        return transaccionModel;
    }

    public void setTransaccionModel(TransaccionModel transaccionModel) {
        this.transaccionModel = transaccionModel;
    }

    public List<AsientoContableModel> getListaAsientoContableModel() {
        return listaAsientoContableModel;
    }

    public void setListaAsientoContableModel(List<AsientoContableModel> listaAsientoContableModel) {
        this.listaAsientoContableModel = listaAsientoContableModel;
    }
    
    
}
