/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

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
 * @author Matias
 */
public class productoDAO extends DAOGenerico implements DAOMetodos<producto,productoextendido>
{

    @Override
    public producto AddRecord(producto Objeto) throws ErroresGenerales 
    {
        producto Salida = null;
        Long PK = Long.valueOf(0);
        int RESULTADO = 0;

        try {
            STATEMENT = CON.getCon().prepareStatement("insert into producto( productonombre, productocodigo, productoprecio, productofaprecio,idcategoria) values( ?, ?, ?, ?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            STATEMENT.setString(1, Objeto.productonombre);
            STATEMENT.setString(2, Objeto.productocodigodebarra);
            STATEMENT.setString(3, Objeto.productoprecio);
            STATEMENT.setString(4, Objeto.productofaprecio);
            STATEMENT.setLong(5, Objeto.getIdcategoria());

            RESULTADO = STATEMENT.executeUpdate();

            if (RESULTADO > 0) {
                ResultSet rs = STATEMENT.getGeneratedKeys();
                if (rs.next()) {
                    PK = rs.getLong(1);
                    Salida = Objeto;
                    Salida.setIdproducto(PK);
                }
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
    public boolean UpdateRecord(producto Objeto) throws ErroresGenerales 
    {
         int RESULTADO = 0;
        try {
            STATEMENT = CON.getCon().prepareStatement("UPDATE producto SET  productonombre=?, productocodigo=?, productoprecio=?, productofaprecio=?,idcategoria=? where idproducto=?");

            STATEMENT.setString(1, Objeto.productonombre);
            STATEMENT.setString(2, Objeto.productocodigodebarra);
            STATEMENT.setString(3, Objeto.productoprecio);
            STATEMENT.setString(4, Objeto.productofaprecio);
             STATEMENT.setLong(5,Objeto.getIdcategoria());
            STATEMENT.setLong(6,Objeto.getIdproducto());

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
    public boolean DeleteRecord(producto Objeto) throws ErroresGenerales 
    {
        int RESULTADO = 0;

        try {
            STATEMENT = CON.getCon().prepareStatement("delete from producto where idproducto = ?");

            STATEMENT.setLong(1, Objeto.idproducto);

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
    public producto LoadRecord(Long PK) throws ErroresGenerales 
    {
       producto Salida = null;

        int RESULTADO = 0;

        ResultSet RS;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement("select * from producto where idproducto = ?");

            STATEMENT.setLong(1,PK);

            RS = STATEMENT.executeQuery();

            while (RS.next())
            {
                Salida = new producto();

                Salida.setIdproducto(PK);
                Salida.setProductonombre(RS.getString("productonombre"));
                Salida.setProductocodigodebarra(RS.getString("productocodigo"));
                Salida.setProductoprecio(RS.getString("productoprecio"));
                Salida.setProductofaprecio(RS.getString("productofaprecio"));
                Salida.setIdcategoria(RS.getLong("idcategoria"));

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
        producto P = new producto();
        Gson Conversor = new Gson();

        P = this.LoadRecord(PK);

        String SalidaDeObjetoEnFormatoJson = Conversor.toJson(P);

        return (SalidaDeObjetoEnFormatoJson);
    }

    @Override
    public producto LoadRecord(String ComandoSQL) throws ErroresGenerales {
        producto salida = null;
        int RESULTADO = 0;
        ResultSet RS;

        try {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);
            RS = STATEMENT.executeQuery();

            while (RS.next()) {
                salida = new producto();

                salida.setIdproducto(RS.getLong("idproducto"));
                salida.setProductonombre(RS.getString("productonombre"));
                salida.setProductocodigodebarra("productocodigo");
                salida.setProductoprecio("productoprecio");
                salida.setProductofaprecio("productofaprecio");
                salida.setIdcategoria(RS.getLong("idcategoria"));

                return salida;
            }

        } catch (PSQLException e) {
            throw new ErroresGenerales(e.getMessage());
        } catch (SQLException e) {
            throw new ErroresGenerales(e.getMessage());
        } catch (Exception e) {
            throw new ErroresGenerales(e.getMessage());
        }

        return salida;

    }
   @Override
    public String LoadRecordToJSON(String ComandoSQL) throws ErroresGenerales {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<producto> getAll(String ComandoSQL) throws ErroresGenerales 
    {
        List<producto> Salida = new ArrayList<producto>();

        int RESULTADO = 0;

        ResultSet RS;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);

            RS = STATEMENT.executeQuery();

            while (RS.next())
            {
                producto P = new producto();


                P.setIdproducto(RS.getLong("idproducto"));
                P.setProductonombre(RS.getString("productonombre"));
                P.setProductocodigodebarra(RS.getString("productocodigo"));
                P.setProductoprecio(RS.getString("productoprecio"));
                P.setProductofaprecio(RS.getString("productofaprecio"));
                P.setIdcategoria(RS.getLong("idcategoria"));

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
    public List<productoextendido> getJoinAll(String ComandoSQL) throws ErroresGenerales {
        List<productoextendido> Salida = new ArrayList<productoextendido>();

        int RESULTADO = 0;

        ResultSet RS;

        try 
        {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);

            RS = STATEMENT.executeQuery();

            while (RS.next())
            {

                productoextendido P = new productoextendido();

               P.setIdproducto(RS.getLong("idproducto"));
                P.setProductonombre(RS.getString("productonombre"));
                P.setProductocodigodebarra(RS.getString("productocodigo"));
                P.setProductoprecio(RS.getString("productoprecio"));
                P.setProductofaprecio(RS.getString("productofaprecio"));
                P.setIdcategoria(RS.getLong("idcategoria"));
               P.setCategorianombre(RS.getString("categorianombre"));






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
    public String getAllToJSON(String ComandoSQL) throws ErroresGenerales 
    {
        Gson Conversor = new Gson();

        List<producto> Salida = new ArrayList<producto>();

        Salida = this.getAll(ComandoSQL);

        return(Conversor.toJson(Salida));
    }

    @Override
    public String getJoinAllToJSON(String ComandoSQL) throws ErroresGenerales {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return(this.getAllToJSON(ComandoSQL));
        Gson Conversor = new Gson();
        
        List<producto> Salida = new ArrayList<producto>();
        
        Salida = this.getAll(ComandoSQL);
        
        return(Conversor.toJson(Salida)); 

    }
    
}
