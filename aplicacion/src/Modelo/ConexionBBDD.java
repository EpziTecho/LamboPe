/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;

/**
 * Esta clase crea un metodo Connection para luego usarlo para conectarnos a la base de datos.
 * También declara las variables con los datos de conexión a la base de datos.
 * @author grupo2
 */
public class ConexionBBDD {
    private static ConexionBBDD miConexion = null;
    private String db = "BD_AlquilerVehiculos";
   // private String cadDeConexion = "jdbc:mysql://127.0.0.1/" +db;
   private String cadDeConexion = "jdbc:sqlserver://localhost:1433;DataBase=" +db +";TrustServerCertificate=True";
   // private String user = "root";
   // private String pass = "";
    private String user = "sa";
    private String pass = "Epzitechpass";
    
    public static ConexionBBDD con() {
        if (miConexion != null) {
            return miConexion;
        } else {
            miConexion = new ConexionBBDD();
            return miConexion;
        }
    }

    public Connection conectar() {
    Connection link = null;
       
    try {
    //Registamos el Driver, llamando a la clase del driver
    //Class.forName("com.mysql.jdbc.Driver");
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    link = DriverManager.getConnection(this.cadDeConexion, this.user, this.pass);
    } catch (ClassNotFoundException cnfe){
        System.out.println("Error de Conexión en Drive");
        cnfe.printStackTrace();
    } catch (SQLException ex){
        System.out.println("Error de Conexión en SQL");
        ex.printStackTrace();
    }
    return link;
    }
}
