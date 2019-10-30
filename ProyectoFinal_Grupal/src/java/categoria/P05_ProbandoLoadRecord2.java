/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

import daogenerico.ErroresGenerales;


/**
 *
 * @author DANIEL MALDONADO
 */
public class P05_ProbandoLoadRecord2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        categoria P = null;
        
        categoriaDAO MyDAO = new categoriaDAO();
        
        try 
        {
            P = MyDAO.LoadRecord("select * from categoria where categorianombre like '%L%'");
            
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
