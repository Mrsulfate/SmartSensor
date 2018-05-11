/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import java.net.MalformedURLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexandercarlsen
 */
@Path("newLayout")
public class changeLayout {

    public static SensorSystemInterface soapPort;

    public changeLayout() throws MalformedURLException {
        getSoapPort getPort = new getSoapPort();
        soapPort = getPort.getSoapPort();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String changeLayout() {

        // GET ALL DEVICE IDS //
        int[] device_id = soapPort.get_Devices_ID(Credentials.token, Credentials.username);
        String[] device_name = new String[device_id.length];
        String[] ext_id = new String[device_id.length];

        for (int l = 0; l < device_id.length; l++) {
            ext_id[l] = soapPort.get_Device_Info(Credentials.token, device_id[l])[1];
            device_name[l] = soapPort.get_Device_Info(Credentials.token, device_id[l])[2];
        }

        int i = 0;
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>");
        builder.append("<html>");
        builder.append("<head><title>");
        builder.append(Credentials.username + " SensorData </title>");

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
                //   + "  margin: 10px;\n"
                //  + "  padding: 20px;\n"
                //  + "  font-size: 30px;\n"
                + "}\n"
                + "</style>\n"
                + "</head>");
        //+ "button margin:auto; display:block;");
        builder.append("<body>"
                + "<h2> " + " SensorSystem " + Credentials.username + "</h2> ");

        builder.append(" <form action=\"device-management\" method=\"get\"> "
                + " <div class=\"flex-container\"> "
                + " <div> <button type =\"submit\">Add Device</button>  </form>  <br/> </div>"
                + "  <form action=\"device-management/modify\" method=\"get\" \">"
                + " <div>    <button type =\"submit\">Modify Device</button>  </form> <br/> </div>"
                + "  <form action=\"sensor-management\" method=\"get\" \">"
                + " <div>    <button type =\"submit\">Create Sensor</button>  </form> <br/>  </div>"
                + " <form action=\"sensor-management/modify\" method=\"get\"  \">"
                + " <div> <button type =\"submit\">Modify Sensor</button>  </form> <br/>  </div>\n"
                + "  <form action=\"user\" method=\"get\">"
                + " <div> <button type =\"submit\">Change Layout</button>  </form> <br/> </div> \n"
                + "  <form action=\"login\" method=\"get\">"
                + " <div>   <button class=\"test\" type =\"submit\"> Logout </button>  </form> </div> \n"
                //   builder.append(".test { height:200px;    width:200px;}"
                + " </div>   <br/>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<br/>\n"
                //////////// SENSOR 1  /////////////
                + "</a> <br/>");

        builder.append("<head>\n"
                + "<style>\n"
                + "table, th, td {\n"
                + "    border: 1px solid black;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<br/>"
                + " <table style=\"width:100%\">\n"
                + "  <tr>\n");

        builder.append("<th> Device ID </th>\n"
                + "     <th> Device Name </th>\n"
                + "     <th> External ID </th>\n"
                + "     <th>Sensor ID</th> \n"
                + "     <th>Sensor Name</th>\n"
                + "     <th>Sensor Type</th>\n"
                + "     <th>Sensor Pin</th>\n"
                + "     <th> Sensor Data</th>\n"
                + "     <th>Last Active</th>\n"
                + "\n"
                + "\n"
                + "  </tr>\n");

        for (i = 0; i < device_id.length; i++) {
            builder.append("<tr>\n");

            for (int j = 0; j < soapPort.get_Sensors_ID(Credentials.token, device_id[i]).length; j++) {

                builder.append("<td>" + device_id[i] + "</td> <td>" + device_name[i] + "</td> <td>" + ext_id[i] + "</td>\n");

                /// GET SENSOR ID //
                if (soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j] == 0) {
                    builder.append("<td>" + " " + "</td>\n");
                } else {
                    builder.append("<td>" + soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j] + "</td>\n");

                }
                /// GET SENSOR NAME //
                if (soapPort.get_Sensor_Info(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[1] == null) {
                    builder.append("<td>" + " " + "</td>\n");
                } else {

                    builder.append("<td>").append(soapPort.get_Sensor_Info(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[1]).append("</td>\n");
                }
                // GET SENSOR TYPE //
                if (soapPort.get_Sensor_Info(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[3] == null) {
                    builder.append("<td>" + " " + "</td>\n");
                } else {
                    builder.append("<td>").append(soapPort.get_Sensor_Info(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[3]).append("</td>\n");

                }
                // GET SENSOR PIN //
                if (soapPort.get_Sensor_Info(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[4] == null) {
                    builder.append("<td>" + " " + "</td>\n");
                } else {
                    builder.append("<td>").append(soapPort.get_Sensor_Info(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[4]).append("</td>\n");

                }
                // GET SENSOR DATA //
                if (soapPort.get_Sensor_Data(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j]).length != 0) {
                    builder.append("<td>").append(soapPort.get_Sensor_Data(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[soapPort.get_Sensor_Data(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j]).length - 1]).append("</td>\n");
                } else {
                    builder.append("<td>" + " " + "</td>\n");
                }

                // GET SENSOR LASTACTIVE //
                if (soapPort.get_Sensor_Info(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[6] == null) {
                    builder.append("<td>" + " " + "</td> </tr>\n");
                } else {
                    builder.append("<td>").append(soapPort.get_Sensor_Info(Credentials.token, soapPort.get_Sensors_ID(Credentials.token, device_id[i])[j])[6]).append("</td> </tr>\n");
                }
            }

            if (soapPort.get_Sensors_ID(Credentials.token, device_id[i]).length == 0) {
                builder.append("<td>" + device_id[i] + "</td> <td>" + device_name[i] + "</td> <td>" + ext_id[i] + "</td>\n");
                for (int n = 0; n < 6; n++) {
                    builder.append("<td>" + " " + "</td>");
                }
            }
        }

        builder.append("</table>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();

    }

}
