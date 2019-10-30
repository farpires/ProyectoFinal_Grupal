/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

/**
 *
 * @author Jorge
 */
public class usuario {
    
    Long idusuario;
    String usuarionombre; 
    String usuariopassword;
    String usuarioemail; 
    Long iddistribuidora;

   

    public usuario(Long idusuario, String usuarionombre, String usuariopassword, String usuarioemail, Long iddistribuidora) {
        this.idusuario = idusuario;
        this.usuarionombre = usuarionombre;
        this.usuariopassword = usuariopassword;
        this.usuarioemail = usuarioemail;
        this.iddistribuidora = iddistribuidora;
    }
	
     public usuario() {
        this.idusuario = Long.valueOf(0);
        this.usuarionombre = "";
        this.usuariopassword = "";
        this.usuarioemail = "";
        this.iddistribuidora = Long.valueOf(0);
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

    @Override
    public String toString() {
        return "usuario{" + "idusuario=" + idusuario + ", usuarionombre=" + usuarionombre + ", usuariopassword=" + usuariopassword + '}';
    }
     
     
    
}
