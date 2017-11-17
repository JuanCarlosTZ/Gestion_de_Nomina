/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import administrator.TransaccionAdministrator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.AsientoContableModel;
import model.ModeloContenido;
import model.TransaccionAsientoContable;
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
public class TransaccionAsientoContableController {
          
    @RequestMapping(value= "TransaccionAsientoContable/index.htm", method = RequestMethod.GET)
    public ModelAndView Index(){
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        TransaccionAdministrator transaccionAdministrator = new TransaccionAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Lista");
        modeloContenido.setPagina("TransaccionAsientoContable/index");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("listaTransaccionModel", transaccionAdministrator.readAll());
        mav.setViewName("layout");
        return (mav);
    }
    


    @RequestMapping(value = "TransaccionAsientoContable/create.htm", method = RequestMethod.GET)
    public ModelAndView Create() {
        
        //Pasar una instancia vacia de EmpleadoModel al modelo
        ModelAndView mav = new ModelAndView();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Transaccion");
        modeloContenido.setPagina("TransaccionAsientoContable/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        mav.addObject("transaccionAsientoContable", new TransaccionAsientoContable());
        mav.setViewName("layout");            
        return mav;
    }

       
    @RequestMapping(value = "TransaccionAsientoContable/create.htm", method = RequestMethod.POST)
    public ModelAndView Create(TransaccionAsientoContable transaccionAsientoContable) {
        
        ModelAndView mav = new ModelAndView();        
        TransaccionAdministrator transaccionAdministrator = new TransaccionAdministrator();
        TransaccionModel transaccionModel = transaccionAsientoContable.getTransaccionModel();
        List<AsientoContableModel> listaAsientoContableModel = transaccionAsientoContable.getListaAsientoContableModel();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Agregando Transaccion");
        modeloContenido.setPagina("Transaccion/create");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        
        float sumaMontoAsientoContable = 0;
        
        for (AsientoContableModel asientoContableModel : listaAsientoContableModel) {
            sumaMontoAsientoContable =+ asientoContableModel.getMonto();
        }
        
        if(transaccionModel.getMonto() != sumaMontoAsientoContable || sumaMontoAsientoContable != 0){
            mav.addObject("transaccionAsientoContable", transaccionAsientoContable);
            modeloContenido.setError("Error al agregar el registro.");
            mav.setViewName("layout");
  
            return mav;
            
        }
        
        
        
  
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
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Actualización de Transaccion");
        modeloContenido.setPagina("Transaccion/edit");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        int id = Integer.parseInt(request.getParameter("id"));
        TransaccionModel transaccionModel = new TransaccionAdministrator().read(id);
        mav.setViewName("layout");
        mav.addObject("transaccionModel", transaccionModel );
        return mav;
    }
    
   
    
    
        @RequestMapping(value = "Transaccion/edit.htm", method = RequestMethod.POST)
    public ModelAndView Edit(TransaccionModel transaccionModel) {
        
        ModelAndView mav = new ModelAndView();        
        TransaccionAdministrator transaccionAdministrator = new TransaccionAdministrator();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        
        if(transaccionAdministrator.update(transaccionModel)){            
            modeloContenido.setMensage("Registro actualizado safisfactoriamente.");  
            
        }else{            
            modeloContenido.setError("Error al actualizar el registro.");
            
        }    
        
                
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
}
