package SensorSystemServer;

import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SensorSystemInterface {

    @WebMethod
    public int validatToken(int token);

    @WebMethod
    public int login(String username, String password);

    @WebMethod
    public String delete_Device(int token, int device_id);

    @WebMethod
    public String delete_Sensor(int token, int sensor_id);

    @WebMethod
    String create_Sensor(
            int token,
            String name,
            int id_device,
            int sensorType,
            int pin);

    @WebMethod
    public String create_Device(int token, String name, int external_id, String owner);

    @WebMethod
    public String set_Sensor_Info(int token, int sensor_id, int device_id_ref, int type, int pin, String name);

    @WebMethod
    public String set_Device_Info(int token, int device_id, String owner, String name);

    @WebMethod
    public String[] get_Sensor_Info(int token, int sensor_id);

    @WebMethod
    public String[] get_Device_Info(int token, int device_id);

    @WebMethod
    public int[] get_Devices_ID(int token, String owner);

    @WebMethod
    public int[] get_Sensors_ID(int token, int device_id);

    @WebMethod
    public String[] get_ids(int token, String owner);

    @WebMethod
    public String[] get_Sensor_Data(int token, int sensor_id);

    @WebMethod
    public String[] get_Sensor_Data_Within_Dates(int token, int sensor_id, Date older, Date newer);

}
