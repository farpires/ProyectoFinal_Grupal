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
        producto productoentrada = new producto(Long.valueOf(0), "Sprite", "765432456754", "82", "29/10/2019",Long.valueOf(2));
        producto productosalida = null;
        productoDAO MyDAO = new productoDAO();
        try 
        {
            productosalida = MyDAO.AddRecord(productoentrada);
            System.out.println("Producto : " + productosalida.toString());
        } 
        catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }
       
    }
    
}
