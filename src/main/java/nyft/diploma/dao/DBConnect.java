package nyft.diploma.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vlad on 08.05.2016.
 */
public class DBConnect {
    private static Connection conn;
    /*private static String dbURL = "jdbc:postgresql://localhost:5432/SlowNews";
    private static String user = "postgres";
    private static String pass = "qa1234";*/


   // private static String url = "jdbc:sqlserver://DESKTOP-HVFJCO6/ProektSystem";
    private static String url = "jdbc:sqlserver://DESKTOP-HVFJCO6\\SQLEXPRESS;databaseName=ProektSystem";
    private static String user = "user";
    private static String pass = "qa1234";

    public static Connection connect() throws SQLException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        }catch(ClassNotFoundException cnfe){
            System.err.println("Error: "+cnfe.getMessage());
        }catch(InstantiationException ie){
            System.err.println("Error: "+ie.getMessage());
        }catch(IllegalAccessException iae){
            System.err.println("Error: "+iae.getMessage());
        }

        conn = DriverManager.getConnection(url,user,pass);
        return conn;
       /* conn = DriverManager.getConnection(dbURL ,user,pass);
        return conn;*/
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn !=null && !conn.isClosed())
            return conn;
        connect();
        return conn;

    }
}
