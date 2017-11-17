/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import model.UsuarioModel;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class UsuarioDataBase extends DataBase{
    

          public void insert(UsuarioModel usuario)
          {
              String entidad = "Usuario";
              String query  = "insert into "+ entidad;
              query += " (codigo"
                      + ", contrasenia"
                      + ", id_tipo_usuario"
                      + ", id_estado"
                      + ", fecha_creacion"
                      + ", id_usuario_creador"
                      + ", fecha_actualizacion"
                      + ", id_usuario_Actualizador"
                      + ")";
          
              query += " Values( "
                      + "'"+usuario.getCodigo()+"'"
                      + ",'"+usuario.getContrasenia()+"'"
                      + ",'"+usuario.getIdTipoUsuario()+"'"
                      + ",'"+usuario.getIdEstado()+"'"
                      + ",'"+usuario.getFechaCreacion()+"'"
                      + ",'"+usuario.getIdUsuarioCreador()+"'"
                      + ",'"+usuario.getFechaActualizacion()+"'"
                      + ",'"+usuario.getIdUsuarioActualizador()+"'"
                      + " )";
              
              guardarSQL(query);
          }
    
}
