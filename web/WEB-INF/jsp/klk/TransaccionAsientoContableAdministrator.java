/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import data.ConnectionBD;
import interfaces.Managment;
import java.sql.Connection;
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
import model.AsientoContableModel;
import model.TransaccionAsientoContable;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class TransaccionAsientoContableAdministrator implements Managment<TransaccionAsientoContable>{
    
    private static final String SQL_INSERT  = " INSERT INTO Transaccion(Tipo_Transaccion, Nombre_Tipo_Transaccion, Id_Empleado, Fecha, Monto, Estado) VALUES (?, ?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE  = " DELETE FROM Transaccion WHERE id = ? ";
    private static final String SQL_UPDATE  = " UPDATE Transaccion SET Tipo_Transaccion = ?, Nombre_Tipo_Transaccion = ?, Id_Empleado = ?, Fecha = ?, Monto = ?, Estado = ? WHERE Id = ?";
    private static final String SQL_READ  = " SELECT * FROM Transaccion WHERE id = ?";
    private static final String SQL_READALL  = " SELECT * FROM Transaccion ";
    
    private static final ConnectionBD con = ConnectionBD.connectionStart();
    private TransaccionAdministrator transaccionAdministrator = new TransaccionAdministrator();
    private AsientoContableAdministrator asientoContableAdministrator = new AsientoContableAdministrator();
    private TransaccionModel tm = new TransaccionModel();
    private List<AsientoContableModel> lac = new ArrayList<AsientoContableModel>();
    
    

    @Override
    public boolean create(TransaccionAsientoContable t) {
        
        PreparedStatement ps;
        
        try {
            
            con.beginTransaction();
            
            ps = con.getCon().prepareStatement(transaccionAdministrator.getSQL_INSERT());
            tm = t.getTransaccionModel();
            ps.setString(1, tm.getTipoTransaccion());
            ps.setString(2, tm.getNombreTipoTransaccion());
            ps.setInt(3, tm.getIdEmpleado());
            ps.setDate(4, new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(tm.getFecha()).getTime()));
            ps.setFloat(5, tm.getMonto());
            ps.setString(6, tm.getEstado());            
            ps.executeUpdate();
            
            
            
            lac = t.getListaAsientoContableModel();
            for (AsientoContableModel asientoContableModel : lac) {
                
                ps = con.getCon().prepareStatement(asientoContableAdministrator.getSQL_INSERT());
                
                ps.setString(1, asientoContableModel.getDescripcion());
                ps.setInt(2, asientoContableModel.getIdEmpleado());
                ps.setString(3, asientoContableModel.getCuenta());
                ps.setString(4, asientoContableModel.getTipoMovimiento());
                ps.setDate(5, new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(asientoContableModel.getFecha()).getTime()));
                ps.setFloat(6, asientoContableModel.getMonto());
                ps.setString(7, asientoContableModel.getEstado());

                ps.executeUpdate() ;
            
             }
            
            con.endTransaction();
            return true;
            
        }catch (Exception ex) {
            con.rollBackTransaction();
           // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
         finally{
           // con.closeConnectionDB();
        }
        
        return false;
        
    }

    @Override
    public boolean delete(Object key) {
        
        /*
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
        
        PreparedStatement ps;
        
        try {
            
            con.beginTransaction();
            
            ps = con.getCon().prepareStatement(transaccionAdministrator.getSQL_DELETE());
            ps.setInt(1, Integer.parseInt(key.toString()));
            tm = t.getTransaccionModel();
            ps.setString(1, tm.getTipoTransaccion());
            ps.setString(2, tm.getNombreTipoTransaccion());
            ps.setInt(3, tm.getIdEmpleado());
            ps.setDate(4, new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(tm.getFecha()).getTime()));
            ps.setFloat(5, tm.getMonto());
            ps.setString(6, tm.getEstado());            
            ps.executeUpdate();
            
            
            
            lac = t.getListaAsientoContableModel();
            for (AsientoContableModel asientoContableModel : lac) {
                
                ps = con.getCon().prepareStatement(asientoContableAdministrator.getSQL_INSERT());
                
                ps.setString(1, asientoContableModel.getDescripcion());
                ps.setInt(2, asientoContableModel.getIdEmpleado());
                ps.setString(3, asientoContableModel.getCuenta());
                ps.setString(4, asientoContableModel.getTipoMovimiento());
                ps.setDate(5, new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(asientoContableModel.getFecha()).getTime()));
                ps.setFloat(6, asientoContableModel.getMonto());
                ps.setString(7, asientoContableModel.getEstado());

                ps.executeUpdate() ;
            
             }
            
            con.endTransaction();
            return true;
            
        }catch (Exception ex) {
            con.rollBackTransaction();
           // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
         finally{
           // con.closeConnectionDB();
        }
        */
        return false;
    }

    @Override
    public boolean update(TransaccionAsientoContable t) {
        PreparedStatement ps;
        /*
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
        */
        return false;
    }

    @Override
    public TransaccionAsientoContable read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        TransaccionAsientoContable t = null;
        /*
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
        }*/
        return t;
    }

    @Override
    public List<TransaccionAsientoContable> readAll() {
        PreparedStatement ps;
        ResultSet res;
        TransaccionAsientoContable t = null;
        ArrayList<TransaccionAsientoContable> litaTransaccionAsientoContable = new ArrayList();
        /*
        try {
            ps = con.getCon().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while (res.next())
            {
                t = new TransaccionAsientoContable();
                t.setId(res.getInt(1)); 
                t.setTipoTransaccion(res.getString(2));
                t.setNombreTipoTransaccion(res.getString(3));
                t.setIdEmpleado(res.getInt(4));
                t.setFecha(res.getString(5));
                t.setMonto(res.getFloat(6));
                t.setEstado(res.getString(7));
                
                litaTransaccionAsientoContable.add(t);
            }
            return litaTransaccionAsientoContable;
        } catch (SQLException ex) {
           // Logger.getLogger(TransaccionAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        */
        return litaTransaccionAsientoContable;
    }
    
}

