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
public class P01_ProbandoAddRecordProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        producto productoentrada = new producto(Long.valueOf(0), "Un riki riki vodka", "00000000", "150", "29/10/2019",Long.valueOf(1));
        producto productosalida = null;
        productoDAO MyDAO = new productoDAO();
        try 
        {
            productosalida = MyDAO.AddRecord(productoentrada);
            System.out.println("Producto agregado: " + productosalida.toString());
        } 
        catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }
       
    }
    
}
