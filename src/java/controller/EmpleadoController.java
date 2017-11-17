/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import administrator.EmpleadoAdministrator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;


import model.EmpleadoModel;
import model.ModeloContenido;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Carlos Tejeda
 */

@Controller
public class EmpleadoController {
          
    @RequestMapping(value= "Empleado/index.htm", method = RequestMethod.GET)
    public ModelAndView Index(){
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        EmpleadoAdministrator empleadoAdministrator = new EmpleadoAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("Empleado/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaEmpleado", empleadoAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);
    }
    


    @RequestMapping(value = "Empleado/create.htm", method = RequestMethod.GET)
    public ModelAndView Create() {
        
        //Pasar una instancia vacia de EmpleadoModel al modelo
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Empleado");
        modeloContenido.setPagina("Empleado/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("empleado", new EmpleadoModel());
        mav.setViewName("layout");            
        return mav;
    }

       
    @RequestMapping(value = "Empleado/create.htm", method = RequestMethod.POST)
    public ModelAndView Create(EmpleadoModel empleado) {
        
        ModelAndView mav = new ModelAndView();        
        EmpleadoAdministrator empleadoAdministrator = new EmpleadoAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Empleado");
        modeloContenido.setPagina("Empleado/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        if(empleadoAdministrator.create(empleado)){            
            
            mav.addObject("empleado", new EmpleadoModel()); 
            modeloContenido.setMensage("Registro agregado safisfactoriamente."); 
            
        }else{                      
            mav.addObject("empleado", empleado);
            modeloContenido.setError("Error al agregar el registro.");
            
        }    
        
        mav.setViewName("layout");
  
        return mav;
    }
    
    
    @RequestMapping(value = "Empleado/edit.htm", method = RequestMethod.GET)
    public ModelAndView Edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Actualización de Empleado");
        modeloContenido.setPagina("Empleado/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        EmpleadoModel empleado = new EmpleadoAdministrator().read(id);
        mav.setViewName("layout");
        mav.addObject("empleado", empleado );
        return mav;
    }
    
   
    
    
        @RequestMapping(value = "Empleado/edit.htm", method = RequestMethod.POST)
    public ModelAndView Edit(EmpleadoModel empleado) {
        
        ModelAndView mav = new ModelAndView();        
        EmpleadoAdministrator empleadoAdministrator = new EmpleadoAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        
        if(empleadoAdministrator.update(empleado)){            
            modeloContenido.setMensage("Registro actualizado safisfactoriamente.");  
            
        }else{            
            modeloContenido.setError("Error al actualizar el registro.");
            
        }    
        
                
        modeloContenido.setTitulo("Actualización de Empleado");
        modeloContenido.setPagina("Empleado/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.setViewName("layout");
        mav.addObject("empleado", empleado);
  
        return mav;
    }
        @RequestMapping(value = "Empleado/delete.htm", method = RequestMethod.GET)
    public ModelAndView Delete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
                
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("Empleado/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        EmpleadoAdministrator empleadoAdministrator = new EmpleadoAdministrator();
        if(empleadoAdministrator.delete(id)){
            modeloContenido.setMensage("Registro eliminado safisfactoriamente.");
        }else{
            modeloContenido.setError("Error al eliminar el registro.");
        }
        
        mav.addObject("listaEmpleado", empleadoAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);

    
}
}
