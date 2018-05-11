/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author alexandercarlsen
 */
public class getSoapPort {
    
    public SensorSystemInterface getSoapPort() throws MalformedURLException {
        URL url = new URL("http://165.227.232.158:9901/SensorSystemService?wsdl");
        QName qname = new QName("http://SensorSystemServer/", "SensorSystemImplementsService");
        Service service = Service.create(url, qname);
        SensorSystemInterface soapPort = service.getPort(SensorSystemInterface.class);
        return soapPort;
        }
}
