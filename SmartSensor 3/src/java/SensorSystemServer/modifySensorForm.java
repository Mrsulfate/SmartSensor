/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexandercarlsen
 */

@Path("sensor-management/modify")
public class modifySensorForm {
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String modifySensorForm() {
        
          StringBuilder builder = new StringBuilder();

             builder.append("<!DOCTYPE html>");
            builder.append("<html>");
            builder.append("<head><title></title>");
            builder.append("</head>");
            builder.append("<head> <style>\n"
                + ".flex-container {\n"
                + "  display: table-cell;\n"
                + " vertical-align: middle; "
                + " flex-direction: column; "
                + "  background-color: DodgerBlue;\n"
                + "}\n"
                + "\n"
                + ".flex-container > div {\n"
                + "  background-color: #f1f1f1;\n"
                + "  margin: 10px;\n"
                + "  padding: 20px;\n"
                + "  font-size: 30px;\n"
                + "}\n"
                + "</style>\n"
                + "</head>"
            
                    + "<form action=\"modify/success\" method=\"post\">" 
                    + " <div class=\"flex-container\"> "
                    + " <div><font color=\"blue\">Sensor ID   </font>:<input name=\"sensor_id\" type=\"text\" style=\"float:right;margin-top:10px;\" /> \n"
                    + " <div> <font color=\"blue\">Device ID  </font>:<input name=\"device_id\" type=\"text\" style=\"float:right;margin-top:10px;\"/> \n"
                    + " <div><font color=\"blue\">Sensor Type  </font>:<input name=\"sensor_type\" type=\"text\"style=\"float:right;margin-top:10px;\" /> \n"
                    + " <div><font color=\"blue\">Sensor Pin  </font>:<input name=\"sensor_pin\" type=\"text\" style=\"float:right;margin-top:10px;\"/> \n"
                    + " <div> <font color=\"blue\">Sensor Name  </font>:<input name=\"sensor_name\" type=\"text\"style=\"float:right;margin-top:10px;\" /> \n"
                    + " <div> <button type =\"submit\">Accept Modifications</button>  </form\n"
                    + " </div>"
                    + " <form action=\"http://165.227.232.158:8080/SmartSensor/user\" method=\"get\">"
                    + "<div> <button type =\"submit\">Cancel</button>  </form>\n"
                    + "<br/>"
                    + "<br/>");
            builder.append("</body>");
            builder.append("</html>");

            return builder.toString();
        
    }
    
}
