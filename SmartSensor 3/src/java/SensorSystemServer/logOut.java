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

@Path("{username}/userid")
public class logOut {
    
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String logOut() {
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("<!DOCTYPE html>");
        builder.append("<html>");
        builder.append("<head><title>Login Page</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<br/>\n"
                + "<form action=\"login\" method=\"get\">"
                + "    <button type =\"submit\">Logout</button> </form\n"
                + "<br/>"
                + "    <br/>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }
    
}
