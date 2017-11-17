/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import data.ConnectionBD;
import interfaces.Managment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TipoDeduccionModel;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class TipoDeduccionAdministrator implements Managment<TipoDeduccionModel>{
    
    private static final String SQL_INSERT  = " INSERT INTO Tipo_Deduccion(Nombre, Depende_Salario, Estado) VALUES (?, ?, ?) ";
    private static final String SQL_DELETE  = " DELETE FROM Tipo_Deduccion WHERE id = ? ";
    private static final String SQL_UPDATE  = " UPDATE Tipo_Deduccion SET Nombre = ?, Depende_Salario = ?, Estado = ? WHERE Id = ?";
    private static final String SQL_READ  = " SELECT * FROM Tipo_Deduccion WHERE id = ?";
    private static final String SQL_READALL  = " SELECT * FROM Tipo_Deduccion ";
    
    private static final ConnectionBD con = ConnectionBD.connectionStart();
    
    

    @Override
    public boolean create(TipoDeduccionModel m) {
        
        PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getDependeDeSalario());
            ps.setString(3, m.getEstado());
            
            ps.executeUpdate() ;
            
                return true;
            
        } catch ( Exception err ) {
           // Logger.getLogger(TipoDeduccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        String  ver = err.getMessage();
        String confVer = ver;
        } finally{
           // con.closeConnectionDB();
        }
        
        return false;
        
    }

    @Override
    public boolean delete(Object key) {
        
        PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, Integer.parseInt(key.toString()));
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
            // Logger.getLogger(TippDeduccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          //  con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public boolean update(TipoDeduccionModel m) {
        PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getDependeDeSalario());
            ps.setString(3, m.getEstado());
            ps.setInt(4, m.getId());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (Exception ex) {
            
           // Logger.getLogger(TipoDeduccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public TipoDeduccionModel read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        TipoDeduccionModel ti = null;
        
        try {
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            
            while (res.next())
            {
                ti = new TipoDeduccionModel();
                ti.setId(res.getInt(1)); 
                ti.setNombre(res.getString(2));
                ti.setDependeDeSalario(res.getInt(3));
                ti.setEstado(res.getString(4));
            }
            return ti;
        } catch (SQLException ex) {
           // Logger.getLogger(TipoDeduccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        return ti;
    }

    @Override
    public List<TipoDeduccionModel> readAll() {
        PreparedStatement ps;
        ResultSet res;
        TipoDeduccionModel ti = null;
        ArrayList<TipoDeduccionModel> tiposDeducciones = new ArrayList();
        
        try {
            ps = con.getCon().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while (res.next())
            {
                ti = new TipoDeduccionModel();
                ti.setId(res.getInt(1)); 
                ti.setNombre(res.getString(2));
                ti.setDependeDeSalario(res.getInt(3));
                ti.setEstado(res.getString(4));
                
                tiposDeducciones.add(ti);
            }
            return tiposDeducciones;
        } catch (SQLException ex) {
            //  Logger.getLogger(TipoDeduccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          //   con.closeConnectionDB();
        }
        return tiposDeducciones;
    }
    
}
