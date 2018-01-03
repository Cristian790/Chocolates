/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Cristian
 */
public class Conexion {
      public static Connection getConexion() {

        Connection connection = null;
        try {
           String driverClassName = "com.mysql.jdbc.Driver";
           String driverUrl="jdbc:mysql://localhost:3306/Your MySQL database name";/*Change the name and the password */
           Class.forName(driverClassName);
//Cambiar pass por la de su equipo o solo deje las comillas en blanco
           connection = DriverManager.getConnection(driverUrl, "root","Your Password");
           System.out.println("Conexion Establecida");
          
        }catch (Exception e) {
            System.out.println("Conexión No Establecida");
            e.printStackTrace();
        }
        return connection;
    }
}

