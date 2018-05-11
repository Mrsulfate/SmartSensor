/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import static SensorSystemServer.addSensor.soapPort;
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
@Path("sensor-management/delete/success")
public class deleteSensor {
    
    
    public static SensorSystemInterface soapPort;
            
    public deleteSensor() throws MalformedURLException {   

        getSoapPort getPort = new getSoapPort();
        soapPort = getPort.getSoapPort();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String deleteSensor(@FormParam("sensor_id") int sensor_id) {
        
        StringBuilder builder = new StringBuilder();

             builder.append("<!DOCTYPE html>");
            builder.append("<html>");
            builder.append("<head><title></title>");
            builder.append("</head>");
            builder.append("<body>");
            builder.append("<br/>\n"
                    + "<form action=\"http://165.227.232.158:8080/SmartSensor/user\" method=\"get\">" 
     + soapPort.delete_Sensor(Credentials.token, sensor_id)
                    + "    <button type =\"submit\">Okay</button>  </form\n"
                    + "<br/>"
                    + "    <br/>");
            builder.append("</body>");
            builder.append("</html>");

            return builder.toString();
    }
    
}
