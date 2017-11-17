/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import data.ConnectionBD;
import model.UsuarioModel;
import interfaces.Managment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class UsuarioAdministrator implements Managment<UsuarioModel>{
    
    private static final String SQL_INSERT  = " INSERT INTO usuario(codigo, contrasenia, id_tipo_usuario, id_estado, fecha_creacion, id_usuario_creador, fecha_actualizacion, id_usuario_Actualizador) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE  = " DELETE FROM usuario WHERE id = ? ";
    private static final String SQL_UPDATE  = " UPDATE usuario SET contrasenia = ?, id_estado = ?, fecha_actualizacion = ?, id_usuario_Actualizador = ?";
    private static final String SQL_READ  = " SELECT * FROM usuario WHERE id = ?";
    private static final String SQL_READALL  = " SELECT * FROM usuario ";
    
    private static final ConnectionBD con = ConnectionBD.connectionStart();
    
    

    @Override
    public boolean create(UsuarioModel m) {
        
        PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, m.getCodigo());
            ps.setString(2, m.getContrasenia());
            ps.setInt(3, m.getIdTipoUsuario());
            ps.setInt(4, m.getIdEstado());
            ps.setString(5, m.getFechaCreacion());
            ps.setInt(6, m.getIdUsuarioCreador());
            ps.setString(7, m.getFechaActualizacion());
            ps.setInt(8, m.getIdUsuarioActualizador());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.closeConnectionDB();
        }
        
        return false;
        
    }

    @Override
    public boolean delete(Object key) {
        
        PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public boolean update(UsuarioModel m) {
        PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, m.getContrasenia());
            ps.setInt(2, m.getIdEstado());
            ps.setString(3, m.getFechaActualizacion());
            ps.setInt(4, m.getIdUsuarioActualizador());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public UsuarioModel read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        UsuarioModel u = null;
        
        try {
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            
            while (res.next())
            {
                u = new UsuarioModel();
                u.setId(res.getInt(1)); 
                u.setCodigo(res.getString(2));
                u.setContrasenia(res.getString(3));
                u.setIdTipoUsuario(res.getInt(4));
                u.setIdEstado(res.getInt(5));
                u.setFechaCreacion(res.getString(6));
                u.setIdUsuarioCreador(res.getInt(7));
                u.setFechaActualizacion(res.getString(8));
                u.setIdUsuarioActualizador(res.getInt(9));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.closeConnectionDB();
        }
        return u;
    }

    @Override
    public List<UsuarioModel> readAll() {
        PreparedStatement ps;
        ResultSet res;
        UsuarioModel u = null;
        ArrayList<UsuarioModel> usuarios = new ArrayList();
        
        try {
            ps = con.getCon().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while (res.next())
            {
                u = new UsuarioModel();
                u.setId(res.getInt(1)); 
                u.setCodigo(res.getString(2));
                u.setContrasenia(res.getString(3));
                u.setIdTipoUsuario(res.getInt(4));
                u.setIdEstado(res.getInt(5));
                u.setFechaCreacion(res.getString(6));
                u.setIdUsuarioCreador(res.getInt(7));
                u.setFechaActualizacion(res.getString(8));
                u.setIdUsuarioActualizador(res.getInt(9));
                
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.closeConnectionDB();
        }
        return usuarios;
    }
    
}
