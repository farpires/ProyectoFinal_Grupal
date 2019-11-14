/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import com.google.gson.Gson;

/**
 *
 * @author Monti
 */
public class P08_ProbandoWS1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*LO QUE HACE EESTO ES CONVERTIR EN OBJ PRODUCTO EN UN OBJETO JSON PARA PASARLO COMO
        PARAMETRO EN EL WS ?TipoProceso=1&ParametroJSON= ...*/
        
        producto P = new producto(Long.valueOf(10), "Manaos uva 1500ml", "00000003", "85", "08/11/2019",Long.valueOf(1));
        Gson G = new Gson();
        
        String productoEnFormatoJSON = G.toJson(P);
        System.out.println(productoEnFormatoJSON);
        
        
        
        
    }
    
}
