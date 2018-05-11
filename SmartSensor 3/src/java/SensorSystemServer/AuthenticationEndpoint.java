/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import java.net.MalformedURLException;
import java.util.Arrays;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexandercarlsen
 */
@Path("auth")
public class AuthenticationEndpoint {

    public static SensorSystemInterface soapPort;
    public static String[] device_info;

    public AuthenticationEndpoint() throws MalformedURLException {
        getSoapPort getPort = new getSoapPort();
        soapPort = getPort.getSoapPort();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String authenticateUser(@FormParam("username") String username, @FormParam("password") String password) throws Exception {

        Credentials creds = new Credentials();
        creds.setUsername(username);
        creds.setPassword(password);
        creds.setToken(soapPort.login(creds.getUsername(), creds.getPassword()));

        if (soapPort.login(creds.getUsername(), creds.getPassword()) != 0) {        // only login if creds is valid
            // Issue a token for the user
            //String token = "22"; // LAV TOKEN GENERERING
            StringBuilder builder = new StringBuilder();
            builder.append("<!DOCTYPE html>");
            builder.append("<html>");
            builder.append("<head><title>");
            builder.append("Login Succesful </title>");
            builder.append("</head>");
            builder.append("<body>");
            builder.append("<br/>\n"
                    //////////// SENSOR 1  /////////////
                    + "<h2>Login Succesful</h2> "
                    + "</a> <br/>"
                    + "<form action=\"user\" method=\"get\">"
                    + "    <button type =\"submit\">Click here to watch sensordata</button>  </form <br/> \n"
                    + "    <br/>");
            builder.append("</body>");
            builder.append("</html>");

            return builder.toString();

        } else if (username.equals("") && password.equals("")) {
            return noCredsEntered();

        } else {
            StringBuilder builder = new StringBuilder();

            builder.append("<!DOCTYPE html>");
            builder.append("<html>");
            builder.append("<head><title>Login Page</title>");
            builder.append("</head>");
            builder.append("<body>");
            builder.append("<br/>\n"
                    + "<form action=\"auth\" method=\"post\">"
                    + "      <font color=\"blue\">Username</font>:<input name=\"username\"  type=\"text\"  /> \n"
                    + "      <font color=\"blue\">Password</font>:<input name=\"password\" type=\"password\" />\n"
                    + "    <button type =\"submit\">Login   </button>  </form\n"
                    + "<br/>"
                    + "Wrong login information, please try again"
                    + "    <br/>");
            builder.append("</body>");
            builder.append("</html>");

            return builder.toString();
        }
    }

    public String noCredsEntered() {

        StringBuilder builder = new StringBuilder();

        builder.append("<!DOCTYPE html>");
        builder.append("<html>");
        builder.append("<head><title>Login Page</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<br/>\n"
                + "<form action=\"auth\" method=\"post\">"
                + "      <font color=\"blue\">Username</font>:<input name=\"username\"  type=\"text\" />\n"
                + "      <font color=\"blue\">Password</font>:<input name=\"password\" type=\"password\" />\n"
                + "    <button type =\"submit\">Login   </button>  </form\n"
                + "<br/>"
                + "No credentials entered, please enter valid login information"
                + "    <br/>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();

    }

}
