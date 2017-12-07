/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import administrator.EmpleadoAdministrator;
import administrator.Reporte;
import administrator.ServicioAdministrador;
import administrator.TransaccionAdministrator;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import javax.ws.rs.Consumes;
import model.AsientoContable;
import model.ModeloContenido;
import model.TransaccionModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juan Carlos Tejeda
 */

@Controller
public class TransaccionController {
    
            java.sql.Date fechaInicio = null;
        java.sql.Date fechaFin = null;
        String generarAsiento = "FALSO";
          
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
        
        /*
           // display to console
   Object json = objectMapper.readValue(
     objectMapper.writeValueAsString(employee), Object.class);

   System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
     .writeValueAsString(json));
        */

        return (mav);
    }
    
    
    
    
    @RequestMapping(value = "Transaccion/asientoContable.htm", method = RequestMethod.GET)
    public ModelAndView EnviarAsiento(int id) {
        
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        Reporte reporte = new Reporte();
        administrator.ServicioAdministrador  servicioAdministrador = new ServicioAdministrador();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Asiento Contable");
        modeloContenido.setPagina("Transaccion/report");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        List<AsientoContable> listaAsientoContable = reporte.asientoContable(null, null);
        
        int idAsientoGenerado = servicioAdministrador.EnviarAsiento(listaAsientoContable);
        

        if(idAsientoGenerado>0){
            modeloContenido.setMensage("Se ha generado el asiento "+idAsientoGenerado);
        }else{
            modeloContenido.setMensage("Ha ocurrido un error");
        }

        mav.addObject("listaReporte", listaAsientoContable );
        mav.setViewName("layout");

        
                return (mav);

    }
    
    
      @RequestMapping(value = "Transaccion/report.htm", method = RequestMethod.POST)
    public ModelAndView Consulta(String fecha1, String fecha2) {
        
        //Intancia de las clases ModelAndView, EmpleadoAdministrador y una lista de EmpleadosModel
        ModelAndView mav = new ModelAndView();
        Reporte reporte = new Reporte();
        administrator.ServicioAdministrador  servicioAdministrador = new ServicioAdministrador();
        
        ModeloContenido modeloContenido = new ModeloContenido();
        modeloContenido.setTitulo("Asiento Contable");
        modeloContenido.setPagina("Transaccion/report");
        modeloContenido.setRuta("../");
        mav.addObject("modeloContenido", modeloContenido);
        
        java.sql.Date fechaInicio = null;
        java.sql.Date fechaFin = null;

        
        try{
            fechaInicio = new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(fecha1.toString()).getTime());
            fechaFin = new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(fecha2.toString()).getTime());
            
        }catch(Exception err){
            String a = "";
        }
        
        List<AsientoContable> listaAsientoContable = reporte.asientoContable(fechaInicio, fechaFin);
        int idAsientoGenerado;

        if(listaAsientoContable.size() > 0)
        {
        idAsientoGenerado = servicioAdministrador.EnviarAsiento(listaAsientoContable);

        if(idAsientoGenerado>0){
            modeloContenido.setMensage("Se ha generado el asiento "+idAsientoGenerado);
        }
        }

        mav.addObject("fecha1", fecha1 );
        mav.addObject("fecha2", fecha2  );
        mav.addObject("listaReporte", listaAsientoContable );
        mav.setViewName("layout");

        
                return (mav);

    }
    

    

}
