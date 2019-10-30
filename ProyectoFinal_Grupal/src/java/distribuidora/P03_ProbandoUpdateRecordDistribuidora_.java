/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidora;

import daogenerico.ErroresGenerales;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class P03_ProbandoUpdateRecordDistribuidora_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       distribuidora distribuidoramodificar = new distribuidora(Long.valueOf(8),"7683722","Cepita","San Martin 77777");
       distribuidoradao MyDAO = new distribuidoradao();
       
        try {
            if (MyDAO.UpdateRecord(distribuidoramodificar))
            {
                System.out.println("MODIFICADO !!!");
            }
            else
            {
                 System.out.println("NO MODIFICADO");
            }
        } catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }
    }
    
}
