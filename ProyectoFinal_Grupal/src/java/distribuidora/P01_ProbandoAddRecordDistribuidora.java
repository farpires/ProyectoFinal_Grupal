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
public class P01_ProbandoAddRecordDistribuidora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        distribuidora distribuidoraentrada = new distribuidora(Long.valueOf(0),"95236783", "Sancor","Sarmiento 3899");
        distribuidora distribuidorasalida = null;
        distribuidoradao MyDao = new distribuidoradao();
        
        try {
            distribuidorasalida=MyDao.AddRecord(distribuidoraentrada);
            System.out.println("Distribuidora " + distribuidorasalida.toString());
        } catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }
    }
    
}
