/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

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
public class categoriaDAO extends DAOGenerico implements DAOMetodos<categoria, categoriaextendida> {

    @Override
    public categoria AddRecord(categoria Objeto) throws ErroresGenerales {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        categoria Salida = null;
        Long PK = Long.valueOf(0);
        int RESULTADO = 0;

        try {
            STATEMENT = CON.getCon().prepareStatement("insert into categoria( categorianombre, iddistribuidora) values( ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            STATEMENT.setString(1, Objeto.categorianombre);
            STATEMENT.setLong(2, Objeto.getIddistribuidora());

            RESULTADO = STATEMENT.executeUpdate();

            if (RESULTADO > 0) {
                ResultSet rs = STATEMENT.getGeneratedKeys();
                if (rs.next()) {
                    PK = rs.getLong(1);
                    Salida = Objeto;
                    Salida.setIdcategoria(PK);
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
    public boolean UpdateRecord(categoria Objeto) throws ErroresGenerales {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int RESULTADO = 0;

        try {
            STATEMENT = CON.getCon().prepareStatement("update categoria set categorianombre = ?,iddistribuidora= ? where idcategoria = ?");

            STATEMENT.setString(1, Objeto.categorianombre);
            STATEMENT.setLong(2, Objeto.getIddistribuidora());
            STATEMENT.setLong(3, Objeto.getIdcategoria());

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
    public boolean DeleteRecord(categoria Objeto) throws ErroresGenerales {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int RESULTADO = 0;

        try {
            STATEMENT = CON.getCon().prepareStatement("delete from categoria where idcategoria = ?");

            STATEMENT.setLong(1, Objeto.getIdcategoria());

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
    public categoria LoadRecord(Long PK) throws ErroresGenerales {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        categoria Salida = null;

        int RESULTADO = 0;

        ResultSet RS;

        try {
            STATEMENT = CON.getCon().prepareStatement("select * from categoria where idcategoria = ?");

            STATEMENT.setLong(1, PK);

            RS = STATEMENT.executeQuery();

            while (RS.next()) {
                Salida = new categoria();
                Salida.setIdcategoria(PK);
                Salida.setCategorianombre(RS.getString("categorianombre"));
                Salida.setIddistribuidora(RS.getLong("iddistribuidora"));
                return Salida;
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
    public String LoadRecordToJSON(Long PK) throws ErroresGenerales {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        categoria P = new categoria();
        Gson Conversor = new Gson();

        P = this.LoadRecord(PK);

        String SalidaDeObjetoEnFormatoJson = Conversor.toJson(P);

        return (SalidaDeObjetoEnFormatoJson);

    }

    @Override
    public categoria LoadRecord(String ComandoSQL) throws ErroresGenerales {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        categoria Salida = null;

        int RESULTADO = 0;

        ResultSet RS;

        try {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);

            RS = STATEMENT.executeQuery();

            while (RS.next()) {
                Salida = new categoria();

                Salida.setIdcategoria(RS.getLong("idcategoria"));
                Salida.setCategorianombre(RS.getString("categorianombre"));
                Salida.setIdcategoria(RS.getLong("iddistribuidora"));

                return Salida;
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
    public String LoadRecordToJSON(String ComandoSQL) throws ErroresGenerales {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<categoria> getAll(String ComandoSQL) throws ErroresGenerales {
        List<categoria> Salida = new ArrayList<categoria>();
        ResultSet RS;
        try {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);
            RS = STATEMENT.executeQuery();

            while (RS.next()) {
                categoria P = new categoria();

                P.setIdcategoria(RS.getLong("idcategoria"));
                P.setCategorianombre(RS.getString("categorianombre"));
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
    public List<categoriaextendida> getJoinAll(String ComandoSQL) throws ErroresGenerales {
        List<categoriaextendida> Salida = new ArrayList<categoriaextendida>();
        int RESULTADO = 0;
        ResultSet RS;

        try {
            STATEMENT = CON.getCon().prepareStatement(ComandoSQL);

            RS = STATEMENT.executeQuery();

            while (RS.next()) {

                categoriaextendida P = new categoriaextendida();

                P.setIdcategoria(RS.getLong("idcategoria"));
                P.setCategorianombre(RS.getString("categorianombre"));
                P.setIddistribuidora(RS.getLong("iddistribuidora"));
                P.setDistribuidoracuit(RS.getString("distribuidoracuit"));
                P.setDistribuidoranombre(RS.getString("distribuidoranombre"));
                P.setDistribuidoradomicilio(RS.getString("distribuidoradomicilio"));
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

        List<categoria> Salida = new ArrayList<categoria>();

        Salida = this.getAll(ComandoSQL);

        return (Conversor.toJson(Salida));
    }

    @Override
    public String getJoinAllToJSON(String ComandoSQL) throws ErroresGenerales {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
