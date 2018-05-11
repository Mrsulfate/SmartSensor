/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import java.net.MalformedURLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;


/**
 * REST Web Service
 *
 * @author alexandercarlsen
 */
@Path("")
public class GenericResource {

    @Context
    private UriInfo context;
    private static SensorSystemInterface bridge;

    public GenericResource() throws MalformedURLException {
        
    }
    
    
}
