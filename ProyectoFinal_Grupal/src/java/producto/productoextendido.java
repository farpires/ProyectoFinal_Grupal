/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

/**
 *
 * @author Matias
 */
public class productoextendido 
{
     Long idproducto;
     String productonombre;
     String productocodigodebarra;
     String productoprecio;
     String productofaprecio;
     Long idcategoria;
     String categorianombre;
     Long iddistribuidora;

    public productoextendido(Long idproducto, String productonombre, String productocodigodebarra, String productoprecio, String productofaprecio, Long idcategoria, String categorianombre, Long iddistribuidora) {
        this.idproducto = idproducto;
        this.productonombre = productonombre;
        this.productocodigodebarra = productocodigodebarra;
        this.productoprecio = productoprecio;
        this.productofaprecio = productofaprecio;
        this.idcategoria = idcategoria;
        this.categorianombre = categorianombre;
        this.iddistribuidora = iddistribuidora;
    }

    public productoextendido() 
    {
         this.idproducto = Long.valueOf(0);
         this.productonombre = "";
         this.productocodigodebarra = "";
         this.productoprecio = "";
         this.productoprecio = "";
         this.productofaprecio = "";
         this.idcategoria = Long.valueOf(0);
         this.categorianombre = "";
         this.iddistribuidora = Long.valueOf(0);
    }

    public Long getIdproducto() 
    {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public String getProductonombre() {
        return productonombre;
    }

    public void setProductonombre(String productonombre) {
        this.productonombre = productonombre;
    }

    public String getProductocodigodebarra() {
        return productocodigodebarra;
    }

    public void setProductocodigodebarra(String productocodigodebarra) {
        this.productocodigodebarra = productocodigodebarra;
    }

    public String getProductoprecio() {
        return productoprecio;
    }

    public void setProductoprecio(String productoprecio) {
        this.productoprecio = productoprecio;
    }

    public String getProductofaprecio() {
        return productofaprecio;
    }

    public void setProductofaprecio(String productofaprecio) {
        this.productofaprecio = productofaprecio;
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
        return "productoextendido{" + "idproducto=" + idproducto + ", productonombre=" + productonombre + ", productocodigodebarra=" + productocodigodebarra + ", productoprecio=" + productoprecio + ", productofaprecio=" + productofaprecio + ", idcategoria=" + idcategoria + ", categorianombre=" + categorianombre + ", iddistribuidora=" + iddistribuidora + '}';
    }

   
     
     
     
}
