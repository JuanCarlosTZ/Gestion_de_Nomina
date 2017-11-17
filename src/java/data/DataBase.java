/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class DataBase {
    
    public boolean accion = false;
    public static String mensajeError = null;
    public static Connection con;
    public ResultSet resultado;
    public String sql;
    public Statement sentencia;

    
    
    public ResultSet Consulta(String entidad)
    {
        sql = select(entidad);
        resultado = ejecutarSQL(sql);
        return resultado;
    }
    
        public ResultSet Consulta(String entidad, String campos)
    {
        sql = select(entidad);
        resultado = ejecutarSQL(sql);                
        return resultado;
    }
        public ResultSet Consulta(String entidad, String campos, List<String>[] filtros)
    {
        sql = select(entidad, campos, filtros);
        resultado = ejecutarSQL(sql);                
        return resultado;
    }
    
    public ResultSet ejecutarSQL(String sql)
    {
        if(ConnectionStart())
        {
            try {
            sentencia = con.createStatement();
            resultado = sentencia.executeQuery(sql);
            con.close();
            sentencia.close();
            accion = true;
        } catch (SQLException e) {
            accion = false;
            mensajeError = e.getMessage();
            return null;
        } 
            
        }
        return resultado;
    }
    
        public void guardarSQL(String sql)
    {
        if(ConnectionStart())
        {
            try {
            sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            con.close();
            sentencia.close();
            accion = true;
        } catch (SQLException e) {
            accion = false;
            mensajeError = e.getMessage();
        } 
            
        }
    }   
    

    public String select(String entidad)
    {
        String query = "Select * from "+ entidad;
        return query;
    }
    
        public String select(String entidad, String campos)
    {
        String query = "Select " + campos + " from "+ entidad;
        return query;
    }
  
      public String select(String entidad, String campos, List<String>[] filtros)
    {
        
        if (campos.length() < 1)
        {
            campos = "*";
        }
        String query = "Select "+campos+" from "+ entidad + " where ";

        List<String> listaCampos = filtros[0];
        List<String> listaValores = filtros[1];
        for (int i = 0; i <= listaCampos.size(); i++) 
        {            
            query += listaCampos.get(i);
            query += " = ";
            query += listaValores.get(i);
        }
 
        return query;
    }
      
      public void insert(String query)
      {
          
      }

    
        
        
        
    
/*
        public DataTable consultar(string pFrmTipo, string pCriterioTipo, string pCriterio)
        {
            if (connectionStart())
            {
                string SQL = " Select * From " + pFrmTipo;
                SQL += " where " + pCriterioTipo + " Like '%" + pCriterio + "%' ";
                SQL += " Order by " + pCriterioTipo;

                return ejecutarSQL(SQL);
            }
            else
            {
                return null;
            }

        }

        public DataTable consultar(string pFrmTipo, string pCriterioTipo, string pCriterio, string pCriterioTipo2, string pCriterio2)
        {
            if (conectar())
            {
                string SQL = " Select * From " + pFrmTipo;
                SQL += " where " + pCriterioTipo + " Like '%" + pCriterio + "%' ";
                SQL += " Order by " + pCriterioTipo;

                return ejecutarSQL(SQL);
            }
            else
            {
                return null;
            }

        }

        public DataTable buscar(string pFrmTipo, string pCriterioTipo, string pCriterio)
        {
            if (conectar())
            {
                string SQL = " Select * From " + pFrmTipo;
                SQL += " where " + pCriterioTipo + " = '" + pCriterio + "' ";
                SQL += " Order by " + pCriterioTipo;

                return ejecutarSQL(SQL);
            }
            else
            {
                return null;
            }

        }


        public DataTable ejecutarSQL(string sql)
        {

            if (conectar())
            {
                try
                {
                    oda = new SqlDataAdapter(sql, ocon);
                    odt = new DataTable();
                    oda.Fill(odt);
                }
                catch (Exception error)
                {
                    MessageBox.Show("Error");
                    return null;
                }


                return odt;
            }
            else
            {
                return null;
            }
        }


        public List<string> camposPorTabla(string frmTipo)
        {
            if (conectar())
            {
                string SQL = "  SELECT SO.NAME, SC.NAME as campo";
                SQL += "       FROM sys.objects SO INNER JOIN sys.columns SC ";
                SQL += "        ON SO.OBJECT_ID = SC.OBJECT_ID ";
                SQL += "        WHERE SO.TYPE = 'U' and SO.NAME = '" + frmTipo + "'";
                SQL += "        ORDER BY SO.NAME, SC.NAME ";

                odt = ejecutarSQL(SQL);
                return odt.Rows.OfType<DataRow>().Select(dr => dr.Field<string>("campo")).ToList();
            }
            else
            {
                return null;
            }

        }

        public bool actualizar(string pSQL)
        {
            
            
            if (conectar())
            {

                try
                {

                    SqlCommand ocdm = new SqlCommand(pSQL, ocon);
                    ocdm.ExecuteNonQuery();
                    MessageBox.Show("Datos actualizados Correctamente");

                }
                catch (Exception error)
                {
                    MessageBox.Show("Error al actualizar los datos");
                    return false;
                }


                return true;
            }
            else
            {
                return false ;
            }
            
        }

        public bool insertar(string pSQL)
        {
            if(conectar())
            {
                
                try
                {
                    
                    SqlCommand ocdm = new SqlCommand(pSQL, ocon);
                    ocdm.ExecuteNonQuery();
                    MessageBox.Show("Datos Guardados Correctamente");
                   
                }
                catch (Exception error)
                {
                    MessageBox.Show("Error al guardar los datos");
                    return false;
                }



            }else
            {
                return false;
            }

            return true;
            
        }


        public bool eliminar(string tabla, string filtro)
        {
            if (conectar())
            {

                try
                {
                    string pSQL = "Delete " + tabla +" "+ filtro ;
                    SqlCommand ocdm = new SqlCommand(pSQL, ocon);
                    ocdm.ExecuteNonQuery();

                }
                catch (Exception error)
                {
                    MessageBox.Show("Error al eliminar");
                    return false;
                }



            }
            else
            {
                return false;
            }

            return true;

        }

        public DataTable consultar(string pFrmTipo)
        {
            if (!conectar())
            {
                return null;
            }

            string SQL = " Select * From " + pFrmTipo;
            SQL += " Order by 1 ";

           
            return ejecutarSQL(SQL);
        }

        public string getIdAulaUltima()
        {
            string subSQL = "select max(id) as ID from aula";
            odt = ejecutarSQL(subSQL);
            string idAula = odt.Rows.OfType<DataRow>().Select(dr => dr.Field<int>("ID")).ToList().First().ToString();
            return idAula;
        }


        public string getIdUsuario()
        {
            string ACCESO = Program.getAcceso();
            string No_Carnet = Program.getNo_Carnet();
            string xSQL = " select ID_Usuario from " + ACCESO + " where No_Carnet =  '" + No_Carnet + "' ";
            odt = ejecutarSQL(xSQL);
            string idUsuario = odt.Rows.OfType<DataRow>().Select(dr => dr.Field<int>("ID_Usuario")).ToList().First().ToString();
            return idUsuario;
        }

        public string getAcceso()
        {
            string ACCESO = Program.getAcceso();
            return ACCESO;
        }


        public string getIdCriterioPorNombre(string ptabla, string pCampo, string pValor)
        {
            string sql = " select top 1 id from " + ptabla + " where " + pCampo + "  = '" + pValor + "' ";
            try
            {
                string id = ejecutarSQL(sql).Rows.OfType<DataRow>().Select(dr => dr.Field<int>("id")).ToList().First().ToString();
                return id;
            }catch(Exception e)
            {
                 return "";
            }
            
           
        }

        public string getIdCriterioPorNombre(string ptabla, string pCampo, string pValor, string pCampo2, string pValor2)
        {
            try
            {
                string sql = " select top 1 id from " + ptabla + " where " + pCampo + "  = '" + pValor + "' and " + pCampo2 + " = '"+ pValor2 + "' ";
            string id = ejecutarSQL(sql).Rows.OfType<DataRow>().Select(dr => dr.Field<int>("id")).ToList().First().ToString();
            return id;
                }catch(Exception e)
                    {
                         return "";
            }
}

        public List<string> getListaCriterio(string pTabla, string pCampoFiltro, string pValor, string pCampoRetorno )
        {
            List<string> lista = buscar(pTabla, pCampoFiltro, pValor).Rows.OfType<DataRow>().Select(dr => dr.Field<string>(pCampoRetorno)).ToList();
            return lista;
        }

        public DataTable getReporteSolicitud()
        {

            string SQL = "  Select SOLICITUD.ID as Solicitud ";
            SQL += " ,USUARIO.Nombre as Usuario ";
            SQL += " ,USUARIO.Cedula as Cedula  ";
            SQL += " ,CAMPUS.Nombre as Campus ";
            SQL += " ,EDIFICIO.Nombre as Edificio ";
            SQL += " ,AULA.Nombre as Aula ";
            SQL += " ,AULA.Tipo as Tipo_Aula ";
            SQL += " ,SOLICITUD.Fecha_Reservacion ";
            SQL += " , dateadd(hour, cantidad_hora, Fecha_reservacion) as Fecha_Fin ";
            SQL += " ,SOLICITUD.Cantidad_Hora ";
            SQL += " ,SOLICITUD.Estado ";
            SQL += " ,SOLICITUD.Ejecucion ";


            SQL += " from SOLICITUD ";
            SQL += " inner join AULA on SOLICITUD.ID_Aula = aula.ID ";
            SQL += " inner join EDIFICIO on AULA.ID_Edificio = EDIFICIO.ID ";
            SQL += " inner join CAMPUS on EDIFICIO.ID_Campus = CAMPUS.ID ";
            SQL += " inner join USUARIO on SOLICITUD.ID_Usuario = USUARIO.ID ";

            return ejecutarSQL(SQL);

        }


        public void iniciaTransaction()
        {
            transaction = ocon.BeginTransaction();
        }

        public void guardarTransaction()
        {
            transaction.Commit();
        }

        public void devolverTransaction()
        {
            transaction.Rollback();
        }


        public bool conectar()
        {
            
            try
            {
                ocon = getOcon();
                ocon.Open();
                this.setOcon(ocon);
            }
            catch (Exception error)
            {
                MessageBox.Show("Error al conectarse a la base de datos");
                return false;
            }
            return true;
        }
        
        */
            
        public static boolean ConnectionStart(){
               
            try
            {                
                SQLServerDataSource ds = new SQLServerDataSource();
                ds.setUser("sa");
                ds.setPassword("sa");
                ds.setDatabaseName("ESTANDAR");
                ds.setPortNumber(1433);
                ds.setServerName("localhost");
                con = ds.getConnection();
                return true;
            }
            catch(SQLServerException e)
            {
                mensajeError = e.getMessage();
                con = null;
                return false;
            }
        
    }
    }

