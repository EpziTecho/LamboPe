
package Reporte;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class conexion {
   private Statement sql;
        static String bd= "BD_AlquilerVehiculos";
        static String login= "sa";
        static String contraseña="analistDeveloper";
        static String url = "jdbc:sqlserver://localhost:1433;DataBase=" + bd +";TrustServerCertificate=True";
        static Connection  conn= null;
        
    public static Connection getConn(){
    return conn;
    }
    public static void conn()throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn= (Connection) DriverManager.getConnection(url, login, contraseña);
            
            if(conn != null){
                System.out.println("conexion exitosa");
            }
        }catch(SQLException ex){
            System.out.println("error al conectar a la bd");
        }
        catch(ClassNotFoundException ex){
          System.out.println(ex);  
        }
    } 
}
