/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import com.google.gson.Gson;
import daogenerico.ErroresGenerales;

/**
 *
 * @author arpir
 */
public class PruebaWSusuarioADDRECORD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
           /*(01) de OBJETO JAVA (Java Object) a OBJETO JSON (Json Object)*/
        
        
       usuario usuarioentrada = new usuario (Long.valueOf(12),"martinmodificado","669964hg","martinhh@hotmail.com",Long.valueOf(3));
        Gson Conversor = new Gson();
         
         
            String SalidaDeObjetoEnFormatoJson = Conversor.toJson(usuarioentrada);
        
            System.out.println(SalidaDeObjetoEnFormatoJson);
        
  

        
        
        
    }
    
}
