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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;

/**
 *
 * @author Jorge
 */
public class usuariodao extends DAOGenerico implements DAOMetodos<usuario,usuarioextendido>{

    @Override
    
    public usuario AddRecord(usuario Objeto) throws ErroresGenerales {
        usuario Salida = null;
        Long PK = Long.valueOf(0);
        int RESULTADO = 0;
        
        try 
        {
            STATEMENT = CON.getCon().prepareStatement("insert into usuario (usuarionombre,usuariopassword,usuarioemail,iddistribuidora) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
        
           
            STATEMENT.setString(1,Objeto.usuarionombre);
            STATEMENT.setString(2,Objeto.usuariopassword);
            STATEMENT.setString(3,Objeto.usuarioemail);
            STATEMENT.setLong(4,Objeto.getIddistribuidora());
            
            RESULTADO = STATEMENT.executeUpdate();
            
            if (RESULTADO > 0)
            {
                ResultSet rs = STATEMENT.getGeneratedKeys();             
                if (rs.next())
                { 
                    PK = rs.getLong(1);   
                    Salida = Objeto;
                    Salida.setIdusuario(PK);
                }           
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
        
        return Salida;    }
    
    
    

    @Override
    public boolean UpdateRecord(usuario Objeto) throws ErroresGenerales {
        int RESULTADO = 0;
        try {
            STATEMENT = CON.getCon().prepareStatement("UPDATE usuario SET  usuarionombre=?, usuariopassword=?, usuarioemail=?, iddistribuidora=?");
            STATEMENT.setString(1, Objeto.usuarionombre);
            STATEMENT.setString(2, Objeto.usuariopassword);
            STATEMENT.setString(3, Objeto.usuarioemail);
            STATEMENT.setLong(4, Objeto.iddistribuidora);
            RESULTADO = STATEMENT.executeUpdate();
            if (RESULTADO > 0) {
                return true;
            }
        } catch (PSQLException e) {
            throw new ErroresGenerales(e.getMessage());
        } catch (SQLException e) {
            throw new ErroresGenerales(e.getMessage());
        } catch (Exception e) {
            throw new ErroresGenerales(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean DeleteRecord(usuario Objeto) throws ErroresGenerales {

        int RESULTADO = 0;
        try {
            STATEMENT = CON.getCon().prepareStatement("delete from usuario where idusuario = ?");

            STATEMENT.setLong(1, Objeto.getIdusuario());

            RESULTADO = STATEMENT.executeUpdate();

            if (RESULTADO > 0) {
                return true;
            }

        } catch (PSQLException e) {
            throw new ErroresGenerales(e.getMessage());
        } catch (SQLException e) {
            throw new ErroresGenerales(e.getMessage());
        } catch (Exception e) {
            throw new ErroresGenerales(e.getMessage());
        }

        return false;
    }

    @Override
    public usuario LoadRecord(Long PK) throws ErroresGenerales 
    {
       usuario Salida = null;
      
        int RESULTADO = 0;
        
        ResultSet RS;
        
        try 
        {
            STATEMENT = CON.getCon().prepareStatement("select * from public.usuario where idusuario = ?");        
                     
            STATEMENT.setLong(1,PK);

            RS = STATEMENT.executeQuery();           
                       
            while (RS.next())
            {
                Salida = new usuario();
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
    public String LoadRecordToJSON(Long PK) throws ErroresGenerales 
    {
       usuario P = new usuario();
       Gson Conversor = new Gson();
       P=this.LoadRecord(PK);
       String SalidaDeObjetoEnFormatoJson = Conversor.toJson(P);
       return(SalidaDeObjetoEnFormatoJson);
    }
    
    @Override
    public usuario LoadRecord(String ComandoSQL) throws ErroresGenerales 
    {
        usuario Salida = null;
      
        int RESULTADO = 0;
        
        ResultSet RS;
        
        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);            
            
            RS = STATEMENT.executeQuery();
            
            while (RS.next())
            {
                Salida = new usuario();
                
                Salida.setIdusuario(RS.getLong("idusuario"));
                Salida.setUsuarionombre(RS.getString("usuarionombre"));
                Salida.setUsuariopassword("usuariopassword");
                Salida.setUsuarioemail("usuarioemail");
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
    public List<usuario> getAll(String ComandoSQL) throws ErroresGenerales 
    {
        List<usuario> Salida = new ArrayList<usuario>();      
        
        int RESULTADO = 0;
        
        ResultSet RS;
        
        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);            
            
            RS = STATEMENT.executeQuery();
            
            while (RS.next())
            {
                usuario P = new usuario();
                
                P.setIdusuario(RS.getLong("idusuario"));
                P.setUsuarionombre(RS.getString("usuarionombre"));
                P.setUsuariopassword("usuariopassword");
                P.setUsuarioemail("usuarioemail");
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
    public List<usuarioextendido> getJoinAll(String ComandoSQL) throws ErroresGenerales {
        List<usuarioextendido> Salida = new ArrayList<usuarioextendido>();
        int RESULTADO = 0;
        ResultSet RS;
        try {

            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);
            RS = STATEMENT.executeQuery();
            while (RS.next()) {

                usuarioextendido P = new usuarioextendido();

                P.setIdusuario(RS.getLong("idusuario"));
                P.setUsuarionombre(RS.getString("usuarionombre"));
                P.setUsuariopassword("usuariopassword");
                P.setUsuarioemail("usuarioemail");
                P.setIddistribuidora(RS.getLong("iddistribuidora"));
                Salida.add(P);
            }
        } catch (PSQLException e) {
            throw new ErroresGenerales(e.getMessage());
        } catch (SQLException e) {
            throw new ErroresGenerales(e.getMessage());
        } catch (Exception e) {
            throw new ErroresGenerales(e.getMessage());
        }

        return Salida;

    }
    @Override
    public String getAllToJSON(String ComandoSQL) throws ErroresGenerales {
        Gson Conversor = new Gson();
        List<usuario> Salida = new ArrayList<usuario>();
        Salida =this.getAll(ComandoSQL);
        return(Conversor.toJson(Salida));    
    }

    @Override
    public String getJoinAllToJSON(String ComandoSQL) throws ErroresGenerales { 
        Gson Conversor = new Gson();
        List<usuarioextendido> Salida = new ArrayList<usuarioextendido>();
        Salida = this.getJoinAll(ComandoSQL);
        return(Conversor.toJson(Salida));
    }
    
    @Override
    public String LoadRecordToJSON(String ComandoSQL) throws ErroresGenerales 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
