/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.DataBase;
import data.UsuarioDataBase;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Juan Carlos Tejeda
 */

@Controller
@RequestMapping("registrarusuario.htm")
public class RegistrarUsuarioController {
    
            @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm(){

            return "usuario/registrarusuario"; 

    }
   
    @RequestMapping(method = RequestMethod.POST)
    public String registrarUsuario(Model model, @RequestParam String codigo
            , @RequestParam String contrasenia, @RequestParam int idTipoUsuario ){
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime(); 
        String fechaActual = dateFormat.format(today);
        
        int idEstado = 1;
        String fechaCreacion = fechaActual;
        int idUsuarioCreador = 1;
        String fechaActualizacion =  fechaActual;
        int idUsuarioActualizador = 1;
        
        boolean customer =false;
        DataBase db = new DataBase();
        UsuarioModel usuario = new UsuarioModel();
        usuario.setCodigo(codigo);
        usuario.setContrasenia(contrasenia);
        usuario.setIdTipoUsuario(idTipoUsuario);
        usuario.setIdEstado(idEstado);
        usuario.setFechaCreacion(fechaCreacion);
        usuario.setIdUsuarioCreador(idUsuarioCreador);
        usuario.setFechaActualizacion(fechaActualizacion);
        usuario.setIdUsuarioActualizador(idUsuarioActualizador);
        
        UsuarioDataBase usuarioDataBase = new UsuarioDataBase();
        usuarioDataBase.insert(usuario);
        model.addAttribute("guardarConfirmacion", "Registro guardado satisfactoriamente");

                 return "usuario/registrarusuario";
         
    }
    
}
