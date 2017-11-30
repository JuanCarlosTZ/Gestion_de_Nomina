/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import administrator.EmpleadoAdministrator;
import administrator.Reporte;
import administrator.TransaccionAdministrator;
import javax.servlet.http.HttpServletRequest;
import model.AsientoContable;
import model.ModeloContenido;
import model.TransaccionModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Carlos Tejeda
 */

@Controller
public class TransaccionController {
          
    @RequestMapping(value= "Transaccion/index.htm", method = RequestMethod.GET)
    public ModelAndView Index(){
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        TransaccionAdministrator transaccionAdministrator = new TransaccionAdministrator();
        EmpleadoAdministrator empleadoAdministrator = new EmpleadoAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("Transaccion/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaEmpleadoModel",empleadoAdministrator.readAll());
        mav.addObject("listaTransaccionModel", transaccionAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);
    }
    


    @RequestMapping(value = "Transaccion/create.htm", method = RequestMethod.GET)
    public ModelAndView Create() {
        
        //Pasar una instancia vacia de EmpleadoModel al modelo
        ModelAndView mav = new ModelAndView();
        EmpleadoAdministrator empleadoAdministrator = new EmpleadoAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Transaccion");
        modeloContenido.setPagina("Transaccion/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaEmpleadoModel",empleadoAdministrator.readAll());   
        mav.addObject("transaccionModel", new TransaccionModel());
        mav.setViewName("layout");            
        return mav;
    }

       
    @RequestMapping(value = "Transaccion/create.htm", method = RequestMethod.POST)
    public ModelAndView Create(TransaccionModel transaccionModel) {
        
        ModelAndView mav = new ModelAndView();        
        TransaccionAdministrator transaccionAdministrator = new TransaccionAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Transaccion");
        modeloContenido.setPagina("Transaccion/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        if(transaccionAdministrator.create(transaccionModel)){            
            
            mav.addObject("transaccionModel", new TransaccionModel()); 
            modeloContenido.setMensage("Registro agregado safisfactoriamente."); 
            
        }else{                      
            mav.addObject("transaccionModel", transaccionModel);
            modeloContenido.setError("Error al agregar el registro.");
            
        }    
        
        mav.setViewName("layout");
  
        return mav;
    }
    
    
    @RequestMapping(value = "Transaccion/edit.htm", method = RequestMethod.GET)
    public ModelAndView Edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        EmpleadoAdministrator empleadoAdministrator = new EmpleadoAdministrator();
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Actualización de Transaccion");
        modeloContenido.setPagina("Transaccion/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaEmpleadoModel",empleadoAdministrator.readAll()); 
        int id = Integer.parseInt(request.getParameter("id"));
        TransaccionModel transaccionModel = new TransaccionAdministrator().read(id);
        mav.setViewName("layout");
        mav.addObject("transaccionModel", transaccionModel );
        return mav;
    }
    
   
    
    
        @RequestMapping(value = "Transaccion/edit.htm", method = RequestMethod.POST)
    public ModelAndView Edit(TransaccionModel transaccionModel) {
        
        ModelAndView mav = new ModelAndView();    
        EmpleadoAdministrator empleadoAdministrator = new EmpleadoAdministrator();
        TransaccionAdministrator transaccionAdministrator = new TransaccionAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        
        if(transaccionAdministrator.update(transaccionModel)){            
            modeloContenido.setMensage("Registro actualizado safisfactoriamente.");  
            
        }else{            
            modeloContenido.setError("Error al actualizar el registro.");
            
        }    
        
        mav.addObject("listaEmpleadoModel",empleadoAdministrator.readAll()); 
        modeloContenido.setTitulo("Actualización de Transaccion");
        modeloContenido.setPagina("Transaccion/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.setViewName("layout");
        mav.addObject("transaccionModel", transaccionModel);
  
        return mav;
    }
        @RequestMapping(value = "Transaccion/delete.htm", method = RequestMethod.GET)
    public ModelAndView Delete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
                
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("Transaccion/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        TransaccionAdministrator transaccionAdministrator = new TransaccionAdministrator();
        if(transaccionAdministrator.delete(id)){
            modeloContenido.setMensage("Registro eliminado safisfactoriamente.");
        }else{
            modeloContenido.setError("Error al eliminar el registro.");
        }
        
        mav.addObject("listaTransaccionModel", transaccionAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);

    
    }
    
    @RequestMapping(value= "Transaccion/report.htm", method = RequestMethod.GET)
    public ModelAndView Report(){
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        Reporte reporte = new Reporte();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("Transaccion/report");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaReporte", reporte.asientoContable(null, null));
        mav.setViewName("layout");
        return (mav);
    }
}
