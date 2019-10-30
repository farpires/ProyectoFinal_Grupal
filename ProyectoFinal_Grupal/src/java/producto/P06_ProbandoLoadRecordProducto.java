/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import daogenerico.ErroresGenerales;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class P06_ProbandoLoadRecordProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        producto P = null;
        productoDAO MyDAO = new productoDAO();
        try {
            P = MyDAO.LoadRecord(Long.valueOf(8));
            if (P != null)
            {
                System.out.println(P.toString());
            }
            else
            {
                System.out.println("NO LO ENCONTRAMOS");
            }
        } 
        catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }  
    }
    
}
