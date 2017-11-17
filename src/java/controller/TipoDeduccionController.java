/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import administrator.TipoDeduccionAdministrator;
import javax.servlet.http.HttpServletRequest;
import model.ModeloContenido;
import model.TipoDeduccionModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Carlos Tejeda
 */

@Controller
public class TipoDeduccionController {
          
    @RequestMapping(value= "TipoDeduccion/index.htm", method = RequestMethod.GET)
    public ModelAndView Index(){
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        TipoDeduccionAdministrator tipoDeduccionAdministrator = new TipoDeduccionAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("TipoDeduccion/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaTipoDeduccionModel", tipoDeduccionAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);
    }
    


    @RequestMapping(value = "TipoDeduccion/create.htm", method = RequestMethod.GET)
    public ModelAndView Create() {
        
        //Pasar una instancia vacia de EmpleadoModel al modelo
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Tipo de Deducción");
        modeloContenido.setPagina("TipoDeduccion/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("tipoDeduccionModel", new TipoDeduccionModel());
        mav.setViewName("layout");            
        return mav;
    }

       
    @RequestMapping(value = "TipoDeduccion/create.htm", method = RequestMethod.POST)
    public ModelAndView Create(TipoDeduccionModel tipoDeduccionModel) {
        
        ModelAndView mav = new ModelAndView();        
        TipoDeduccionAdministrator tipoDescuentoAdministrator = new TipoDeduccionAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Tipo de Deducción");
        modeloContenido.setPagina("TipoDeduccion/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        if(tipoDescuentoAdministrator.create(tipoDeduccionModel)){            
            
            mav.addObject("tipoDeduccionModel", new TipoDeduccionModel()); 
            modeloContenido.setMensage("Registro agregado safisfactoriamente."); 
            
        }else{                      
            mav.addObject("tipoDeduccionModel", tipoDeduccionModel);
            modeloContenido.setError("Error al agregar el registro.");
            
        }    
        
        mav.setViewName("layout");
  
        return mav;
    }
    
    
    @RequestMapping(value = "TipoDeduccion/edit.htm", method = RequestMethod.GET)
    public ModelAndView Edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Actualización de Tipo de Deducción");
        modeloContenido.setPagina("TipoDeduccion/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        TipoDeduccionModel tipoDeduccionModel = new TipoDeduccionAdministrator().read(id);
        mav.setViewName("layout");
        mav.addObject("tipoDeduccionModel", tipoDeduccionModel );
        return mav;
    }
    
   
    
    
        @RequestMapping(value = "TipoDeduccion/edit.htm", method = RequestMethod.POST)
    public ModelAndView Edit(TipoDeduccionModel tipoDeduccionModel) {
        
        ModelAndView mav = new ModelAndView();        
        TipoDeduccionAdministrator tipoDeduccionAdministrator = new TipoDeduccionAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        
        if(tipoDeduccionAdministrator.update(tipoDeduccionModel)){            
            modeloContenido.setMensage("Registro actualizado safisfactoriamente.");  
            
        }else{    
            modeloContenido.setError("Error al actualizar el registro.");
            
        }      
        modeloContenido.setTitulo("Actualización de Tipo de Deduccion");
        modeloContenido.setPagina("TipoDeduccion/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.setViewName("layout");
        mav.addObject("tipoDeduccionModel", tipoDeduccionModel);
  
        return mav;
    }
    
        @RequestMapping(value = "TipoDeduccion/delete.htm", method = RequestMethod.GET)
    public ModelAndView Delete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
                
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("TipoDeduccion/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        TipoDeduccionAdministrator tipoDeduccionAdministrator = new TipoDeduccionAdministrator();
        if(tipoDeduccionAdministrator.delete(id)){
            modeloContenido.setMensage("Registro eliminado safisfactoriamente.");
        }else{
            modeloContenido.setError("Error al eliminar el registro.");
        }
        
        mav.addObject("listaTipoDeduccionModel", tipoDeduccionAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);

    
}
}
