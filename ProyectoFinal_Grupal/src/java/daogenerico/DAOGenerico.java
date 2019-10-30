/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daogenerico;

import conectividad.Conexion;
import java.sql.PreparedStatement;

/**
 *
 * @author DANIEL MALDONADO
 */
public abstract class DAOGenerico
{
    public Conexion CON;     
    public PreparedStatement STATEMENT;

    public DAOGenerico()
    {
        CON = Conexion.OpenConnection();
    }

    public Conexion getCON() {
        return CON;
    }

    public void setCON(Conexion CON) {
        this.CON = CON;
    }

    public PreparedStatement getSTATEMENT() {
        return STATEMENT;
    }

    public void setSTATEMENT(PreparedStatement STATEMENT) {
        this.STATEMENT = STATEMENT;
    }

    
   

    
    
}
