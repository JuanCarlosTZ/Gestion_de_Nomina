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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AsientoContable;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class Reporte{
    
    private static final String SQL_INSERT  = " INSERT INTO Asiento_Contable(Descripcion, Id_Empleado, Cuenta, Tipo_Movimiento, Fecha, Monto, Estado) VALUES (?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE  = " DELETE FROM Asiento_Contable WHERE id = ? ";
    private static final String SQL_UPDATE  = " UPDATE Asiento_Contable SET Descripcion = ?, Id_Empleado = ?, Cuenta = ?, Tipo_Movimiento = ?, Fecha = ?, Monto= ?, Estado = ? WHERE Id = ?";
    private static final String SQL_READ  = " SELECT * FROM Asiento_Contable WHERE id = ?";
    private static final String SQL_READALL  = " SELECT * FROM Asiento_Contable ";
    private static final String SQL_ASIENTO_CONTABLE  = " SELECT * FROM ufnGetAccountingEntryInformation(?,?) ";
    
    private static final ConnectionBD con = ConnectionBD.connectionStart();

    

    public List<AsientoContable> asientoContable(java.sql.Date dateStart, java.sql.Date dateEnd) {
        
        PreparedStatement ps;
        ResultSet res;
        AsientoContable ac;
        List<AsientoContable> asientosContables = new ArrayList<AsientoContable>();
        
        try {
            ps = con.getCon().prepareStatement(SQL_ASIENTO_CONTABLE);
            ps.setDate(1, dateStart);
            ps.setDate(2, dateEnd);
            
            res = ps.executeQuery() ;
            int i = 0;
            while (res.next())
            {
                i++;
                ac = new AsientoContable();
                ac.setId(i); 
                ac.setCuenta(res.getString(1));
                ac.setTipoMovimiento(res.getString(2));
                ac.setMonto(res.getFloat(3));
                ac.setFecha(res.getDate(4).toString());
                ac.setFecha2(res.getDate(4));
                ac.setFecha3(res.getDate(4));
                
                asientosContables.add(ac);
            }
            return asientosContables;
                
        } catch (Exception ex) {
            String  v = ex.getMessage();
            String a = v;
           // Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        /*} catch (ParseException ex) {
           // Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);*/
        } finally{
           // con.closeConnectionDB();
        }
        
        return null;
        
    }
/*
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
           // Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public boolean update(AsientoContable t) {
        PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, t.getDescripcion());
            ps.setInt(2, t.getIdEmpleado());
            ps.setString(3, t.getCuenta());
            ps.setString(4, t.getTipoMovimiento());
            ps.setDate(5, new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(t.getFecha()).getTime()));
            ps.setFloat(6, t.getMonto());
            ps.setString(7, t.getEstado());
            ps.setInt(8, t.getId());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
           // Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
           // Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public AsientoContable read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        AsientoContable ac = null;
        
        try {
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            
            while (res.next())
            {
                ac = new AsientoContable();
                ac.setId(res.getInt(1)); 
                ac.setDescripcion(res.getString(2));
                ac.setIdEmpleado(res.getInt(3));
                ac.setCuenta(res.getString(4));
                ac.setTipoMovimiento(res.getString(5));
                ac.setFecha(res.getString(6));
                ac.setMonto(res.getFloat(7));
                ac.setEstado(res.getString(8));
                
            }
            return ac;
        } catch (SQLException ex) {
          //  Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          //  con.closeConnectionDB();
        }
        return ac;
    }

    @Override
    public List<AsientoContable> readAll() {
        PreparedStatement ps;
        ResultSet res;
        AsientoContable ac = null;
        ArrayList<AsientoContable> asientosContables = new ArrayList();
        
        try {
            ps = con.getCon().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while (res.next())
            {
                ac = new AsientoContable();
                ac.setId(res.getInt(1)); 
                ac.setDescripcion(res.getString(2));
                ac.setIdEmpleado(res.getInt(3));
                ac.setCuenta(res.getString(4));
                ac.setTipoMovimiento(res.getString(5));
                ac.setFecha(res.getString(6));
                ac.setMonto(res.getFloat(7));
                ac.setEstado(res.getString(8));
                
                asientosContables.add(ac);
            }
            return asientosContables;
        } catch (SQLException ex) {
           // Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          //  con.closeConnectionDB();
        }
        return asientosContables;
    }
    */
}

