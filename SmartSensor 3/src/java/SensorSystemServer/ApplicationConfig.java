/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author alexandercarlsen
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(SensorSystemServer.AuthenticationEndpoint.class);
        resources.add(SensorSystemServer.GenericResource.class);
        resources.add(SensorSystemServer.addDevice.class);
        resources.add(SensorSystemServer.addDeviceForm.class);
        resources.add(SensorSystemServer.addSensor.class);
        resources.add(SensorSystemServer.addSensorForm.class);
        resources.add(SensorSystemServer.changeLayout.class);
        resources.add(SensorSystemServer.deleteDevice.class);
        resources.add(SensorSystemServer.deleteDeviceForm.class);
        resources.add(SensorSystemServer.deleteSensor.class);
        resources.add(SensorSystemServer.deleteSensorForm.class);
        resources.add(SensorSystemServer.logOut.class);
        resources.add(SensorSystemServer.login.class);
        resources.add(SensorSystemServer.modifyDevice.class);
        resources.add(SensorSystemServer.modifyDeviceForm.class);
        resources.add(SensorSystemServer.modifySensor.class);
        resources.add(SensorSystemServer.modifySensorForm.class);
        resources.add(SensorSystemServer.postTest.class);
        resources.add(SensorSystemServer.startPage.class);
    }
    
}
