/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

import daogenerico.ErroresGenerales;
import distribuidora.*;

/**
 *
 * @author Matias
 */
public class P05_ProbandoLoadRecord1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
           categoria P = null;
        
        categoriaDAO MyDAO = new categoriaDAO();
        
        try 
        {
            P = MyDAO.LoadRecord(Long.valueOf(2));
            
            if (P != null)
            {
                System.out.println(P.toString());
            }
            else
            {
                System.out.println("NO LO ENCONTRAMOS");
            }
            
        } catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }        
        
    }
    
}
