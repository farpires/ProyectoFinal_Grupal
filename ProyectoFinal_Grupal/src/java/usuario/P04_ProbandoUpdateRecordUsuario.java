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
public class P04_ProbandoUpdateRecordUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        usuario usuariomodificar = new usuario(Long.valueOf(10),"probando modificacion solo una","2610261000","modificacion@gmail",Long.valueOf(1));
        usuariodao MyDao = new usuariodao();
         try 
        {
            if (MyDao.UpdateRecord(usuariomodificar))
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
