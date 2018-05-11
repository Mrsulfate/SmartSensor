/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorSystemServer;

/**
 *
 * @author alexandercarlsen
 */
public class Credentials {

    public static String username;
    public static String password;
    public static int token;

    public String getUsername() {

        return username;
    }
    
        public Credentials() {
      
    }

    public String getPassword() {

        return password;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setPassword(String password) {

        this.password = password;
    }
    
    public void setToken(int token) {

        this.token = token;
    }

    public int getToken() {

        return token;
    }
}
