/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;
import daogenerico.ErroresGenerales;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jorge
 */
public class P01_ProbandoAddRecordUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         usuario usuarioentrada = new usuario (Long.valueOf(0),"Matias","123456","matias@hotmail.com",Long.valueOf(1));
        
        usuario usuariosalida = null;
        
        usuariodao MyDAO = new usuariodao();
        
        try 
        {
            usuariosalida = MyDAO.AddRecord(usuarioentrada);
            
            System.out.println("PRODUCTO:= " + usuariosalida.toString());
            
        } catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }        

    }
    }

    
    

