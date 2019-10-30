/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import daogenerico.ErroresGenerales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias
 */
public class P06_ProbandoGetAllusuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<usuario> ListaDevuelta = new ArrayList<usuario>();        
        
        usuariodao MyDAO = new usuariodao();
        
        try 
        {
            ListaDevuelta = MyDAO.getAll("select * from usuario");
            
            if (ListaDevuelta != null)
            {
                for (int i = 0; i < ListaDevuelta.size();i++)
                {
                    System.out.println(ListaDevuelta.get(i).toString());
                }
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
