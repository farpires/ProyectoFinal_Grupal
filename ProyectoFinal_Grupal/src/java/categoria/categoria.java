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
public class categoria {
    Long idcategoria;
    String categorianombre;
    Long iddistribuidora;

    public categoria(Long idcategoria, String categorianombre, Long iddistribuidora) {
        this.idcategoria = idcategoria;
        this.categorianombre = categorianombre;
        this.iddistribuidora = iddistribuidora;
    }

    public categoria() {
         this.idcategoria = Long.valueOf(0);
        this.categorianombre = " ";
        this.iddistribuidora = Long.valueOf(0);
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

    @Override
    public String toString() {
        return "categoria{" + "idcategoria=" + idcategoria + ", categorianombre=" + categorianombre + ", iddistribuidora=" + iddistribuidora + '}';
    }
    
    
    
}
