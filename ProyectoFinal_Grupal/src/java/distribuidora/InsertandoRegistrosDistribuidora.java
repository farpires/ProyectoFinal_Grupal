/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidora;


import conectividad.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class InsertandoRegistrosDistribuidora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        distribuidora P1 = new distribuidora();
        P1.setDistribuidoracuit("3232323232");
        P1.setDistribuidoranombre("Prueba 6/11/2019");
        P1.setDistribuidoradomicilio("Calle Espero que ande el proyecto 777");
        Long PK = Long.valueOf(0);
        
        /* AQUI TENGO EL CÓDIGO QUE EJECUTA EL COMANDO SQL A TRAVES DE LA CONEXION ESTABLECIDA */
        
        Conexion Con  = Conexion.OpenConnection();
        
        String COMANDOSQL = "delete from distribuidora where iddistribuidora = ?";
        
        PreparedStatement STATEMENT;
        
         try 
        {
            STATEMENT = Con.getCon().prepareStatement(COMANDOSQL,Statement.RETURN_GENERATED_KEYS);
            
            STATEMENT.setString(1,P1.getDistribuidoracuit());
            STATEMENT.setString(2,P1.getDistribuidoranombre());
            STATEMENT.setString(3,P1.getDistribuidoradomicilio());
            
            int ResultadoSentenciaSQL = 0;
            
            try
            {
                ResultadoSentenciaSQL = STATEMENT.executeUpdate();
                
                ResultSet rs = STATEMENT.getGeneratedKeys(); 
            
                if (rs.next())
                { 
                    PK = rs.getLong(1);                   
                }
            }
            catch (org.postgresql.util.PSQLException e1)
            {
                System.out.println(e1.getLocalizedMessage());
            }
            
            if (ResultadoSentenciaSQL > 0)
            {
                System.out.println("Agregado:= " + ResultadoSentenciaSQL + " - " + PK);
            }
            else
            {
                System.out.println("NO SE AGREGÓ NINGÚN VALOR, ALGÚN PROBLEMA EXISTIÓ !!!");
            }
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(InsertandoRegistrosDistribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}
