/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

/**
 *
 * @author arpir
 */
public class categoriaextendida {
    
    Long idcategoria;
    String categorianombre;
    Long iddistribuidora;
    String distribuidoracuit; 
    String distribuidoranombre;
    String distribuidoradomicilio;

    public categoriaextendida(Long idcategoria, String categorianombre, Long iddistribuidora, String distribuidoracuit, String distribuidoranombre, String distribuidoradomicilio) {
        this.idcategoria = idcategoria;
        this.categorianombre = categorianombre;
        this.iddistribuidora = iddistribuidora;
        this.distribuidoracuit = distribuidoracuit;
        this.distribuidoranombre = distribuidoranombre;
        this.distribuidoradomicilio = distribuidoradomicilio;
    }

    public categoriaextendida() {
        
        this.idcategoria = Long.valueOf(0);
        this.categorianombre = " ";
        this.iddistribuidora = Long.valueOf(0);
        this.distribuidoracuit = " ";
        this.distribuidoranombre = " ";
        this.distribuidoradomicilio = " ";
    }

    public Long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategorianombre() {
        return categorianombre;
    }

    public void setCategorianombre(String categorianombre) {
        this.categorianombre = categorianombre;
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
        return "categoriaextendida{" + "idcategoria=" + idcategoria + ", categorianombre=" + categorianombre + ", iddistribuidora=" + iddistribuidora + ", distribuidoracuit=" + distribuidoracuit + ", distribuidoranombre=" + distribuidoranombre + ", distribuidoradomicilio=" + distribuidoradomicilio + '}';
    }
    



}