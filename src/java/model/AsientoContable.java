/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import sun.net.www.http.HttpClient;


/**
 *
 * @author Juan Carlos Tejeda
 */
public class AsientoContable {

    public AsientoContable() {
    }
    
    
    private int id;
    private String cuenta;
    private String tipoMovimiento;
    private float Monto;
    private String fecha;
    private java.sql.Date fecha2;
    private java.util.Date fecha3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public java.sql.Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(java.sql.Date fecha2) {
        this.fecha2 = fecha2;
    }

    public java.util.Date getFecha3() {
        return fecha3;
    }

    public void setFecha3(java.util.Date fecha3) {
        this.fecha3 = fecha3;
    }
    
    public int postEntry(String description, int auxiliar, int account, String movementType, Date date, double amount, String status) throws ProtocolException, MalformedURLException, IOException{
    
        
        final String url = "http://example.com";
        
  
/*
        
        String body = "{'Description': "+description+","
                + "'AuxiliarId': "+auxiliar+","
                + "'AccountId': "+account+","
                + "'MovementType': "+movementType+","
                + "'EntryDate': "+date+","
                + "'EntryAmount': "+amount+","
                + "'Status': "+status+"";
        URL url = new URL("http://accountingsystem.azurewebsites.net/Api/Entries");
                
      
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);//5 secs
            connection.setReadTimeout(5000);//5 secs

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());  
            out.write(body);
            out.flush();
            out.close();

        int res = connection.getResponseCode();
        
        String response = connection.getContent().toString();
*/
        return 1;

    }

    
}
