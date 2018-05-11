/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexandercarlsen
 */
@Path("sensor-management")
public class addSensorForm {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String addSensorForm() {

        StringBuilder builder = new StringBuilder();

        builder.append("<!DOCTYPE html>");
        builder.append("<html>");
        //  builder.append("<head><title>Sensor Created</title>");
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
                + "</head>");

        builder.append("<body>"
                + " <form action=\"sensor-management/sensor_id\" method=\"post\">"
                + " <div class=\"flex-container\"> "
                + " <div> <font color=\"blue\">Sensor name</font>:<input name=\"sensor_name\"type=\"text\" style=\"float:right;margin-top:10px;\"/>\n"
                + " <div> <font color=\"blue\">Device id  </font>:<input name=\"device_id\" type=\"text\" style=\"float:right;margin-top:10px;\" /> "
                + " <div> <font color=\"blue\">Sensor Type</font>:<input name=\"sensor_type\" type=\"text\" style=\"float:right;margin-top:10px;\" /> "
                + " <div> <font color=\"blue\">Pin number </font>:<input name=\"pin_number\" type=\"text\"  style=\"float:right;margin-top:10px;\"/> "
                + " <div> <br/> <button type =\"submit\">Ok</button>  </form>  </div>\n"
                + " </div>"        
                + " <form action=\"http://165.227.232.158:8080/SmartSensor/user\" method=\"get\" >"
                + " <div>   <button type =\"submit\">Cancel</button>  </form> </div>\n"
                + "    <br/>");

        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }

}
