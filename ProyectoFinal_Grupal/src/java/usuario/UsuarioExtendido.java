/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

/**
 *
 * @author arpir
 */
public class UsuarioExtendido {
    
        Long idusuario; 
    String usuarionombre; 
    String usuariopassword;
    String usuarioemail; 
    Long iddistribuidora;
    
    String distribuidoracuit; 
    String distribuidoranombre;
    String distribuidoradomicilio;

    public UsuarioExtendido(Long idusuario, String usuarionombre, String usuariopassword, String usuarioemail, Long iddistribuidora, String distribuidoracuit, String distribuidoranombre, String distribuidoradomicilio) {
        this.idusuario = idusuario;
        this.usuarionombre = usuarionombre;
        this.usuariopassword = usuariopassword;
        this.usuarioemail = usuarioemail;
        this.iddistribuidora = iddistribuidora;
        this.distribuidoracuit = distribuidoracuit;
        this.distribuidoranombre = distribuidoranombre;
        this.distribuidoradomicilio = distribuidoradomicilio;
    }

    public UsuarioExtendido() {
               this.idusuario = Long.valueOf(0);
        this.usuarionombre = " ";
        this.usuariopassword = " ";
        this.usuarioemail = " ";
        this.iddistribuidora = Long.valueOf(0);
        this.distribuidoracuit = " ";
        this.distribuidoranombre = " ";
        this.distribuidoradomicilio = " ";
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuarionombre() {
        return usuarionombre;
    }

    public void setUsuarionombre(String usuarionombre) {
        this.usuarionombre = usuarionombre;
    }

    public String getUsuariopassword() {
        return usuariopassword;
    }

    public void setUsuariopassword(String usuariopassword) {
        this.usuariopassword = usuariopassword;
    }

    public String getUsuarioemail() {
        return usuarioemail;
    }

    public void setUsuarioemail(String usuarioemail) {
        this.usuarioemail = usuarioemail;
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
        return "UsuarioExtendido{" + "idusuario=" + idusuario + ", usuarionombre=" + usuarionombre + ", usuariopassword=" + usuariopassword + ", usuarioemail=" + usuarioemail + ", iddistribuidora=" + iddistribuidora + ", distribuidoracuit=" + distribuidoracuit + ", distribuidoranombre=" + distribuidoranombre + ", distribuidoradomicilio=" + distribuidoradomicilio + '}';
    }

    
    
    
    
    

    
    
    
}

    