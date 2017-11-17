/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Juan Carlos Tejeda
 */
public class ConnectionBD {
    
    public static ConnectionBD instancia;
    private Connection con;
    
    private ConnectionBD()
    {
               
        try
        {
                SQLServerDataSource ds = new SQLServerDataSource();
                ds.setUser("sa");
                ds.setPassword("sa");
                ds.setDatabaseName("NOMINA");
                ds.setPortNumber(1433);
                ds.setServerName("localhost");
                con = ds.getConnection();
        }
        catch(SQLServerException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    public synchronized static ConnectionBD connectionStart()
    {
        if(instancia == null)
        {
            instancia = new ConnectionBD();
        }
        return instancia;
    }
    
    public Connection getCon()
    {
        return con;
    }
    
    public void closeConnectionDB()
    {
        con = null;
    }
    
    public void beginTransaction()
    {
        try {
            con.setAutoCommit(false);
        } catch (SQLException ex) {
          //  Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    public void endTransaction()
    {
        try {
            con.commit();
        } catch (SQLException ex) {
            //Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void rollBackTransaction()
    {
        try {
            con.rollback();
        } catch (SQLException ex) {
            //Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
