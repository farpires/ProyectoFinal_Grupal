/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import daogenerico.ErroresGenerales;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class P07_ProbandoGetJoinAllusuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<usuarioextendido> ListaDeVuelta = new ArrayList<usuarioextendido>();
        usuariodao MyDAO = new usuariodao();
        try {
            ListaDeVuelta = MyDAO.getJoinAll("select usuario.*,distribuidora.* from usuario inner join distribuidora on usuario.iddistribuidora = distribuidora.iddistribuidora");
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
