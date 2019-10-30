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
public class P01_ProbandoAddRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*"insert into usuario (idusuario, usuarionombre, usuariopassword, usuarioemail, iddistribuidora)*/
        
        categoria ProductoEntrada = new categoria(Long.valueOf(0),"bebida2",Long.valueOf(1));
        
        categoria ProductoSalida = null;
        
        categoriaDAO MyDAO = new categoriaDAO();
        
        try 
        {
            ProductoSalida = MyDAO.AddRecord(ProductoEntrada);
            
            System.out.println("PRODUCTO:= " + ProductoSalida.toString());
            
        } catch (ErroresGenerales ex) 
        {
            System.out.println(ex.getMensajeDeErrorSalida());
            System.out.println("HUBO UN ERROR !!! " + ex.getMensajeDeErrorGeneral());
        }        
    }
    
}
