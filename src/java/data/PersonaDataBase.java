/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import model.PersonaModel;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class PersonaDataBase extends DataBase{
    

          public void insert(PersonaModel persona)
          {
              String entidad = "Persona";
              String query  = "insert into "+ entidad;
              query += " (id_usuario"
                      + ", cedula"
                      + ", nombre"
                      + ", primer_apellido"
                      + ", segundo_apellido"
                      + ", genero"
                      + ", fecha_nacimiento"
                      + ", nacionalidad"
                      + ", fecha_creacion"
                      + ", id_usuario_creador"
                      + ", fecha_actualizacion"
                      + ", id_usuario_Actualizacion"
                      + ")";
          
              query += " Value( "
                      + "'"+persona.getIdUsuario()+"'"
                      + "'"+persona.getCedula()+"'"
                      + "'"+persona.getNombre()+"'"
                      + "'"+persona.getPrimerApellido()+"'"
                      + "'"+persona.getSegundoApellido()+"'"
                      + "'"+persona.getGenero()+"'"
                      + "'"+persona.getFechaNacimiento()+"'"
                      + "'"+persona.getNacionalidad()+"'"
                      + "'"+persona.getFechaCreacion()+"'"
                      + "'"+persona.getIdUsuarioCreador()+"'"
                      + "'"+persona.getFechaActualizacion()+"'"
                      + "'"+persona.getIdUsuarioActualizador()+"'"
                      + " )";
              
              guardarSQL(query);
          }
}
