/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import administrator.Reporte;
import javax.servlet.http.HttpServletRequest;
import model.AsientoContable;
import model.ModeloContenido;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Carlos Tejeda
 */

@Controller
public class AsientoContableController {
          /*
    @RequestMapping(value= "AsientoContable/index.htm", method = RequestMethod.GET)
    public ModelAndView Index(){
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        Reporte asientoContableAdministrator = new Reporte();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("AsientoContable/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaAsientoContableModel", asientoContableAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);
    }
    


    @RequestMapping(value = "AsientoContable/create.htm", method = RequestMethod.GET)
    public ModelAndView Create() {
        
        //Pasar una instancia vacia de EmpleadoModel al modelo
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Asiento Contable");
        modeloContenido.setPagina("AsientoContable/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("asientoContableModel", new AsientoContable());
        mav.setViewName("layout");            
        return mav;
    }

       
    @RequestMapping(value = "AsientoContable/create.htm", method = RequestMethod.POST)
    public ModelAndView Create(AsientoContable asientoContableModel) {
        
        ModelAndView mav = new ModelAndView();        
        Reporte asientoContableAdministrator = new Reporte();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Asiento Contable");
        modeloContenido.setPagina("AsientoContable/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        if(asientoContableAdministrator.create(asientoContableModel)){            
            
            mav.addObject("asientoContableModel", new AsientoContable()); 
            modeloContenido.setMensage("Registro agregado safisfactoriamente."); 
            
        }else{                      
            mav.addObject("asientoContableModel", asientoContableModel);
            modeloContenido.setError("Error al agregar el registro.");
            
        }    
        
        mav.setViewName("layout");
  
        return mav;
    }
    
    
    @RequestMapping(value = "AsientoContable/edit.htm", method = RequestMethod.GET)
    public ModelAndView Edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Actualización de Asiento Contable");
        modeloContenido.setPagina("AsientoContable/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        AsientoContable asientoContableModel = new Reporte().read(id);
        mav.setViewName("layout");
        mav.addObject("asientoContableModel", asientoContableModel );
        return mav;
    }
    
   
    
    
        @RequestMapping(value = "AsientoContable/edit.htm", method = RequestMethod.POST)
    public ModelAndView Edit(AsientoContable asientoContableModel) {
        
        ModelAndView mav = new ModelAndView();        
        Reporte asientoContableAdministrator = new Reporte();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        
        if(asientoContableAdministrator.update(asientoContableModel)){            
            modeloContenido.setMensage("Registro actualizado safisfactoriamente.");  
            
        }else{            
            modeloContenido.setError("Error al actualizar el registro.");
            
        }    
        
                
        modeloContenido.setTitulo("Actualización de Asiento Contable");
        modeloContenido.setPagina("AsientoContable/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.setViewName("layout");
        mav.addObject("asientoContableModel", asientoContableModel);
  
        return mav;
    }
        @RequestMapping(value = "AsientoContable/delete.htm", method = RequestMethod.GET)
    public ModelAndView Delete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
                
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("AsientoContable/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        Reporte asientoContableAdministrator = new Reporte();
        if(asientoContableAdministrator.delete(id)){
            modeloContenido.setMensage("Registro eliminado safisfactoriamente.");
        }else{
            modeloContenido.setError("Error al eliminar el registro.");
        }
        
        mav.addObject("listaAsientoContableModel", asientoContableAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);

    
}

*/
}
