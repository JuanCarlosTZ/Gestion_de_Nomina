/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import model.AsientoContable;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Juan Carlos Tejeda
 */
public class ServicioAdministrador {
    
    
    public int EnviarAsiento(List<AsientoContable> listaAsientoContable){
        
        int id = 0;
        try {

		URL url = new URL("http://accountingsystem.azurewebsites.net/api/Entries");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input = getJson(listaAsientoContable);

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}
                
                BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}               
		in.close();
                conn.disconnect();
                
                
                
 
        try {
 
            JSONObject jObject = new JSONObject(response.toString());            
            id = jObject.getInt("EntryId");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
                
                

		

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }
        
        
        return id;

    }
    
    
    
    
   public String getJson(List<AsientoContable> listaAsientoContable){
       
       int idCredito = 4;
       int idDebito = 5;


       int idAuxiliar = 2;
       float balanceCredito = 0;
       float balanceDebito = 0;
       
      
      for(AsientoContable asientoContable: listaAsientoContable)
      {
          if(asientoContable.getTipoMovimiento() == "CR"){
              balanceCredito =+ asientoContable.getMonto();
          }else{
              balanceDebito =+ asientoContable.getMonto();
          }
          
      } 
      
      String json = "{\n" +
            "  \"Description\": \"Asiento de Nominas correspondiente al periodo 2017-12-01\",\n" +
            "  \"AuxiliarId\": "+idAuxiliar+",\n" +
            "  \"AccountId\": "+idDebito+",\n" +
            "  \"MovementType\": \"DB\",\n" +
            "  \"EntryDate\": \"2017-12-07T07:42:32.3268517+00:00\",\n" +
            "  \"EntryAmount\": "+balanceDebito+",\n" +
            "  \"Status\": \"ACTIVO\"\n" +
            "}";
      
      json += "{\n" +
            "  \"Description\": \"Asiento de Nominas correspondiente al periodo 2017-12-01\",\n" +
            "  \"AuxiliarId\": "+idAuxiliar+",\n" +
            "  \"AccountId\": "+idCredito+",\n" +
            "  \"MovementType\": \"CR\",\n" +
            "  \"EntryDate\": \"2017-12-07T07:42:32.3268517+00:00\",\n" +
            "  \"EntryAmount\": "+balanceCredito+",\n" +
            "  \"Status\": \"ACTIVO\"\n" +
            "}";
      
            /*
      String json = "{\n" +
            "  \"EntryId\": 1,\n" +
            "  \"Description\": \"Asiento de Nominas correspondiente al periodo 2017-12-01\",\n" +
            "  \"AuxiliarId\": "+idAuxiliar+",\n" +
            "  \"AccountId\": "+idDebito+",\n" +
            "  \"Account\": {\n" +
            "    \"AccountId\": "+idCredito+",\n" +
            "    \"Description\": \"Salarios y Sueldos Empleados\",\n" +
            "    \"AccountType\": \"CR\",\n" +
            "    \"AllowTransactions\": true,\n" +
            "    \"Level\": \"sample string 5\",\n" +
            "    \"ParentAccount\": \"sample string 6\",\n" +
            "    \"Balance\": \""+balanceCredito+"\",\n" +
            "    \"Status\": \"ACTIVO\"\n" +
            "  },\n" +
            "  \"MovementType\": \"DB\",\n" +
            "  \"EntryDate\": \"2017-12-07T07:42:32.3268517+00:00\",\n" +
            "  \"EntryAmount\": "+balanceDebito+",\n" +
            "  \"Status\": \"ACTIVO\"\n" +
            "}";*/
      
      return json;
      
   }
    
}
