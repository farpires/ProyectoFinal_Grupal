/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidora;

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
 * @author Jorge
 */
public class distribuidoradao extends DAOGenerico implements DAOMetodos<distribuidora,distribuidora> {
    @Override
    public distribuidora AddRecord(distribuidora Objeto) throws ErroresGenerales 
    {
        distribuidora Salida = null;
        Long PK = Long.valueOf(0);
        int RESULTADO = 0;
        
        try 
        {
            
            STATEMENT = CON.getCon().prepareStatement("insert into distribuidora (distribuidoracuit,distribuidoranombre,distribuidoradomicilio) values (?,?,?)");

            
            STATEMENT.setString(1,Objeto.getDistribuidoracuit());
             STATEMENT.setString(2,Objeto.getDistribuidoranombre());
              STATEMENT.setString(3,Objeto.getDistribuidoradomicilio());
           
            
           
            
            RESULTADO = STATEMENT.executeUpdate();
            
            if (RESULTADO > 0)
            {
                ResultSet rs = STATEMENT.getGeneratedKeys();             
                if (rs.next())
                { 
                    PK = rs.getLong(1);   
                    Salida = Objeto;
                    Salida.setIddistribuidora(PK);
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
        
        return Salida;
        
       
    }

    @Override
    public boolean UpdateRecord(distribuidora Objeto) throws ErroresGenerales
    {
         int RESULTADO = 0;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement("update distribuidora set distribuidoracuit = ?, distribuidoranombre = ?,distribuidoradomicilio = ? where iddistribuidora = ?");

            STATEMENT.setString(1,Objeto.distribuidoracuit);
             STATEMENT.setString(2,Objeto.distribuidoranombre);
              STATEMENT.setString(3,Objeto.distribuidoradomicilio);
            STATEMENT.setLong(4,Objeto.getIddistribuidora());

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
    public boolean DeleteRecord(distribuidora Objeto) throws ErroresGenerales {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

 int RESULTADO = 0;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement("delete from distribuidora where iddistribuidora = ?");

            STATEMENT.setLong(1,Objeto.getIddistribuidora());

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
    public distribuidora LoadRecord(Long PK) throws ErroresGenerales {
       distribuidora Salida = null;

        int RESULTADO = 0;

        ResultSet RS;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement("select * from distribuidora where iddistribuidora = ?");

            STATEMENT.setLong(1,PK);

            RS = STATEMENT.executeQuery();

            while (RS.next())
            {
                Salida = new distribuidora();
                Salida.setIddistribuidora(PK);
                Salida.setDistribuidoracuit(RS.getString("distribuidoracuit"));
                Salida.setDistribuidoradomicilio(RS.getString("distribuidoradomicilio"));
                Salida.setDistribuidoranombre(RS.getString("distribuidoranombre"));
               
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
        distribuidora P = new distribuidora();
       Gson Conversor = new Gson();
       P=this.LoadRecord(PK);
       String SalidaDeObjetoEnFormatoJson = Conversor.toJson(P);
       return(SalidaDeObjetoEnFormatoJson);    }

    @Override
    public distribuidora LoadRecord(String ComandoSQL) throws ErroresGenerales {
        distribuidora Salida = null;

        int RESULTADO = 0;

        ResultSet RS;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);

            RS = STATEMENT.executeQuery();

            while (RS.next())
            {
                Salida = new distribuidora();


                Salida = new distribuidora();
                Salida.setIddistribuidora(RS.getLong("iddistribuidora"));
                Salida.setDistribuidoracuit(RS.getString("distribuidoracuit"));
                Salida.setDistribuidoradomicilio(RS.getString("distribuidoradomicilio"));
                Salida.setDistribuidoranombre(RS.getString("distribuidoranombre"));
                
                


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
    public List<distribuidora> getAll(String ComandoSQL) throws ErroresGenerales {
       List<distribuidora> Salida = new ArrayList<distribuidora>();      
       
        int RESULTADO = 0;
        
        ResultSet RS;
        
        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);            
            
            RS = STATEMENT.executeQuery();
            
            while (RS.next())
            {
                distribuidora P = new distribuidora();
                
                
                P.setIddistribuidora(RS.getLong("iddistribuidora"));
                P.setDistribuidoracuit(RS.getString("distribuidoracuit"));
                P.setDistribuidoradomicilio(RS.getString("distribuidoradomicilio"));
                P.setDistribuidoranombre(RS.getString("distribuidoranombre"));
                
                
                
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
    public List<distribuidora> getJoinAll(String ComandoSQL) throws ErroresGenerales {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAllToJSON(String ComandoSQL) throws ErroresGenerales {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinAllToJSON(String ComandoSQL) throws ErroresGenerales {
        Gson Conversor = new Gson();
        
        List<distribuidora> Salida = new ArrayList<distribuidora>();
        
        Salida = this.getAll(ComandoSQL);
        
        return(Conversor.toJson(Salida));    }
    
}