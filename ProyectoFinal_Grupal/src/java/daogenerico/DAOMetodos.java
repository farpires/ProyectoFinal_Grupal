/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daogenerico;

import java.util.List;

/**
 *
 * @author DANIEL MALDONADO
 */
public interface DAOMetodos <CLASEBASE,CLASEEXTENDIDA>
{
    public CLASEBASE AddRecord(CLASEBASE Objeto) throws ErroresGenerales;
    
    public boolean UpdateRecord(CLASEBASE Objeto) throws ErroresGenerales;
    
    public boolean DeleteRecord(CLASEBASE Objeto) throws ErroresGenerales;
    
    public CLASEBASE LoadRecord(Long PK) throws ErroresGenerales;
    
    public String LoadRecordToJSON(Long PK) throws ErroresGenerales;
    
    public CLASEBASE LoadRecord(String ComandoSQL) throws ErroresGenerales;
    
    public String LoadRecordToJSON(String ComandoSQL) throws ErroresGenerales;
    
    public List<CLASEBASE> getAll(String ComandoSQL) throws ErroresGenerales;
    
    public List<CLASEEXTENDIDA> getJoinAll(String ComandoSQL) throws ErroresGenerales;    
    
    public String getAllToJSON(String ComandoSQL) throws ErroresGenerales;
    
    public String getJoinAllToJSON(String ComandoSQL) throws ErroresGenerales;

    
    
}
