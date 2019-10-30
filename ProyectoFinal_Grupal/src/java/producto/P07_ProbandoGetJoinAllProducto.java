/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import daogenerico.ErroresGenerales;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class P07_ProbandoGetJoinAllProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       List<productoextendido> ListaDevuelta = new ArrayList<productoextendido>();

        productoDAO MyDAO = new productoDAO();

        try 
        {
            ListaDevuelta = MyDAO.getJoinAll("select producto.*,categoria.categorianombre \n" +
"    from producto inner join categoria \n" +
"    on producto.idcategoria = categoria.idcategoria");

            if (ListaDevuelta != null)
            {
                for (int i = 0; i < ListaDevuelta.size();i++)
                {
                    System.out.println(ListaDevuelta.get(i).toString());
                }
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
