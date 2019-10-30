/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import com.google.gson.Gson;
import daogenerico.DAOGenerico;
import daogenerico.DAOMetodos;
import daogenerico.ErroresGenerales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

/**
 *
 * @author arpir
 */
public class UsuarioDAO extends DAOGenerico implements DAOMetodos<Usuario, UsuarioExtendido>{

    @Override
    public Usuario AddRecord(Usuario Objeto) throws ErroresGenerales {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Usuario Salida = null;
        Long PK = Long.valueOf(0);
        int RESULTADO = 0;
        /*INSERT INTO public.usuario(
	idusuario, usuarionombre, usuariopassword, usuarioemail, iddistribuidora)
	VALUES (?, ?, ?, ?, ?);*/
        
        
        try {
            STATEMENT = CON.getCon().prepareStatement("insert into usuario( usuarionombre, usuariopassword, usuarioemail, iddistribuidora) values( ?, ?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
            
            STATEMENT.setString(1, Objeto.usuarionombre);
            STATEMENT.setString(2, Objeto.usuariopassword);
            STATEMENT.setString(3, Objeto.usuarioemail);
            STATEMENT.setLong(4,Objeto.getIddistribuidora());
            
            RESULTADO = STATEMENT.executeUpdate();
            
            if (RESULTADO > 0) {
                ResultSet rs = STATEMENT.getGeneratedKeys();
                if (rs.next()) {
                    PK = rs.getLong(1);
                    Salida = Objeto;
                    Salida.setIdusuario(PK);
                }
            }
        } catch (PSQLException e) 
        {  
            throw new ErroresGenerales(e.getMessage());                
        }
        catch(SQLException e) 
        {              
            throw new ErroresGenerales(e.getMessage());               
        }
        catch(Exception e)
        {
            throw new ErroresGenerales(e.getMessage()); 
        }    
        
        return Salida;
    
    
    
    }

    @Override
    public boolean UpdateRecord(Usuario Objeto) throws ErroresGenerales {
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     int RESULTADO = 0;   
     /*SELECT idusuario, usuarionombre, usuariopassword, usuarioemail, iddistribuidora
	FROM public.usuario;*/
        try 
        {
            STATEMENT = CON.getCon().prepareStatement("update usuario set usuarionombre = ?, usuariopassword = ?,usuarioemail = ?, iddistribuidora = ? where idusuario = ?");
        
            STATEMENT.setString(1,Objeto.usuarionombre);
            STATEMENT.setString(2,Objeto.usuariopassword);
            STATEMENT.setString(3,Objeto.usuarioemail);
            STATEMENT.setLong(4,Objeto.getIddistribuidora());
            STATEMENT.setLong(5,Objeto.getIdusuario());
            
            RESULTADO = STATEMENT.executeUpdate();
            
            if (RESULTADO > 0)
            {
                return true;
            }
            
        }catch (PSQLException e) 
        {  
            throw new ErroresGenerales(e.getMessage());                
        }
        catch(SQLException e) 
        {              
            throw new ErroresGenerales(e.getMessage());               
        }
        catch(Exception e)
        {
            throw new ErroresGenerales(e.getMessage()); 
        }     
        
        return false;
    
    }

    @Override
    public boolean DeleteRecord(Usuario Objeto) throws ErroresGenerales {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    int RESULTADO = 0;
    /*DELETE FROM public.usuario
	WHERE <condition>;*/
        
        try 
        {
            STATEMENT = CON.getCon().prepareStatement("delete from usuario where idusuario = ?");
        
            STATEMENT.setLong(1,Objeto.getIdusuario());
            
            RESULTADO = STATEMENT.executeUpdate();
            
            if (RESULTADO > 0)
            {
                return true;
            }
            
        }catch (PSQLException e) 
        {  
            throw new ErroresGenerales(e.getMessage());                
        }
        catch(SQLException e) 
        {              
            throw new ErroresGenerales(e.getMessage());               
        }
        catch(Exception e)
        {
            throw new ErroresGenerales(e.getMessage()); 
        }    
        
        return false;         
    
    
    
    }

    @Override
    public Usuario LoadRecord(Long PK) throws ErroresGenerales {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Usuario Salida = null;

        int RESULTADO = 0;

        ResultSet RS;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement("select * from usuario where idusuario = ?");

            STATEMENT.setLong(1,PK);

            RS = STATEMENT.executeQuery();

            while (RS.next())
            {
                Salida = new Usuario();
                Salida.setIdusuario(PK);
                Salida.setUsuarionombre(RS.getString("usuarionombre"));
                Salida.setUsuariopassword(RS.getString("usuariopassword"));
                Salida.setUsuarioemail(RS.getString("usuarioemail"));
                Salida.setIddistribuidora(RS.getLong("iddistribuidora"));
                return Salida;
            }

        }catch (PSQLException e) 
        {
            throw new ErroresGenerales(e.getMessage());
        }
        catch(SQLException e) 
        {
            throw new ErroresGenerales(e.getMessage());
        }
        catch(Exception e)
        {
            throw new ErroresGenerales(e.getMessage()); 
        }

        return Salida;
    
    }

