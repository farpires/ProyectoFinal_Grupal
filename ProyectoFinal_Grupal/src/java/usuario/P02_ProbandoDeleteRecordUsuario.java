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
public class P02_ProbandoDeleteRecordUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       
      
        usuario usuarioEliminar = new usuario(Long.valueOf(3), "matias","43535","Modificado", Long.valueOf(3));
        
        usuariodao MyDAO = new usuariodao();
        
        try 
        {
            if (MyDAO.DeleteRecord(usuarioEliminar))
            {
                System.out.println("ELIMINADO !!!");
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
