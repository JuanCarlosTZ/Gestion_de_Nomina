/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.DataBase;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.mock.web.MockHttpSession;
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
@RequestMapping("login.htm")
public class LoginController {

        @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm(HttpSession session){

        if(session.isNew())
        {
            return "home";
        }
        else
        {
            return "login"; 
            
        }
        
    }
   
    @RequestMapping(method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String userId, 
            @RequestParam String password, Model model){
        
        boolean customer =false;
        DataBase db = new DataBase();
        
        ResultSet resultado = db.Consulta("Usuario");

          try
          {
          while ( resultado.next() ) {
              String codigo = resultado.getString("codigo");
              String contrasenia = resultado.getString("contrasenia");
               if(userId.equals(codigo)  && password.equals(contrasenia))
               {
                   customer = true;
                   model.addAttribute("nombre", codigo);
                   return "../views/home";
                   
                   
               }

            }
          }catch(Exception e)
          {
              
          }
                          if(customer == false){
                     model.addAttribute("loginError", "Error iniciando session. Por favor, intente de nuevo");
                     return  "../views//login";
                 }
                 return "";
         
    }

//    @RequestMapping(value="/entrar", method = RequestMethod.POST)
//    public String entrar(){
//        
//        return "../views/home";
//        
//    }
    
    
    
}
