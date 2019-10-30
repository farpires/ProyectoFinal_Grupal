/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import daogenerico.ErroresGenerales;


/**
 *
 * @author Matias
 */
public class P03_ProbandoUpdateRecordProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        producto ProductoModificar = new producto(Long.valueOf(5), "Un riki riki vodka", "00000000", "150", "30/10/2019",Long.valueOf(1));
        productoDAO MyDAO = new productoDAO();

        try 
        {
            if (MyDAO.UpdateRecord(ProductoModificar))
            {
                System.out.println("Producto MODIFICADO: " + ProductoModificar);
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
