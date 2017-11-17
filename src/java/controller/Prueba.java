/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import administrator.UsuarioAdministrator;
import model.UsuarioModel;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class Prueba {
    public static void main(String[] args){
        UsuarioAdministrator  uAdmin = new UsuarioAdministrator();
        UsuarioModel usuario = uAdmin.read("6");
        System.out.println(usuario.getCodigo());
        
    }
    
}
