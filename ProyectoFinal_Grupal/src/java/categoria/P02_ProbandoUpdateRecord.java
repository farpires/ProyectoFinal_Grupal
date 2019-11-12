/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;


import categoria.categoria;
import categoria.categoriaDAO;
import daogenerico.ErroresGenerales;


/**
 *
 * @author arpir
 */
public class P02_ProbandoUpdateRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          /*SELECT idusuario, usuarionombre, usuariopassword, usuarioemail, iddistribuidora
	FROM public.usuario;*/
      categoria UsuarioModificar = new categoria(Long.valueOf(2),"CerealesModificado",Long.valueOf(3));      
        
     categoriaDAO MyDAO = new categoriaDAO();
        
        try 
        {
            if (MyDAO.UpdateRecord(UsuarioModificar))
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
