/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidora;

/**
 *
 * @author Jorge
 */
public class distribuidora {
    
    Long iddistribuidora;
    String distribuidoracuit;
   String distribuidoranombre;
   String distribuidoradomicilio;

    public distribuidora() {
        
         this.iddistribuidora = Long.valueOf(0);
        this.distribuidoracuit = "";
        this.distribuidoranombre = "";
        this.distribuidoradomicilio = "";
    }

    public distribuidora(Long iddistribuidora, String distribuidoracuit, String distribuidoranombre, String distribuidoradomicilio) {
        this.iddistribuidora = iddistribuidora;
        this.distribuidoracuit = distribuidoracuit;
        this.distribuidoranombre = distribuidoranombre;
        this.distribuidoradomicilio = distribuidoradomicilio;
    }

    distribuidora(long parseLong, String delet) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    

    public Long getIddistribuidora() {
        return iddistribuidora;
    }

    public void setIddistribuidora(Long iddistribuidora) {
        this.iddistribuidora = iddistribuidora;
    }

    public String getDistribuidoracuit() {
        return distribuidoracuit;
    }

    public void setDistribuidoracuit(String distribuidoracuit) {
        this.distribuidoracuit = distribuidoracuit;
    }

    public String getDistribuidoranombre() {
        return distribuidoranombre;
    }

    public void setDistribuidoranombre(String distribuidoranombre) {
        this.distribuidoranombre = distribuidoranombre;
    }

    public String getDistribuidoradomicilio() {
        return distribuidoradomicilio;
    }

    public void setDistribuidoradomicilio(String distribuidoradomicilio) {
        this.distribuidoradomicilio = distribuidoradomicilio;
    }

    @Override
    public String toString() {
        return "distribuidora{" + "iddistribuidora=" + iddistribuidora + ", distribuidoracuit=" + distribuidoracuit + ", distribuidoranombre=" + distribuidoranombre + ", distribuidoradomicilio=" + distribuidoradomicilio + '}';
    }
   
   
   
    
}
