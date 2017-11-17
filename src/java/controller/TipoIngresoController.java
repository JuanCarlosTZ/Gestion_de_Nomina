/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import administrator.TipoIngresoAdministrator;
import javax.servlet.http.HttpServletRequest;
import model.ModeloContenido;
import model.TipoIngresoModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Carlos Tejeda
 */

@Controller
public class TipoIngresoController {
          
    @RequestMapping(value= "TipoIngreso/index.htm", method = RequestMethod.GET)
    public ModelAndView Index(){
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        TipoIngresoAdministrator tipoIngresoAdministrator = new TipoIngresoAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("TipoIngreso/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaTipoIngresoModel", tipoIngresoAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);
    }
    


    @RequestMapping(value = "TipoIngreso/create.htm", method = RequestMethod.GET)
    public ModelAndView Create() {
        
        //Pasar una instancia vacia de EmpleadoModel al modelo
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Tipo de Ingreso");
        modeloContenido.setPagina("TipoIngreso/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("tipoIngresoModel", new TipoIngresoModel());
        mav.setViewName("layout");            
        return mav;
    }

       
    @RequestMapping(value = "TipoIngreso/create.htm", method = RequestMethod.POST)
    public ModelAndView Create(TipoIngresoModel tipoIngresoModel) {
        
        ModelAndView mav = new ModelAndView();        
        TipoIngresoAdministrator tipoIngresoAdministrator = new TipoIngresoAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Tipo de Ingreso");
        modeloContenido.setPagina("TipoIngreso/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        if(tipoIngresoAdministrator.create(tipoIngresoModel)){            
            
            mav.addObject("tipoIngresoModel", new TipoIngresoModel()); 
            modeloContenido.setMensage("Registro agregado safisfactoriamente."); 
            
        }else{                      
            mav.addObject("tipoIngresoModel", tipoIngresoModel);
            modeloContenido.setError("Error al agregar el registro.");
            
        }    
        
        mav.setViewName("layout");
  
        return mav;
    }
    
    
    @RequestMapping(value = "TipoIngreso/edit.htm", method = RequestMethod.GET)
    public ModelAndView Edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Actualización de Tipo de Ingreso");
        modeloContenido.setPagina("TipoIngreso/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        TipoIngresoModel tipoIngresoModel = new TipoIngresoAdministrator().read(id);
        mav.setViewName("layout");
        mav.addObject("tipoIngresoModel", tipoIngresoModel );
        return mav;
    }
    
   
    
    
        @RequestMapping(value = "TipoIngreso/edit.htm", method = RequestMethod.POST)
    public ModelAndView Edit(TipoIngresoModel tipoIngresoModel) {
        
        ModelAndView mav = new ModelAndView();        
        TipoIngresoAdministrator tipoIngresoAdministrator = new TipoIngresoAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        
        if(tipoIngresoAdministrator.update(tipoIngresoModel)){            
            modeloContenido.setMensage("Registro actualizado safisfactoriamente.");  
            
        }else{            
            modeloContenido.setError("Error al actualizar el registro.");
            
        }    
        
                
        modeloContenido.setTitulo("Actualización de Tipo de Ingreso");
        modeloContenido.setPagina("TipoIngreso/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.setViewName("layout");
        mav.addObject("tipoIngresoModel", tipoIngresoModel);
  
        return mav;
    }
        @RequestMapping(value = "TipoIngreso/delete.htm", method = RequestMethod.GET)
    public ModelAndView Delete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
                
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("TipoIngreso/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        TipoIngresoAdministrator tipoIngresoAdministrator = new TipoIngresoAdministrator();
        if(tipoIngresoAdministrator.delete(id)){
            modeloContenido.setMensage("Registro eliminado safisfactoriamente.");
        }else{
            modeloContenido.setError("Error al eliminar el registro.");
        }
        
        mav.addObject("listaTipoIngresoModel", tipoIngresoAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);

    
}
}
