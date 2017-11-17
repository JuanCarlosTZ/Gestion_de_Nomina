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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.EmpleadoModel;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class EmpleadoAdministrator implements Managment<EmpleadoModel>{
    
    private static final String SQL_INSERT  = " INSERT INTO Empleado(Cedula, Nombre, Departamento, Puesto, Salario, Cuenta, Id_Nomina) VALUES (?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE  = " DELETE FROM Empleado WHERE id = ? ";
    private static final String SQL_UPDATE  = " UPDATE Empleado SET Cedula = ?, Nombre = ?, Departamento = ?, Puesto = ?, Salario = ?, Cuenta = ?, Id_Nomina = ? WHERE Id = ?";
    private static final String SQL_READ  = " SELECT * FROM Empleado WHERE id = ?";
    private static final String SQL_READALL  = " SELECT * FROM Empleado ";
    
    private static final ConnectionBD con = ConnectionBD.connectionStart();
    
    
                    List<EmpleadoModel> empleados = new ArrayList<EmpleadoModel>();
            PreparedStatement ps;
            ResultSet res;
            EmpleadoModel e = null;    
    @Override
    public boolean create(EmpleadoModel m) {
        

        
       // PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, m.getCedula());
            ps.setString(2, m.getNombre());
            ps.setString(3, m.getDepartamento());
            ps.setString(4, m.getPuesto());
            ps.setFloat(5, m.getSalario());
            ps.setString(6, m.getCuenta());
            ps.setInt(7, m.getIdNomina());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
          //  Logger.getLogger(EmpleadoAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          //  con.closeConnectionDB();
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
         //   Logger.getLogger(EmpleadoAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           // con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public boolean update(EmpleadoModel m) {
        PreparedStatement ps;
        
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, m.getCedula());
            ps.setString(2, m.getNombre());
            ps.setString(3, m.getDepartamento());
            ps.setString(4, m.getPuesto());
            ps.setFloat(5, m.getSalario());
            ps.setString(6, m.getCuenta());
            ps.setInt(7, m.getIdNomina());
            ps.setFloat(8, m.getId());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
           // Logger.getLogger(EmpleadoAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          //  con.closeConnectionDB();
        }
        
        return false;
    }

    @Override
    public EmpleadoModel read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        EmpleadoModel e = null;
        
        try {
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            
            while (res.next())
            {
                e = new EmpleadoModel();
                e.setId(res.getInt(1)); 
                e.setCedula(res.getString(2));
                e.setNombre(res.getString(3));
                e.setDepartamento(res.getString(4));
                e.setPuesto(res.getString(5));
                e.setSalario(res.getFloat(6));
                e.setCuenta(res.getString(7));
                e.setIdNomina(res.getInt(8));
            }
            return e;
        } catch (SQLException ex) {
           // Logger.getLogger(EmpleadoAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            //con.closeConnectionDB();
        }
        return e;
    }

    @Override
    public List<EmpleadoModel> readAll() {

           
        try {
            
            ps = con.getCon().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            

            while (res.next())
            {
                e = new EmpleadoModel();
                e.setId(res.getInt(1)); 
                e.setCedula(res.getString(2));
                e.setNombre(res.getString(3));
                e.setDepartamento(res.getString(4));
                e.setPuesto(res.getString(5));
                e.setSalario(res.getFloat(6));
                e.setCuenta(res.getString(7));
                e.setIdNomina(res.getInt(8));
                
                empleados.add(e);
            }
        /*    ps.close();
            res.close();*/
            
            return empleados;
        } catch (SQLException ex) {
            /*Logger.getLogger(EmpleadoAdministrator.class.getName()).log(Level.SEVERE, null, ex);*/
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } finally{
            //con.closeConnectionDB();
        }
        return empleados;
    }
    
}