    @Override
    public String LoadRecordToJSON(Long PK) throws ErroresGenerales {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
       Usuario P = new Usuario();
       Gson Conversor = new Gson();
       P=this.LoadRecord(PK);
       String SalidaDeObjetoEnFormatoJson = Conversor.toJson(P);
       return(SalidaDeObjetoEnFormatoJson);
    
    }

    @Override
    public Usuario LoadRecord(String ComandoSQL) throws ErroresGenerales {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Usuario Salida = null;

        int RESULTADO = 0;

        ResultSet RS;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);

            RS = STATEMENT.executeQuery();

            while (RS.next())
            {
                Salida = new Usuario();


                Salida.setIdusuario(RS.getLong("idusuario"));
                Salida.setUsuarionombre(RS.getString("usuarionombre"));
                Salida.setUsuariopassword(RS.getString("usuariopassword"));
                Salida.setUsuarioemail(RS.getString("usuarioemail"));
                Salida.setIddistribuidora(RS.getLong("iddistribuidora"));


                return Salida;
            }



        }catch (PSQLException e) 
        {
            throw new ErroresGenerales(e.getMessage());
        }
        catch(SQLException e) 
        {
            throw new ErroresGenerales(e.getMessage());
        }
        catch(Exception e)
        {
            throw new ErroresGenerales(e.getMessage()); 
        }

        return Salida;
    
    
    }

    @Override
    public String LoadRecordToJSON(String ComandoSQL) throws ErroresGenerales {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> getAll(String ComandoSQL) throws ErroresGenerales {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<Usuario> Salida = new ArrayList<Usuario>();      
       
        int RESULTADO = 0;
        
        ResultSet RS;
        
        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);            
            
            RS = STATEMENT.executeQuery();
            
            while (RS.next())
            {
                Usuario P = new Usuario();
                
                P.setIdusuario(RS.getLong("idusuario"));
                P.setUsuarionombre(RS.getString("usuarionombre"));
                P.setUsuariopassword(RS.getString("usuariopassword"));
                P.setUsuarioemail(RS.getString("usuarioemail"));    
                P.setIddistribuidora(RS.getLong("iddistribuidora"));    
                
                Salida.add(P);
            }
            
        }catch (PSQLException e) 
        {  
            throw new ErroresGenerales(e.getMessage());                
        }
        catch(SQLException e) 
        {              
            throw new ErroresGenerales(e.getMessage());               
        }
        catch(Exception e)
        {
            throw new ErroresGenerales(e.getMessage()); 
        }
        
        return Salida;                    
    
    }

    @Override
    public List<UsuarioExtendido> getJoinAll(String ComandoSQL) throws ErroresGenerales {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    List<UsuarioExtendido> Salida = new ArrayList<UsuarioExtendido>();      
           /*INSERT INTO public.usuario(
	idusuario, usuarionombre, usuariopassword, usuarioemail, iddistribuidora)
	VALUES (?, ?, ?, ?, ?);*/
        int RESULTADO = 0;
        
        ResultSet RS;
        
        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);            
            
            RS = STATEMENT.executeQuery();
            
            while (RS.next())
            {               
                
                UsuarioExtendido P = new UsuarioExtendido();
                
                P.setIdusuario(RS.getLong("idusuario"));
                P.setUsuarionombre(RS.getString("usuarionombre"));
                P.setUsuariopassword(RS.getString("usuariopassword"));
                P.setUsuarioemail(RS.getString("usuarioemail"));
                
                P.setIddistribuidora(RS.getLong("iddistribuidora"));                                   
                P.setDistribuidoracuit(RS.getString("distribuidoracuit"));   
                P.setDistribuidoranombre(RS.getString("distribuidoranombre"));   
                P.setDistribuidoradomicilio(RS.getString("distribuidoradomicilio"));   
                
                
                Salida.add(P);
            }
            
        }catch (PSQLException e) 
        {  
            throw new ErroresGenerales(e.getMessage());                
        }
        catch(SQLException e) 
        {              
            throw new ErroresGenerales(e.getMessage());               
        }
        catch(Exception e)
        {
            throw new ErroresGenerales(e.getMessage()); 
        }
        
        return Salida;             
    
    }

    @Override
    public String getAllToJSON(String ComandoSQL) throws ErroresGenerales {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Gson Conversor = new Gson();
        
        List<Usuario> Salida = new ArrayList<Usuario>();
        
        Salida = this.getAll(ComandoSQL);
        
        return(Conversor.toJson(Salida));
    }
    
    
    

    @Override
    public String getJoinAllToJSON(String ComandoSQL) throws ErroresGenerales {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Gson Conversor = new Gson();
        
        List<UsuarioExtendido> Salida = new ArrayList<UsuarioExtendido>();
        
        Salida = this.getJoinAll(ComandoSQL);
        
        return(Conversor.toJson(Salida));
    }
    
    
}
