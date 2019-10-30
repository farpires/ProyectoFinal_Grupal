/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import daogenerico.ErroresGenerales;

/**
 *
 * @author Matias
 */
public class P03_ProbandoLoadRecordUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       usuario U = null;

        usuariodao MyDAO = new usuariodao();

        try 
        {
            U = MyDAO.LoadRecord(Long.valueOf(6));

            if (U != null)
            {
                System.out.println(U.toString());
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
