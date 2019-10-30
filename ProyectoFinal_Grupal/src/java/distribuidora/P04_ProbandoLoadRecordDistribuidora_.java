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
public class P04_ProbandoLoadRecordDistribuidora_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        distribuidora P = null;
        distribuidoradao MyDAO = new distribuidoradao();
        try {
            P = MyDAO.LoadRecord("select * from distribuidora where distribuidoranombre like '%C%'");
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
