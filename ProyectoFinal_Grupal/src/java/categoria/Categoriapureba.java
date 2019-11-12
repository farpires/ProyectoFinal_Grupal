/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

import conectividad.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class Categoriapureba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        categoria P1 = new categoria();
        P1.setCategoriaNombre("HOlissssssssssss");
        P1.setIDDistribuidora(Long.valueOf(2));
        
        
        Long PK = Long.valueOf(0);
        
        /* AQUI TENGO EL CÓDIGO QUE EJECUTA EL COMANDO SQL A TRAVES DE LA CONEXION ESTABLECIDA */
        
        Conexion Con = Conexion.OpenConnection();
        
        String COMANDOSQL = "insert into categoria (categorianombre,iddistribuidora) values (?,?)";
        
        PreparedStatement STATEMENT;
        
        try 
        {
            STATEMENT = Con.getCon().prepareStatement(COMANDOSQL,Statement.RETURN_GENERATED_KEYS);
            
            STATEMENT.setString(1,P1.getCategoriaNombre());
            STATEMENT.setLong(2,P1.getIDDistribuidora());
            
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
                System.out.println("VALOR AGREGADO:= " + ResultadoSentenciaSQL + " - " + PK);
            }
            else
            {
                System.out.println("NO SE AGREGÓ NINGÚN VALOR, ALGÚN PROBLEMA EXISTIÓ !!!");
            }
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(Categoriapureba.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}
