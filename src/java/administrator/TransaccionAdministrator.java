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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TransaccionModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class TransaccionAdministrator implements Managment<TransaccionModel>{
    
    private static final String SQL_INSERT  = " INSERT INTO Transaccion(Tipo_Transaccion, Nombre_Tipo_Transaccion, Id_Empleado, Fecha, Monto, Estado) VALUES (?, ?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE  = " DELETE FROM Transaccion WHERE id = ? ";
    private static final String SQL_UPDATE  = " UPDATE Transaccion SET Tipo_Transaccion = ?, Nombre_Tipo_Transaccion = ?, Id_Empleado = ?, Fecha = ?, Monto = ?, Estado = ? WHERE Id = ?";
    private static final String SQL_READ  = " SELECT * FROM Transaccion WHERE id = ?";
    private static final String SQL_READALL  = " SELECT * FROM Transaccion ";
    
    
    private static final ConnectionBD con = ConnectionBD.connectionStart();

    @Override
    public boolean create(TransaccionModel t) {
        
        PreparedStatement ps;
        
        try {
    
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, t.getTipoTransaccion());
            ps.setString(2, t.getNombreTipoTransaccion());
            ps.setInt(3, t.getIdEmpleado());
            ps.setDate(4, new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(t.getFecha()).getTime()));
            ps.setFloat(5, t.getMonto());
            ps.setString(6, t.getEstado());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
           // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
           // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
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
          //  Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public boolean update(TransaccionModel t) {
        PreparedStatement ps;
        
        try {
            
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, t.getTipoTransaccion());
            ps.setString(2, t.getNombreTipoTransaccion());
            ps.setInt(3, t.getIdEmpleado());
            ps.setDate(4, new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(t.getFecha()).getTime())); 
            ps.setFloat(5, t.getMonto());
            ps.setString(6, t.getEstado());
            ps.setInt(7, t.getId());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
           // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
           // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public TransaccionModel read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        TransaccionModel t = null;
        
        try {
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            
            while (res.next())
            {
                t = new TransaccionModel();
                t.setId(res.getInt(1)); 
                t.setTipoTransaccion(res.getString(2));
                t.setNombreTipoTransaccion(res.getString(3));
                t.setIdEmpleado(res.getInt(4));
                t.setFecha(res.getString(5));
                t.setMonto(res.getFloat(6));
                t.setEstado(res.getString(7));
            }
            return t;
        } catch (SQLException ex) {
          //  Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        return t;
    }

    @Override
    public List<TransaccionModel> readAll() {
        PreparedStatement ps;
        ResultSet res;
        TransaccionModel t = null;
        ArrayList<TransaccionModel> transacciones = new ArrayList();
        
        try {
            ps = con.getCon().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while (res.next())
            {
                t = new TransaccionModel();
                t.setId(res.getInt(1)); 
                t.setTipoTransaccion(res.getString(2));
                t.setNombreTipoTransaccion(res.getString(3));
                t.setIdEmpleado(res.getInt(4));
                t.setFecha(res.getString(5));
                t.setMonto(res.getFloat(6));
                t.setEstado(res.getString(7));
                
                transacciones.add(t);
            }
            return transacciones;
        } catch (SQLException ex) {
           // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        return transacciones;
    }
    
}

