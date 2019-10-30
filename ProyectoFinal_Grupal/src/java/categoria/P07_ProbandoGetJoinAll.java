/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

import daogenerico.ErroresGenerales;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class P07_ProbandoGetJoinAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       List<categoriaextendida> ListaDeVuelta = new ArrayList<categoriaextendida>();
       categoriaDAO MyDAO = new categoriaDAO();
        try {
          
            ListaDeVuelta = MyDAO.getJoinAll("select categoria.*,distribuidora.* from categoria inner join distribuidora on categoria.iddistribuidora = distribuidora.iddistribuidora");
            
            if (ListaDeVuelta != null)
            {
                for (int i = 0; i < ListaDeVuelta.size();i++)
                {
                    System.out.println(ListaDeVuelta.get(i).toString());
                }
            }
            else
            {
                System.out.println("NO LO ENCONTRAMOS");
            }
        }catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }
       
    }
    
}
