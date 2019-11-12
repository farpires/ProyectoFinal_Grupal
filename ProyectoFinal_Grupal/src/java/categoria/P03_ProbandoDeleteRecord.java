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
public class P03_ProbandoDeleteRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
            /*"insert into usuario (idusuario, usuarionombre, usuariopassword, usuarioemail, iddistribuidora)*/
        // TODO code application logic here
          categoria ProductoEliminar = new categoria(Long.valueOf(2)," ",Long.valueOf(0));      
        
        categoriaDAO MyDAO = new categoriaDAO();
        
        try 
        {
            if (MyDAO.DeleteRecord(ProductoEliminar))
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
