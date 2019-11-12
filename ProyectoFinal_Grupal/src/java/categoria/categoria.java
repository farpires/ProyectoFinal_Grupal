/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

/**
 *
 * @author DANIEL MALDONADO
 */
public class categoria 
{
    Long CategoriaPK;
    String CategoriaNombre;
    Long IDDistribuidora;

    public categoria(Long CategoriaPK, String CategoriaNombre,Long IDDistribuidora)
    {
        this.CategoriaPK = CategoriaPK;
        this.CategoriaNombre = CategoriaNombre;
        this.IDDistribuidora = IDDistribuidora;
    }

    public categoria() 
    {
        this.CategoriaPK = Long.valueOf(0);
        this.CategoriaNombre = "";
        this.IDDistribuidora = Long.valueOf(0);
    }




    public Long getCategoriaPK() {
        return CategoriaPK;
    }

    public void setCategoriaPK(Long CategoriaPK) {
        this.CategoriaPK = CategoriaPK;
    }

    public String getCategoriaNombre() {
        return CategoriaNombre;
    }

    public void setCategoriaNombre(String CategoriaNombre) {
        this.CategoriaNombre = CategoriaNombre;
    }

    public Long getIDDistribuidora() {
        return IDDistribuidora;
    }

    public void setIDDistribuidora(Long IDDistribuidora) {
        this.IDDistribuidora = IDDistribuidora;
    }
    
    

    @Override
    public String toString() 
    {
        return "Categoria{" + "CategoriaPK=" + CategoriaPK + ", CategoriaNombre=" + CategoriaNombre + ", IDDistribuidora=" + IDDistribuidora + '}';
    }

    void IDDistribuidora(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
