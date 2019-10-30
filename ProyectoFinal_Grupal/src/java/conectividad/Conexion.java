/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DANIEL MALDONADO
 */
public class Conexion 
{
     // https://www.youtube.com/watch?v=Okd2RhMl9ME&t=480s //
    
    public static Conexion instance; // Singleton
    private Connection con;
    
    private Conexion()
    {
       
        String ruta = "jdbc:postgresql://localhost:5432/proyecto";
        String user = "postgres";
        String password = "12345678";
        
         try
         {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(ruta, user, password);
            System.out.println("CONECTADO !!!");
         }catch (ClassNotFoundException | SQLException e)
         {
             System.out.println("NOOOOOOOOO CONECTADO !!!");
         }
    }
    
    public synchronized static Conexion OpenConnection()
    {
        if (instance == null)
        {
            instance = new Conexion();
        }
        
        return instance;        
    }   

    public Connection getCon() 
    {
        return con;
    }
    
    public void CloseConnection()
    {
        instance = null;
    }    
}
