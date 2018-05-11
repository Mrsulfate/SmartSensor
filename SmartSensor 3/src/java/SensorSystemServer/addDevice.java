/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import java.net.MalformedURLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexandercarlsen
 */
@Path("device-management/addDevice")
public class addDevice {
    
            public static SensorSystemInterface soapPort;
            
    public addDevice() throws MalformedURLException {   

        getSoapPort getPort = new getSoapPort();
        soapPort = getPort.getSoapPort();

    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addDeviceOnDatabase(@FormParam("ext_id") String ext_id, @FormParam("device_name") String device_name) throws Exception {
            
     int external_id = Integer.parseInt(ext_id);
            StringBuilder builder = new StringBuilder();

             builder.append("<!DOCTYPE html>");
            builder.append("<html>");
            builder.append("<head><title></title>");
            builder.append("</head>");
            builder.append("<body>");
            builder.append("<br/>\n"
                    + "<form action=\"http://165.227.232.158:8080/SmartSensor/user\" method=\"get\">" 
                    + soapPort.create_Device(Credentials.token, device_name, external_id, Credentials.username)
                    + "    <button type =\"submit\">Okay   </button>  </form\n"
                    + "<br/>"
                    + "    <br/>");
            builder.append("</body>");
            builder.append("</html>");

            return builder.toString();
    }
    
    
    
    
    
  
    
}
